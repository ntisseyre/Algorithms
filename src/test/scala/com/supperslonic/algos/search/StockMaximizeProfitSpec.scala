package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class StockMaximizeProfitSpec extends FunSpec with Matchers {
  describe("Stock Maximize Profit") {
    it("Maximum Profit") {

      val stockPrices = Seq(100, 180, 260, 310, 40, 535, 695)

      val profit = new StockMaximizeProfit()
      val result = profit.maximize(stockPrices)

      result shouldBe Seq(BuySell(100, 310), BuySell(40, 695))
    }
    it("Only Increasing") {

      val stockPrices = Seq(100, 180, 260, 535, 695)

      val profit = new StockMaximizeProfit()
      val result = profit.maximize(stockPrices)

      result shouldBe Seq(BuySell(100, 695))
    }
    it("Only Decreasing") {

      val stockPrices = Seq(695, 535, 260, 180, 100)

      val profit = new StockMaximizeProfit()
      val result = profit.maximize(stockPrices)

      result shouldBe Seq()
    }
    it("One buy/sell and then Decreasing") {

      val stockPrices = Seq(30, 535, 789, 260, 180, 100)

      val profit = new StockMaximizeProfit()
      val result = profit.maximize(stockPrices)

      result shouldBe Seq(BuySell(30, 789))
    }
  }
}
