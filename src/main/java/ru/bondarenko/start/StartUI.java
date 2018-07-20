package ru.bondarenko.start;

import ru.bondarenko.models.*;


//c:\projects\Tracker>java -cp target\tracker-1.0.jar ru.bondarenko.start.StartUI
//c:\projects\Tracker>mvn clean package

public class StartUI {	
// Константа меню для добавления новой заявки.
      private static final String ADD = "0";
// Константа для вывода всех заявок.
      private static final String SHOW = "1";
// Константа для редактирования заявки.
      private static final String EDIT = "2";
// Константа для удаления заявки.
      private static final String DEL = "3";
// Константа для поиска заявки по ID.
      private static final String FINDBYID = "4";
// Константа для поиска заявки по имени
      private static final String FINDBYNAME = "5";	  
// Константа для выхода из цикла.
      private static final String EXIT = "6";
    // Получение данных от пользователя.
     private final Input input;
	// Хранилище заявок. 
	 private final Tracker tracker;
     /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
	  
	  

     /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter menu point number : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAll();
            } else if (DEL.equals(answer)) {
                this.delById();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdAndShow();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameAndShow();
            } else if (EDIT.equals(answer)) {
				this.editItem();				
			} else if (EXIT.equals(answer)) {
                exit = true;
            }
			
	    }
	}	
	 
 /**
  * Метод редактирует заявку по id, то есть находит нужную заявку по id, создает новую заявку
  * и сохраняет ее под указанныи id в хранилище.
  */	  
  
	 private void editItem() {
     System.out.println("------------ Edit ticket in tracker --------------");
		String id = this.input.ask("Input ticket id to edit :");
        String name = this.input.ask("Input ticket name :");
        String desc = this.input.ask("Input ticket description :");
        Item item = new Task(name, desc);
        boolean result = this.tracker.replace(id, item);
		if (result) {
			System.out.println("------------ Ticket with id : " + id + " has just changed to-----------");
			System.out.println(item.toString());
		} else {
		    System.out.println("------------ Ticket with id : " + id + " not found" + "-----------");
		}           
    } 
	 
	 
/**
* Метод находит заявку по name (имени) и печатает 
*/
  public void findByNameAndShow() {
	  System.out.println("------------ Find ticket by name and printing out --------------");
	  String name = this.input.ask("Input ticket name to find :");
	  Item[] result = tracker.findByName(name); 
            if (result.length != 0) {
			for (Item item : result) {
		System.out.println(item.toString());
	}
			}			else {
			System.out.println("------------ Ticket with name : " + name + " not found" + "-----------");
			}	  
    }	 
	 
	 
/**
* Метод находит заявку по id и печатает 
*/
  public void findByIdAndShow() {
	  System.out.println("------------ Find ticket by id and printing out --------------");
	  String id = this.input.ask("Input ticket id to find :");
	  Item item = tracker.findById(id); 
            if (item != null) {
			System.out.println(item.toString());
			}			else {
			System.out.println("------------ Ticket with id : " + id + " not found" + "-----------");
			}	  
    }	
	 
/**
 * Метод удаляет заявку
*/
  public void delById() {
	  System.out.println("------------ Deleting ticket by id --------------");
	  String id = this.input.ask("Input ticket id to delete :");
	  Boolean result = false;
	  result = tracker.delete(id);
        if (result) {
			System.out.println("------------ Ticket with id : " + id + " deleted");
			}			else {
			System.out.println("------------ Ticket with id : " + id + " not found or deleted");
			}		
    }	
	 
	 
/**
 * Метод отображает все заявки
*/
  public void showAll() {
	  System.out.println("------------ Printing out ticket list --------------");
    for (Item item : tracker.findAll()) {
		System.out.println(item.toString());
	}
    }	

	 
	 
 /**
  * Метод реализует добавление новой заявки в хранилище.
  */	 
	 private void createItem() {
        System.out.println("------------ Adding new ticket --------------");
        String name = this.input.ask("Input ticket name :");
        String desc = this.input.ask("Input ticket description :");
        Item item = new Task(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New ticket with getId : " + item.getId() + "-----------");
    }
/**
  * Метод печатает меню.
  */	 
	 private void showMenu() {	
System.out.println("0. Add new Item");
System.out.println("1. Show all items");
System.out.println("2. Edit item");
System.out.println("3. Delete item");
System.out.println("4. Find item by Id");
System.out.println("5. Find items by name");
System.out.println("6. Exit Program");
System.out.println("Select:");        
    }


	/**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
	
	
	
    

}