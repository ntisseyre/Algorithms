package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class IncrementBigIntegerSpec extends FunSpec with Matchers {

  describe("New Array") {
    it("1 -> 2") {
      val algo = new IncrementBigInteger()

      val elems = Seq(1)
      algo.increment(elems) shouldBe Seq(0, 2)
    }
    it("9 -> 10") {
      val algo = new IncrementBigInteger()

      val elems = Seq(9)
      algo.increment(elems) shouldBe Seq(1, 0)
    }
    it("99 -> 100") {
      val algo = new IncrementBigInteger()

      val elems = Seq(9, 9)
      algo.increment(elems) shouldBe Seq(1, 0, 0)
    }
    it("100 -> 101") {
      val algo = new IncrementBigInteger()

      val elems = Seq(1, 0, 0)
      algo.increment(elems) shouldBe Seq(0, 1, 0, 1)
    }
  }
  describe("In Place") {
    it("1 -> 2") {
      val algo = new IncrementBigInteger()

      val elems = mutable.Seq(0, 1)
      algo.inPlace(elems)

      elems shouldBe Seq(0, 2)
    }
    it("9 -> 10") {
      val algo = new IncrementBigInteger()

      val elems = mutable.Seq(0, 9)
      algo.inPlace(elems)

      elems shouldBe Seq(1, 0)
    }
    it("99 -> 100") {
      val algo = new IncrementBigInteger()

      val elems = mutable.Seq(0, 9, 9)
      algo.inPlace(elems)

      elems shouldBe Seq(1, 0, 0)
    }
    it("100 -> 101") {
      val algo = new IncrementBigInteger()

      val elems = mutable.Seq(0, 1, 0, 0)
      algo.inPlace(elems)
      elems shouldBe Seq(0, 1, 0, 1)
    }
  }
}
