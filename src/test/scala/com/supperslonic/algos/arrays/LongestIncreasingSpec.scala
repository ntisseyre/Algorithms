package com.supperslonic.algos.arrays

import org.scalatest.{FunSpec, Matchers}

class LongestIncreasingSpec extends FunSpec with Matchers {
  describe("Longest Increasing") {
    it("Can find") {

      val elems = Seq(2, 11, 3, 5, 13, 7, 19, 17, 23)
      val increasing = new LongestIncreasing()

      val result = increasing.find(elems)
      println(elems.slice(result._1, result._2 + 1))
      result shouldBe (2, 4)
    }
    it("Single element") {

      val elems = Seq(2)
      val increasing = new LongestIncreasing()

      val result = increasing.find(elems)
      result shouldBe (0, 0)
    }
    it("2 elements increasing") {

      val elems = Seq(2, 4)
      val increasing = new LongestIncreasing()

      val result = increasing.find(elems)
      println(elems.slice(result._1, result._2 + 1))
      result shouldBe (0, 1)
    }
    it("2 elements decreasing") {

      val elems = Seq(4, 2)
      val increasing = new LongestIncreasing()

      val result = increasing.find(elems)
      result shouldBe (0, 0)
    }
  }
}
