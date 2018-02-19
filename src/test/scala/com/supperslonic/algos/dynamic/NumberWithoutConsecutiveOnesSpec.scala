package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class NumberWithoutConsecutiveOnesSpec extends FunSpec with Matchers {
  describe("Number Of Numbers Without Consecutive Ones") {
    it("0") {

      val n = 0

      val numbers = new NumberWithoutConsecutiveOnes()
      numbers.find(n) shouldBe 0
    }
    it("1") {

      val n = 1

      val numbers = new NumberWithoutConsecutiveOnes()
      numbers.find(n) shouldBe 1
    }
    it("9") {

      val n = 9

      val numbers = new NumberWithoutConsecutiveOnes()
      numbers.find(n) shouldBe 1
    }
  }
}
