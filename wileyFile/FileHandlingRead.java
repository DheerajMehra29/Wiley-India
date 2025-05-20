package Conceptual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileHandlingRead {
public static void main(String[] args) throws FileNotFoundException {
	File f = new File("src/Conceptual/TextFile3.txt");
	Scanner sc = new Scanner(f);
	while (sc.hasNextLine()) {
        String currentLine = sc.nextLine();
        
        //split into words
        String words[] = currentLine.split(" ");

        //For each word in the line
        for(String str : words) {
           try {
              int num = Integer.parseInt(str);
              System.out.println(num);
           }catch(NumberFormatException nfe) { }; //word is not an integer, do nothing
        }
     } 
	
	
	
	
	
	/*try(){
		while(sc.hasNextLine()) {  
			System.out.println(sc.next()); // .next() will give word by word
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	*/
}
}
