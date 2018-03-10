package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class WordLadderSpec extends FunSpec with Matchers {
  describe("Find Ladder") {
    it("1") {

      val beginWord = "hit"
      val endWord = "cog"
      val wordList = Seq("hot", "dot", "dog", "lot", "log", "cog").toList

      val ladder = new WordLadder()
      ladder.findLadders(beginWord, endWord, wordList) shouldBe Seq(
        Seq("hit", "hot", "dot", "dog", "cog"),
        Seq("hit", "hot", "lot", "log", "cog")
      )
    }
    it("2") {

      val beginWord = "hot"
      val endWord = "dot"
      val wordList = Seq("hot", "dot", "dog").toList

      val ladder = new WordLadder()
      ladder.findLadders(beginWord, endWord, wordList) shouldBe Seq(Seq("hot", "dot"))
    }
  }
  describe("Is Next Word") {
    it("hot -> lot") {
      val word1 = "hot"
      val word2 = "lot"

      val ladder = new WordLadder()
      ladder.isNextWord(word1, word2) shouldBe true
    }
    it("hot -> ltt") {
      val word1 = "hot"
      val word2 = "ltt"

      val ladder = new WordLadder()
      ladder.isNextWord(word1, word2) shouldBe false
    }
  }
}
