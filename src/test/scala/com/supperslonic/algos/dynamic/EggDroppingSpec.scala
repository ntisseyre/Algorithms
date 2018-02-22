package com.supperslonic.algos.dynamic

import org.scalatest.{FunSpec, Matchers}

class EggDroppingSpec extends FunSpec with Matchers {
  describe("Minimum Attempts For Egg Dropping") {
    it("6 floors, 2 eggs") {

      val eggs = 2
      val floors = 6

      val eggDropping = new EggDropping()
      eggDropping.minimumAttempts(eggs, floors) shouldBe 3
    }
  }
}
