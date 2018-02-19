package com.supperslonic.algos.strings

class JustifyText {
  def justify(words: Seq[String], justifyLength: Int): String = {

    val result = StringBuilder.newBuilder

    var startIndex = 0
    var numberOfWords = 0
    var lineLength = 0

    for (w <- words.indices) {

      numberOfWords += 1
      val length = words(w).length + (numberOfWords - 1) + lineLength

      if (length == justifyLength) {
        result.append(format(words, startIndex, w, numberOfWords - 1))

        startIndex = w + 1
        lineLength = 0
        numberOfWords = 0

      } else if (length < justifyLength) {
        lineLength += words(w).length
      } else {

        result.append(format(words, startIndex, w - 1, justifyLength - lineLength))

        startIndex = w
        numberOfWords = 1
        lineLength = words(w).length
      }
    }

    result.mkString
  }

  def format(words: Seq[String], startIndex: Int, endIndex: Int, numberOfSpaces: Int): String = {

    val result = StringBuilder.newBuilder

    var used = 0
    val distribution = numberOfSpaces / (endIndex - startIndex)

    for (w <- startIndex until endIndex) {
      result.append(words(w))

      val num = if (w == endIndex - 1) {
        numberOfSpaces - used
      }
      else {
        used += distribution
        distribution
      }

      println(num)
      for (s <- 0 to num)
        result.append("_")
    }

    result.append(words(endIndex))

    println(result.mkString)
    result.mkString
  }
}
