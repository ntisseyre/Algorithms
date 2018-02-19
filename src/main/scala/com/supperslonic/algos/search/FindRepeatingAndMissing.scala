package com.supperslonic.algos.search

case class RepeatingAndMissing(repeating: Int, missing: Int)
class FindRepeatingAndMissing {

  private val IntSize = 32

  def find(elems: Seq[Int]): RepeatingAndMissing = {

    //Get only good elements
    var tmp = 0
    for (i <- elems.indices) {
      tmp ^= elems(i)
    }

    //For all elements from [1..n] xor with good elements, so only duplicate and missing will be left
    for (i <- elems.indices) {
      tmp ^= (i + 1)
    }

    println(s"Duplicate and Missing = $tmp")

    //A bit is set in xor only if corresponding bits in X and Y are different. This is the crucial step to understand.
    //We take a set bit in XOR. Let us consider the rightmost set bit in XOR:
    //Note: 110 -> the right most SET bit is 010
    /* Get the rightmost set bit in set_bit_no */

    //http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
    /**
      *       01011000    (x)
      *   &   01010111    (x-1)
      *       --------
      *       01010000
      *
      *       subtracting one from X sets all the lower bits to one and changes that rightmost bit to 0
      *       than we reverse the mask and do intersection -> only the rightmost bit matches 1
      */
    val setBitInXor = tmp & ~(tmp - 1)

    var contains = 0
    var notContains = 0
    /* Now divide elements in two sets by comparing
    rightmost set bit of xor1 with bit at same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
    for (i <- elems.indices) {
      if ((elems(i) & setBitInXor) == setBitInXor) {
        contains ^= elems(i)
      } else {
        notContains ^= elems(i)
      }
    }
    for (i <- elems.indices) {
      val elem = i + 1
      if ((elem & setBitInXor) == setBitInXor) {
        contains ^= elem
      } else {
        notContains ^= elem
      }
    }

    //Xor duplicate out and we get missing
    RepeatingAndMissing(contains, notContains)
  }
}
