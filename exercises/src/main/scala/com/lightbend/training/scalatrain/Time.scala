package com.lightbend.training.scalatrain

class Time(val hours: Int = 0, val minutes: Int = 0) {
  val asMinutes: Int = (hours * 60) + minutes
  // TODO Verify that hours is within 0 and 23
  //  TODO Verify that minutes is within 0 and 59

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