package com.supperslonic.algos.general

class PowerOf4 {

  def isPowerOf4(number: Int): Boolean = {
    if (number == 1) return true
    if (number < 4) return false

    var tmp = number
    while (tmp > 4) {
      if ((tmp % 4) == 0) tmp = tmp / 4 else return false
    }
    tmp == 4
  }

  def isPowerOf4Good(number: Int): Boolean = {
    if (number == 0) return false
    if (number == 1) return true
    ((number & (number - 1)) == 0) && ((number & 0x55555554) == number)
  }
}
