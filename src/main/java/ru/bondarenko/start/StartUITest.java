package ru.bondarenko.start;

//c:\projects\Tracker>java -cp target\tracker-1.0.jar ru.bondarenko.start.StartUITest
public class StartUITest {
	
	public static void main(String[] args) {
	  Input input = new StubInput(new String[] {"create stub task"});
       new StartUI(new ConsoleInput(), new Tracker()).init();
	
	
	
    }
	
}