package com.supperslonic.algos.search

import scala.collection.mutable

case class NextWord(value: String, depth: Int = 0, parent: Option[NextWord] = None)

class WordLadder {
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {

    var parent: Option[NextWord] = None
    val usedWords = mutable.Set[String]()

    val nextWords = mutable.Queue[NextWord]()
    nextWords.enqueue(NextWord(beginWord))

    var min = Int.MaxValue
    val words = mutable.ArrayBuffer[NextWord]()

    while (nextWords.nonEmpty) {

      val currentWord = nextWords.dequeue()

       if (parent.isEmpty || parent != currentWord.parent) {
         usedWords.add(currentWord.value)
         parent = Some(currentWord)
       }

      wordList
        .filterNot(word => usedWords.contains(word))
        .filter(word => isNextWord(currentWord.value, word))
        .map(word => NextWord(word, currentWord.depth + 1, Some(currentWord)))
        .foreach(word => {
          if (word.value == endWord && min >= word.depth) {
            if (min > word.depth) words.clear()
            words.append(word)
            min = word.depth
          } else {
            nextWords.enqueue(word)
          }
        })
    }

    words.map(word => {

      var tmp:Option[NextWord] = Some(word)
      var result: List[String] = Nil
      while(tmp.isDefined) {
        result = tmp.get.value :: result
        tmp = tmp.get.parent
      }
      result
    }).toList
  }

  def isNextWord(word: String, nextWord: String): Boolean = {
    var count = 0
    for(i <- 0 until word.length) {
      if(word(i) != nextWord(i)) {
        if(count == 1) return false else count = 1
      }
    }
    count == 1
  }
}
