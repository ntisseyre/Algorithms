package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class ScoreCombinationsSpec extends FunSpec with Matchers {
  describe("Score Combinations") {
    it("score") {

      val points = Seq(2, 3, 7)
      val game = new ScoreCombinations()

      val combinations = game.count(points, 12)

      println(combinations)
      combinations shouldBe Some(18)
    }
    it("score 3") {

      val points = Seq(1, 2, 3)
      val game = new ScoreCombinations()

      val combinations = game.count(points, 3)

      println(combinations)
      combinations shouldBe Some(3)
    }
  }
}
