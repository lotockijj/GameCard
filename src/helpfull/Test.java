package helpfull;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run(){
            	StartupWindow start = new StartupWindow();
            	start.frame.setVisible(true);
            }
        });

	}

}
