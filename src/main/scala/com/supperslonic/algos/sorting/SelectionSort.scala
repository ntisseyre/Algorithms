package com.supperslonic.algos.sorting

import scala.collection.mutable

class SelectionSort {
  def sort(elems: mutable.Seq[Int]): Unit = {

    for (i <- elems.indices) {

      var min = i
      for(j <- i + 1 until elems.size) {
        if(elems(j) < elems(min)) min = j
      }

      val tmp = elems(i)
      elems(i) = elems(min)
      elems(min) = tmp
    }

    println(s"===== SelectionSort: $elems")
  }
}
