/**
     * <this class represents the ordered list 
     * of cars and adds and removes cars from the list>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prog01_aOrderedList {
	 public static void main(String[] args)throws FileNotFoundException {
		 
		 /**
		     * <prompts user for the name of the input 
		     * file it should read and the name of the 
		     * file the output will be written to>
		     *
		     * CSC 1351 Programming Project No <1>
		     * 
		     * Section <1>
		     *
		     * @author <Cameron Bly>
		     * @since <March 17th, 2024>
		     *
		     */
		 aOrderedList orderedList = new aOrderedList();
		 Scanner inputFileScanner = getInputFileScanner("Enter input file name: ");
		 
		 while(inputFileScanner.hasNextLine()) {
			 String line = inputFileScanner.nextLine();
			 processInputLine(line, orderedList);
		 }
		 
		 inputFileScanner.close();
		 
		 PrintWriter outputFileWriter = getOutputFile("Enter output file name: ");
		 outputResults(outputFileWriter, orderedList);
		 outputFileWriter.close();
	 	}
	 
	 /**
	     * <processes the lines of the input file and takes 
	     * the information relates to creating cars then adds 
	     * the new cars to the ordered list and deletes cars 
	     * that are not needed in the list>
	     *
	     * CSC 1351 Programming Project No <1>
	     * 
	     * Section <1>
	     *
	     * @author <Cameron Bly>
	     * @since <March 17th, 2024>
	     *
	     */
	 	private static void processInputLine(String line, aOrderedList orderedList) {
	 		String[] parts = line.split(",");
	 		
	 		if(parts.length == 4 && parts[0].equals("A")) {
	 			String make = parts[1];
	 			int year = Integer.parseInt(parts[2].trim());
				 int price = Integer.parseInt(parts[3].trim());
				 Car newCar = new Car(make, year, price);
				 orderedList.add(newCar);	
				 }
	 		
	 		else if(parts.length == 3 && parts[0].equals("D")) {
	 			String make = parts[1];
	 			int year = Integer.parseInt(parts[2]);
	 			orderedList.deleteCar(make, year);
	 		}
	 		
	 		else {
	 			System.out.println("Invalid input line: " + line);
	 		}
	 	}
	 	
	 	/**
	     * <returns a scanner object for reading 
	     * the input file and handles if a file 
	     * is invalid by asking the user to continue 
	     * of cancel the program>
	     *
	     * CSC 1351 Programming Project No <1>
	     * 
	     * Section <1>
	     *
	     * @author <Cameron Bly>
	     * @since <March 17th, 2024>
	     *
	     */
	 	private static Scanner getInputFileScanner(String userPrompt) throws FileNotFoundException {
	 		Scanner Input = new Scanner (System.in);
	 		
	 		while(true) {
	 			
	 			try {
	 				System.out.print(userPrompt);
	 				String fileName = Input.nextLine();
	 				
	 				if(fileName.trim().equalsIgnoreCase("N")) {
	 					System.out.println("Cancled program.");
	 					System.exit(0);
	 				}
	 				
	 				return new Scanner (new File(fileName));
	 			}
	 			
	 			catch(FileNotFoundException e) {
	 				System.out.println("File <" + userPrompt + " > does not exist. Would you like to continue? <Y/N>");
	 			}
	 		}
	 	}
	 	
	 	/**
	     * <returns a printwriter for writing the 
	     * output of the list and handles when the 
	     * filename is invalid by asking the user 
	     * to continue, overwrite, or cancel>
	     *
	     * CSC 1351 Programming Project No <1>
	     * 
	     * Section <1>
	     *
	     * @author <Cameron Bly>
	     * @since <March 17th, 2024>
	     *
	     */
	 	public static PrintWriter getOutputFile(String userPrompt) throws FileNotFoundException{
	 		Scanner Output = new Scanner(System.in);
	 		String fileName;
	 		
	 		while(true) {
	 			
	 			try {
	 				System.out.print(userPrompt);
	 				fileName = Output.nextLine();
	 				
	 				if(fileName.equalsIgnoreCase("N")) {
	 					throw new FileNotFoundException("Cancled program.");
	 				}
	 				
	 				File file = new File(fileName);
	 				
	 				if(file.exists()) {
	 					System.out.println("File already exists. Would you like to overwrite? <Y/N>");
	 					String response = Output.nextLine();
	 					
	 					if(!response.equalsIgnoreCase("Y")) {
	 						System.out.println("Enter a different file name or 'N' to cancle.");
	 						continue;
	 					}
	 				}
	 				break;
	 			}
	 			
	 			catch(FileNotFoundException e) {
	 				System.out.println("File <" + userPrompt + "> does not exist. Would you like to continue? <Y/N>");
	 			}
	 		}
	 			
	 			return new PrintWriter(new File(fileName));
	 		
	 	}
	 	
	 	/**
	     * <writes the results of the list to the user specified output file>
	     *
	     * CSC 1351 Programming Project No <1>
	     * 
	     * Section <1>
	     *
	     * @author <Cameron Bly>
	     * @since <March 17th, 2024>
	     *
	     */
	 	private static void outputResults(PrintWriter outputFileWriter, aOrderedList orderedList) {
	 		outputFileWriter.println("Number of cars: " + orderedList.size());
	 		
	 		for(int i = 0; i < orderedList.size(); i++) {
	 			Car car = (Car) orderedList.get(i);
	 			outputFileWriter.println("Make: " + car.getMake());
	 			outputFileWriter.println("Year: " + car.getYear());
	 			outputFileWriter.println("Price: $" + car.getPrice());
	 			outputFileWriter.println();
	 		}
	 	}
	}	
