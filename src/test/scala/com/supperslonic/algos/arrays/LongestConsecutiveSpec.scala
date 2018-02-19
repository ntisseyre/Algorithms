package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class LongestConsecutiveSpec extends FunSpec with Matchers {
  describe("Longest Consecutive") {
    it("Can find 1, 3, 4, 2") {
      val elems = Seq(1, 9, 3, 10, 4, 20, 2)
      val longestConsecutive = new LongestConsecutive()
      longestConsecutive.find(elems) shouldBe 4
    }
    it("Can find 36, 35, 33, 34, 32") {
      val elems = Seq(36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42)
      val longestConsecutive = new LongestConsecutive()
      longestConsecutive.find(elems) shouldBe 5
    }
  }
}
