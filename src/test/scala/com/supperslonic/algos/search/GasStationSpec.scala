package com.supperslonic.algos.search

import org.scalatest.{FunSpec, Matchers}

class GasStationSpec extends FunSpec with Matchers {
  describe("Can visit all stations") {
    it("No stations") {
      val gas = Seq.empty[Int]
      val cost = Seq.empty[Int]
      val gasStations = new GasStation()

      gasStations.canCompleteCircuit(gas, cost) shouldBe -1
    }

    it("2 stations") {
      val gas = Seq(5, 4)
      val cost = Seq(6, 3)
      val gasStations = new GasStation()

      gasStations.canCompleteCircuit(gas, cost) shouldBe 1
    }

    it("Multi stations") {
      val gas = Seq(1, 2, 3, 4, 5)
      val cost = Seq(3, 4, 5, 1, 2)
      val gasStations = new GasStation()

      gasStations.canCompleteCircuit(gas, cost) shouldBe 3
    }
  }
}
