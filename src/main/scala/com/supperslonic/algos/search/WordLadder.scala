package com.supperslonic.algos.search

import scala.collection.mutable

case class NextWord(value: String,
                    count: Int = 0,
                    parents: mutable.ArrayBuffer[NextWord] = new mutable.ArrayBuffer[NextWord]())

class WordLadder {
  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
    val searchIn = wordList.to[mutable.Set]
    val removeList = mutable.Map[NextWord, mutable.ArrayBuffer[String]]()

    val nextWords = mutable.Queue[NextWord]()
    nextWords.enqueue(NextWord(beginWord))
    val processed = mutable.Map[String, NextWord]()

    var min = Int.MaxValue

    while (nextWords.nonEmpty) {

      val currentWord = nextWords.dequeue()
      searchIn.remove(currentWord.value) //???

      //Remove siblings from search
      currentWord.parents.foreach(parent => {
        if (removeList.contains(parent)) {
          removeList(parent).foreach(tmp => searchIn.remove(tmp))
          removeList.remove(parent)
        }
      })

      if (currentWord.count < min) {

        searchIn
          .foreach(word => {
            if (isNextWord(currentWord.value, word)) {

              val count = currentWord.count + 1
              var enqueue = false

              processed.get(word) match {
                case None =>
                  val nextWord = NextWord(word, count)
                  nextWord.parents.append(currentWord)
                  processed.put(word, nextWord)
                  enqueue = true

                case Some(processedWord) =>
                  //Don't add word to the processing queue if it is already there
                  if(processedWord.parents.head.count == currentWord.count) {
                    processedWord.parents.append(currentWord)
                  } else if(processedWord.parents.head.count > currentWord.count) {
                    processedWord.parents.clear()
                    processedWord.parents.append(currentWord)
                  }
              }

              if (word == endWord) {
                min = count
              } else {

                if (enqueue) nextWords.enqueue(processed(word))

                removeList.get(currentWord) match {
                  case None =>
                    val tmp = new mutable.ArrayBuffer[String]()
                    tmp.append(word)
                    removeList.put(currentWord, tmp)
                  case Some(tmp) => tmp.append(word)
                }
              }
            }
          })
      }
    }

    /*println(words.size)
    println(processed.size)
    processed.keys.foreach(key => {
      println(key + " " + processed(key).parents.map(p => p.value))
    })
    println("=========")*/
    processed.get(endWord) match {
      case None => List()
      case Some(result) => walkResult(result).map(list => list.reverse)
    }
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

  def walkResult(nextWord: NextWord): List[List[String]] = {
    if (nextWord.parents.isEmpty) {
      List(List(nextWord.value))
    } else {
      nextWord.parents.flatMap(parent => walkResult(parent).map(list => nextWord.value :: list)).toList
    }
  }
}
