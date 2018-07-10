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
	
	
/**
* Test adding method for tracker - public Item add(Item item);
*/
@Test
public void whenAddNewItemThenTrackerHasSameItem() {
 Tracker tracker = new Tracker();
 Item itemFirst  = new Item("test1","testDescription",100L);
 Item itemSecond = new Item("test2","testDescription",101L);
 tracker.add(itemFirst);
 tracker.add(itemSecond);
 assertThat(tracker.findAll()[0], is(itemFirst));
 assertThat(tracker.findAll()[1], is(itemSecond));
}


/**
* Test findAll method for tracker - public Item[] findAll();
*/
@Test
public void whenFindAllItemsInTracker() {		
		Tracker tracker = new Tracker();
		Item one   =  new Item("first  task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("third  task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("6th    task",  "6th    desc", 10006L);
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);
        Item[] expect = new Item[]{one, two, three, four, six};
        Item[] result = tracker.findAll();
        assertThat(result, is(expect));
}


/**
* Test replace method for tracker - public void replace(String id, Item item);
*/
@Test
public void whenReplaceNameThenReturnNewName() {
    Tracker tracker = new Tracker();
    Item previous = new Item("test1","testDescription",123L);
    // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
    // Создаем новую заявку.
    Item next = new Item("test2","testDescription2",1234L);
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
		Item one   =  new Item("first  task",  "first  desc", 10001L);
		Item two   =  new Item("second task",  "second desc", 10002L);
		Item three =  new Item("third  task",  "third  desc", 10003L);
		Item four  =  new Item("4th    task",  "4th    desc", 10004L);
		Item six   =  new Item("6th    task",  "6th    desc", 10006L);
		tracker.add(one);
		tracker.add(two);
		tracker.add(three);
		tracker.add(four);
		tracker.add(six);
		tracker.delete(tracker.findAll()[0].getId());
		tracker.delete(tracker.findAll()[1].getId());
		Item[] expect = new Item[]{two, four, six};
        Item[] result = tracker.findAll();	
        assertThat(result, is(expect));		
}


/**
* Test the same item finding method - Item findById(String id);
*/
@Test
public void whenTheSameNameItemsInTracker() {
 Tracker tracker = new Tracker();
 // creating Items, 3 jf them - one, three, six - they have the same name "first task"
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
// expected array shoud have only 3 Items with the same name "first task"	
		Item[] expect = new Item[]{one, three, six};
// result array made by .findByName("first task") method		
        Item[] result = tracker.findByName("first task");
		 assertThat(result, is(expect));
}

@Test
public void whenReplaceNameThenReturnNewName12() {
    Tracker tracker = new Tracker();
    Item previous = new Item("test1","testDescription", 123L);
	Item next     = new Item("test2","testDescription2",1234L);
    // Добавляем  в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
	tracker.add(next);  
    String ID = previous.getId();
    // Обновляем заявку в трекере.
   
    // Проверяем, что заявка с таким id имеет новые имя test2.
    assertThat(tracker.findById(ID), is( previous));
}


}