package binary_tree

/**
 * D Holbrook
 *
 * Code Club: PO1
 *
 * (*) Define a binary tree data structure and related fundamental operations.
 *
 * Use whichever language features are the best fit (this will depend on the language you have selected).  The following operations should be supported:
 *
 * Constructors
 * (bitree data left right) - Should return a binary tree containing data and the left and right children.
 * Accessors
 * (bitree-data t) - Should return the data contained by the tree.
 * (bitree-left t) - Should return the left child of the tree.
 * (bitree-right t) - Should return the right child of the tree.
 * Predicates
 * (bitree-leaf? t) - Should return true if the tree is a leaf (has null left and right children), false otherwise
 */

trait Tree[+A] {

  import scala.annotation.tailrec

  def value: Option[A] = this match {
    case n: Node[A] => Some(n.v)
    case l: Leaf[A] => Some(l.v)
    case Empty => None
  }

  def myPreOrderList(): List[A] = {
    @tailrec
    def rec(tree: List[Tree[A]], acc: List[A]): List[A] = {
      tree match {
        case (n: Node[A]) :: tail =>
          rec((n.l :: n.r :: Nil) ::: tail, acc :+ n.v)
        case (l: Leaf[A]) :: tail => rec(tail, acc :+ l.v)
        case Empty :: tail => rec(tail, acc)
        case _ => acc
      }
    }
    rec(List(this), List[A]())
  }

  def myLevelOrderList(): List[A] = {
    @tailrec
    def rec(tree: List[Tree[A]], acc: List[A]): List[A] = {
      tree match {
        case (n: Node[A]) :: tail =>
          rec(tail ::: (n.l :: n.r :: Nil), acc :+ n.v)
        case (l: Leaf[A]) :: tail => rec(tail, acc :+ l.v)
        case Empty :: tail => rec(tail, acc)
        case _ => acc
      }
    }
    rec(List(this), List[A]())
  }

  def myInOrderList(): List[A] = {
    @tailrec
    def rec(tree: List[Tree[A]], acc: List[A]): List[A] = {
      tree match {
        case (n: Node[A]) :: tail =>
          rec((n.l :: Eval(n.v) :: (n.r) :: Nil) ::: tail, acc)
        case (l: Leaf[A]) :: tail => rec(tail, acc :+ (l.v))
        case (e: Eval[A]) :: tail => rec(tail, acc :+ e.v)
        case Empty :: tail => rec(tail, acc)
        case _ => acc
      }
    }
    rec(List(this), List[A]())
  }

  def myPostOrderList(): List[A] = {
    @tailrec
    def rec(tree: List[Tree[A]], acc: List[A]): List[A] = {
      tree match {
        case (n: Node[A]) :: tail =>
          rec((n.l :: (n.r) :: Eval(n.v) :: Nil) ::: tail, acc)
        case (l: Leaf[A]) :: tail => rec(tail, acc :+ (l.v))
        case (e: Eval[A]) :: tail => rec(tail, acc :+ e.v)
        case Empty :: tail => rec(tail, acc)
        case _ => acc
      }
    }
    rec(List(this), List[A]())
  }

  def height: Int = {
    def loop(t: Tree[A]): Int = t match {
      case l: Leaf[A] => 1
      case n: Node[A] => Seq(loop(n.left.get), loop(n.right.get)).max + 1
      case _ => 0
    }
    loop(this) - 1
  }

  def left: Option[Tree[A]] = this match {
    case n: Node[A] => Some(n.l)
    case l: Leaf[A] => None
    case Empty => None
  }

  def right: Option[Tree[A]] = this match {
    case n: Node[A] => Some(n.r)
    case l: Leaf[A] => None
    case Empty => None
  }

  def leafCount: Int = {
    @tailrec
    def loop(t: List[Tree[A]], z: Int): Int = t match {
      case (n: Node[A]) :: tl => loop(n.left.get :: n.right.get :: tl, z)
      case (l: Leaf[A]) :: tl => loop(tl, z + 1)
      case _ :: tl => loop(tl, z)
      case _ => z
    }
    loop(List(this), 0)
  }

  /**
   * Represents a deferred evaluation of a node value
   */
  private case class Eval[A](v: A) extends Tree[A]

  //  def search(el:Eval[A])(compare:(A, A) => Int):Boolean = {
  //    @tailrec
  //    def searchBinaryTree[A](root:Tree[A]): Boolean = {
  //      this match {
  //        case n: Node[A] => compare(n.value.get,el.v) match {
  //          case 0 => true
  //          case -1 => searchBinaryTree(n.r)
  //          case 1 => searchBinaryTree(n.l)
  //        }
  //        case l: Leaf[A] => compare(l.value.get, el.v) match {
  //          case 0 => true
  //          case _ => false
  //        }
  //        case Empty => false
  //      }
  //    }
  //
  //    searchBinaryTree(this)
  //  }

}

case class Node[A](v: A, l: Tree[A], r: Tree[A]) extends Tree[A]

case class Leaf[A](v: A) extends Tree[A]

case object Empty extends Tree[Nothing]

object Run extends App {
  val t: Tree[Char] = Node('F', Node('B', Leaf('A'), Node('D', Leaf('C'), Leaf('E'))), Node('G', Empty, Node('I', Leaf('H'), Empty)))

  //  t.search('G')((x: Char, y: Char) => x.compareTo(y))

  t.myPreOrderList().foreach(println)
  //  println()
  //  t.myInOrderList().foreach(println)
  //  println()
  //  t.myPostOrderList().foreach(println)
  //  println()
  //  t.myLevelOrderList().foreach(println)
  //  println(t.height)

  //
  /**
   * **** output *********
   *
   * tree: Node('F,Node('B,Leaf('A),Node('D,Leaf('C),Leaf('E))),Node('G,Empty,Node('I,Leaf('H),Empty)))
   * B node: 'B
   * D node: 'D
   * as seq: List('A, 'B, 'C, 'D, 'E, 'F, 'G, 'H, 'I)
   * count: 9
   * height: 3
   * leaft count: 4
   * as seqPreorder: List('F, 'B, 'A, 'D, 'C, 'E, 'G, 'I, 'H)
   * as seqInorder: List('A, 'B, 'C, 'D, 'E, 'F, 'G, 'H, 'I)
   * as seqPostorder: List('A, 'C, 'E, 'D, 'B, 'H, 'I, 'G, 'F)
   * as seqLevelorder: List('F, 'B, 'G, 'A, 'D, 'I, 'C, 'E, 'H)
   * last preorder :'H
   * last inorder :'I
   * last postorder :'F
   * last levelorder: List('F, 'B, 'G, 'A, 'D, 'I, 'C, 'E, 'H)
   * nth preorder 5 : 'C
   * nth inorder 5 : 'E
   * nth postorder 5 : 'B
   * nth levelorder 5 : 'D
   *
   * ***********************
   */

}