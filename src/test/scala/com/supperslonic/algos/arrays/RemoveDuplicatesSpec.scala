package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class RemoveDuplicatesSpec extends FunSpec with Matchers {
  describe("Remove Duplicate") {
    it("2 elements") {
      val algo = new RemoveDuplicates()

      val elems = mutable.Seq(2, 2)
      algo.remove(elems)

      elems shouldBe Seq(2, 0)
    }
    it("Multi elements") {
      val algo = new RemoveDuplicates()

      val elems = mutable.Seq(2, 3, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9)
      algo.remove(elems)

      elems shouldBe Seq(2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0)
    }
  }
}
