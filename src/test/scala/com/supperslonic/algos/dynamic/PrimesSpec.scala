package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class PrimesSpec extends FunSpec with Matchers {
  describe("Primes") {
    it("up to 2") {

      val primes = new Primes()
      val result = primes.generate(2)

      println(result)
      result shouldBe Seq(2)
    }

    it("up to 3") {

      val primes = new Primes()
      val result = primes.generate(3)

      println(result)
      result shouldBe Seq(2, 3)
    }

    it("up to 4") {

      val primes = new Primes()
      val result = primes.generate(4)

      println(result)
      result shouldBe Seq(2, 3)
    }

    it("up to 100") {

      val primes = new Primes()
      val result = primes.generate(100)

      println(result)
      result shouldBe Seq(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    }

  }
}
