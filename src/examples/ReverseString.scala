package examples

object ReverseString {

  def main(args: Array[String]): Unit = {
    val s = "abcefgh".toCharArray()
    println(new String(s))
    reverseWord(s, 0 , s.length-1)
    println(new String(s))
    
    val words = "pankaj  mittal is developer".toCharArray()
    reverseWords(words)
    println(new String(words))
    
    val words2 = "pankaj  mittal is developer".toCharArray()
    val reversed = reverseWords(words2)
    val reversed2 = reverseWord(words2, 0, words2.length-1)
    
    println(new String(words2))
  }
  
  private def reverseWord(s: Array[Char], start: Int, end: Int) = {
    var i = start
    var j = end
    while(i < j) {
      val temp = s(i)
      s(i) = s(j)
      s(j) = temp
      i += 1
      j -= 1
    }
  } 
  
  /* abc def ghi => cba fed ihg*/
  private def reverseWords(s: Array[Char]) = {
    var i,j,k = 0
    while(j <= s.length) {
      if (j < s.length && s(j) != ' ') {
        j+=1
      } else {
        k = j + 1
        reverseWord(s, i, j-1)
        i=k
        j=k
      }
    }
  }
}