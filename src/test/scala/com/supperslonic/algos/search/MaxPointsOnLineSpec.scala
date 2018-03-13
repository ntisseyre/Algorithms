package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class MaxPointsOnLineSpec extends FunSpec with Matchers {

  describe("Max Points On Line") {
    it("4") {
      val points = Seq(
        Point(-1, 1),
        Point(0, 0),
        Point(1, 1),
        Point(2, 2),
        Point(3, 3),
        Point(3, 4)).toArray

      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.maxPoints(points) shouldBe 4
    }
    it("[0, 0]") {
      val points = Seq(
        Point(0, 0)).toArray

      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.maxPoints(points) shouldBe 1
    }
    it("[0, 0] [0, 0]") {
      val points = Seq(
        Point(0, 0),
        Point(0, 0)).toArray

      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.maxPoints(points) shouldBe 2
    }

    it("[0, 0] [1, 1], [0, 0]") {
      val points = Seq(
        Point(0, 0),
        Point(1, 1),
        Point(0, 0)).toArray

      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.maxPoints(points) shouldBe 3
    }
  }

  describe("Greatest Common Divisor") {
    it("6/8") {
      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.greatestCommonDivisor(6, 8) shouldBe 2
    }
    it("8/6") {
      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.greatestCommonDivisor(8, 6) shouldBe 2
    }
    it("4/12") {
      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.greatestCommonDivisor(4, 12) shouldBe 4
    }
    it("2/3") {
      val maxPointsOnLine = new MaxPointsOnLine()
      maxPointsOnLine.greatestCommonDivisor(2, 3) shouldBe 1
    }
  }
}
