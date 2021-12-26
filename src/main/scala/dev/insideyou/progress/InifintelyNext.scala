package dev.insideyou
package progress

final class InfinitelyNext[A](self: NonEmptyIndexedSeq[A]) extends (() => A):
  override def apply(): A =
    val result = self(index)

    index = (index + 1) % length

    result

  private var index: Int = 0
  private val length: Int = self.length
