lazy val commonSettings = Seq(
  organization := "com.kakaocorp.todd",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.4",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.10",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.10" % Test
  )
)


lazy val akka =
  (project in file("akka-learning"))
    .settings(commonSettings)

