package com.supperslonic.algos.search

/**
  * We can sum the bits in same positions for all the numbers and take modulo with 3.
  * The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
  *
  * Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
  *
  * Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0;
  * Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
  * Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0;
  * Sum of fourth bits%3 = (1)%3 = 1;
  *
  * Hence number which appears once is 1000
  *
  * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
  */
class FindElementOnlyOnce {
  def find(elems: Seq[Int]): Int = {

    var ones = 0
    var twos = 0

    for (i <- elems.indices) {

      //Keep numbers that we saw ONLY TWICE
      twos = twos | (ones & elems(i))

      //Keep numbers that we saw ONLY ONCE
      ones = ones ^ elems(i)

      //If we saw a number 3 times -> it will be both in twos and ones, take the common bits and reset them
      val commonBitMask = ~(ones & twos)
      ones &= commonBitMask
      twos &= commonBitMask
    }

    ones
  }
}
