package com.supperslonic.algos.strings

import org.scalatest.{FunSpec, Matchers}

class JustifyTextSpec extends FunSpec with Matchers {

  describe("Justify Text") {
    it("Justify") {

      val words = Seq("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dogs")

      val algorithm = new JustifyText()
      val result = algorithm.justify(words, 11)

      println(result)

    }
  }
}
