package com.supperslonic.algos.search

import scala.collection.mutable

class WordLadder {
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {

    findNext(beginWord, endWord, mutable.Set[String](), wordList).map(list => beginWord :: list)
  }

  def findNext(beginWord: String,
               endWord: String,
               usedWords: mutable.Set[String],
               wordList: List[String]): List[List[String]] = {

    usedWords.add(beginWord)
    val nextWords = wordList.filter(word => !usedWords.contains(word) && isNextWord(beginWord, word))

    //println(s"nextWords = $nextWords")
    nextWords.foreach(word => usedWords.add(word))

    nextWords
      .flatMap(word => {
        //println(s"findNext for $word")
        if (word == endWord) {
          List(List(word))
        } else {
          val results = findNext(word, endWord, usedWords.clone(), wordList)
          results.map(list => word :: list)
        }
      })
  }

  def isNextWord(word: String, nextWord: String): Boolean = editLength(word, nextWord) == 1

  def editLength(word: String, nextWord: String): Int = {
    val editOperations = new Array[Int](word.length)

    for (j <- 0 until word.length) {
      editOperations(j) = j + 1
    }

    //println(editOperations.toSeq)

    for (i <- 0 until nextWord.length) {
      var replace = i
      for (j <- 0 until word.length) {
        val insert = editOperations(j)
        if (nextWord(i) == word(j)) {
          editOperations(j) = replace
        } else {
          val delete = if (j == 0) i + 1 else editOperations(j - 1)
          editOperations(j) = Math.min(insert, Math.min(replace, delete)) + 1
        }
        replace = insert
      }

     //println(editOperations.toSeq)
    }

    editOperations.last
  }
}
