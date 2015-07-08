package codility

object MaxProductOfThree extends App {

  def solution(array: Array[Int]): Int = {
    if (array.size == 3)
      return array.product
    // a*b*c => a,b - negative lowest and c is max
    // d*e*f => biggest 3 numbers
    var min1, min2 = Integer.MAX_VALUE
    var max1, max2, max3 = Integer.MIN_VALUE
    array.foreach { el =>
      el match {
        case element if (element < min1) =>
          min2 = min1
          min1 = element
        case element if (element < min2) =>
          min2 = element
        case _ =>
      }
      el match {
        case element if (element > max1) =>
          max3 = max2
          max2 = max1
          max1 = element
        case element if (element > max2) =>
          max3 = max2
          max2 = element
        case element if (element > max3) =>
          max3 = element
        case _ =>
      }
    }
    (max1 * max2 * max3).max(min1 * min2 * max1)
  }

//  println(solution(Array(-3, 1, 2, -2, 5, 6)))
//  println(solution(Array(-3, -3, -2, -1)))
  println(solution(Array(3, 1, -1, 6)))
//  println(solution(Array(-5, -6, -4, -7, -10)))
  //  println(solution(Array(-3, 1, 2)))
}
