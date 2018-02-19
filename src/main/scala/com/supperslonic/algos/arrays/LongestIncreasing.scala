package com.supperslonic.algos.arrays

class LongestIncreasing {
  def find(elems: Seq[Int]): (Int, Int) = {

    var max = 0
    var startIndex = 0

    var maxCurrent = 0
    var startCurrent = 0
    for (i <- 1 until elems.size) {
      if (elems(i - 1) <= elems(i)) {
        maxCurrent += 1
      } else {

        if (max < maxCurrent) {
          max = maxCurrent
          startIndex = startCurrent
        }
        maxCurrent = 0
        startCurrent = i
      }
    }

    if (max < maxCurrent) {
      max = maxCurrent
      startIndex = startCurrent
    }

    (startIndex, startIndex + max)
  }
}
