package com.supperslonic.algos.strings

class KmpSearch {

  /**
    * The length of longest proper prefix-suffix (or len) is always between 0 to n-1.
    * If len is n-1, then all characters in string are same. For example len is 3 for “AAAA”.
    *
    * If len is n-2 and n is even, then two characters in string repeat n/2 times.
    * For example “ABABABAB”, length of lps is 6.
    * The reason is if the first n-2 characters are same as last n-2 character, the starting from the first pair,
    * every pair of characters is identical to the next pair. The following diagram demonstrates same for substring of length 4.
    *
    * @param str
    * @return
    */
  def isRepeating(str: String): Boolean = {
    val lps = computeLPS(str)

    // Find length of the longest suffix
    val len = lps.last

    // If there exist a suffix which is also prefix AND
    // Length of the remaining substring divides total
    // length, then str[0..n-len-1] is the substring that
    // repeats n/(n-len) times (Readers can print substring
    // and value of n/(n-len) for more clarity.
    len > 0 && (str.length % (str.length - len) == 0)
  }
  def computeLPS(str: String): Seq[Int] = {
    val lps = new Array[Int](str.length)

    var i = 1
    var j = 0
    lps(0) = 0

    while (i < str.length) {
      if (str(j) == str(i)) {
        j += 1
        lps(i) = j
        i += 1
      } else {
        if (j == 0) {
          lps(i) = 0
          i += 1
        } else {
          j = lps(j - 1)
        }
      }
    }

    println(lps.toSeq)
    lps
  }
}
