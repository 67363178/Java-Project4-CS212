import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
	/**
	 * FileMenuHandler implements ActionListener
	 * This is called when the use clicked on file (Open),(Quit)
	 * Created on April 26, 2016
	 * @author chunyiu
	 *
	 */
	public class FileMenuHandler implements ActionListener{
		
	Project4GUI myGUI;
		public FileMenuHandler(Project4GUI gui){
			myGUI=gui;
		}
		
		/**
		 * actionPerformed
		 * see what menu name the user clicked on, then corresponded the following method.
		 */
		public void actionPerformed(ActionEvent event) {
			String menuName;
			menuName=event.getActionCommand();
			
			if(menuName.equals("Open"))
				openFile();
			else if(menuName.equals("Quit"))
				System.exit(0);
			
		}//actionPerformed
		
		/**
		 * openFile()
		 * when menu name is open, then use this openFile() method.
		 * It will open a selected file
		 * 
		 */
		private void openFile(){
			JFileChooser chooser;
			int status;
			chooser=new JFileChooser();
			status =chooser.showOpenDialog(null);
			if(status==JFileChooser.APPROVE_OPTION)
			readSource(chooser.getSelectedFile());
		}//OpenFile

		/**
		 * readSource
		 * After opening a file, it reads the data from the file.
		 * Create a TreeMap and HashMap.
		 * TreeMap will sort them in order and HashMap just put them in random.
		 * In order to use Tree and HashMap , we need to include TreeMap and HashMap
		 * 
		 * while the file is not empty, we put the String into the map. In this case, the file data is the Key and new Integer(value) is a value
		 * To display, we need to find the key from the map. we set itr=hashMap.KEYSET().iterator(); and print it-->> the Key is the file data.
		 * myGUI.HASHMAP.append <-- to display is on gui
		 * 
		 * Find N/V
		 * @param chosenFile the file that the user wants to open
		 */
		private void readSource(File chosenFile) {
			String chosenFileName=chosenFile.getName();
			TextFileInput inFile=new TextFileInput(chosenFileName);
			String in=inFile.readLine(); 
			

			//HashMap, TreeMap
			String Letter;
			int Position;
			TreeMap <String, String> MyTreeMap =new TreeMap<String, String>();
			
			HashMap mymap =new HashMap();
			
			while(in!=null){
				Position=in.indexOf("(");
				Letter=in.substring(Position+1, in.length()-1);
				
				mymap.put(in,Letter);
				MyTreeMap.put(in,Letter);
				in=inFile.readLine();
			}
			
			//Display HashMap
			Iterator itrH,itrT;
			
			itrH=mymap.keySet().iterator();
	        while(itrH. hasNext()){        
	            myGUI.HASHMAP.append((String) itrH.next()+"\n");
	        }
	        
	        //Display TreeMap
	        itrT=MyTreeMap.keySet().iterator();
	        while(itrT.hasNext()){
	        	 myGUI.TREEMAP.append((String) itrT.next()+"\n");
	        }
	        //Done
	        

		}


		
}
