package com.supperslonic.algos.arrays

import scala.collection.mutable

class NextPremutation {

  /**
    * {1, 0, 3, 2} -> {1, 2, 0, 3}
    */
  def compute(premutation: mutable.Seq[Int]): Seq[Int] = {

    println(s"Original: $premutation")
    val endIndex = premutation.size - 1
    for (i <- endIndex to 1 by -1) {

      if (premutation(i) > premutation(i - 1)) {

        println(s"premutation($i) >  premutation(${i - 1}) => ${premutation(i)} > ${premutation(i - 1)}")
        val minimum = findMinimum(premutation, i - 1)
        swap(premutation, i - 1, minimum)
        println(s"After minimum swap: $premutation")

        //we don't need to sort, because if we are here, means all numbers from right to left are elems(i) < elems(i - 1)
        //and the swap was just with the minimum which is greater than our i - 1, so just reverse an order
        val middle = i + 1 + ((endIndex - i - 1) >> 1)
        println(s"Middle index $middle")
        for (j <- i until middle)
          swap(premutation, i, endIndex - j + i)

        return premutation
      }
    }

    premutation
  }

  private def swap(elems: mutable.Seq[Int], index1: Int, index2: Int): Unit = {
    val tmp = elems(index1)
    elems(index1) = elems(index2)
    elems(index2) = tmp
  }

  private def findMinimum(premutation: mutable.Seq[Int], endIndex: Int): Int = {
    var currentMinimum: Option[Int] = None

    for (i <- premutation.size - 1 until endIndex by -1) {
      if (premutation(i) >= premutation(endIndex)) {
        currentMinimum match {
          case None => currentMinimum = Some(i)
          case Some(index) => if (premutation(i) < premutation(index)) currentMinimum = Some(i)
        }
      }
    }
    currentMinimum.get
  }
}
