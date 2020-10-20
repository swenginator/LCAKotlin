package main.kotlin

import kotlin.collections.HashSet

/** Define a node class that holds a value and a set of children **/
class Node<V>(val data: V, val children: MutableSet<Node<V>> = HashSet())

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