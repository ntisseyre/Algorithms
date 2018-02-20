package com.supperslonic.algos.dynamic

/**
  * ‘?’ – matches any single character
  * ‘*’ – Matches any sequence of characters (including the empty sequence)
  */
class PatternMatching {

  def isMatch(str: String, pattern: String): Boolean = {

    val tabulation = Array.ofDim[Boolean](str.length + 1, pattern.length + 1)

    //[0][0] = true, empty string matches empty pattern
    tabulation.head(0) = true

    for (i <- 1 to pattern.length) {
      if (pattern(i - 1) == '*')
        tabulation.head(i) = tabulation.head(i - 1)
    }

    for (i <- 1 to str.length)
      for (j <- 1 to pattern.length) {

        //We have 3 cases:
        val strChar = str(i - 1)
        val patternChar = pattern(j - 1)

        if (strChar == patternChar || patternChar == '?') {
          tabulation(i)(j) = tabulation(i - 1)(j - 1)

        } else if (patternChar == '*') {

          //tabulation(i)(j - 1) - means single occurrence of a character
          //tabulation(i - 1)(j) - means zero occurrence of a character
          tabulation(i)(j) = tabulation(i)(j - 1) || tabulation(i - 1)(j)
        } else {
          tabulation(i)(j) = false
        }
      }

    tabulation.last.last
  }
}
