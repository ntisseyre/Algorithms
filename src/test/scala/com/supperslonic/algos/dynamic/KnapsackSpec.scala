package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class KnapsackSpec extends FunSpec with Matchers {
  describe("Knapsack") {
    it("Can pick") {

      val knapsack = new Knapsack()
      val weight = knapsack.pick(Seq(
        Item(weight = 3, value = 5),
        Item(weight = 2, value = 3),
        Item(weight = 1, value = 4)), 5)

      println(weight)
      weight shouldBe 9
    }
    it("Can pick 2") {

      val knapsack = new Knapsack()
      val weight = knapsack.pick(Seq(
        Item(weight = 1, value = 1),
        Item(weight = 3, value = 4),
        Item(weight = 4, value = 5),
        Item(weight = 5, value = 7)), 7)

      println(weight)
      weight shouldBe 9
    }

    it("Can pick Recursive"){
      val knapsack = new Knapsack()
      val weight = knapsack.pickRecursive(Seq(
        Item(weight = 3, value = 5),
        Item(weight = 2, value = 3),
        Item(weight = 1, value = 4)), 5)

      println(weight)
      weight shouldBe 9
    }

    it("Can pick Recursive 2"){
      val knapsack = new Knapsack()
      val weight = knapsack.pickRecursive(Seq(
        Item(weight = 1, value = 1),
        Item(weight = 3, value = 4),
        Item(weight = 4, value = 5),
        Item(weight = 5, value = 7)), 7)

      println(weight)
      weight shouldBe 9
    }
    it("Can pick Recursive 3"){
      val knapsack = new Knapsack()
      val weight = knapsack.pickRecursive(Seq(
        Item(weight = 10, value = 60),
        Item(weight = 20, value = 100),
        Item(weight = 30, value = 120)), 50)

      println(weight)
      weight shouldBe 220
    }
  }
  describe("Knapsack Fractional") {
    it("Can pick Recursive"){
      val knapsack = new Knapsack()
      val weight = knapsack.pickFractionalRecursive(Seq(
        Item(weight = 10, value = 60),
        Item(weight = 20, value = 100),
        Item(weight = 30, value = 120)), 50)

      println(weight)
      weight shouldBe 240
    }
  }
}
