package com.kakao.todd.ch01

import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import com.kakao.todd.ch01.Greeter.{Greet, WhoToGreet}
import com.kakao.todd.ch01.Printer.Greeting
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

import scala.concurrent.duration.FiniteDuration
import scala.language.postfixOps

class AkkaQuickstartSpec(_system: ActorSystem) extends TestKit(_system) with Matchers with FlatSpecLike with BeforeAndAfterAll {

  def this() = this(ActorSystem("AkkaQuickstartSpec"))

  override def afterAll: Unit = {
    shutdown(system)
  }

  "A Greeter Actor" should "pass on a greeting message when instructed to" in {
    val testProbe = TestProbe()
    val helloGreetingMessage = "hello"
    val helloGreeter = system.actorOf(Greeter.props(helloGreetingMessage, testProbe.ref))
    val greetPerson = "Akka"
    helloGreeter ! WhoToGreet(greetPerson)
    helloGreeter ! Greet
    testProbe.expectMsg(FiniteDuration(500, TimeUnit.MILLISECONDS) , Greeting(s"$helloGreetingMessage, $greetPerson"))
  }
}

