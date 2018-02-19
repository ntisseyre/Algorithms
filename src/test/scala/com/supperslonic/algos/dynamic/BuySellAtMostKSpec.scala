package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class BuySellAtMostKSpec extends FunSpec with Matchers {
  describe("Buy/Sell at Most K") {
    it("2") {

      val stockPrices = Seq(10, 22, 5, 75, 65, 80)
      val k = 2
      val buySell = new BuySellAtMostK()

      buySell.maxProfit(stockPrices, k) shouldBe 87
    }
    it("3") {

      val stockPrices = Seq(2, 5, 7, 1, 4, 3, 1, 3)
      val k = 3
      val buySell = new BuySellAtMostK()

      buySell.maxProfit(stockPrices, k) shouldBe 10
    }
  }
}
