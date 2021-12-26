package dev.insideyou
package progress

object ProgressCircleSegment:
  def make(): InfinitelyNext[Char] =
    InfinitelyNext(AllSegmentsInOrder)

  lazy val AllSegmentsInOrder: NonEmptyIndexedSeq[Char] =
    NonEmptyIndexedSeq.unsafe("")
