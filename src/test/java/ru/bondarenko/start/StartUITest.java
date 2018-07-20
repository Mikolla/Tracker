package ru.bondarenko.start;

import ru.bondarenko.models.*;
/*
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.IsNull;
*/

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;



/**
* Test.
*
* @author Bondarenko Nikolay
* @version 01
* @since 09.07.2018
*/
public class StartUITest {
	
	@Test
public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
	System.out.println("------------ adding test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker
   Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
   assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
} 


 @Test
 public void whenUpdateThenTrackerHasUpdatedValue() {
	 System.out.println("------------ replace test starting --------------");
    // создаём Tracker
    Tracker tracker = new Tracker();
    //Напрямую добавляем заявку
    Item item = tracker.add(new Item("test name", "desc", 1234L));
    //создаём StubInput с последовательностью действий(производим замену заявки)
    Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "ticket replaced", "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
    // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
 } 

 
@Test
public void whenUserAddTwoTickets() {
   System.out.println("------------ adding two tickets test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker   
   Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0", "test name2", "desc2", "1", "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
   assertThat(tracker.findAll()[1].getName(), is("test name2")); // проверяем, что первый элемент массива в трекере содержит имя, введённое при эмуляции.  
}  


@Test
public void whenUserDelOneTicket() {
   System.out.println("------------ del test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker
   Item itemOne = tracker.add(new Item("first item", "item to delete", 1234L));
   Item itemTwo = tracker.add(new Item("second item", "item to delete", 1235L));
   String idToDel = tracker.findAll()[0].getId();
   String idExist = tracker.findAll()[1].getId();
   System.out.println("id for delete = " + idToDel);
   
   
   Input input1 = new StubInput(new String[]{"3", idToDel, "1", "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input1, tracker).init();     //   создаём StartUI и вызываем метод init()
   
        assertThat(tracker.findById(idToDel), is(nullValue()));

        //true, check not null
        assertThat(tracker.findById(idExist), is(notNullValue()));
   
   
   }



 
	
}