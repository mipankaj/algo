package unionfind

object UnionFind {
  def main(args: Array[String]) {
    val qu = new QuickUnion(6)

    qu.union(0, 1)
    qu.union(0, 3)
    qu.union(1, 2)
    qu.union(1, 4)
    qu.union(2, 4)
    qu.union(4, 5)

  /*
   *  0----1------4---5
   *  |    |      |   
   *  |    2------|   
   *  |               
   *  3
   * 
   */

    qu.ids.foreach(print)
    
    println
    println(qu.connected(1, 3))
    println(qu.connected(0, 5))
    println(qu.connected(4, 3))
    println(qu.connected(1, 3))
    
    println("----------------------------------------")
    
    val iqu = new ImprovedQuickUnion(6)

    iqu.union(0, 1)
    iqu.union(0, 3)
    iqu.union(1, 2)
    iqu.union(1, 4)
    iqu.union(2, 4)
    iqu.union(4, 5)

  /*
   *  0----1------4---5
   *  |    |      |   
   *  |    2------|   
   *  |               
   *  3
   * 
   */

    iqu.ids.foreach(print)
    
    println
    println(iqu.connected(1, 3))
    println(iqu.connected(0, 5))
    println(iqu.connected(4, 3))
    println(iqu.connected(1, 3))

  }
}




