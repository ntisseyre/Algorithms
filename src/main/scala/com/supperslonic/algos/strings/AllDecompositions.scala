package com.supperslonic.algos.strings

import scala.collection.mutable

/**
  * Str: "barfoothefoobarman"
  * Words: ["foo", "bar"]
  * Result indices: [0,9].
  */
class AllDecompositions {
  def find(str: String, words: Seq[String]): Seq[String] = {
    if (words.isEmpty) return Seq.empty[String]

    val wordsSet = words.toSet
    val wordSize = words.head.length

    println(s"wordSize=$wordSize")

    val result = mutable.ArrayBuffer[Int]()

    for (i <- 0 to str.length - (wordSize * wordsSet.size)) {
      if (checkWords(str, i, wordsSet, wordSize)) {
        result.append(i)
      }
    }
    result.map(startIndex => str.substring(startIndex, startIndex + wordSize * wordsSet.size))
  }

  /**
    * All words must appear at least once in str
    */
  def checkWords(str: String, startIndex: Int, wordsSet: Set[String], wordSize: Int): Boolean = {
    for (i <- 0 until wordsSet.size) {
      val start = startIndex + i * wordSize
      val subStr = str.substring(start, start + wordSize)
      println(s"sub-string: $subStr")
      if (!wordsSet.contains(subStr)) return false
    }
    true
  }
}
