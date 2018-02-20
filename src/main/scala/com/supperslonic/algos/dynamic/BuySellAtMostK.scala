package com.supperslonic.algos.dynamic

class BuySellAtMostK {

  /**
    * for (int m = 0; m < j; m++)
    * max_so_far = max(max_so_far, price[j] - price[m] + profit[i-1][m]);
    *
    * If we carefully notice, max(price[j] – price[m] + profit[i-1][m]) for all m in range [0, j-1]
    * can be rewritten as: price[j] + max(profit[i-1][m] – price[m]) for all m in range [0, j-1]
    *
    * which can be rewritten as:  price[j] + max(prevMax, profit[i-1][j-1] – price[j-1])
    * where prevMax = max(profit[i-1][m] – price[m]) for all m in range [0, j-2].
    *
    * So, if we have already calculated max(profit[i-1][m] – price[m]) for all m in range [0, j-2],
    * we can calculate it for m = j – 1 in constant time.
    * In other words, we don’t have to look back in range [0, j-1] anymore to find out best day to buy.
    * We can determine that in constant time using below revised relation.
    *
    */
  def maxProfit(stockPrices: Seq[Int], k: Int): Int = {
    val profit = Array.ofDim[Int](k + 1, stockPrices.size + 1)

    // For day 0, you can't earn money
    // irrespective of how many times you trade
    for (i <- 0 to k) profit(i)(0) = 0

    // profit is 0 if we don't do any transation
    // (i.e. k =0)
    for (j <- 0 to stockPrices.size) profit.head(j) = 0

    // fill the table in bottom-up fashion
    for (i <- 1 to k) {

      var prevDiff = Int.MinValue
      for (j <- 1 until stockPrices.size) {

        prevDiff = Math.max(prevDiff, profit(i - 1)(j - 1) - stockPrices(j - 1))
        profit(i)(j) = Math.max(profit(i)(j - 1), stockPrices(j) + prevDiff)
        printTable(profit)
      }
    }

    profit.last(stockPrices.size - 1)
  }

  private def printTable(tabulation: Array[Array[Int]]): Unit = {
    tabulation.foreach(line => println(line.toSeq))
    println()
  }
}
