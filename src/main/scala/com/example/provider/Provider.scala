package com.example.provider

import org.http4s._
import org.http4s.dsl._
import _root_.argonaut._
import Argonaut._
import org.http4s.argonaut._
import java.io.File

import scala.io.Source
import scala.util.Random

import org.http4s.util.CaseInsensitiveString

object Provider {

  import UserImplicits._

  val service = HttpService {
    case GET -> Root / "user" =>
      Ok(User(1, "John").asJson)

    case request @ GET -> Root / ".well-known" / "live" =>
      NoContent()
     
    case request @ GET -> Root / ".well-known" / "ready" =>
      NoContent()

    case request @ HEAD -> Root / ".well-known" / "live" =>
      NoContent()
     
    case request @ HEAD -> Root / ".well-known" / "ready" =>
      NoContent()
  }

}

object UserImplicits {
  implicit lazy val resultsCodec: CodecJson[User] =
    casecodec2(User.apply, User.unapply)("id", "name")
}

case class User(id: Int, name: String)
