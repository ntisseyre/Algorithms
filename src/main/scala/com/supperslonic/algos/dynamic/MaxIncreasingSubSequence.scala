package com.supperslonic.algos.dynamic

/**
  * Memoization and Tabulation
  * --------------------------------
  * In computing, memoization or memoisation is an optimization technique used primarily to speed up computer programs
  * by storing the results of expensive function calls and returning the cached result when the same inputs occur again.
  *
  * Memoization vs Tabulation
  * --------------------------------
  *
  * Tabulation = Bottom Up
  *
  * As the name itself suggests starting from the bottom and cumulating answers to the top. Let’s discuss in terms of state transition.
  * Let’s describe a state for our DP problem to be dp[x] with dp[0] as  base state and  dp[n] as our destination state.
  * So, we need to find the value of destination state i.e dp[n].
  * If we start our transition from our base state i.e dp[0] and follow our state transition relation to reach our destination state dp[n],
  * we call it Bottom Up approach as it is quite clear that we started our transition from the bottom base state
  * and reached the top most desired state.
  *
  * Factorial example:
  * int dp[0] = 1;
  * for (int i = 1; i< =n; i++)
  * { dp[i] = dp[i-1] * i; }
  *
  *
  * Memoization = Top Down
  *
  * Once, again let’s describe it in terms of state transition. If we need to find the value for some state say dp[n]
  * and instead of starting from the base state that i.e dp[0] we ask our answer from the states that can reach
  * the destination state dp[n] following the state transition relation, then it is the top-down fashion of DP.
  *
  * Factorial example:
  *
  * // initialized to -1
  * int dp[MAXN]
  *
  * int solve(int x)
  * {
  *   if (x==0) return 1;
  *   if (dp[x]!=-1) return dp[x];
  *   return (dp[x] = x * solve(x-1));
  * }
  */
class MaxIncreasingSubSequence {

  def search(elems: Seq[Int]): Int = {

    val tabulation = new Array[Int](elems.size)
    for (i <- tabulation.indices) tabulation(i) = 1

    for (i <- 1 until elems.size) {
      for (j <- 0 until i) {
        if (elems(j) < elems(i) && (tabulation(i) < tabulation(j) + 1)) {
          tabulation(i) = tabulation(j) + 1
        }
        println(tabulation.toSeq)
      }
    }

    tabulation.max
  }

  def searchRecursive(elems: Seq[Int]): Int = {
    searchRecursive(elems, elems.size)
  }

  /**
    * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
    * where recursively f(n-1) = f(n-2) + f(n-3) + ... f(1)
    *
    * Clearly, we can observe that f(n) = 2*f(n-1)
    * So our compact recurrence relation is f(n) = 2*f(n-1).
    *
    * f(n) = 2*f(n-1)
    * f(n-1) = 2*f(n-2)
    * ...
    * f(2) = 2*f(1)
    * f(1) = 2*f(0)
    *
    * Among the above equations, multiply the ith equation by 2^(i-1) and then add all the equations.
    * We clearly then have f(n) = (2^n)*f(0) = O(2^n).
    *
    * Hence the complexity is exponential = O(2^n).
    *
    *               lis(4)
    *
    *           /       |      \
    *       lis(3)      lis(2)    lis(1)
    *      /     \        /
    *   lis(2)  lis(1)   lis(1)
    *     /
    *   lis(1)
    *
    */
  def searchRecursive(elems: Seq[Int], size: Int): Int = {

    if (size == 1) return 1

    // 'max_ending_here' is length of LIS ending with arr[n-1]
    var maxEndingHere = 1
    /* Recursively get all LIS ending with arr[0], arr[1] ... arr[n-2].
       If arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs to be updated, then update it.
    */
    for (i <- 1 until size) {
      println(s"searchRecursive(elems, $i)")
      val maxSubSeq = searchRecursive(elems, i)
      println(s"maxSubSeq=$maxSubSeq and ${elems(i - 1)} < ${elems(size - 1)} ?")
      if (elems(i - 1) < elems(size - 1) && (maxSubSeq + 1) > maxEndingHere) maxEndingHere = maxSubSeq + 1
    }

    maxEndingHere
  }
}
