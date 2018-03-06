package com.kakao.todd.ch01

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import com.kakao.todd.ch01.Greeter.{Greet, WhoToGreet}
import com.kakao.todd.ch01.Printer.Greeting

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  var greeting = ""

  override def receive: Receive = {
    case WhoToGreet(who) => greeting = s"$message, $who"
    case Greet => printerActor ! Greeting(greeting)

  }
}

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  final case class WhoToGreet(who: String)

  case object Greet
}

class Printer extends Actor with ActorLogging {
  override def receive: Receive = {
    case Greeting(greeting) => log.info(s"Greeting received(from ${sender()}) : $greeting")
  }
}

object Printer {
  def props: Props  = Props[Printer]

  final case class Greeting(greeting: String)
}

object QuickStartTest extends App {
  val system = ActorSystem()

  val printer = system.actorOf(Printer.props, "printerActor")
  val howdyGreeter = system.actorOf(Greeter.props("Howdy", printer), "howdyGreeter")
  val helloGreeter = system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
  val goodDayGreeter = system.actorOf(Greeter.props("Good day", printer), "goodDayGreeter")

  howdyGreeter ! WhoToGreet("Akka")
  howdyGreeter ! Greet

  howdyGreeter ! WhoToGreet("LightBend")
  howdyGreeter ! Greet

  helloGreeter ! WhoToGreet("Scala")
  helloGreeter ! Greet

  goodDayGreeter ! WhoToGreet("Play")
  goodDayGreeter ! Greet

  printer ! Greeting("Hi")
}

