package examples

object ArrayProblems extends App {
  val a = List(1, 2, 3, 4, 5)
  val res = for {
    List(crt, next) <- a.sliding(2)
    //    (crt, next) = (elems.head, elems.tail)
    if (crt % 2 == 0)
    res = crt
  } yield res

  res.foreach(println)





  //
  //
  //  def permutation(nos: List[Int]): List[List[Int]] = {
  //    nos match {
  //      case List(no) => List(List(no))
  //      case list =>
  //        for {
  //          i <- List.range(0, list.length)
  //          p <- permutation(list.slice(0, i) ++ list.slice(i + 1, list.length))
  //        } yield list(i) :: p
  //    }
  //  }
  //
  //  val a = 12;
  //  val b = 13
  //  val c = 14
  //
  //  //  case class Date(day: Int, month: Int, year: Int) {
  //  //    require(year + month + day > 2000)
  //  //    require(year < 3000)
  //  //  }
  //
  //  // cal method on Date instantiation
  //  def yearify(year: Int) =
  //    year match {
  //      case x: Int if x == 0 => 2000
  //      case x: Int if x < 10 => year * 1000
  //      case x: Int if x < 100 => year * 100
  //    }
  //
  //
  //  def createDate(ints: List[Int]): Option[Date] = {
  //    val cal = Calendar.getInstance()
  //    ints match {
  //      case (d, m, y) =>
  //        try{
  //          cal.set(d, m, yearify(y))
  //          Some(cal.getTime)
  //        }catch{
  //          case NonFatal(e) => None
  //        }
  //      case _ => None
  //    }
  //  }
  //
  //  def execute(): Unit = {
  //    val all = List(a, b, c).permutations
  //    val map: Iterator[Option[Date]] = all.map { candidate =>
  //      createDate(candidate)
  //    }
  //    map.flatten.toList.sortBy(_.getTime).head
  //
  //  }


}
