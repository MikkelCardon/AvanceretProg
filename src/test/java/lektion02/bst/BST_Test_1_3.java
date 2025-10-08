package lektion02.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BST_Test_1_3 {
    BST<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
    }

    @Test
    void inorder() {
        // Expected inorder: Left - Root - Right
        List<Integer> expected = List.of(20, 30, 40, 50, 60, 70, 80);
        assertEquals(expected, bst.inorderList());
    }

    @Test
    void inorder2() {
        bst.insert(10);

        // Expected inorder: Left - Root - Right
        List<Integer> expected = List.of(10, 20, 30, 40, 50, 60, 70, 80);
        assertEquals(expected, bst.inorderList());
    }

    @Test
    void postorder() {
        // Expected postorder: Left - Right - Root
        List<Integer> expected = List.of(20, 40, 30, 60, 80, 70, 50);
        assertEquals(expected, bst.postorderList());
    }

    @Test
    void postorder2() {
        bst.insert(10);

        // Expected postorder: Left - Right - Root
        List<Integer> expected = List.of(10, 20, 40, 30, 60, 80, 70, 50);
        assertEquals(expected, bst.postorderList());
    }

    @Test
    void preorder() {

        // Expected preorder: Root - Left - Right
        List<Integer> expected = List.of(50, 30, 20, 40, 70, 60, 80);
        assertEquals(expected, bst.preorderList());
    }

    @Test
    void preorder2() {
        bst.insert(90);
        // Expected preorder: Root - Left - Right
        List<Integer> expected = List.of(50, 30, 20, 40, 70, 60, 80, 90);
        assertEquals(expected, bst.preorderList());
    }
}
