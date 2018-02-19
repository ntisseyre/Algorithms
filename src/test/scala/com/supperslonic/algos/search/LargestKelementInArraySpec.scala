package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

import scala.collection.mutable

class LargestKelementInArraySpec extends FunSpec with Matchers {
  describe("Largest K element") {
    it("Pick") {

      val elems = mutable.Seq(10, 20, 11, 70, 50, 40, 100, 5)
      val largest = new LargestKelementInArray()

      val result = largest.pick(elems, 3)
      println(result)
      elems(result) shouldBe 50
    }
    it("Pick 2") {

      val elems = mutable.Seq(7, 10, 4, 3, 20, 15)
      val largest = new LargestKelementInArray()

      val result = largest.pick(elems, 3)
      println(result)
      elems(result) shouldBe 10
    }
  }
}
