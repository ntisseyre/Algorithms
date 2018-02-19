package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class LargestRectangularInHistogramSpec extends FunSpec with Matchers {
  describe("Largest Rectangular In Histogram") {
    it("Find") {

      val histogram = Seq(6, 2, 5, 4, 5, 1, 6)
      val largest = new LargestRectangularInHistogram()

      largest.find(histogram) shouldBe 12
    }
  }
}
