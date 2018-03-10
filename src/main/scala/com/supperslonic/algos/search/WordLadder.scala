package com.supperslonic.algos.search

import scala.collection.mutable

class WordLadder {
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {

    findNext(beginWord, endWord, wordList).map(list => beginWord :: list).toList
  }

  def findNext(beginWord: String,
               endWord: String,
               wordList: List[String]): mutable.Set[List[String]] = {

    val nextWords = mutable.Set[String]()
    wordList.foreach(word => if(isNextWord(beginWord, word)) nextWords.add(word))
    val wordListCut = wordList.filterNot(w => w == beginWord || nextWords.contains(w))

    nextWords.flatMap(word => {
        //println(s"findNext for $word")
        if (word == endWord) {
          Set(List(word))
        } else {
          val results = findNext(word, endWord, wordListCut)
          results.map(list => word :: list)
        }
      })
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
