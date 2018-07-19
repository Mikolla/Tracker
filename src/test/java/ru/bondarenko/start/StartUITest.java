package ru.bondarenko.start;

import ru.bondarenko.models.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
* Test.
*
* @author Bondarenko Nikolay
* @version 01
* @since 09.07.2018
*/
public class StartUITest {
	
/*	@Test
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
 } */

@Test
public void whenUserAddItemAndDel() {
   System.out.println("------------ del test starting --------------");
   Tracker tracker = new Tracker();     // создаём Tracker   
   Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0", "test name2", "desc2", "1", "6"});   //создаём StubInput с последовательностью действий
   new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
  // startUI.showAll();
   //assertThat(tracker.findAll()[1].getName(), is("test name1")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
} 



 
	
}