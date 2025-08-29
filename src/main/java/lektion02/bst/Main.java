package lektion02.bst;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.insert(45);
        bst.insert(22);
        bst.insert(11);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(77);
        bst.insert(90);
        bst.insert(88);

        bst.inorder();
        bst.preorder();
        bst.postorder();

        System.out.println(bst.height());

        System.out.println("bst.sum() = " + bst.sum());

        System.out.println("bst.findMax() = " + bst.findMax());
        System.out.println("bst.findMin() = " + bst.findMin());
    }
}
