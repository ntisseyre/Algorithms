package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class FindRepeatingAndMissingSpec extends FunSpec with Matchers {
  describe("Find Repeating And Missing") {
    it("Find") {
      val elems = Seq(3, 1, 3)
      val find = new FindRepeatingAndMissing()

      val result = find.find(elems)
      result shouldBe RepeatingAndMissing(3, 2)
    }
  }
}