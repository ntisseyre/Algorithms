package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class RemoveInvalidParenthesesSpec extends FunSpec with Matchers {
  describe("Remove the minimum number of invalid parentheses in order to make the input string valid. " +
    "Return all possible results.") {

    it("Empty String") {
      //Input
      val s = ""

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("")
    }

    it(")(") {
      //Input
      val s = ")("

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("")
    }

    it("(())(") {
      //Input
      val s = "(())("

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("(())")
    }

    it("(((()))") {
      //Input
      val s = "(((()))"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("((()))")
    }
    it(")()))())))") {
      //Input
      val s = ")()))())))"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("()()", "(())")
    }
    it("()())()") {
      //Input
      val s = "()())()"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("()()()", "(())()")
    }
    it("()())()((())") {
      //Input
      val s = "()())()((())"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("()()()(())", "(())()(())")
    }
    it("(a)())()") {
      //Input
      val s = "(a)())()"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("(a)()()", "(a())()")
    }
    it("p(r)") {
      //Input
      val s = "p(r)"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("p(r)")
    }
    it(")(f") {
      //Input
      val s = ")(f"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("f")
    }
    it("zw(()") {
      //Input
      val s = "zw(()"

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("zw()")
    }
    it("(r(()()(") {
      //Input
      val s = "(r(()()("

      val algorithm = new RemoveInvalidParentheses()
      val actual = algorithm.removeInvalidParentheses(s)

      actual shouldBe Seq("(r())", "r()()")
    }
  }
}
