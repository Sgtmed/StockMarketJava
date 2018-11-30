/**
 *
 * @author danbrost
 */
import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

public class ReadFiles
{
	public static void IfFileExists()
	{
		try
		{
			File file = new File("C:\\temp\\newBBD.csv");
			if(file.exists())
			{
				System.out.println("\nThe file " + file + " exists.");
				System.out.println("***********************************");
			}
			else
			{
				System.out.println("The file selected does not exist");
			}	
		}catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
	public static void NumberOfRows()
	{
		try
		{
			File file = new File("C:\\temp\\newBBD.csv");
			
			{
				FileReader fileReader = new FileReader(file);
				LineNumberReader lineReader = new LineNumberReader(fileReader);
				
				int numberOfRows = 0;
				while(lineReader.readLine() !=null)
				{
					numberOfRows++;
				}
				System.out.println("The number of rows are: " + numberOfRows);
				System.out.println("****************************");
				lineReader.close();
			}
			
		}catch(Exception e)
		{
			System.out.println("Error message: " + e);
		}
	}
	public static void ConvertcsvFileToArray()
	{	
		System.out.println(".csv File to Array");
		System.out.println("****************************");
		try
		{
			//.csv file where data is coming from
			String csvFile = "C:\\temp\\newBBD.csv";
			
			//create BufferedReader to read the file
			BufferedReader bufferedReader = new BufferedReader( new FileReader(csvFile));
			String line = "";
			int lineNumber = 0;
			int tokenNumber = 0;
			
			//read file line by line
			while( (line = bufferedReader.readLine()) != null && lineNumber <20)
			{
				lineNumber++;
				// Initializing ArrayList
				ArrayList<String> csvArray = new ArrayList<>();
				// break up data into tokens/ pieces
				StringTokenizer z = new StringTokenizer(line, ","); 
				while(z.hasMoreTokens())
				{
					// assigns token number for each values from csv File
					tokenNumber++;
					String token = z.nextToken();
					//add each token to the Array list
						csvArray.add(token);	
				}
					System.out.println(csvArray);
					//reset the token number to 0
					tokenNumber = 0;
			}	
		}
		catch(Exception e)
		{
			System.out.println("Exception while reading csv file: " + e);			
		}
	}
		public static void PrintArray()
		{	
			System.out.println("\nPrint Array");
			System.out.println("****************************");
			String Heading0 = "Date";
			String Heading1 = "Open";
			String Heading2 = "High";
			String Heading3 = "Low";
			String Heading4 = "Close";
			String Heading5 = "sAdj Close";
			String Heading6 = "Volume";
		
			// prints headings
			System.out.println("----------------------------------------------------------------------");
			System.out.printf("%7s %10s %8s %7s %10s %10s %8s","|   " + Heading0,"|  " + Heading1,"|  " + Heading2,"|  " + Heading3,"|  " + Heading4,"| " + Heading5,"|  " + Heading6);
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
		
			try
			{
				//.csv file where data is coming from
				String csvFile = "C:\\temp\\newBBD.csv";
			
				//create BufferedReader to read the file
				BufferedReader bufferedReader = new BufferedReader( new FileReader(csvFile));
				String line = "";
				int lineNumber = 0;
				int tokenNumber = 0;
			
				//read file line by line
				while( (line = bufferedReader.readLine()) != null && lineNumber <20)
				{
					lineNumber++;
					// Initializing ArrayList
					ArrayList<String> csvArray = new ArrayList<>();
					// break up data into tokens/ pieces
					StringTokenizer z = new StringTokenizer(line, ","); 
					while(z.hasMoreTokens())
					{
						// assigns token number for each values from csv File
						tokenNumber++;
						String token = z.nextToken();
						//add each token to the Array list
						csvArray.add(token);	
					
					}
						//prints data
						System.out.println(String.format("|%s %-7s %-8s %-8s %-8s %-11s %-15s" , csvArray.get(0), "|" + csvArray.get(1), " |" 
						+ csvArray.get(2) , " |" + csvArray.get(3), " |" + csvArray.get(4), " |" + csvArray.get(5), "  | " + csvArray.get(6)));    
						tokenNumber = 0;
				}	
					System.out.println("----------------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
		}
}


	
	
	
