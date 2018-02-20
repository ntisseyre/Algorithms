package com.supperslonic.algos.dynamic

import scala.collection.mutable

class NumberWithoutConsecutiveOnes {
  def find(n: Int): Int = {
    val sequence = mutable.ArrayBuffer[Int]()
    for (i <- 0 until n) sequence.append(if (i == 0 || i == 1) 1 else 0)

    for (i <- 2 until n) {
      sequence(i) = sequence(i - 1) + sequence(i - 2)
    }
    sequence.last
  }

  def log2(elem: Int): Int = {
    var result = 0
    var tmp = elem
    while (tmp != 1) {
      result += 1
      tmp = tmp >> 1
    }

    println(s"2 ^ $result = $elem")
    result
  }
}
