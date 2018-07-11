package ru.bondarenko.start;

import ru.bondarenko.models.*;

//c:\projects\Tracker>java -cp target\tracker-1.0.jar ru.bondarenko.start.StartUI
//c:\projects\Tracker>mvn clean package

public class StartUI {	

      private Input input;
	  public StartUI(Input input) {
		  this.input = input; 
	  }
	  
	  

     public void init() {
		 
		 
		String name = input.ask("Please, enter task name: ");
		
		Tracker tracker = new Tracker();
		tracker.add(new Task(name,  "first  desc"));
		tracker.add(new Item("second task",  "second desc", 10002L));
		tracker.add(new Item("third  task",  "third  desc", 10003L));
		tracker.add(new Item("4th    task",  "4th    desc", 10004L));
		tracker.add(new Item("5th    task",  "5th    desc", 10005L));
		tracker.add(new Item("6th    task",  "6th    desc", 10006L));
		
	
	System.out.println("do test2 task rep it with prev test2 and print out again");
	 Item previous = new Item("test1", "testDescription", 123L);
    // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
	
	for (Item item : tracker.findAll()) {
		System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
	}
	System.out.println("----------------------------------------");
		 
	 }


	public static void main(String[] args) {
      new StartUI(
	  new StubInput(new String[] {"create stub task"})
	  ).init();
	
	
	
    }

}