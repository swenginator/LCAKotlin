package main.kotlin

/** Define a node class that holds a value and a set of children **/
class Node<V>(val data: V, val children: MutableSet<Node<V>> = HashSet())

fun <V> getLCA(root: Node<V>, nodea: Node<V>, nodeb: Node<V>): Node<V>? {

    // Find all ancestors of a and b, then return the maximum element of the intersection of the two sets

    if (nodea === root || nodeb === root) return root

    val ancestorsA = getAncestors(root, nodea)
    val ancestorsB = getAncestors(root, nodeb)
    val commonAncestors = ancestorsA.intersect(ancestorsB)

    for (ancestor in commonAncestors) {
        var isLeaf = true
        for (child in ancestor.children) {
            if(commonAncestors.contains(child)){
                isLeaf = false
                break
            }
        }
        if(isLeaf) return ancestor
    }

    return root
}

/**
 * Returns all ancestors for the given node
 */
private fun <V> getAncestors(root: Node<V>, target: Node<V>): Set<Node<V>> {
    val result: MutableSet<Node<V>> = HashSet()
    getAncestorsHelper(root, target, result)
    return result
}

/**
 * Recursive function to get the set of all ancestors of a given node
 */
private fun <V> getAncestorsHelper(root: Node<V>, target: Node<V>, result: MutableSet<Node<V>>): Boolean {
   if(root === target) return true

    for (child in root.children) {
        if(getAncestorsHelper(child, target, result)){
            result.add(root)
            return true
        }
    }

    return false
}