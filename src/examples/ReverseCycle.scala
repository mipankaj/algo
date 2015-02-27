package examples

object ReverseCycle {
  
  def main(args: Array[String]): Unit = {
    
    val a = Array[Int](1, 3, 0, 2)
    
    reverse(a)
  }
  
  /* for j = a(i) replace a(j) as i */
  private def reverse(a: Array[Int]) {
    var tempIndex = -1
    
    var i = 0
    val first = 0
    
    while(tempIndex != first) {
      val j = a(i)
      
      tempIndex = a(j) // store old value
      a(j) = i
      i = tempIndex
    }
    
    a.foreach(print)
    
  }
  
}