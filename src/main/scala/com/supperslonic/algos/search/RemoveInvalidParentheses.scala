package com.supperslonic.algos.search

import scala.collection.mutable

class RemoveInvalidParentheses {
  def removeInvalidParentheses(s: String): List[String] = {

    var insertIndex = 0
    var open = 0
    var close = 0

    val result = mutable.ArrayBuffer[String]()

    val letters = mutable.Stack[Int]()

    val straight = new mutable.StringBuilder()

    for (i <- 0 until s.length) {
      val char = s(i)
      if ('('.equals(char)) {
        open += 1
      } else if (')'.equals(char)) {
        if (open > 0) {
          open -= 1

          straight.insert(insertIndex, '(')
          while (letters.nonEmpty) {
            insertIndex += 1
            straight.insert(insertIndex, s(letters.pop()))
            insertIndex += 1
          }

          if (open == 0) {
            insertIndex = straight.length + 1
          }

          straight.append(')')
        }
      }
      else {
        if (open == 0) {
          straight.append(s(i))
          insertIndex += 1
        }
        else {
          letters.push(i)
        }
      }
    }

    while(letters.nonEmpty) straight.append(s(letters.pop()))
    result.append(straight.toString())

    insertIndex = 0
    val reverseStringBuilder = new mutable.StringBuilder()
    //Reverse
    for (i <- (s.length - 1) to 0 by -1) {
     // println(reverseStringBuilder.toString())
      val char = s(i)
      if (')'.equals(char)) {
        close += 1
      } else if ('('.equals(char)) {
        if (close > 0) {
          reverseStringBuilder.insert(insertIndex, ')')
          while(letters.nonEmpty) reverseStringBuilder.insert(0, s(letters.pop()))
          reverseStringBuilder.insert(0, '(')
          close -= 1
          if (close > 0) {
            insertIndex += 2
          } else {
            insertIndex = 0
          }
        }
      }
      else {
        if(close == 0) {
          reverseStringBuilder.insert(0, s(i))
        }
        else {
          letters.push(i)
        }
      }
    }

    if (reverseStringBuilder.nonEmpty && reverseStringBuilder != straight) result.append(reverseStringBuilder.toString())
    result.toList
  }
}
