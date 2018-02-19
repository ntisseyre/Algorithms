package com.supperslonic.algos.dynamic

class MinimumEditDistance {
  def distance(str1: String, str2: String): Int = {

    if(str1.length < str2.length) return distance(str2, str1)

    val tabulation = new Array[Int](str2.length + 1)

    for (i <- 0 until str1.length) {
      var replace = tabulation(0)
      tabulation(0) = i + 1
      for (j <- 1 to str2.length) {
        val deletion = tabulation(j)
        tabulation(j) = if (str1(i) == str2(j - 1)) replace else 1 + Math.min(replace,
          Math.min(tabulation(j - 1), deletion))
        replace = deletion
      }
    }

    tabulation.last
  }
}
