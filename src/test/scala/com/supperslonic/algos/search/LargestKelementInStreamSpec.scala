package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class LargestKelementInStreamSpec extends FunSpec with Matchers {
  describe("Largest K element") {
    it("Pick") {

      val elems = Seq(10, 20, 11, 70, 50, 40, 100, 5)
      val largest = new LargestKelementInStream()

      val result = largest.pick(elems.iterator, 3)
      println(result)
      result shouldBe 50
    }
    it("Pick 2") {

      val elems = Seq(7, 10, 4, 3, 20, 15)
      val largest = new LargestKelementInStream()

      val result = largest.pick(elems.iterator, 3)
      println(result)
      result shouldBe 10
    }
  }
}
