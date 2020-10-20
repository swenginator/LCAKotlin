import java.util.*

/** Define a node class that holds a value and a set of children **/
class Node<V>(val data: V, val children: MutableSet<Node<V>> = HashSet())

fun main() {
    // Create a test tree
    val root = Node(0)
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    root.children.add(node1)
    root.children.add(node2)
    node1.children.add(node3)
    node1.children.add(node4)

    val lca = getLCA(root, node3, node4)
    println("LCA: " + lca?.data)
}

fun <V> getLCA(root: Node<V>, nodea: Node<V>, nodeb: Node<V>): Node<V>? {
    if (nodea === root || nodeb === root) return root

    var childrenFound = 0
    var lastFoundNode: Node<V>? = null

    for (child in root.children) {
        val node = getLCA(child, nodea, nodeb)

        if (node != null) {
            lastFoundNode = node
            childrenFound++
        }

        if (childrenFound >= 2) return root
    }
    return lastFoundNode
}