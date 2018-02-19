package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class LongestAtMostKSpec extends FunSpec with Matchers {
  describe("Longest that sums at most to k") {
    it("Can find") {

      val k = 184
      val elems = Seq(431, -15, 639, 342, -14, 565, -924, 635, 167, -70)

      val longestAtMostK = new LongestAtMostK()
      longestAtMostK.find(elems, 184) shouldBe Some((3, 6))
    }
  }
}
