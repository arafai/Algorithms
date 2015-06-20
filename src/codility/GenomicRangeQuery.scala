package codility

object GenomicRangeQuery extends App {

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val dnaSeq = s.map(getFactor)
    p zip q map { case (left, right) =>
      dnaSeq.slice(left, right + 1).min
    }
  }

  def getFactor(ch: Char): Int =
    ch match {
      case 'A' => 1
      case 'C' => 2
      case 'G' => 3
      case _ => 4
    }


  println(RafalGenomicRangeQuery.genome("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)).mkString(" "))
}
