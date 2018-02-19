package com.supperslonic.algos.arrays

import scala.collection.mutable

class RemoveDuplicates {
  def remove(elems: mutable.Seq[Int]): Unit = {
    var j = 0

    for (i <- 1 until elems.size) {
      if (elems(i) != elems(j)) {
        j += 1
        elems(j) = elems(i)
      }
    }

    for(c <- j + 1 until elems.size)
      elems(c) = 0

    println(s"===== RemoveDuplicates: $elems")
  }
}
