package com.supperslonic.algos.strings

import org.scalatest.{FunSpec, Matchers}

class SmallestSubstringOfPatternSpec extends FunSpec with Matchers {
  describe("Smallest Substring Of Pattern") {
    it("Find 1") {
      val str = "this is a test string"
      val pattern = "tist"

      val smallestSubstringOfPattern = new SmallestSubstringOfPattern()
      val result = smallestSubstringOfPattern.find(str.iterator, pattern)

      str.substring(result._1, result._2) shouldBe "t stri"
    }
    it("Find 2") {
      val str = "geeksforgeeks"
      val pattern = "ork"

      val smallestSubstringOfPattern = new SmallestSubstringOfPattern()
      val result = smallestSubstringOfPattern.find(str.iterator, pattern)

      str.substring(result._1, result._2) shouldBe "ksfor"
    }
  }
}
