package com.supperslonic.algos.dynamic

import scala.collection.mutable

class Primes {

  def generate(n: Int): Seq[Int] = {

    val primes = mutable.ArrayBuffer[Boolean]()
    for (p <- 2 to n) primes.append(true)

    var p = 2
    while (p * p <= n) {
      if (primes(p - 2)) {
        for (j <- 2 * p to n by p) {
          primes(j - 2) = false
        }
      }

      p += 1
    }

    val result = mutable.ArrayBuffer[Int]()
    for (i <- primes.indices) if (primes(i)) result.append(i + 2)

    result
  }
}
