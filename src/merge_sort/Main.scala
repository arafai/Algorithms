package merge_sort

import scala.collection.immutable.Stream.Empty


object Main extends App {
  //  val fibs:Stresam[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  implicit def IntIntLessThan(x: Int, y: Int) = x < y

  println(mergeSort(List(4, 2, 1, 3)))
  println(merge(List(4, 2, 1, 3).toStream, List(8, 6, 5, 7).toStream).toList)


  def merge(first: Stream[Int], second: Stream[Int]): Stream[Int] =
    (first, second) match {
      case (x #:: xs, ys@(y #:: _)) if x <= y => x #:: merge(xs, ys)
      case (xs, y #:: ys) => y #:: merge(xs, ys)
      case (xs, Empty) => xs
      case (Empty, ys) => ys
    }

  def mergeSort[T](xs: List[T])(implicit pred: (T, T) => Boolean): List[T] = {
    val m = xs.length / 2
    if (m == 0) xs
    else {
      @scala.annotation.tailrec
      def merge(ls: List[T], rs: List[T], acc: List[T] = List()): List[T] =
        (ls, rs) match {
          case (Nil, _) => acc ++ rs
          case (_, Nil) => acc ++ ls
          case (l :: ls1, r :: rs1) =>
            if (pred(l, r)) merge(ls1, rs, acc :+ l)
            else merge(ls, rs1, acc :+ r)
        }
      val (l, r) = xs splitAt m
      merge(mergeSort(l), mergeSort(r))
    }
  }

}
