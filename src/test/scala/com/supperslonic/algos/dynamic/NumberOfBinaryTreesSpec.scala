package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class NumberOfBinaryTreesSpec extends FunSpec with Matchers {
  describe("Number Of Binary Trees") {
    it("0") {

      val n = 0

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 0
    }
    it("1") {

      val n = 1

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 1
    }
    it("2") {

      val n = 2

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 2
    }
    it("3") {

      val n = 3

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 5
    }
    it("4") {

      val n = 4

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 14
    }
    it("5") {

      val n = 5

      val trees = new NumberOfBinaryTrees()
      trees.find(n) shouldBe 42
    }
  }
}
