package com.supperslonic.algos.dynamic

class FishingTrip {

  def maxProfit(sea: Array[Array[Int]]): Option[Int] = {

    val profit = new Array[Int](sea.length)

    for (j <- sea.indices) {
      for (i <- sea.indices) {
        profit(i) = if(i == 0 && j == 0) sea(j)(i)
        else if(i == 0) profit(i) + sea(j)(i)
        else Math.max(profit(i), profit(i - 1)) + sea(j)(i)
      }
    }

    profit.lastOption
  }
}
