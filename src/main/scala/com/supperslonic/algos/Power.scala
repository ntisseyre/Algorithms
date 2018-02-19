package com.supperslonic.algos

class Power {

  def power(elem: Int, p: Int): Int = {

    val result = calculate(elem, p)
    println(s"=== Power $elem of $p = $result")
    result
  }

  private def calculate(elem: Int, p: Int): Int = {
    if (p == 0) {
      1
    } else {
      val tmp = calculate(elem, p >> 1)
      if ((p & 1) == 1) {
       tmp * tmp * elem
      }
      else {
        tmp * tmp
      }
    }
  }
}
