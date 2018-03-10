package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class EditDistanceSpec extends FunSpec with Matchers {
  describe("Edit Distance") {
    it("saturday -> sunday") {
      val word1 = "saturday"
      val word2 = "sunday"

      val editDistance = new EditDistance()
      editDistance.find(word1, word2) shouldBe 3
    }
    it("abcdef -> azced") {
      val word1 = "abcdef"
      val word2 = "azced"

      val editDistance = new EditDistance()
      editDistance.find(word1, word2) shouldBe 3
    }
  }
}
