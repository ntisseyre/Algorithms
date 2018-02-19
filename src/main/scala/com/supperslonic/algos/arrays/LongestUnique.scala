package com.supperslonic.algos.arrays

import scala.collection.mutable

class LongestUnique {
  def find(elems: Seq[Int]): (Int, Int) = {

    var max = 0
    var startIndex = 0

    var currentMax = 0
    var currentStartIndex = 0
    val uniqueIndex = new mutable.HashMap[Int, Int]()

    for (i <- elems.indices) {
      if (uniqueIndex.contains(elems(i))) {

        println(s"currentMax=$currentMax, currentStartIndex=$currentStartIndex")
        if (max < currentMax) {
          max = currentMax
          startIndex = currentStartIndex
        }

        currentMax = i - uniqueIndex(elems(i))
        currentStartIndex = uniqueIndex(elems(i)) + 1

        println(s"New currentMax=$currentMax, currentStartIndex=$currentStartIndex")
      } else {
        uniqueIndex.put(elems(i), i)
        currentMax += 1
      }
    }

    if (max < currentMax) {
      max = currentMax
      startIndex = currentStartIndex
    }

    (startIndex, startIndex + max)
  }
}
