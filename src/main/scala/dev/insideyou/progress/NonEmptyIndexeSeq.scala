package dev.insideyou
package progress

final case class NonEmptyIndexedSeq[+A] private (self: IndexedSeq[A]):
  export self.*

object NonEmptyIndexedSeq:
  def apply[A](first: A, others: A*): NonEmptyIndexedSeq[A] =
    NonEmptyIndexedSeq.unsafe(first +: others.toIndexedSeq)

  def apply[A](self: IndexedSeq[A]): Option[NonEmptyIndexedSeq[A]] =
    Option.when(self.nonEmpty)(new NonEmptyIndexedSeq(self))

  def unsafe[A](self: IndexedSeq[A]): NonEmptyIndexedSeq[A] =
    apply(self).getOrElse(throw IllegalArgumentException("Expected IndexedSeq to be non-empty!"))
