package com.supperslonic.algos.sorting

import scala.collection.mutable

class InsertionSort {
  def sort(elems: mutable.Seq[Int]): Unit = {

    for (i <- 1 until elems.size) {

      var j = i - 1
      val key = elems(i)

      while (j >= 0 && elems(j) > key) {
        elems(j + 1) = elems(j)
        j -= 1
      }

      elems(j + 1) = key
    }
  }
}
