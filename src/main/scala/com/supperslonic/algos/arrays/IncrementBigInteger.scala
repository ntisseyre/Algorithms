package com.supperslonic.algos.arrays

import scala.collection.mutable

class IncrementBigInteger {
  def increment(elems: Seq[Int]): Seq[Int] = {

    var i = elems.size
    val result = new Array[Int](i + 1)

    var next = 1

    for (c <- elems.size - 1 to 0 by -1) {
      val elem = elems(c)
      if (elem == 9 && next == 1) {
        next = 1
        result(i) = 0
      } else {
        result(i) = elem + next
        next = 0
      }
      i -= 1
    }

    result(0) = next

    println(s"====IncrementBigInteger: ${result.toList}")
    result.toList
  }

  def inPlace(elems: mutable.Seq[Int]): Unit = {

    var next = 1

    for (c <- elems.size - 1 to 0 by -1) {
      val elem = elems(c)
      if (elem == 9 && next == 1) {
        next = 1
        elems(c) = 0
      } else {
        elems(c) = elem + next
        next = 0
      }
    }

    println(s"====IncrementBigInteger: $elems")
  }
}
