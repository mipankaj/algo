package dp

object EditDistance {

  val input1 = "eeee"
  val input2 = "abbd"

  val arr = Array.ofDim[Int](input1.length() + 1, input2.length() + 1)
  (0 to input1.length()).foreach { i =>
    arr(i)(0) = 0
  }
  (0 to input2.length()).foreach { i =>
    arr(0)(i) = 0
  }

  def main(args: Array[String]) {
    print(distance(input1.toCharArray(), input2.toCharArray(), input1.length(), input2.length()))
  }

  private def distance(p: Array[Char], q: Array[Char], m: Int, n: Int): Int = {
    for (i <- 0 to (p.length - 1)) {
      for (j <- 0 to q.length - 1) {
        if (p(i) == q(j)) arr(i + 1)(j + 1) = arr(i)(j)
        else {
          val r = arr(i + 1)(j) + 1
          val in = arr(i + 1)(j) + 1
          val d = arr(i)(j + 1) + 1
          val mi = min(r, in)
          arr(i + 1)(j + 1) = min(mi, d)
        }
      }
    }
    arr(m)(n)
  }
  private def min(a: Int, b: Int) = if (a > b) b else a
}