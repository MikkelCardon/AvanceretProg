package lektion02.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected Comparator<Object> c;

    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo((E) e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(Comparator<Object> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo((E) e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root
     * venstre
     * knuden
     * højre
     * */
    public void inorder() {
        System.out.print("Inorder: ");
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(TreeNode root) {
        if(root == null){
            return;
        }
        inorderHelper(root.left);
        System.out.print(root.element + " ");
        inorderHelper(root.right);
    }

    //FOR TEST ONLY
    public List<E> inorderList() {
        List<E> nodeList = new ArrayList<>();
        inorderHelperList(root, nodeList);
        return nodeList;
    }

    private void inorderHelperList(TreeNode root, List<E> list) {
        if(root == null){
            return;
        }
        inorderHelperList(root.left, list);
        list.add((E) root.element);
        inorderHelperList(root.right, list);
    }


    @Override
    /** Postorder traversal from the root
     * venstre
     * højre
     * knude
     * */
    public void postorder() {
        System.out.print("Postorder: ");
        postorderHelper(root);
        System.out.println();
    }

    private void postorderHelper(TreeNode root) {
        if (root == null){
            return;
        }
        postorderHelper(root.left);
        postorderHelper(root.right);
        System.out.print(root.element + " ");
    }

    //FOR TEST ONLY
    public List<E> postorderList() {
        List<E> nodeList = new ArrayList<>();
        postorderHelperList(root, nodeList);
        return nodeList;
    }

    private void postorderHelperList(TreeNode root, List<E> list) {
        if (root == null){
            return;
        }
        postorderHelperList(root.left, list);
        postorderHelperList(root.right, list);
        list.add((E) root.element);
    }



    @Override
    /** Preorder traversal from the root
     * Knuden
     * venstre
     * højre
     * */
    public void preorder() {
        System.out.print("Preorder: ");
        preorderHelper(root);
        System.out.println();
    }

    private void preorderHelper(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.element + " ");
        preorderHelper(root.left);
        preorderHelper(root.right);
    }

    //TEST ONLY
    public List<E> preorderList() {
        List<E> nodeList = new ArrayList<>();
        preorderHelperList(root, nodeList);
        return nodeList;
    }

    private void preorderHelperList(TreeNode root, List<E> list){
        if(root == null){
            return;
        }
        list.add((E) root.element);
        preorderHelperList(root.left, list);
        preorderHelperList(root.right, list);
    }


    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

//
    //-------------------------------------------------------------------
    public boolean isLeaf(E element){
        TreeNode node = root;

        while(node != null){
            if (node.element == element){
                return node.left == null && node.right == null;
            }
            else if (c.compare(node.element, element) > 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }

        return false;
    }

    public boolean isLeafWithNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    @Override
    public int height() {
        if (root == null) return -1;
        return heightHelper(root);
    }

    public int heightHelper(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int sum() { //Metode er O(N) lige meget hvad. Og kan laves med alle de forskellige "gennemløbs" metoder
        return preorderCount(root);
    }

    private int preorderCount(TreeNode root){
        if(root == null){
            return 0;
        }
        return (int)root.element + preorderCount(root.left) + preorderCount(root.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public E findMax(){ //O(log(N))
        return findMax(root);
    }

    private E findMax(TreeNode root){
        if (root.right == null){
            return (E) root.element;
        }
        return findMax(root.right);
    }

    public E findMin(){ //O(log(N))
        return findMin(root);
    }

    private E findMin(TreeNode root){
        if (root.left == null){
            return (E) root.element;
        }
        return findMin(root.left);
    }

    public E removeMin(){
        TreeNode previous = null;
        TreeNode currentNode = root;

        while(currentNode.left != null){
            previous = currentNode;
            currentNode = currentNode.left;
        }
        if (previous == null){
            root = currentNode.right;
        }else{
            previous.left = currentNode.right;
        }
        size--;
        return (E) currentNode.element;
    }

    public E removeMax() {
        TreeNode previous = null;
        TreeNode currentNode = root;

        while (currentNode.right != null) {
            previous = currentNode;
            currentNode = currentNode.right;
        }

        if (previous == null) {
            root = currentNode.left;
        } else {
            previous.right = currentNode.left; //Hvis "maxNode" har en child kan den kun være left. og den child vil altid være størrer end parent. Hvis ingen så bliver null bare sat
        }
        size--;
        return (E) currentNode.element;
    }

    public List<E> greaterThan(E element){
        List<E> list = new ArrayList<>();
        greaterThanHelper(root, element, list);
        return list;
    }

    private void greaterThanHelper(TreeNode root, E element, List<E> list) {
        if(root == null){
            return;

        }
        if (c.compare(root.element, element) > 0){
            list.add((E) root.element);
            greaterThanHelper(root.left, element, list);
            greaterThanHelper(root.right, element, list);
        } else {
            greaterThanHelper(root.right, element, list);
        }

    }

    public int numberOfLeaves(){
        return numberOfLeavesHelper(root);
    }

    private int numberOfLeavesHelper(TreeNode node){
        if (node == null) return 0;

        if (node.left == null && node.right == null){
            return 1;
        }
        return numberOfLeavesHelper(node.left) + numberOfLeavesHelper(node.right);
    }

    public int heightNodeCount(int targetHeight){
       return heightNodeCountHelper(root, 0, targetHeight);
    }

    private int heightNodeCountHelper(TreeNode node, int currentHeight, int targetHeight){
        if (node == null) return 0;

        if (currentHeight == targetHeight){
            return 1;
        }
        return heightNodeCountHelper(node.left, currentHeight+1, targetHeight)
                + heightNodeCountHelper(node.right, currentHeight+1, targetHeight);
    }
}
