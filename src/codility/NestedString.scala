package codility


object NestedString extends App {

  def solution(s: String): Int = {
    if (s.isEmpty) return 1
    var n = s.size
    var close, open, i = 0
    if (n % 2 == 1) return 0
    while (i < n && open <= n / 2 && open >= close) {
      if (s.charAt(i) == '(')
        open += 1
      else
        close += 1
      i+=1
    }
    if(i==n && open==close)
      1
    else
      0
  }

  println(solution("(()(())())"))
}
