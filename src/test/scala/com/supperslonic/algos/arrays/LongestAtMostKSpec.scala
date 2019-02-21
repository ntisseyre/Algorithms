package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class LongestAtMostKSpec extends FunSpec with Matchers {
  describe("Longest that sums at most to k") {
    it("Can find") {

      val k = 184
      val elems = Seq(431, -15, 639, 342, -14, 565, -924, 635, 167, -70)

      val longestAtMostK = new LongestAtMostK()
      longestAtMostK.find(elems, k) shouldBe Some((3, 6))
    }

    it("Can find another") {

      val k = 5
      val elems = Seq(1, 0, 2, 3, -1, -4, 5)

      val longestAtMostK = new LongestAtMostK()
      longestAtMostK.find(elems, k) shouldBe Some((0, 5))
    }
  }
}
