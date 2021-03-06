package dev.insideyou
package progress

final class ProgressBar private (factor: Int) extends (Double => String):
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
  lazy val   `0%`: String = s"$le${mf * 0}${me * 8}$re"
  lazy val  `10%`: String = s"$lf${mf * 0}${me * 8}$re"
  lazy val  `20%`: String = s"$lf${mf * 1}${me * 7}$re"
  lazy val  `30%`: String = s"$lf${mf * 2}${me * 6}$re"
  lazy val  `40%`: String = s"$lf${mf * 3}${me * 5}$re"
  lazy val  `50%`: String = s"$lf${mf * 4}${me * 4}$re"
  lazy val  `60%`: String = s"$lf${mf * 5}${me * 3}$re"
  lazy val  `70%`: String = s"$lf${mf * 6}${me * 2}$re"
  lazy val  `80%`: String = s"$lf${mf * 7}${me * 1}$re"
  lazy val  `90%`: String = s"$lf${mf * 8}${me * 0}$re"
  lazy val `100%`: String = s"$lf${mf * 8}${me * 0}$rf"
  // format: on

  private lazy val le = me.updated(0, '')
  private lazy val lf = mf.updated(0, '')
  private lazy val me = "" * f
  private lazy val mf = "" * f
  private lazy val re = me.updated(me.length - 1, '')
  private lazy val rf = mf.updated(mf.length - 1, '')
  private lazy val f = factor.inside(1 to 10)

  extension (self: Int)
    private def inside(range: Range): Int =
      inside(range.start, range.end)

    private def inside(from: Int, to: Int): Int =
      val f = from min to
      val t = from max to

      self max f min t

object ProgressBar:
  def make(factor: Int): ProgressBar =
    ProgressBar(factor)
