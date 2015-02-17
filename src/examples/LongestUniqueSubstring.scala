package examples

object LongestUniqueSubstring {

  val input = "abcdefgabcdefghd"

  def main(args: Array[String]) {
    println(lus(input))
  }

  def lus(s: String) = {
    var maxSubstring = ""
    for (i <- 0 until s.length) {
      val longestPrefix = lup(s.substring(i))
      if (maxSubstring.length < longestPrefix.length) {
        maxSubstring = longestPrefix
      }
    }
    maxSubstring
  }

  //longest unique chars prefix
  var lubArr: Array[Boolean] = null
  private def lup(s: String): String = {
    lubArr = new Array[Boolean](256)
    var index = 0
    var ret = new StringBuilder()
    while (index < s.length) {
      if (!lubArr(s.charAt(index))) {
        ret.append(s.charAt(index))
        lubArr(s.charAt(index)) = true
        index += 1
      } else {
        return ret.toString
      }
    }
    return ret.toString
  }
}