package com.supperslonic.algos.search

class GasStation {
  def canCompleteCircuit(gas: Seq[Int], cost: Seq[Int]): Int = {

    if (gas.isEmpty || cost.isEmpty) {
      return -1
    }

    var start = 0
    val length = gas.size
    var tank = gas(start)
    var current = 1 % length
    var prev = start

    while (current != start) {
      println(s"current: $current, start: $start, tank: $tank, cost: ${cost(prev)}")
      if (tank < cost(prev)) {
        start = current
        tank = gas(current)
        prev = current
        current = (current + 1) % length
      }
      else {
        tank = tank - cost(prev) + gas(current)
        prev = current
        current = (current + 1) % length
      }
    }
    start
  }
}
