package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class WordLadderSpec extends FunSpec with Matchers {
  describe("Find Ladder") {
    it("1") {

      val beginWord = "hit"
      val endWord = "cog"
      val wordList = Seq("hot","dot","dog","lot","log","cog").toList

      val ladder = new WordLadder()
      ladder.findLadders(beginWord, endWord, wordList) shouldBe Seq(
        Seq("hit","hot","dot","dog","cog"),
        Seq("hit","hot","lot","log","cog")
      )
    }
    it("2") {

      val beginWord = "hot"
      val endWord = "dot"
      val wordList = Seq("hot","dot","dog").toList

      val ladder = new WordLadder()
      ladder.findLadders(beginWord, endWord, wordList) shouldBe Seq(Seq("hot", "dot"))
    }
  }
  describe("Edit length") {
    it("hot -> lot") {
      val word = "hot"
      val nextWord = "lot"

      val ladder = new WordLadder()
      ladder.editLength(word, nextWord) shouldBe 1
    }
    it("hot -> lott") {
      val word = "hot"
      val nextWord = "lott"

      val ladder = new WordLadder()
      ladder.editLength(word, nextWord) shouldBe 2
    }
  }
}
