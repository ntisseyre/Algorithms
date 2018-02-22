package com.supperslonic.algos.dynamic

class EggDropping {
  def minimumAttempts(eggsCount: Int, floorsCount: Int): Int = {

    val attempts = Array.ofDim[Int](eggsCount + 1, floorsCount + 1)
    for (i <- 0 to floorsCount) attempts(1)(i) = i
    printAttempts(attempts)

    for (i <- 2 to eggsCount) {

      var prevMin = Int.MaxValue
      for (j <- 1 to floorsCount) {

        val ifDropsAttempts = attempts(i - 1)(j - 1)
        val ifNotDropsAttempts = attempts(i)(j)
        prevMin = Math.min(prevMin, Math.max(ifDropsAttempts, ifNotDropsAttempts))

        var max = Int.MinValue
        var min = Int.MaxValue

        for(k <- 1 to j) {
          val ifDropsAttempts1 = attempts(i - 1)(k - 1)
          val ifNotDropsAttempts1 = attempts(i)(j - k)
          max = Math.max(ifDropsAttempts1, ifNotDropsAttempts1)
          println(s"step $k, min=$min")
          min =  Math.min(min, max)
        }

        println(s"prevMin=$prevMin, cycleMax=$max, cycleMin=$min")

        attempts(i)(j) = 1 + min
        printAttempts(attempts)
      }
    }

    attempts.last.last
  }

  def printAttempts(attempts: Array[Array[Int]]): Unit = {
    attempts.foreach(line => println(line.toSeq))
    println()
  }
}
