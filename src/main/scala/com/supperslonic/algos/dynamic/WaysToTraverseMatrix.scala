package com.supperslonic.algos.dynamic

class WaysToTraverseMatrix {

  def count(size: Int): Option[Int] = {

    val array = new Array[Int](size)

    for (j <- 0 until size) {
      for (i <- 0 until size) {
        array(i) = if(i == 0) 1 else array(i - 1) + array(i)
      }
    }

    array.lastOption
  }
}
