package lektion02.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BST_Test_2 {
    BST<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BST<>();
        bst.insert(45);
        bst.insert(22);
        bst.insert(11);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(77);
        bst.insert(90);
        bst.insert(88);
    }

    @Test
    void isLeaf(){
        assertTrue(bst.isLeaf(88));
        assertTrue(bst.isLeaf(15));
        assertTrue(bst.isLeaf(25));

        assertFalse(bst.isLeaf(45));
        assertFalse(bst.isLeaf(22));
        assertFalse(bst.isLeaf(90));
    }

    @Test
    void heightTest() {
        assertEquals(3, bst.height());

        bst.insert(89);
        assertEquals(4, bst.height());

        //EMPTY bst
        BST emptyBST = new BST();
        assertEquals(-1, emptyBST.height());
    }

    @Test
    void sumTest() {
        assertEquals(403, bst.sum());

        bst.insert(17);
        assertEquals(420, bst.sum());
    }

    @Test
    void findMax() {
        assertEquals(90, bst.findMax());

        BST stringBst = new BST();
        stringBst.insert("a");
        stringBst.insert("c");
        stringBst.insert("d");
        stringBst.insert("b");
        stringBst.insert("g");
        stringBst.insert("h");
        stringBst.insert("x");
        assertEquals("x", stringBst.findMax());
    }

    @Test
    void findMin() {
        assertEquals(11, bst.findMin());

        BST stringBst = new BST();
        stringBst.insert("a");
        stringBst.insert("c");
        stringBst.insert("d");
        stringBst.insert("b");
        stringBst.insert("g");
        stringBst.insert("h");
        stringBst.insert("x");
        assertEquals("a", stringBst.findMin());
    }

    @Test
    void removeMinTest() {
        assertEquals(11, bst.removeMin());
        assertEquals(15, bst.removeMin());
    }

    @Test
    void removeMinTest2() {
        Integer[] values = {50, 30, 70, 20, 40, 60, 80};
        BST<Integer> bst = new BST<>(values);

        // tjek inorder function først
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), bst.inorderList());

        Integer removed = bst.removeMin();

        // tjekker om alt er rigtigt efter remove
        assertEquals(20, removed);
        assertEquals(6, bst.getSize());
        assertEquals(List.of(30, 40, 50, 60, 70, 80), bst.inorderList());
        assertEquals(30, bst.findMin());
    }

    @Test
    void removeMaxTest() {
        assertEquals(90, bst.removeMax());
        assertEquals(88, bst.removeMax());
    }

    @Test
    void removeMaxTest2() {
        Integer[] values = {50, 30, 70, 20, 40, 60, 80};
        BST<Integer> bst = new BST<>(values);

        // tjek inorder function først
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), bst.inorderList());

        Integer removed = bst.removeMax();

        // tjekker om alt er rigtigt efter remove
        assertEquals(80, removed);
        assertEquals(6, bst.getSize());
        assertEquals(List.of(20, 30, 40, 50, 60, 70), bst.inorderList());
        assertEquals(70, bst.findMax());
    }

    @Test
    void greaterThanTest() {
        //middle
        assertEquals(List.of(77, 90, 88), bst.greaterThan(45));

        //greater than element in left side
        assertEquals(List.of(45, 30, 25, 77, 90, 88), bst.greaterThan(22));

        //greater than element in right side
        assertEquals(List.of(90), bst.greaterThan(88));
        assertEquals(List.of(90, 88), bst.greaterThan(77));
    }

    @Test
    void numberOfLeavesTest() {
        assertEquals(3, bst.numberOfLeaves());

        bst.insert(9); //new leaf
        assertEquals(4, bst.numberOfLeaves());
    }

    @Test
    void numberOfLeavesOnEmpty() {
        BST<Integer> bst = new BST<>();
        assertEquals(0, bst.numberOfLeaves());
    }

    @Test
    void heightNodeCount() { //Starter fra højde 0
        assertEquals(1, bst.heightNodeCount(0));
        assertEquals(2, bst.heightNodeCount(1));
        assertEquals(3, bst.heightNodeCount(2));
        assertEquals(3, bst.heightNodeCount(3));
    }
}
