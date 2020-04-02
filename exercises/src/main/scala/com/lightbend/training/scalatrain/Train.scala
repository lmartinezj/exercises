package com.lightbend.training.scalatrain


case class Train(kind: String, number: Int, schedule: Seq[Station]) {
  require(schedule.size >= 2, "Schedule must contain at least 2 elements")
}


