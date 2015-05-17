package max_continous_subarr

object Main extends App {
  val arr = Array(13, -3, -25, 20, -3, -16 - 23, 18, 20, -7, 12, -5, -22, 15, -4)
  val res: (Int, Int, Int) = maxSubArray(arr, 0, arr.length - 1)
  println(res)
  println(arr(res._1))
  println(arr(res._2))


  def maxCrossingSubArray(elems: Array[Int], low: Int, mid: Int, high: Int): (Int, Int, Int) = {
    var sum = 0
    var leftSum, rightSum, maxLeft, maxRight = Integer.MIN_VALUE
    (mid.to(low, -1)).foreach { index =>
      sum += elems(index)
      if (sum > leftSum) {
        leftSum = sum
        maxLeft = index
      }
    }
    sum = 0
    ((mid + 1) to high).foreach { index =>
      sum += elems(index)
      if (sum > rightSum) {
        rightSum = sum
        maxRight = index
      }
    }
    (maxLeft, maxRight, leftSum + rightSum)
  }


  def maxSubArray(elems: Array[Int], low: Int, high: Int): (Int, Int, Int) =
    if (high == low)
      return (low, high, elems(low))
    else {
      val mid = (low + high) / 2
      val leftie = maxSubArray(elems, low, mid)
      val rightie = maxSubArray(elems, mid + 1, high)
      val cross = maxCrossingSubArray(elems, low, mid, high)
      if (leftie._3 >= rightie._3 && leftie._3 >= cross._3)
        leftie
      else if (rightie._3 >= leftie._3 && rightie._3 >= cross._3)
        rightie
      else cross
    }


}
