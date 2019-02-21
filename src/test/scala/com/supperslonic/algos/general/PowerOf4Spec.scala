package com.supperslonic.algos.general

import org.scalatest.{FunSpec, Matchers}

class PowerOf4Spec extends FunSpec with Matchers {

  describe("Brute force") {
    it("-2") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(-2) shouldBe false
    }
    it("0") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(0) shouldBe false
    }
    it("1") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(1) shouldBe true
    }
    it("3") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(3) shouldBe false
    }
    it("4") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(4) shouldBe true
    }
    it("8") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(8) shouldBe false
    }
    it("15") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(15) shouldBe false
    }
    it("16") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(16) shouldBe true
    }
    it("32") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(32) shouldBe false
    }
    it("64") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4(64) shouldBe true
    }
  }
  describe("Bit mask") {
    it("-2") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(-2) shouldBe false
    }
    it("0") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(0) shouldBe false
    }
    it("1") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(1) shouldBe true
    }
    it("3") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(3) shouldBe false
    }
    it("4") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(4) shouldBe true
    }
    it("8") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(8) shouldBe false
    }
    it("15") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(15) shouldBe false
    }
    it("16") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(16) shouldBe true
    }
    it("32") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(32) shouldBe false
    }
    it("64") {
      val powerOf4 = new PowerOf4()
      powerOf4.isPowerOf4Good(64) shouldBe true
    }
  }
}
