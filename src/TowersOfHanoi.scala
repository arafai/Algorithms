
object TowersOfHanoi extends App {
  def hanoi(n: Int, fromPeg: Int, toPeg: Int): String = {
    if (n == 1)
      s"$fromPeg -> $toPeg \n"
    else {
      val helpPeg = 6 - fromPeg - toPeg
      val step1 = hanoi(n - 1, fromPeg, helpPeg)
      val myStep = s"$fromPeg -> $toPeg\n"
      val step3 = hanoi(n - 1, helpPeg, toPeg)
      step1 + myStep + step3
    }
  }

  println(hanoi(4, 1, 3))

}
