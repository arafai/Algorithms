package graphs

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Graph(val value: Char, var children: ListBuffer[Graph] = new ListBuffer[Graph](), var visited: Boolean = false) {
  def addChildren(list: List[Graph]) =
    children ++= list
}

object Graph{
  def apply(ch:Char) = new Graph(ch)
}


object DFS{
  def traverse(start:Graph, target:Char):Boolean = {
    var stack = mutable.Stack[Graph]()
    stack.push(start)
    var found = false
    while(stack.nonEmpty && !found){
      val elem = stack.pop()
      if(!elem.visited) {
        if(elem.value == target)
          found=true
        elem.visited=true
        elem.children.foreach(stack.push(_))
      }
    }
    found
  }
}

object Runner extends App {
  val g1 = Graph('A')
  val g2 = Graph('B')
  val g3 = Graph('C')
  val g4 = Graph('D')
  // A=B, A=C, B=C
  g1.addChildren(List(g2,g3))
  g2.addChildren(List(g1,g3))
  g3.addChildren(List(g2,g3))

  println(DFS.traverse(g1, 'D'))

}
