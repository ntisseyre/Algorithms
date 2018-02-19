package com.supperslonic.algos.dynamic

class NumberOfBinaryTrees {
  def find(n: Int): Int = {

    if(n == 0) return 0

    val tabulation = new Array[Int](n + 1)
    tabulation(0) = 1
    tabulation(1) = 1

    for (i <- 2 to n) {
      for (j <- 0 until i) {
        val leftCount = j
        val rightCount = i - leftCount - 1
        tabulation(i) += tabulation(leftCount) * tabulation(rightCount)
      }
    }

    tabulation.last
  }
}
