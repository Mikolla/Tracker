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
public class TrackerTest {
	
	
/**
* Test adding method for tracker - public Item add(Item item);
*/
@Test
public void whenAddNewItemThenTrackerHasSameItem() {
 Tracker tracker = new Tracker();
  // creating Items  
 Item itemFirst  = new Item("test1", "testDescription", 100L);
 Item itemSecond = new Item("test2", "testDescription", 101L);
 // adding all Items to tracker 
 tracker.add(itemFirst);
 tracker.add(itemSecond);
 // our tracker should contain all Items added before
 assertThat(tracker.findAll()[0], is(itemFirst));
 assertThat(tracker.findAll()[1], is(itemSecond));
}


/**
* Test findAll method for tracker - public Item[] findAll();
*/
@Test
public void whenFindAllItemsInTracker() {		
		Tracker tracker = new Tracker();
		 // creating Items  
		Item one   =  new Item("first  task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("third  task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("6th    task",  "6th    desc", 10006L);
		// adding all Items to tracker
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);
		// manually make expected array containing earlyer created Items
        Item[] expect = new Item[]{one, two, three, four, six};
		// getting result array by .findAll(); method from  our tracker
        Item[] result = tracker.findAll();
		// checking if expected array equals to result array
        assertThat(result, is(expect));
}


/**
* Test replace method for tracker - public void replace(String id, Item item);
*/
@Test
public void whenReplaceNameThenReturnNewName() {
    Tracker tracker = new Tracker();
    Item previous = new Item("test1", "testDescription", 123L);
    // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
    // Создаем новую заявку.
    Item next = new Item("test2", "testDescription2", 1234L);
    // Проставляем старый id из previous, который был сгенерирован выше.
    next.setId(previous.getId());
    // Обновляем заявку в трекере.
    tracker.replace(previous.getId(), next);
    // Проверяем, что заявка с таким id имеет новые имя test2.
    assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
}


/**
* Test deleting method for tracker - public void delete(String id);
*/
@Test
public void whenDelTwoItems() {		
		Tracker tracker = new Tracker();
		 // creating Items  
		Item one   =  new Item("first  task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("third  task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("6th    task",  "6th    desc", 10006L);
		// adding all Items to tracker
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);
		// deleting 2 Items from tracker by their Id
		tracker.delete(tracker.findAll()[0].getId());
		tracker.delete(tracker.findAll()[1].getId());
		// when only 3 Items shoul remain in expected array because two Items were removed
		Item[] expect = new Item[]{two, four, six};
		// getting the result array from tracker
        Item[] result = tracker.findAll();	
		// check if the result array equals to expected array after deleting two Items
        assertThat(result, is(expect));		
}


/**
* Test the same name finding method - public Item[] findByName(String key);
*/
@Test
public void whenTheSameNameItemsInTracker() {
 Tracker tracker = new Tracker();
 // creating Items, 3 of them - one, three, six - they have the same name "first task"
		Item one   =  new Item("first task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("first task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("first task",  "6th    desc", 10006L);
 // adding all Items to tracker		
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);	
// expected array should have only 3 Items with the same name "first task"	
		Item[] expect = new Item[]{one, three, six};
// result array made by .findByName("first task") method		
        Item[] result = tracker.findByName("first task");
// check if result Item found by name equals to expected Item added to our tracker just before		
		 assertThat(result, is(expect));
}


/**
* Test item finding method by Id - Item findById(String id);
*/
@Test
public void whenFoundItemById() {
   Tracker tracker = new Tracker();
 // creating Items  
		Item one   =  new Item("first  task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("third  task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("6th    task",  "6th    desc", 10006L);
 // adding all Items to tracker
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);  
// getting ID string of Item by name "four"		
    String id = four.getId();
// check if the Item found by method .findById(ID) is the same with Item with name "four"
    assertThat(tracker.findById(id), is(four));
}


}