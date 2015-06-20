package codility

object CountDiv extends App {

  def solution(a: Int, b: Int, k: Int): Int = {
    if (a % k == 0)
      (b - a) / k + 1
    else
      (b - (a - a % k)) / k
  }

  println(solution(11, 345, 17))
  println(solution(6, 11, 2))
  println(solution(10, 10, 7))
  println(solution(0, Int.MaxValue, Int.MaxValue))
  println(solution(0, 0, 11))
}
