package com.supperslonic.algos.dynamic

class SubsetSum {
  def exists(elems: Seq[Int], sum: Int): Boolean = {
    val exists = new Array[Boolean](sum + 1)
    exists(0) = true

    elems.foreach(elem => {
      print(s"$elem: ")
      for (i <- sum to elem by -1) {
        exists(i) = exists(i) || exists(i - elem)
      }
      println(exists.toSeq)
    })

    exists(sum)
  }
}
