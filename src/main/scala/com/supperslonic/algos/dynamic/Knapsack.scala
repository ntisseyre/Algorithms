package com.supperslonic.algos.dynamic

import scala.collection.mutable

class Knapsack {

  def pick(items: Seq[Item], capacity: Int): Int = {

    val knapsack = mutable.ArrayBuffer[Int]()
    val takeMe = mutable.ArrayBuffer[mutable.ArrayBuffer[Item]]()
    for (i <- 0 to capacity) knapsack.append(0)
    for (i <- 0 to capacity) takeMe.append(mutable.ArrayBuffer[Item]())

    for (i <- items.indices) {
      for (j <- capacity to items(i).weight by -1) {
        val addOn = knapsack(j - items(i).weight)
        if (knapsack(j) < (items(i).value + addOn)) {
          knapsack(j) = items(i).value + addOn
          takeMe(j).clear()
          takeMe(j).append(items(i))
          takeMe(j).appendAll(takeMe(j - items(i).weight))
        }
      }
      println(knapsack)
      println(takeMe.last)
    }

    knapsack.last
  }

  def pickRecursive(items: Seq[Item], capacity: Int): Int = {
    pickRecursive(items, 0, capacity, 0)
  }

  def pickRecursive(items: Seq[Item], itemIndex: Int, capacity: Int, currentValue: Int): Int = {

    if(items.size == itemIndex) return currentValue

    val currentItem = items(itemIndex)
    val leftWeight = capacity - currentItem.weight

    val betIfNotTake = pickRecursive(items, itemIndex + 1, capacity, currentValue)
    val bestIfTake = if (leftWeight < 0) currentValue else
      pickRecursive(items, itemIndex + 1, leftWeight, currentItem.value + currentValue)

    Math.max(bestIfTake, betIfNotTake)
  }

  def pickFractionalRecursive(items: Seq[Item], capacity: Int): Double = {
    pickFractionalRecursive(items, 0, capacity, 0)
  }
  def pickFractionalRecursive(items: Seq[Item], itemIndex: Int, capacity: Int, currentValue: Double): Double = {

    if (items.size == itemIndex) return currentValue

    val currentItem = items(itemIndex)
    val leftWeight = capacity - currentItem.weight

    val betIfNotTake = pickFractionalRecursive(items, itemIndex + 1, capacity, currentValue)
    val bestIfTake = if (leftWeight < 0){
      pickFractionalRecursive(items, itemIndex + 1, 0, currentItem.value * (capacity.toDouble / currentItem.weight) + currentValue)
    }
       else
      pickFractionalRecursive(items, itemIndex + 1, leftWeight, currentItem.value + currentValue)

    Math.max(bestIfTake, betIfNotTake)
  }
}

case class Item(weight: Int, value: Int)
