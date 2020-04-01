package com.lightbend.training.scalatrain

class Time(val hours: Int = 0, val minutes: Int = 0) {
  val asMinutes: Int = (hours * 60) + minutes
  require(hours>=0 && hours<=23, "hour value out of permitted range")
  require(minutes>=0 && minutes<=59, "minute value out of permitted range")
  def minus(that:Time):Int = asMinutes - that.asMinutes
  def -(that:Time):Int = minus(that)
}

object Time {
  def fromMinutes(minutes: Int):Time = {
    val  myHours:Int = minutes / 60
    val myMinutes:Int = minutes % 60
    new Time(myHours, myMinutes)
  }
}