package com.supperslonic.algos.dynamic

import scala.collection.mutable

class Fibonacci {

  def generate(n: Int): Int = {
    val sequence = mutable.ArrayBuffer[Int]()
    for (i <- 0 until n) sequence.append(if (i == 0 || i == 1) 1 else 0)

    for (i <- 2 until n) {
      sequence(i) = sequence(i - 1) + sequence(i - 2)
    }
    sequence.last
  }

  def generateRecursive(n: Int): Int = {
    if (n == 1 || n == 2) {
      1
    } else {
      generateRecursive(n - 1) + generateRecursive(n - 2)
    }
  }
}
