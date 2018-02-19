package com.supperslonic.algos

import org.scalatest.{FunSpec, Matchers}

class PowerSpec extends FunSpec with Matchers {

  describe("Power") {
    it("2^0") {
      val algorithm = new Power()
      val result = algorithm.power(2, 0)

      result shouldBe 1
    }
    it("2^1") {
      val algorithm = new Power()
      val result = algorithm.power(2, 1)

      result shouldBe 2
    }
    it("2^2") {
      val algorithm = new Power()
      val result = algorithm.power(2, 2)

      result shouldBe 4
    }
    it("2^3") {
      val algorithm = new Power()
      val result = algorithm.power(2, 3)

      result shouldBe 8
    }
    it("2^4") {
      val algorithm = new Power()
      val result = algorithm.power(2, 4)

      result shouldBe 16
    }
    it("2^5") {
      val algorithm = new Power()
      val result = algorithm.power(2, 5)

      result shouldBe 32
    }
    it("2^6") {
      val algorithm = new Power()
      val result = algorithm.power(2, 6)

      result shouldBe 64
    }
  }
}
