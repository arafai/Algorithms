package cut_rod_problem

object CutRodCutting extends App {


  def cutRod(prices: Array[Int], n: Int): Int = {
    def cutRodRec(m: Int): Int = {
      if (m == 0)
        return 0
      var q = Int.MinValue
      (1 to m).foreach { i =>
        q = q.max(prices(i - 1) + cutRodRec(m - i))
      }
      q
    }
    cutRodRec(n)
  }

  def memoizedCutRod(prices: Array[Int], n: Int): Int = {
    val r = Array.fill[Int](n)(Int.MinValue)
    def cutRodRec(m: Int): Int = {
      if (m == 0) {
        return 0
      }
      if (r(m - 1) > 0)
        return r(m - 1)
      var q = 0
      q = Int.MinValue
      (1 to m).foreach { i =>
        q = q.max(prices(i - 1) + cutRodRec(m - i))
      }
      r(m-1) = q
      q
    }
    cutRodRec(n)
  }


  println(cutRod(Array(1, 5, 8, 9), 4))
  println(memoizedCutRod(Array(1, 5, 8, 9), 4))

}
