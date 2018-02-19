package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class MinimumEditDistanceSpec extends FunSpec with Matchers {
  describe("Minimum Edit Distance") {
    it("Empty String -> Empty String"){
      val str1 = ""
      val str2 = ""

      val editDistance = new MinimumEditDistance()
      editDistance.distance(str1, str2) shouldBe 0
    }
    it("Empty String -> abc"){
      val str1 = ""
      val str2 = "abc"

      val editDistance = new MinimumEditDistance()
      editDistance.distance(str1, str2) shouldBe 3
    }
    it("abc -> Empty String"){
      val str1 = "abc"
      val str2 = ""

      val editDistance = new MinimumEditDistance()
      editDistance.distance(str1, str2) shouldBe 3
    }
    it("a -> abc"){
      val str1 = "a"
      val str2 = "abc"

      val editDistance = new MinimumEditDistance()
      editDistance.distance(str1, str2) shouldBe 2
    }
    it("sunday -> saturday"){
      val str1 = "sunday"
      val str2 = "saturday"

      val editDistance = new MinimumEditDistance()
      editDistance.distance(str1, str2) shouldBe 3
    }
  }
}
