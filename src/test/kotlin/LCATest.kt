package test.kotlin

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import main.kotlin.Node
import main.kotlin.getLCA

class LCATest : StringSpec({
    /**
     * Create simple test tree structure
     *         (0)
     *      (1)   (2)
     *   (3)  (4)
     **/
    val root: Node<Int> = Node(0)
    val node1: Node<Int> = Node(1)
    val node2: Node<Int> = Node(2)
    val node3: Node<Int> = Node(3)
    val node4: Node<Int> = Node(4)
    root.children.add(node1)
    root.children.add(node2)
    node1.children.add(node3)
    node1.children.add(node4)

    "Find ancestor of 3 and 4, should be 1" {
        getLCA(root, node3, node4) shouldBe node1
    }

    "Find ancestor of 3 and 2, should be 0" {
        getLCA(root, node3, node2) shouldBe root
    }

    "Find ancestor of root and root node, should be root" {
        getLCA(root, node3, node2) shouldBe root
    }

    "Make sure having nodes with the same values does not throw errors"{
        val root: Node<Int> = Node(0)
        val node1: Node<Int> = Node(0)
        root.children.add(node1)
        getLCA(root, root, node1) shouldBe root
    }

    "Make sure having a node child of itself return itself, i.e. root"{
        val root: Node<Int> = Node(0)
        root.children.add(root)
        getLCA(root, root, root) shouldBe root
    }
})
