package com.supperslonic.algos.sorting

import scala.collection.mutable

/**
  * One example of external sorting is the external merge sort algorithm, which is a K-way merge algorithm.
  * It sorts chunks that each fit in RAM, then merges the sorted chunks together.
  *
  * The algorithm first sorts M items at a time and puts the sorted lists back into external memory.
  * It then recursively does a {\displaystyle M/B-way merge on those sorted lists.
  * To do this merge, B elements from each sorted list are loaded into internal memory, and the minimum is repeatedly outputted.
  *
  * For example, for sorting 900 megabytes of data using only 100 megabytes of RAM:
  * Read 100 MB of the data in main memory and sort by some conventional method, like quicksort.
  * Write the sorted data to disk.
  * Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks (there are 900MB / 100MB = 9 chunks),
  * which now need to be merged into one single output file.
  *
  * Read the first 10 MB (= 100MB / (9 chunks + 1)) of each sorted chunk into input buffers in main memory and allocate
  * the remaining 10 MB for an output buffer. (In practice, it might provide better performance to make the output buffer larger
  * and the input buffers slightly smaller.)
  *
  * Perform a 9-way merge and store the result in the output buffer. Whenever the output buffer fills, write it to the final sorted file
  * and empty it.
  *
  * Whenever any of the 9 input buffers empties, fill it with the next 10 MB of its associated 100 MB sorted chunk until no more data
  * from the chunk is available. This is the key step that makes external merge sort work externally -- because the merge algorithm
  * only makes one pass sequentially through each of the chunks, each chunk does not have to be loaded completely;
  * rather, sequential parts of the chunk can be loaded as needed.
  *
  * Historically, instead of a sort, sometimes a replacement-selection algorithm[3] was used to perform the initial distribution,
  * to produce on average half as many output chunks of double the length.
  *
  * Complexity:
  *
  * f(n) = 2*f(n/2) + n
  * where recursively: f(n/2) = 2*f(n/4) + n/2, f(n/4) = 2*f(n/8) + n/4 ...
  * So, f(n) = 2*(2*f(n/4) + n/2) + n =
  *   4*f(n/4) + 2n =
  *   4*(2*f(n/8) + n/4) + 2n =
  *   8*f(n/8) + 3n ... =
  *   2^k*f(n/2^k) + k*n,
  * where k  logN (base 2), gives us n + logN * n
  */
class MergeSort {
  def sort(elems: mutable.Seq[Int], startIndex: Int, endIndex: Int): mutable.ArrayBuffer[Int] = {
    if (startIndex == endIndex) new mutable.ArrayBuffer[Int]() :+ elems(startIndex)
    else {
      val middle = startIndex + (endIndex - startIndex) / 2

      val left = sort(elems, startIndex, middle)
      val right = sort(elems, middle + 1, endIndex)

      val result = mutable.ArrayBuffer[Int]()

      var leftIndex = 0
      var rightIndex = 0

      while (leftIndex < left.size && rightIndex < right.size) {

        if (left(leftIndex) <= right(rightIndex)) {
          result.append(left(leftIndex))
          leftIndex += 1
        }
        else {
          result.append(right(rightIndex))
          rightIndex += 1
        }
      }

      while(leftIndex < left.size) {
        result.append(left(leftIndex))
        leftIndex += 1
      }

      while(rightIndex < right.size) {
        result.append(right(rightIndex))
        rightIndex += 1
      }

      println(s"total result=$result")
      result
    }
  }
}
