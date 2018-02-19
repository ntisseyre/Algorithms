package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class WaysToTraverseMatrixSpec extends FunSpec with Matchers {
  describe("Ways To Traverse Matrix") {
    it("0") {
      val matrix = new WaysToTraverseMatrix()
      val ways = matrix.count(0)

      println(ways)
      ways shouldBe None
    }
    it("1") {
      val matrix = new WaysToTraverseMatrix()
      val ways = matrix.count(1)

      println(ways)
      ways shouldBe Some(1)
    }
    it("2") {
      val matrix = new WaysToTraverseMatrix()
      val ways = matrix.count(2)

      println(ways)
      ways shouldBe Some(2)
    }
    it("5") {
      val matrix = new WaysToTraverseMatrix()
      val ways = matrix.count(5)

      println(ways)
      ways shouldBe Some(70)
    }
  }
}
