package heap_sort

import scala.collection.mutable._
import scala.util.Random

//heapify - for a specific index check values are root > left > right - or swape and call recursive function on swaped element
// O(lg n) - because distribution of array length in binary tree
// build heap - for n/2 to 1 (all not leaf nodes) call heapify
// build heap - O( n * O(heapify)) = O(n*lg n)
// heap sort

object HeapSort {

  private val randGen = new Random()

  def main(args: Array[String]) {
    val arraySize = 10
    val repeat = 1
    var times = perform(repeat, arraySize)
    println("Average: " + averageOf(times) + " ms for " + times.size + " runs.")
  }

  def buildHeap(arr: Array[Int]) {
    ((arr.length / 2.0D).floor.toInt - 1 until -1 by -1).foreach(i => heapify(arr, i, arr.length))
  }

  def heapify(arr: Array[Int], idx: Int, max: Int) {
    val l = left(idx)
    val r = right(idx)
    var largest = if (l < max && arr(l) > arr(idx)) l else idx
    largest = if (r < max && arr(r) > arr(largest)) r else largest
    if (largest != idx) {
      swap(arr, idx, largest)
      heapify(arr, largest, max)
    }
  }

  def swap(s: Array[Int], i: Int, j: Int): Unit = {
    val v = s(i);
    s(i) = s(j);
    s(j) = v
  }

  def initArrayWith(limit: Int): Array[Int] = {
    val list: ListBuffer[Int] = new ListBuffer()
    val randGen = new Random()
    (0 until limit).foreach(i => list += randGen.nextInt(1000000))
    return list.toArray
  }

  def averageOf(benchmarks: ListBuffer[Int]): Long = {
    var sortedBm: Array[Int] = benchmarks.toArray
    heapSort(sortedBm)
    var sum: Int = 0;
    val sumFunc = (t: Int) => sum += t
    // Get rid of best and worst if we ran it more than twice
    if (sortedBm.length > 2)
      sortedBm.slice(1, sortedBm.size - 2).foreach(sumFunc)
    else
      sortedBm.foreach(sumFunc)
    return sum / sortedBm.length
  }

  private def heapSort(arr: Array[Int]): Array[Int] = {
    val x = arr.clone()
    buildHeap(arr)
    (arr.length - 1 until 0 by -1).foreach(i => {
      swap(arr, 0, i)
      heapify(arr, 0, i)
    })
    arr
  }

  private def parent(idx: Int): Int = (idx / 2.0D).floor.toInt

  private def left(idx: Int): Int = 2 * idx + 1

  private def right(idx: Int): Int = (2 * idx) + 2

  private def perform(times: Int, initListSize: Int): ListBuffer[Int] = {
    val benchmarks: ListBuffer[Int] = new ListBuffer[Int]
    (0 until times).foreach(idx => {
      val arr: Array[Int] = initArrayWith(initListSize)
      val start = System.currentTimeMillis()
      heapSort(arr)
      val end = System.currentTimeMillis()
      benchmarks += (end - start).toInt
    });
    benchmarks
  }
}


//sealed trait Tree[+A <: Ordered[A]] {
//
//
//  def get(index: Int): Option[Tree[A]] = {
//    def go(t: Tree[A]): Option[Tree[A]] = {
//      t match {
//        case n: Node[A] if n.index == index => Some(n)
//        case l: Leaf[A] if l.index == index => Some(l)
//        case n: Node[A] if n.index < index => val l = List(go(n.l), go(n.r)).filter(_.isDefined)
//          if (l.isEmpty) None
//          else l.head
//        case Empty | _ => None
//      }
//    }
//    go(this)
//  }
//
//  def setValue(value:Int) = {
//    this
//  }
//
//  def value: Option[A] = this match {
//    case n: Node[A] => Some(n.v)
//    case l: Leaf[A] => Some(l.v)
//    case Empty => None
//  }
//
//  def left: Option[Tree[A]] = this match {
//    case n: Node[A] => Some(n.l)
//    case l: Leaf[A] => None
//    case Empty => None
//  }
//
//  def right: Option[Tree[A]] = this match {
//    case n: Node[A] => Some(n.r)
//    case l: Leaf[A] => None
//    case Empty => None
//  }
//
//  def maxHeapify(index: Int) = {
//    get(index).foreach { tree =>
//      val leftT = tree.left
//      val rightT = tree.right
//      (leftT, rightT) match {
//        case (Some(left), Some(right)) =>
//          (tree.value, left.value, right.value) match {
//            case (Some(value), Some(leftV), Some(rightV)) =>
//              if(leftV.compare(rightV) < 0)
//                if(rightV.compare(value) > 0)
//                  tree.value = rightV
//
//          }
//        case (Some(left), None) =>
//      }
//
//    }
//
//  }
//
//  //  def left(index:Int):Option[Tree[A]] = this match {
//  //    case Leaf => None
//  //  }
//}
//
//case class Node[A](var v: A, index: Int, l: Tree[A], r: Tree[A]) extends Tree[A]
//
//case class Leaf[A](var v: A, index: Int) extends Tree[A]
//
//case object Empty extends Tree[Nothing]
//
//object Run extends App {
//  val t: Tree[Int] = Node(16, 1, Node(4, 2, Node(14, 4, Leaf(2, 8), Leaf(8, 9)), Node(7, 5, Leaf(1, 10), Empty)), Node(10, 3, Leaf(9, 6), Leaf(3, 7)))
//  //  private val maybeTree: Option[Tree[Int]] = t.get(1)
//  //  println(maybeTree.get.value)
//  private val maybeTree2: Option[Tree[Int]] = t.get(5)
//  println(maybeTree2.get.value)
//}
//
////         F
////*      /   \
////*    B       G
////*   / \       \
////*  A   D       I
////*     / \     /
////*    C   E   H
//


