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
import java.util.*;

import java.io.IOException;
public class Test
{
public static void main(String[] args)
{
	List<Double> highestOpening = new ArrayList<>();
	List<Double> highestClosing = new ArrayList<>();
	List<Double> lowestOpening = new ArrayList<>();
	List<Double> lowestClosing = new ArrayList<>();
	double maxValue = 0;
	double minValue = 10000000;
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
						double openFloat = Double.parseDouble(csvArray.get(1));
						//Highest Opening and Closing
						highestOpening.add(Double.parseDouble(csvArray.get(1)));
						highestClosing.add(Double.parseDouble(csvArray.get(4)));
						//Lowest Opening and Closing
						lowestOpening.add(Double.parseDouble(csvArray.get(1)));
						lowestClosing.add(Double.parseDouble(csvArray.get(4)));
						
						
						tokenNumber = 0;
				}	
					System.out.println("------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
			// Highest opening value
			for(double value: highestOpening) {
				if(value > maxValue) {
					maxValue = value;
				}
			}
			System.out.println("Highest Opening Value: " + maxValue);
			
			// Highest closing value
			for(double value: highestClosing) {
				if(value > maxValue) {
					maxValue = value;
				}
			}
			System.out.println("Highest Closing Value " + maxValue);
			// lowest opening value
			for(double value: lowestOpening) {
				if(value < minValue) {
					minValue = value;
				}
			}
			System.out.println("Lowest Opening Value: " + minValue);
			
			// Highest closing value
			for(double value: lowestClosing) {
				if(value < minValue) {
					minValue = value;
				}
			}
			System.out.println("Lowest Closing Value " + minValue);
	}
  }