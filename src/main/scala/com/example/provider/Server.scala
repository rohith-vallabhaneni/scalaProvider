package com.example.provider

import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server._

object AlternateStartupApproach {

  // On ordinary start up, this service will begin here.
  def main(args: Array[String]): Unit = {
    startServer().awaitShutdown()
  }

  // This function allows us to start the service while supplying the dependencies
  // (in the form of functions) that are supposed to do the work. Meaning if
  // this function is called directly, say from our test suite, we can inject
  // any core logic we like, thus side stepping a few pesky little things...
  //  ...like databases.
  def startServer(): Server = {
    BlazeBuilder.bindHttp(8054,"0.0.0.0")
      .mountService(Provider.service, "/")
      .run
    }

  def stopServer(server: Server): Unit = {
    server.shutdown
  }
}
