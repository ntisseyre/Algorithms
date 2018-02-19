package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class SubsetSumSpec  extends FunSpec with Matchers {
  describe("Subset Sum") {
    it("Exists") {
      val elems = Seq(3, 34, 4, 12, 5, 2)
      val subsetSum = new SubsetSum()

      subsetSum.exists(elems, 9) shouldBe true
    }
  }
}
