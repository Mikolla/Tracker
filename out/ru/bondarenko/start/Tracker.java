package ru.bondarenko.start;

import ru.bondarenko.models.*;

public class Tracker {
	
	public Item[] items = new Item[3];
	
	public static void main(String[] args) {
		
		Tracker tracker = new Tracker();
		
	tracker.items[0] = new Item("name", "desc", 0l);	
	tracker.items[1] = new Task("name", "desc");
	tracker.items[2] = new Bug(); 
	
	
	for (Item item : tracker.items) {
		if (item instanceof Task) { 
		System.out.println(  ((Task)item).calculatePrice());
		}
	System.out.println(item.getName() + " " + item.getDescription());
	}
	}

}