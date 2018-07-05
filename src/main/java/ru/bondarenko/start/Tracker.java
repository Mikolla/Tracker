package ru.bondarenko.start;

import ru.bondarenko.models.*;
import java.utils.*;

public class Tracker {	
	private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random();
	public Item add(Item item) {
		item.setId(String.valueOf(RN.next()));
		this.item[position++] = item;
		return item;
	}
	
	protected Item findById(String id) {		
		Item result = null;
		for(Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item; break;
			}
		}
		return result;
	}

}