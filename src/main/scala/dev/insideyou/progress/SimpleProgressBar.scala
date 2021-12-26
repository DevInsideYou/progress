package dev.insideyou
package progress

object SimpleProgressBar extends (Double => String):
  override def apply(percentage: Double): String =
    val p = percentage.toInt

    // format: off
         if p <  10 then   `0%`
    else if p <  20 then  `10%`
    else if p <  30 then  `20%`
    else if p <  40 then  `30%`
    else if p <  50 then  `40%`
    else if p <  60 then  `50%`
    else if p <  70 then  `60%`
    else if p <  80 then  `70%`
    else if p <  90 then  `80%`
    else if p < 100 then  `90%`
    else                 `100%`
    // format: on

  // format: off
  val   `0%`: String = ""
  val  `10%`: String = ""
  val  `20%`: String = ""
  val  `30%`: String = ""
  val  `40%`: String = ""
  val  `50%`: String = ""
  val  `60%`: String = ""
  val  `70%`: String = ""
  val  `80%`: String = ""
  val  `90%`: String = ""
  val `100%`: String = ""
  // format: on
