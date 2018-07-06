package ru.bondarenko.start;

import ru.bondarenko.models.*;

//c:\projects\Tracker>java -cp target\tracker-1.0.jar ru.bondarenko.start.StartUI
//c:\projects\Tracker>mvn clean package

public class StartUI {	
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first  task",  "first  desc"));
		tracker.add(new Task("second task",  "second desc"));
		tracker.add(new Task("third  task",  "third  desc"));
		tracker.add(new Task("4th    task",  "4th    desc"));
		tracker.add(new Task("5th    task",  "5th    desc"));
		tracker.add(new Task("6th    task",  "6th    desc"));
		tracker.add(new Task("7th    task",  "7th    desc"));
		tracker.add(new Task("8th    task",  "8th    desc"));
		tracker.add(new Task("9th    task",  "9th    desc"));
		tracker.add(new Task("10th   task",  "10th   desc"));
		tracker.add(new Task("11th   task",  "11th   desc"));
		tracker.add(new Task("11th   task",  "11th   desc"));
		tracker.add(new Task("11th   task",  "11th   desc"));
		tracker.add(new Task("11th   task",  "11th   desc"));
		tracker.add(new Task("11th   task",  "11th   desc"));
	for (Item item : tracker.findAll()) {
		System.out.println(item.getName() + " " + item.getId());
	}
	System.out.println("----------------------------------------");
	
	System.out.println("do fives task and out again");
	
	tracker.replace(tracker.findAll()[2].getId(),new Task("fives task", "fives desc"));
	
	for (Item item : tracker.findAll()) {
		System.out.println(item.getName() + " " + item.getId());
	}
	System.out.println("----------------------------------------");
	
	System.out.println("deleting 6-th element and print out");	
	String ID = tracker.findAll()[6].getId();
	System.out.println("deleting 6-th ID = " + ID);
	tracker.delete(ID);
	for (Item item : tracker.findAll()) {
		if(item!=null){
		System.out.println(item.getName() + " " + item.getId());
		}
		else {
			System.out.println("empty element");
		}
	}
	
	System.out.println("----------------------------------------");
	
	System.out.println("name finder and printing out");	
	
	for (Item item : tracker.findByName("11th   task")) {
		if(item!=null){
		System.out.println(item.getName() + " " + item.getId());
		}
		else {
			System.out.println("empty element");
		}
	}
	
	}
	
	
	
}