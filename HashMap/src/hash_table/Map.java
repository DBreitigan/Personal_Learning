package hash_table;

import java.util.ArrayList;

public class Map<K, V> {
	private ArrayList<HashNode<K,V>> table;
	
	private int numCapacity = 10;
	private int size;
	
	//Constructor
	public Map()
	{
		table = new ArrayList<>();
		numCapacity = 10;
		size = 0;
		
		///Create empty chains
		for (int i =0; i < numCapacity; i++)
		{
			table.add(null);
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public int getIndex(K key)
	{
		int hashCode = key.hashCode();
		int index = hashCode % numCapacity;
		return index;
	}
	
	public V remove (K key)
	{
		int index = getIndex(key);
		
		//Get chain
		HashNode<K, V> head = table.get(index);
		
		HashNode<K, V> prev = null;
		//Loop through table to find value
		while (head != null)
		{
			if (head.key.equals(key))
				break;
			
			prev = head;
			head = head.next;
		}
		
		if (head == null)
			return null;
		
		size--;
		
		if (prev != null)
			prev.next = head.next;
		else
			table.set(index, head.next);
		
		return head.value;
	}
	
	public void add(K key, V value)
	{
		int index = getIndex(key);
		HashNode<K, V> head = table.get(index);
		
		while (head != null)
		{
			if (head.key.equals(key))
			{
				head.value = value;
				return;
			}
			
			head = head.next;
		}
		
		size++;
		head = table.get(index);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		table.set(index, newNode);
		
		//Make sure our hash table is large enough
		if ((1.0 * size) / numCapacity >= 0.7)
		{
			this.expandHashTable();
		}
	}
	
	//If the add function adds an object and the array is beginning to get too large,
	//it doubles in size
	private void expandHashTable()
	{
		ArrayList<HashNode<K, V>> temp = table;
		table = new ArrayList<>();
		numCapacity = numCapacity * 2;
		size = 0;
		for(int i = 0; i < numCapacity; i++)
		{
			table.add(null);
		}
		
		for(HashNode<K,V> headNode : temp)
		{
			while (headNode != null)
			{
				add(headNode.key, headNode.value);
				headNode = headNode.next;
			}
		}
	}
}
