package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class FishingTripSpec extends FunSpec with Matchers {
  describe("Fishing Trip") {
    it("2") {
      val size = 2
      val sea = new Array[Array[Int]](size)
      for(i <- sea.indices) sea(i) = new Array[Int](size)

      sea(0)(1) = 5
      sea(1)(0) = 3

      val fishingTrip = new FishingTrip()
      val profit = fishingTrip.maxProfit(sea)

      println(profit)
      profit shouldBe Some(5)
    }
    it("5") {
      val size = 5
      val sea = new Array[Array[Int]](size)
      for(i <- sea.indices) sea(i) = new Array[Int](size)

      sea(0)(1) = 5
      sea(0)(3) = 15
      sea(1)(1) = 3
      sea(1)(2) = 6
      sea(2)(3) = 3
      sea(3)(3) = 5
      sea(4)(2) = 25

      val fishingTrip = new FishingTrip()
      val profit = fishingTrip.maxProfit(sea)

      println(profit)
      profit shouldBe Some(39)
    }
  }
}
