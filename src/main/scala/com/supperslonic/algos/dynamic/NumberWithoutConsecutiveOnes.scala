package com.supperslonic.algos.dynamic

import scala.collection.mutable

class NumberWithoutConsecutiveOnes {
  def find(n: Int): Int = {
    if (n == 0) return 0

    val total = log2(n)
    val tablulation = new Array[Int](total)
    tablulation(0) = 2 //2
    tablulation(1) = 3 //4
    for (i <- 1 until total) {
      tablulation(i) = tablulation(i - 1) + 1
    }
    0
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
