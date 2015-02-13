package dp

/**
 * algo - http://www.geeksforgeeks.org/printing-longest-common-subsequence/
 */
object LongestCommonSubsequence {

  val in1 = "abcd"
  val in2 = "gabcdii"
  val dp = Array.ofDim[Int](in1.length() + 1, in2.length + 1)

  def main(args: Array[String]) {
    lcs(in1.toCharArray(), in2.toCharArray()).foreach(print)
  }

  private def max(a: Int, b: Int) = if (a > b) a else b

  private def lcs(x: Array[Char], y: Array[Char]) = {
    for (i <- 0 to x.length) {
      for (j <- 0 to y.length) {
        if (i == 0 || j == 0) dp(i)(j) = 0
        else if (x(i - 1) == y(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
        } else {
          val delete = dp(i - 1)(j)
          val insert = dp(i)(j - 1)
          dp(i)(j) = max(delete, insert)
        }

      }
    }

    var i = x.length
    var j = y.length
    var lcsLen = dp(i)(j)
    val lcs = new Array[Char](lcsLen)

    while (i > 0 && j > 0) {
      if (x(i - 1) == y(j - 1)) {
        lcs(lcsLen - 1) = x(i - 1)
        i -= 1; j -= 1; lcsLen -= 1
      } else if (dp(i - 1)(j) > dp(i)(j - 1)) {
        i -= 1
      } else {
        j -= 1
      }

    }

    //dp(x.length)(y.length)
    lcs
  }

}