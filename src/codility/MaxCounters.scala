package codility

object MaxCounters extends App {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val lastIndexOf = a.lastIndexOf(n + 1)
    if (lastIndexOf < 0)
      regularSolution(n, a)
    else {
      var max = 0
      var i = 0
      val map = scala.collection.mutable.Map[Int, Int]()
      while (i <= lastIndexOf) {
        val elem = a(i)
        if (elem <= n) {
          val counter = map.get(elem)
          if (counter.isDefined) {
            map.put(elem, counter.get + 1)
            if (counter.get + 1 > max)
              max = counter.get + 1
          } else {
            map.put(elem, 1)
            if (1 > max)
              max = 1
          }
        }
        i += 1
      }
      regularSolution(n, a, lastIndexOf, max)
    }


  }

  def regularSolution(n: Int, a: Array[Int], startIndex: Int = 0, max: Int = 0): Array[Int] = {
    var result = Array.fill[Int](n)(max)
    var i = startIndex

    val length = a.length
    while (i < length) {
      val elem = a(i)
      if (elem <= n)
        result(elem - 1) = result(elem - 1) + 1
      i += 1
    }

    result
  }

  println(solution(5, Array(3, 1)).mkString(","))
}
