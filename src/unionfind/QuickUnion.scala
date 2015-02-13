package unionfind

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