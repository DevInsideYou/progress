package dev.insideyou
package progress

object Style:
  def random(): String =
    All(util.Random.nextInt(All.length))

  def makePseudoRandomGenerator(): InfinitelyNext[String] =
    InfinitelyNext(All)

  lazy val All: NonEmptyIndexedSeq[String] =
    import Console.*

    NonEmptyIndexedSeq.unsafe(IndexedSeq(BLACK, BLUE, CYAN, GREEN, MAGENTA, RED, WHITE, YELLOW))
