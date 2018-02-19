package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class PatternMatchingSpec extends FunSpec with Matchers {
  describe("Pattern Matching") {
    it("Empty String, Empty Pattern") {
      val str = ""
      val pattern = ""

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe true
    }
    it("Empty Pattern") {
      val str = "abc"
      val pattern = ""

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe false
    }
    it("Empty String and *") {
      val str = ""
      val pattern = "*"

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe true
    }
    it("Empty String and Pattern") {
      val str = ""
      val pattern = "a"

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe false
    }
    it("Matching") {
      val str = "xaabyc"
      val pattern = "xa*b?c"

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe true
    }
    it("Not Matching") {
      val str = "xaaaabycc"
      val pattern = "xa*b?c"

      val patternMatching = new PatternMatching()
      patternMatching.isMatch(str, pattern) shouldBe false
    }
  }
}
