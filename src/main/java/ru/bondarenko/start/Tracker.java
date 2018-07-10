package ru.bondarenko.start;

import ru.bondarenko.models.*;
import java.util.*;
import java.lang.*;

public class Tracker {	
	private Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();
	
	
	public Item add(Item item) {
	    item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}
	
	protected Item findById(String id) {		
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item; break;
			}
		}
		return result;
	}
	
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	
	public Item[] findAll() {
		Item[] result = Arrays.copyOf(this.items, position);		
		return result;
	}
	
	public boolean replace(String id, Item item) {
		boolean result = false;
		for (int index = 0; index != position; index++) {
			if (this.items[index].getId().equals(id)) {
				item.setId(id);
				this.items[index] = item;
				result = true;
				break;
			}
		}
		return result;
	}

	
	public boolean delete(String id) {
		boolean result = false;
		for (int index = 0; index != position; index++) {
			if (this.items[index].getId().equals(id)) {			
				System.arraycopy(this.items, index + 1, this.items, index, position - index - 1);			
				position--;
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	public Item[] findByName(String key) {
		Item[] temp = new Item[position];
		int tempindex = 0;
		for (int index = 0; index != position; index++) {
			if (this.items[index].getName().equals(key)) {
				temp[tempindex] = this.items[index];
				tempindex++;
			}
		}
         Item[] result = new Item[tempindex];
         System.arraycopy(temp, 0, result, 0, tempindex);		 
	return result;
	}
	

}