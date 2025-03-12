package desafio.itau.springboot.storage;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;



/**
 * Generic class for storing items using a concurrent queue.
 * 
 * @param <T> the type of elements stored in the data structure.
 * 
 * @author Eduardo Fiorentin
 */

public class CustomStorage<T> {
	private Queue<T> storage = new ConcurrentLinkedQueue<T>(); 
	
	/**
     * Adds an item to the storage.
     * 
     * @param item the item to be added to the queue.
     */
	public void addItem(T item) {
		storage.add(item);
	}
	
	
    /**
     * Removes all items stored in the structure.
     */
	public void clearItens() {
		storage.clear();
	}
	
	
    /**
     * Returns a stream containing all stored items.
     * 
     * @return a {@code Stream<T>} with all items in the structure.
     */
	public Stream<T> getAllItems() {
		return storage.stream();
	}
}
