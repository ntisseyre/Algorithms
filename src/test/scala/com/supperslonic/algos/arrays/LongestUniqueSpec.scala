package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class LongestUniqueSpec extends FunSpec with Matchers {
  describe("Longest Unique") {
    it("Single element") {
      val elems = Seq(2)
      val unique = new LongestUnique()

      val result = unique.find(elems)
      result shouldBe (0, 1)
    }
    it("2 unique elements") {
      val elems = Seq(2, 3)
      val unique = new LongestUnique()

      val result = unique.find(elems)
      result shouldBe (0, 2)
    }
    it("2 same elements") {
      val elems = Seq(2, 2)
      val unique = new LongestUnique()

      val result = unique.find(elems)
      result shouldBe (0, 1)
    }
    it("Multi elements") {
      val elems = Seq(5, 8, 3, 7, 5, 11, 13, 2, 11, 19, 2, 11)
      val unique = new LongestUnique()

      val result = unique.find(elems)
      result shouldBe (1, 8)
    }
  }
}
