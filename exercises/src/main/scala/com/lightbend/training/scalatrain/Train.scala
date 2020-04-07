package com.lightbend.training.scalatrain


case class Train(info: TrainInfo, schedule: Seq[(Time,Station)]) {
  require(schedule.size >= 2, "Schedule must contain at least 2 elements")
  val stations: Seq[Station] = schedule.map(_._2)

  def timeAt(station: Station): Option[Time] = {
    schedule.find {
      case (_, myStation) => myStation == station
    }.map {
      case (myTime, _) => myTime
    }
  }


}


