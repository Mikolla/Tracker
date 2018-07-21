package ru.bondarenko.start;

import ru.bondarenko.models.*;


import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;



/**
* Test.
*
* @author Bondarenko Nikolay
* @version 01
* @since 19.07.2018
*/
public class StartUITest {
	
	@Test
public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
//	System.out.println("------------ adding test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker
   Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
   assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
} 


 @Test
 public void whenUpdateThenTrackerHasUpdatedValue() {
//	 System.out.println("------------ replace test starting --------------");
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
 //  System.out.println("------------ adding two tickets test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker   
   Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0", "test name2", "desc2",  "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
   assertThat(tracker.findAll()[1].getName(), is("test name2")); // проверяем, что первый элемент массива в трекере содержит имя, введённое при эмуляции.  
}  


@Test
public void whenUserDelOneTicket() {
 //  System.out.println("------------ del test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker
   Item itemOne = tracker.add(new Item("first item", "item to delete", 1234L));
    //Напрямую добавляем заявку
   Item itemTwo = tracker.add(new Item("second item", "item to delete", 1235L));
    //Напрямую добавляем заявку
   String idToDel = tracker.findAll()[0].getId(); // получаем id первой заявки, которая будет удалена
   String idExist = tracker.findAll()[1].getId(); // получаем id второй заявки, которая будет оставлена
   Input input1 = new StubInput(new String[]{"3", idToDel,  "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input1, tracker).init();     //   создаём StartUI и вызываем метод init()   
        assertThat(tracker.findById(idToDel), is(nullValue())); // проверяем, что удаленная заявка отсутствует в трекере
        //true, check not null
        assertThat(tracker.findById(idExist), is(notNullValue())); // проверяем, что оставленная заявка есть в трекере   
   } 
	
}