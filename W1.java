/**
* W1.java
*
* @version   $Id: W1.java,v_2.0 2014/09/09 21:31:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/

	/*
	 *  This program finds the count of each printable character in the file "macbeth.txt"
	 * Also no of words in the file and no of lines in the file are displayed
	 */


import java.util.Scanner;
import java.io.File;

public class W1
{
    public static void main( String[] args ) 
    {
    	int no_of_char=0;	//stores no of characters
    	int no_of_lines=0;	//stores no of lines
    	int no_of_words=0;	//stores no of words
    	int count_of_char[] = new int[95];	//stores the no of occurrence of each printable character
   
		try
		{
			                                                     
			Scanner sc  = new Scanner( new File("macbeth.txt"));	//loads txt file in scanner
			
			while ( sc.hasNext() )	//checks if line is available to be read
			{
				
				String line = sc.nextLine();	//stores the whole line as a string
				
				if(line.length()!=0)	//checks if line is empty and stores increases word count by one
					no_of_words++;
				
				no_of_char = no_of_char + line.length();	//calculates no of characters in given line and adds to the previous count
				no_of_lines++;	//increments no of lines for each line read
				
				for(int i = 0 ;i < line.length() ; i++)	//calculates no of words and 
				{
	
					if(line.charAt(i) == ' ')	//increases word count if a space is found in the line 
						no_of_words++;
			
					for (int j = 0 ; j < 95 ; j++)	// counts no of occurrence of each printable character
						if (line.charAt(i) == (char)(j+32))
							count_of_char[j]++;
				
				}
				
			}
			
			System.out.println("no of lines : " + no_of_lines);	//prints total no of lines
			System.out.println("no of words : " + no_of_words);	//prints total no of words
			System.out.println("no of characters : "+ no_of_char+"\n");	//prints total no of characters
			System.out.println("Following are the characters that occurred in the macbeth.txt and their count");
			
			for (int i = 0 ; i < 95 ; i++)	//prints printable character and their count
				if(count_of_char[i]!=0)
					System.out.println((char)(i+32) + " : " + count_of_char[i]);
		
			sc.close();	//close scanner
			
		} 
	
		catch ( Exception e )	//catches an exception if thrown by try block
		{
			System.err.println("Something went wrong!");
		}
    }
}