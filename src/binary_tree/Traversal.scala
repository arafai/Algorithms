package binary_tree

object Traversal extends App {
  def preorderInorderToPostOrder(pree: Array[Int], inn: Array[Int]): Unit = {
    def go(pre: Array[Int], in: Array[Int]): Unit = {
      val n = in.size
      val rootIndex = in.indexOf(pre(0))
      if (rootIndex != 0)
        go(pre.slice(1, 1 + rootIndex), in.slice(0, rootIndex))
      if (rootIndex != n - 1)
        go(pre.slice(rootIndex + 1, n), in.slice(rootIndex + 1, n))
      println(pre(0))
    }

    go(pree, inn)
  }

  preorderInorderToPostOrder(Array(1, 2, 4, 5, 3, 6), Array(4, 2, 5, 1, 3, 6))

  def preorderToTree(arr: Array[Int]): Unit = {
    def go(pre: Array[Int]): Unit = {

    }
  }


}
