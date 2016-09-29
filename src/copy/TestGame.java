package copy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestGame extends Thread{
	
	public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
		
		Table table = new Table();
		GUIForStartAndSetData set = new GUIForStartAndSetData(table);
		View view = new View("-");
		set.createGuiForStartGame();
		Controller controller = new Controller(table, view);
		controller.contol();
	}
}
