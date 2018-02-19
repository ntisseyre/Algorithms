package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class SkyLineSpec extends FunSpec with Matchers {
  describe("Sky Line") {
    it("Find 1") {

      val buildings = Seq(
        Building(1, 3, 3),
        Building(6, 7, 4),
        Building(5, 8, 2),
        Building(8, 9, 4),
        Building(2, 4, 4))

      val skyLine = new SkyLine()
      val result = skyLine.find(buildings)

      println(result)
      result shouldBe Seq(
        SkyLineResult(1, 3),
        SkyLineResult(2, 4),
        SkyLineResult(4, 0),
        SkyLineResult(5, 2),
        SkyLineResult(6, 4),
        SkyLineResult(7, 2),
        SkyLineResult(8, 0),
        SkyLineResult(8, 4),
        SkyLineResult(9, 0))
    }
    it("Find 2") {

      val buildings = Seq(
        Building(1, 5, 11),
        Building(19, 22, 18),
        Building(2, 7, 6),
        Building(3, 9, 13),
        Building(14, 25, 3),
        Building(23, 29, 13),
        Building(24, 28, 4),
        Building(12, 16, 7))

      val skyLine = new SkyLine()
      val result = skyLine.find(buildings)

      println(result)
      result shouldBe Seq(
        SkyLineResult(1, 11),
        SkyLineResult(3, 13),
        SkyLineResult(9, 0),
        SkyLineResult(12, 7),
        SkyLineResult(16, 3),
        SkyLineResult(19, 18),
        SkyLineResult(22, 3),
        SkyLineResult(23, 13),
        SkyLineResult(29, 0))
    }
  }
}
