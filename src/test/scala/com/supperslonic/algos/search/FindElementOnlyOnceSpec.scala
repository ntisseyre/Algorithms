package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class FindElementOnlyOnceSpec extends FunSpec with Matchers {
  describe("Find Element That Appears Only Once") {
    it("Find") {
      val elems = Seq(12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7)
      val findElementOnlyOnce = new FindElementOnlyOnce()

      val result = findElementOnlyOnce.find(elems)
      result shouldBe 7
    }
  }
}
