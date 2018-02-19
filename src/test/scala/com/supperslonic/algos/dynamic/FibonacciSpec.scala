package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class FibonacciSpec extends FunSpec with Matchers {
  describe("Fibonacci Recursive") {
    it("1") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generateRecursive(1)

      println(result)
      result shouldBe 1
    }
    it("2") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generateRecursive(2)

      println(result)
      result shouldBe 1
    }
    it("3") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generateRecursive(3)

      println(result)
      result shouldBe 2
    }
    it("4") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generateRecursive(4)

      println(result)
      result shouldBe 3
    }
    it("10") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generateRecursive(10)

      println(result)
      result shouldBe 55
    }
  }
  describe("Fibonacci") {
    it("1") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generate(1)

      println(result)
      result shouldBe 1
    }
    it("2") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generate(2)

      println(result)
      result shouldBe 1
    }
    it("3") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generate(3)

      println(result)
      result shouldBe 2
    }
    it("4") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generate(4)

      println(result)
      result shouldBe 3
    }
    it("10") {

      val fibonacci = new Fibonacci()
      val result = fibonacci.generate(10)

      println(result)
      result shouldBe 55
    }
  }
}
