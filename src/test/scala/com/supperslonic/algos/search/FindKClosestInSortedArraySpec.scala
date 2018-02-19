package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class FindKClosestInSortedArraySpec extends FunSpec with Matchers {
  describe("Find K Closest In Sorted Array") {
    it("Find") {
      val elems = Seq(12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56)
      val find = new FindKClosestInSortedArray()

      val result = find.pick(elems, 4, 35)
      result.sorted shouldBe Seq(30, 39, 42, 45)
    }
  }
}
