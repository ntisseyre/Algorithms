package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class FindKelementInSortedArraysSpec extends FunSpec with Matchers {
  describe("Find K Element In Sorted Arrays") {
    it("Find") {
      val elems1 = Seq(2, 3, 6, 7, 9)
      val elems2 = Seq(1, 4, 8, 10)
      val k = 5
      val find = new FindKelementInSortedArrays()

      val result = find.pick(elems1, elems2, k)
      result shouldBe 6
    }
  }
}
