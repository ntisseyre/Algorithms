package com.supperslonic.algos.arrays

import scala.collection.mutable

class DeleteKey {
  def delete(elems: mutable.Seq[Int], key: Int): Unit = {
    var j = 0
    for (i <- elems.indices) {
      if (elems(i) != key) {
        elems(j) = elems(i)
        j += 1
      }
    }

    for(c <- j until elems.size){
      elems(c) = 0
    }

    println(s"===== DeleteKey: $elems")
  }
}
