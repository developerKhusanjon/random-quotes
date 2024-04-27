ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "random-quotes",
    version := "0.1",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.6.19",
      "com.typesafe.akka" %% "akka-http-core" % "10.2.9",
      "com.typesafe.akka" %% "akka-http" % "10.2.9",
      "com.typesafe.akka" % "akka-actor-typed_2.13" % "2.6.19",
      "com.typesafe.akka" % "akka-stream-typed_2.13" % "2.6.19",
      "com.typesafe.akka" % "akka-http-spray-json_2.13" % "10.2.9")
  )
