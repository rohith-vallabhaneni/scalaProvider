organization := "com.example"
name := "scala_pact_Provider"
version := "0.0.1"
scalaVersion := "2.12.1"

pactBrokerAddress := "http://54.207.30.143:8081"
providerName := "scala_pact_Provider"
consumerNames :=Seq("scala_pact_Consumer")


libraryDependencies ++= Seq(
  "org.http4s"     %% "http4s-blaze-server" % "0.15.0a",
  "org.http4s"     %% "http4s-dsl"          % "0.15.0a",
  "org.http4s"     %% "http4s-argonaut"     % "0.15.0a",
  "org.scalatest"  %% "scalatest"           % "3.0.0" % "test",
  "com.itv"        %% "scalapact-scalatest" % "2.1.3" % "test"
)

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"
