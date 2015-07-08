
object StringPermutation extends App {

  def perm(s: String) = {

    def permRec(ss: String, res: String = "") {
      val n = ss.size
      if (ss.size == 0)
        println(res)
      else
      ss.zipWithIndex.foreach { case (ch, i) =>
//        permRec(ss.substring(0, i) + ss.substring(i + 1, n), res + ch)
        permRec(ss.substring(0, i) + ss.substring(i + 1, n), res + ch)
      }
    }

    permRec(s)
  }

  perm("abcd")
}