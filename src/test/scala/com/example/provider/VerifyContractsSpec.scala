package com.example.provider

import org.scalatest.{FunSpec, Matchers, BeforeAndAfterAll}
import org.http4s.server.Server
import java.lang.String
import com.itv.scalapact.ScalaPactVerify._

class VerifyContractsSpec extends FunSpec with Matchers with BeforeAndAfterAll {

  // There are almost certainly nicer ways to do this.
  var runningService: Option[Server] = None

  // Before all the tests are run, we start our service, which is the real service
  // code, the only difference is that the core business logic has been replaced
  // by functional dependency injection to return known values.
  override def beforeAll(): Unit = {

     runningService = Some(AlternateStartupApproach.startServer())
  }

  // Afterwards we need to remember to shut our service down again.
  override def afterAll(): Unit = {
    runningService.foreach(AlternateStartupApproach.stopServer)
  }
  println("Hello World")
  describe("Verifying Consumer Contracts") {

    it("should be able to verify it's contracts") {
	 verifyPact
          .withPactSource(pactBroker("http://54.207.30.143:8081","scala_pact_Provider",List[String]("scala_pact_Consumer")))
          .noSetupRequired 
          .runVerificationAgainst("localhost", 8054)
    }

 } 
}
