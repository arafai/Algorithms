package sorting



//Write a function that prints all combinations of well-formed brackets.
// The input is a number which says how many pairs of brackets will the different outputs have.
// For Brackets(3) the output would be: ((()))  (()())  (())()  ()(())  ()()().
object BracketGenerator extends App {

  def generate(output: String = "", open: Byte = 0, closed: Byte = 0, total: Byte = 0): Unit = {
    if (output.size == total * 2 && open == closed && output.last == ')')
      println(output)
    else if (closed > open || open > total)
      return
    else {
      if (open == closed)
        generate(output + "(", (open + 1).toByte, closed, total)
      if (open > closed) {
        generate(output + "(", (open + 1).toByte, closed, total)
        generate(output + ")", open, (closed + 1).toByte, total)
      }
    }
  }

  generate(total = 3)

}
