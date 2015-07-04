package codility.maxSliceProb

//A non-empty zero-indexed array A consisting of N integers is given.
//
//A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//
//The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//
//For example, array A such that:
//
//A[0] = 3
//A[1] = 2
//A[2] = 6
//A[3] = -1
//A[4] = 4
//A[5] = 5
//A[6] = -1
//A[7] = 2
//
//contains the following example double slices:
//
//double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//double slice (3, 4, 5), sum is 0.
//
//The goal is to find the maximal sum of any double slice.
//
//Write a function:
//
//int solution(int A[], int N);
//
//that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.

object MaxDoubleSlice extends App {

  def solution(array: Array[Int]): Int = {
    var maxEnding, maxSlice = 0
    array.foreach { elem =>
      maxEnding = 0.max(maxEnding + elem)
      maxSlice = maxSlice.max(maxEnding)
    }
    maxSlice
  }

  println(solution(Array(3, 2, -6, 4, 0)))
  println(solution(Array(-1, -2, 3, 4, -5, 6)))
}
