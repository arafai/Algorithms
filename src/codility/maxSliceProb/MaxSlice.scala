package codility.maxSliceProb


//A non-empty zero-indexed array A consisting of N integers is given.
// A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
// The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

//Write a function:
//
//int solution(int A[], int N);
//
//that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
//
//For example, given array A such that:
//
//A[0] = 3  A[1] = 2  A[2] = -6
//A[3] = 4  A[4] = 0
//
//the function should return 5 because:
//
//(3, 4) is a slice of A that has sum 4,
//(2, 2) is a slice of A that has sum −6,
//(0, 1) is a slice of A that has sum 5,
//no other slice of A has sum greater than (0, 1).


object MaxSlice extends App {

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
