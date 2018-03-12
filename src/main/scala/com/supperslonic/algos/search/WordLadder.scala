package com.supperslonic.algos.search

import scala.collection.mutable

case class NextWord(value: String, count: Int = 0, parent: Option[NextWord] = None)

class WordLadder {
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
    val searchIn = wordList.to[mutable.Set]
    val removeList = mutable.Map[NextWord, mutable.ArrayBuffer[String]]()

    val nextWords = mutable.Queue[NextWord]()
    nextWords.enqueue(NextWord(beginWord))

    var min = Int.MaxValue
    val words = mutable.ArrayBuffer[NextWord]()

    while (nextWords.nonEmpty) {

      val currentWord = nextWords.dequeue()
      searchIn.remove(currentWord.value)
      if(currentWord.parent.isDefined && removeList.contains(currentWord.parent.get)){
        removeList(currentWord.parent.get).foreach(tmp => searchIn.remove(tmp))
        removeList.remove(currentWord.parent.get)
      }

      if (currentWord.count < min) {


        searchIn
          //.filter(word => isNextWord(currentWord.value, word))
          //.map(word => NextWord(word, currentWord.count + 1, Some(currentWord)))
          .foreach(word => {
          if (isNextWord(currentWord.value, word)) {

            val nextWord = NextWord(word, currentWord.count + 1, Some(currentWord))

            if (nextWord.value == endWord) {
              if (min > nextWord.count) words.clear()
              words.append(nextWord)
              min = nextWord.count
            } else {
              nextWords.enqueue(nextWord)
              removeList.get(currentWord) match {
                case None =>
                  val tmp = new mutable.ArrayBuffer[String]()
                  tmp.append(nextWord.value)
                  removeList.put(currentWord, tmp)
                case Some(tmp) => tmp.append(nextWord.value)
              }
            }
          }
        })
      }
    }

    words.map(word => {

      var tmp: Option[NextWord] = Some(word)
      val result = Array.ofDim[String](word.count + 1)
      while (tmp.isDefined) {
        result(tmp.get.count) = tmp.get.value
        tmp = tmp.get.parent
      }
      result.to[List]
    }).toList
  }

  def isNextWord(word: String, nextWord: String): Boolean = {
    var count = 0
    for (i <- 0 until word.length) {
      if (word(i) != nextWord(i)) {
        if (count == 1) return false else count = 1
      }
    }
    count == 1
  }
}
