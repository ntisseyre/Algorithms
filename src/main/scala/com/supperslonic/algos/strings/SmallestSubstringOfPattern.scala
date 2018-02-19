package com.supperslonic.algos.strings

import scala.collection.mutable

case class CharCounter(expected: Int, positions: mutable.Queue[Int])
class SmallestSubstringOfPattern {

  def find(strIterator: Iterator[Char], pattern: String): (Int, Int) = {

    val patternMap = new mutable.HashMap[Char, CharCounter]()
    pattern.foreach(char => patternMap.get(char) match {
      case None => patternMap.put(char, CharCounter(1, new mutable.Queue[Int]()))
      case Some(charCounter) => patternMap.put(char, charCounter.copy(expected = charCounter.expected + 1))
    })

    println(s"patternMap=$patternMap")

    var index = 0
    var startIndex: Option[Int] = None
    var endIndex: Option[Int] = None
    val occurrence = mutable.ArrayBuffer[Int]()

    strIterator.foreach(char => {

      if(patternMap.contains(char)) {
        val charCounter = patternMap(char)
        println(s"current=${charCounter.positions.size}, expected=${charCounter.expected}")
        if (charCounter.positions.size == charCounter.expected) {
          println(s"Remove index ${charCounter.positions.last}")
          occurrence.remove(occurrence.indexOf(charCounter.positions.dequeue()))
        }

        charCounter.positions.enqueue(index)
        occurrence.append(index)
        println(s"occurrence=$occurrence")
      }

      // if all the characters are matched
      if (occurrence.size == pattern.length &&
        //Pick the smallest length
        ((startIndex.isEmpty && endIndex.isEmpty) || index - occurrence.head < endIndex.get - startIndex.get)) {

        startIndex = Some(occurrence.head)
        endIndex = Some(occurrence.last + 1)
        println(s"startIndex=$startIndex, endIndex=$endIndex")
      }

      index += 1
    })

    (startIndex.get, endIndex.get)
  }
}
