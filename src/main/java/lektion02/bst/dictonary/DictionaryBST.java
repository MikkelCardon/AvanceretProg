package lektion02.bst.dictonary;

public class DictionaryBST<K extends Comparable<K>, V> implements
Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
        Node node = find(key);
        return node == null ? null : node.value;
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V put(K key, V value) {
		if (key == null || value == null){
			throw new IllegalArgumentException();
		}

		if (root == null){
			root = new Node(key, value);
		}else{
			Node parentNode = null;
			Node currentNode = root;
			while (currentNode != null){
				if (currentNode.key == key){
					V oldValue = currentNode.value;
					currentNode.value = value;
					return oldValue;
				}else if(currentNode.key.compareTo(key) > 0){
					parentNode = currentNode;
					currentNode = currentNode.left;
				}
				else {
					parentNode = currentNode;
					currentNode = currentNode.right;
				}
			}

			if (parentNode.key.compareTo(key) > 0){
				parentNode.left = new Node(key, value);
			} else {
				parentNode.right = new Node(key, value);
			}
		}

		return null;
	}

	@Override
	public V remove(K key) {
		// TODO
		return null;
	}

	@Override
	public int size() {
		return sizeHelper(root);
	}

	private int sizeHelper(Node node){
		if(node == null){
			return 0;
		}
		return 1 + sizeHelper(node.left) + sizeHelper(node.right);
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}

}
