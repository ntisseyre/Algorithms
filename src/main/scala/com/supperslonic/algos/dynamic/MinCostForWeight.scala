package com.supperslonic.algos.dynamic

import scala.collection.mutable

case class CostItem(weight: Int, cost: Int)
class MinCostForWeight {
  def pick(items: Seq[CostItem], weight: Int): Int = {

    val tmpResults = new Array[Int](items.size + 1)
    val takeMe = mutable.ArrayBuffer[mutable.ArrayBuffer[CostItem]]()
    for (i <- 0 to weight) takeMe.append(mutable.ArrayBuffer[CostItem]())

    for (i <- items.indices) {
      val currentItem = items(i)
      for (j <- currentItem.weight to weight) {
        println(tmpResults.toSeq)
        if (tmpResults(j) == 0 || tmpResults(j) > currentItem.cost + tmpResults(j - currentItem.weight)) {
          tmpResults(j) = currentItem.cost + tmpResults(j - currentItem.weight)
          takeMe(j).clear()
          takeMe(j).append(currentItem)
          takeMe(j).appendAll(takeMe(j - items(i).weight))
        }
      }
    }

    println(takeMe.last)
    tmpResults.last
  }
}
