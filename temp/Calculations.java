import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

import java.io.IOException;
 

/**
 *
 * @author danbrost
 */
  public class Calculations
  {
	public static void PrintDateArray()
	{
				System.out.println("\nPrint date Array");
				System.out.println("****************************");
				// .csv file where data is coming from
				String fileName = "C:\\temp\\newBBD.csv";
				// Creates a new file to store date from .csv file
				File file = new File(fileName);
				/****************lookup file******************/ 
				// Headings
				int lineNumber = 0;
				String Heading0 = "Date";
				// prints heading
				System.out.printf("%7s" , Heading0);
				System.out.println();
				System.out.println("-------------------");
			try
			{
				
				//create Scanner to read the file
				Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()&& lineNumber <20)
				{
					lineNumber++;
					//reads whole line
					String info = inputStream.next();
					// splits each row into columns when a comma is reached
					String[] data = info.split(",");
					// convert to date
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date date = sdf.parse(data[0]);
					List list = new ArrayList(Arrays.asList(sdf.format(date)));
					System.out.println(list);
					
				}
				
				inputStream.close();
				
			} catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}
	public static void PrintDataArray()
	{
				System.out.println("\nPrint dataArray");
				System.out.println("****************************");
				// .csv file where data is coming from
				String fileName = "C:\\temp\\newBBD.csv";
				// Creates a new file to store date from .csv file
				File file = new File(fileName);
				/****************lookup file******************/ 
				// Headings
				int lineNumber = 0;
				String Heading1 = "Open";
				String Heading2 = "High";
				String Heading3 = "Low";
				String Heading4 = "Close";
				String Heading5 = "sAdj Close";
				String Heading6 = "Volume";
				System.out.printf("|%6s  |%6s  |%6s  |%7s  |%11s | %11s",Heading1, Heading2, Heading3, Heading4, Heading5, Heading6 + " |" + "\n");
				System.out.println("--------------------------------------------------------------");
			try
			{
				
				//create Scanner to read the file
				Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()&& lineNumber <20)
				{
					lineNumber++;
					//reads whole line
					String info = inputStream.next();
					// splits each row into columns when a comma is reached
					String[] data = info.split(",");
					// convert to float
					float open = Float.parseFloat(data[1]);
					float high = Float.parseFloat(data[2]);
					float low = Float.parseFloat(data[3]);
					float close = Float.parseFloat(data[4]);
					float sAdjClose = Float.parseFloat(data[5]);
					float volume = Float.parseFloat(data[6]);
					//float [][] dataArray = new float[][]{open, high, low, close, sAdjClose, voleume};
			
					
					System.out.println(String.format("| %.3f | %6.3f | %6.3f | %6.4f | %6.7f | %8.0f |" , open, high, low, close, sAdjClose, volume));
				}
				
				inputStream.close();
				
			} catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}

		public static void BasicCalculations()
		{
	
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
						float openFloat = Float.parseFloat(csvArray.get(1));
						List open = new ArrayList(Arrays.asList(openFloat));
						
						
						
						System.out.println("Maximum element from the list: " +Collections.max(open));
						tokenNumber = 0;
				}	
					System.out.println("------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}
  }
		



// BasicCalculations
/* Highest Opening Value?
 * Highest Closing Value?
 * Lowest Opening Value?
 * Lowest Closing Value?
 * Top 10 dates with the highest Closing Value?(Highest to Lowest)
 * Top 10 dates with the lowest Closing Value?(Lowest to Highest)
 * Add a column difference for all rows (determine by open amount - closing amount); and 
 * write to a new file (saved in your c:\temp). */