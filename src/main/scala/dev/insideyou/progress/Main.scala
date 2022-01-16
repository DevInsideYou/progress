package dev.insideyou
package progress

@main def Main(args: String*): Unit =
  println("─" * 100)

  val generatePseudoRandomStyle: () => String =
    Style.makePseudoRandomGenerator()

  def bar(factor: Int): Unit =
    printProgressBarln(generatePseudoRandomStyle(), factor)

  for factor <- 1 to 4 by +1 do bar(factor)
  for factor <- 4 to 1 by -1 do bar(factor)

  def circle(): Unit =
    printProgressCircle(generatePseudoRandomStyle())

  println("─" * 100)

  for _ <- 1 to 8 do circle()
  clearPrint()

def printProgressBarln(style: String, factor: Int): Unit =
  val renderedProgressBar = ProgressBar.make(factor)

  for percentage <- 0 to 100 do
    val progressBar = renderedProgressBar(percentage)
    val styledProgressBar = progressBar in style

    clearPrint(styledProgressBar + " ")

    Thread.sleep(5)

  println()

def printProgressCircle(style: String): Unit =
  val renderedSegment = ProgressCircleSegment.make()

  for _ <- 1 to 6 do
    val segment = renderedSegment()
    val styledSegment = segment in style

    clearPrint(" " + styledSegment + " ")

    Thread.sleep(200)

def clearPrint(in: Any = ""): Unit =
  val ReplaceEveryCharOfLineWithSpace = "\u001b[2K"
  val PostionCursorAtBeginningOfLine = "\r"

  print(ReplaceEveryCharOfLineWithSpace + PostionCursorAtBeginningOfLine + in + Console.RESET)

extension (self: Any)
  infix def in(style: String): String =
    style + self + Console.RESET
