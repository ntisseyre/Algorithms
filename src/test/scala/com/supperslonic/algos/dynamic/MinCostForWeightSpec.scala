package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class MinCostForWeightSpec extends FunSpec with Matchers {
  describe("Min Cost For Weight") {
    it("Can pick 2,3") {

      val minCost = new MinCostForWeight()
      val cost = minCost.pick(Seq(
        CostItem(weight = 1, cost = 20),
        CostItem(weight = 2, cost = 10),
        CostItem(weight = 3, cost = 4),
        CostItem(weight = 4, cost = 50),
        CostItem(weight = 5, cost = 100)), 5)

      println(cost)
      cost shouldBe 14
    }

    it("Can pick 1 =  5 times") {

      val minCost = new MinCostForWeight()
      val cost = minCost.pick(Seq(
        CostItem(weight = 1, cost = 1),
        CostItem(weight = 2, cost = 10),
        CostItem(weight = 3, cost = 4),
        CostItem(weight = 4, cost = 50),
        CostItem(weight = 5, cost = 100)), 5)

      println(cost)
      cost shouldBe 5
    }
  }
}
