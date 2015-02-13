package graph

import scala.collection.mutable.ListBuffer
import scala.io.Source

class Graph(numberOfVertices: Int) {
  private val vertices = new Array[Int](numberOfVertices)
  private val buckets = new Array[ListBuffer[Int]](numberOfVertices)

  (0 to numberOfVertices - 1).foreach { x =>
    vertices(x) = x
    buckets(x) = ListBuffer.empty[Int]
  }

  def addEdge(v1: Int, v2: Int) = {
    buckets(v1) += v2
    buckets(v2) += v1
  }

  def addBucket(v: Int, iterable: ListBuffer[Int]) = buckets(v) = iterable

  def adj(v: Int) = buckets(v).toIterable

  def totalV = numberOfVertices
  def totalE = {
    val l = buckets.map(_.toList.size)
    l.sum
  }
}

object GraphTest {
  val mapping = Map(
    "A" -> 0,
    "B" -> 1,
    "C" -> 2,
    "D" -> 3,
    "E" -> 4,
    "F" -> 5,
    "G" -> 6,
    "H" -> 7
  )
  val rev = Map(
    0 -> "A",
    1 -> "B",
    2 -> "C",
    3 -> "D",
    4 -> "E",
    5 -> "F",
    6 -> "G",
    7 -> "H"
  )
  def main(args: Array[String]) {

    val source = Source.fromFile("in.txt")

    val numOfVertices = 8
    val graph = new Graph(numOfVertices)
    val regex = """([a-zA-Z]+)""".r

    for (line <- source.getLines()) {
      println(line)
      if (!line.isEmpty()) {
        val itr = regex.findAllIn(line).map(mapping).toList
        val vertex = itr(0)
        val bucket = itr.tail.to[ListBuffer]
        graph.addBucket(vertex, bucket)
      }
    }
    val dfs = new DepthFirstSearch(graph, 0)
  }
}

class DepthFirstSearch(graph: Graph, v: Int) {
  val marked = new Array[Boolean](graph.totalV)
  val edgeTo = new Array[Int](graph.totalV)
  val rev = Map(
    0 -> "A",
    1 -> "B",
    2 -> "C",
    3 -> "D",
    4 -> "E",
    5 -> "F",
    6 -> "G",
    7 -> "H"
  )
  dfs(graph, v)
  private def dfs(g: Graph, v: Int): Unit = {
    marked(v) = true
    print(rev(v) + " ")

    for (av <- g.adj(v)) {
      if (!marked(av)) {
        dfs(g, av)
        edgeTo(av) = v
      }
    }
  }

  def visits = {

  }

  def pathTo(s: Int): String = {
    var path = ""
    var prev = edgeTo(s)
    while (prev != v) {
      path = s"$prev " + path
      prev = edgeTo(s)
    }
    path
  }
}



