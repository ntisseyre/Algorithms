package com.supperslonic.algos.strings

import org.scalatest.{FunSpec, Matchers}

class KmpSearchSpec extends FunSpec with Matchers {
  describe("LPS") {
    it("AAACAAAA") {

      val str = "AAACAAAA"
      val kmp = new KmpSearch()

      val lps = kmp.computeLPS(str)
      lps shouldBe Seq(0, 1, 2, 0, 1, 2, 3, 3)
    }
    it("AABAABAAA") {

      val str = "AABAABAAA"
      val kmp = new KmpSearch()

      val lps = kmp.computeLPS(str)
      lps shouldBe Seq(0, 1, 0, 1, 2, 3, 4, 5, 2)
    }
    it("abcdabca") {

      val str = "abcdabca"
      val kmp = new KmpSearch()

      val lps = kmp.computeLPS(str)
      lps shouldBe Seq(0, 0, 0, 0, 1, 2, 3, 1)
    }
  }
  describe("Is Repeating") {
    it("abcabc") {

      val str = "abcabc"
      val kmp = new KmpSearch()

      val isRepeating = kmp.isRepeating(str)
      isRepeating shouldBe true
    }
    it("ababab") {

      val str = "ababab"
      val kmp = new KmpSearch()

      val isRepeating = kmp.isRepeating(str)
      isRepeating shouldBe true
    }
    it("aaacaaa") {

      val str = "aaacaaa"
      val kmp = new KmpSearch()

      val isRepeating = kmp.isRepeating(str)
      isRepeating shouldBe false
    }
  }
}
