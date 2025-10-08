package Lektion05.opgave2;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		start = null; //FIXME: Meget bedre at sætte start til null i stedet for tom node
		size = 0;
	}

	@Override
	public V get(K key) {
		if (key == null) throw new IllegalArgumentException("Key cant be null");

		Node current = start;
		while (current != null){
			if (current.key.equals(key)){
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key == null || value == null)
			throw new IllegalArgumentException("Key and Value can't be null");

		Node current = start;

		while (current != null) {
			if (current.key.equals(key)) {
				V toReturn = current.value;
				current.value = value; // update existing
				return toReturn;
			}
			current = current.next;
		}

		//INsert in the front if not found
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		newNode.next = start;
		start = newNode;
		size++;
		return value;
	}

	@Override
	public V remove(K key) {
		if (key == null) throw new IllegalArgumentException("Key can't be null");
		if (isEmpty()){
			return null;
		}

		Node previous = null;
		Node current = start;

		while(current != null){
			if (current.key.equals(key)){
				V toRemove = current.value;
				if (previous == null){
					start = current.next;
				}else {
					previous.next = current.next;
				}
				size--;
				return toRemove;
			}

			previous = current;
			current = current.next;
		}

		return null;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;
	}

}
