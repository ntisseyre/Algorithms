package com.supperslonic.algos.dynamic

class EditDistance {

  def find(word1: String, word2: String): Int = {
    val editOperations = new Array[Int](word1.length)

    for (j <- 0 until word1.length) {
      editOperations(j) = j + 1
    }

    //println(editOperations.toSeq)

    for (i <- 0 until word2.length) {
      var replace = i
      for (j <- 0 until word1.length) {
        val insert = editOperations(j)
        if (word2(i) == word1(j)) {
          editOperations(j) = replace
        } else {
          val delete = if (j == 0) i + 1 else editOperations(j - 1)
          editOperations(j) = Math.min(insert, Math.min(replace, delete)) + 1
        }
        replace = insert
      }

      //println(editOperations.toSeq)
    }

    editOperations.last
  }

}
