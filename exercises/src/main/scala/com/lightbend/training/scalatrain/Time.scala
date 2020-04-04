package com.lightbend.training.scalatrain

case class Time(hours: Int = 0, minutes: Int = 0) {
  val asMinutes: Int = (hours * 60) + minutes
  require(hours>=0 && hours<=23, "hour value out of permitted range")
  require(minutes>=0 && minutes<=59, "minute value out of permitted range")
  def minus(that:Time):Int = asMinutes - that.asMinutes
  def -(that:Time):Int = minus(that)

  override lazy val toString: String = f"${hours}%02d:${minutes}%02d"
}

object Time {
  def fromMinutes(minutes: Int):Time = {
    val  myHours:Int = minutes / 60
    val myMinutes:Int = minutes % 60
    Time(myHours, myMinutes)
  }
}