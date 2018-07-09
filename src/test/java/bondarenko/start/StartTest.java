package ru.bondarenko.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.bondarenko.models.*;

public class StartTest {

@Test
public void whenReplaceNameThenReturnNewName() {
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