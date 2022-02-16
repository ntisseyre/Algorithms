package com.supperslonic.algos.futures

import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

class FuturesSpec extends FunSpec with Matchers {
  describe("Test Futures") {
    it("No Exception") {
      val futures = new Futures

      val futureResult = futures.transform(throwException = false)
      val result = Await.result(futureResult, 1 second)
      result shouldBe "42"
    }

    it("Throws Exception") {
      val futures = new Futures

      val futureResult = futures.transform(throwException = true)
      try {
        Await.result(futureResult, 1 second)
        fail("No exception has been thrown")
      } catch {
        case ex: Throwable => ex.getMessage shouldBe "Ooops!"
      }
    }

    it("Sleeps, no dependency") {
      val futures = new Futures

      val futureResult = futures.sleep()
      val result = Await.result(futureResult, 4 seconds)

      result shouldBe "stringResult"
    }
  }
}
