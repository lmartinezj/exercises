class Time(val hours: Int, val minutes: Int) {
  val asMinutes: Int = (hours * 60) + minutes;
  // TODO Verify that hours is within 0 and 23
  //  TODO Verify that minutes is within 0 and 59
  def minus(that:Time):Int = asMinutes - that.asMinutes
}