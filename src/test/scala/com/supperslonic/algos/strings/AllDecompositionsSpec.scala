package com.supperslonic.algos.strings

import org.scalatest.{FunSpec, Matchers}

class AllDecompositionsSpec extends FunSpec with Matchers {
  describe("All Decompositions") {
    it("Find 1") {

      val str = "amanaplanacanal"
      val words = Seq("can", "apl", "ana")

      val decompositions = new AllDecompositions()
      val result = decompositions.find(str, words)

      println(result)
      result shouldBe Seq("aplanacan")
    }
    it("Find 2") {

      val str = "barfoothefoobarman"
      val words = Seq("bar", "foo")

      val decompositions = new AllDecompositions()
      val result = decompositions.find(str, words)

      println(result)
      result shouldBe Seq("barfoo", "foobar")
    }
  }
}
