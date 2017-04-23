import javax.swing.*;
import java.awt.*;

/**
 * Project4GUI
 * This is just a GUI class
 * Created on April 26,2016
 * @author chunyiu
 *
 */
public class Project4GUI extends JFrame {

	Container myContentPane;
	TextArea HASHMAP=new TextArea();
	TextArea TREEMAP=new TextArea();
	JMenuBar menuBar=new JMenuBar();
	
	/**
	 * set up GUI
	 * @param title The title
	 */
	public Project4GUI(String title){
		setTitle(title);
		setLocation(100,100);
		setSize(500, 500);
		createFileMenu(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myContentPane=getContentPane();
		myContentPane.setLayout(new GridLayout(1,2));
		myContentPane.add(HASHMAP);
		myContentPane.add(TREEMAP);
		setVisible(true);
	}
	/**
	 * set up FileMenu which contains two items, OPEN and QUIT
	 * 
	 * @param menuBar
	 */
	private void createFileMenu(JMenuBar menuBar) {
		 JMenuItem   item;
	      JMenu       fileMenu = new JMenu("File");
	      FileMenuHandler fmh  = new FileMenuHandler(this);

	      
	      //File Open
	      item = new JMenuItem("Open");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      fileMenu.addSeparator();           //add a horizontal separator line
	    
	      item = new JMenuItem("Quit");       //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      
	      setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	     
		
	}
	
}
