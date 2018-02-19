package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class MaxIncreasingSubSequenceSpec extends FunSpec with Matchers {
  describe("Max Increasing Sequence") {
    it("Single element") {

      val elems = Seq(1)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.search(elems)

      println(result)
      result shouldBe 1
    }

    it("2 elements increasing") {

      val elems = Seq(1, 2)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.search(elems)

      println(result)
      result shouldBe 2
    }

    it("2 elements decreasing") {

      val elems = Seq(2, 1)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.search(elems)

      println(result)
      result shouldBe 1
    }
    it("4 elements") {

      val elems = Seq(10, 22, 9, 33)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.search(elems)

      println(result)
      result shouldBe 3
    }
    it("Multi elements") {

      val elems = Seq(10, 22, 9, 33, 21, 50, 41, 60, 80)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.search(elems)

      println(result)
      result shouldBe 6
    }
  }
  describe("Recursive") {
    it("4 elements") {

      val elems = Seq(10, 22, 9, 33)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.searchRecursive(elems)

      println(result)
      result shouldBe 3
    }
    it("Multi elements") {

      val elems = Seq(10, 22, 9, 33, 21, 50, 41, 60, 80)
      val sequence = new MaxIncreasingSubSequence()

      val result = sequence.searchRecursive(elems)

      println(result)
      result shouldBe 6
    }
  }
}
