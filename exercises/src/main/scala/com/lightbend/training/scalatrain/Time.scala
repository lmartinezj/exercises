package com.lightbend.training.scalatrain

import play.api.libs.json.{JsNumber, JsObject, JsValue}

import scala.util.{Failure, Success, Try}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {
  val asMinutes: Int = (hours * 60) + minutes
  require(hours>=0 && hours<=23, "hour value out of permitted range")
  require(minutes>=0 && minutes<=59, "minute value out of permitted range")
  def minus(that:Time):Int = asMinutes - that.asMinutes
  def -(that:Time):Int = minus(that)

  override lazy val toString: String = f"${hours}%02d:${minutes}%02d"

  override def compare(that: Time): Int = this - that

  def toJson:JsValue = {
    JsObject(Seq(
        "hours" -> JsNumber(hours),
        "minutes" -> JsNumber(minutes)
      )
    )
  }
}

object Time {
  def fromMinutes(minutes: Int):Time = {
    val  myHours:Int = minutes / 60
    val myMinutes:Int = minutes % 60
    Time(myHours, myMinutes)
  }

  def fromJson(jsValue: JsValue): Option[Time] = {
    for {
      hours <- Try((jsValue\"hours").as[Int])
      minutes <- Try((jsValue\"minutes").as[Int]).recover {
        case _ => 0
      }
    } yield Time(hours, minutes)
  }.toOption
}