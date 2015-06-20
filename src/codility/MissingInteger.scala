package codility


object MissingInteger extends App {

  def solution(array: Array[Int]): Int = {
    val map = scala.collection.mutable.Map[Int, Boolean]()
    var max = 0
    array.iterator.foreach { element =>
      if (map.get(element).isEmpty)
        map.put(element, true)
      if (element > max)
        max = element
    }
    var i = 1
    var found = false
    while (i <= max + 1 && !found) {
      if (map.get(i).isEmpty)
        found = true
      else
        i += 1
    }
    i
  }

  println(solution(Array(Integer.MIN_VALUE, Integer.MAX_VALUE)))
}
