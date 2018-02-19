package com.supperslonic.algos.search

import scala.collection.mutable

case class BuySell(buy: Int, sell: Int)
class StockMaximizeProfit {

  def maximize(stockPrices: Seq[Int]): Seq[BuySell] = {
    val result = mutable.ArrayBuffer[BuySell]()

    var i = 1
    while(i < stockPrices.size) {

      var localMinimum = stockPrices(i - 1)
      while (i < stockPrices.size && localMinimum > stockPrices(i) ) {
        localMinimum = stockPrices(i)
        i += 1
      }

      if(i == stockPrices.size) return result
      var localMaximum = stockPrices(i)
      i +=1

      while (i < stockPrices.size && stockPrices(i) > localMaximum) {
        localMaximum = stockPrices(i)
        i += 1
      }

      result.append(BuySell(localMinimum, localMaximum))
      i +=1
    }

    result
  }
}
