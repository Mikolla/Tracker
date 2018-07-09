package ru.bondarenko.start;

import ru.bondarenko.models.*;

//c:\projects\Tracker>java -cp target\tracker-1.0.jar ru.bondarenko.start.StartUI
//c:\projects\Tracker>mvn clean package

public class StartUI {	
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.add(new Item("first  task",  "first  desc", 10001L));
		tracker.add(new Item("second task",  "second desc", 10002L));
		tracker.add(new Item("third  task",  "third  desc", 10003L));
		tracker.add(new Item("4th    task",  "4th    desc", 10004L));
		tracker.add(new Item("5th    task",  "5th    desc", 10005L));
		tracker.add(new Item("6th    task",  "6th    desc", 10006L));
		tracker.add(new Item("7th    task",  "7th    desc", 10007L));
		tracker.add(new Item("8th    task",  "8th    desc", 10008L));
		tracker.add(new Item("9th    task",  "9th    desc", 10009L));
		tracker.add(new Item("10th   task",  "10th   desc", 10010L));
		tracker.add(new Item("11th   task",  "11th   desc", 10011L));
		tracker.add(new Item("11th   task",  "11th   desc", 10012L));
		tracker.add(new Item("11th   task",  "11th   desc", 10013L));
		tracker.add(new Item("11th   task",  "11th   desc", 10014L));
		
	
	
	System.out.println("do test2 task rep it with prev test2 and print out again");
	 Item previous = new Item("test1","testDescription",123L);
    // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
	
	for (Item item : tracker.findAll()) {
		System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
	}
	System.out.println("----------------------------------------");
	
    // Создаем новую заявку.
    Item next = new Item("test2","testDescription2",1234L);
    // Проставляем старый id из previous, который был сгенерирован выше.
    next.setId(previous.getId());
    // Обновляем заявку в трекере.
    tracker.replace(previous.getId(), next);
	
	//tracker.replace(tracker.findAll()[2].getId(),new Item("fives task", "fives desc", 200015L));
	
	for (Item item : tracker.findAll()) {
		System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
	}
	System.out.println("----------------------------------------");
	
	System.out.println("deleting 6-th element and print out");	
	String ID = tracker.findAll()[6].getId();
	System.out.println("deleting 6-th ID = " + ID);
	tracker.delete(ID);
	for (Item item : tracker.findAll()) {
		if(item!=null){
		System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
		}
		else {
			System.out.println("empty element");
		}
	}
	
	System.out.println("----------------------------------------");
	
	System.out.println("name finder and printing out");	
	
	for (Item item : tracker.findByName("11th   task")) {
		if(item!=null){
		System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
		}
		else {
			System.out.println("empty element");
		}
	}
	
	}
	
	
	
}