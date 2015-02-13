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

class QuickUnion(numberOfVertices: Int) {
  private val arr = new Array[Int](numberOfVertices)

  //Initialize
  (0 to numberOfVertices - 1).foreach { x =>
    arr(x) = x
  }

  private def root(v: Int): Int = {
    var complexity = 0
    var current = v
    while (current != arr(current)) {
      current = arr(current)
      complexity += 1
    }
    println(s"complexity: $complexity")
    current
  }

  //root of v1 is child of root of v2
  def union(v1: Int, v2: Int): Unit = {
    val p = root(v1)
    val q = root(v2)
    arr(p) = q
  }

  def connected(v1: Int, v2: Int) = {
    root(v1) == root(v2)
  }

  def ids = arr
}


class ImprovedQuickUnion(numberOfVertices: Int) {
  private val arr = new Array[Int](numberOfVertices)
  private val size = new Array[Int](numberOfVertices)
  
  //Initialize
  (0 to numberOfVertices - 1).foreach { x =>
    arr(x) = x
  }

  // Need to improve this - it could be large tree
  // For tall tree it could be N complexity
  private def root(v: Int): Int = {
    var complexity = 0
    var current = v
    while (current != arr(current)) {
      current = arr(current)
      complexity += 1
    }
    println(s"complexity: $complexity")
    current
  }

  //root of v1 is child of root of v2
  def union(v1: Int, v2: Int): Unit = {
    val p = root(v1)
    val q = root(v2)

    if (p == q) return
    if (size(p) < size(q)) {
      arr(p) = q
      size(p) = size(p) + size(q)
    } else {
      arr(q) = p
      size(q) = size(q) + size(p)
    }
  }

  def connected(v1: Int, v2: Int) = {
    root(v1) == root(v2)
  }

  def ids = arr
}
