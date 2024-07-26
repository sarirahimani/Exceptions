package assignment6;
//Import the Scanner.
import java.util.Scanner;
//Import for file IO and exceptions, we import all the IO libraries.
import java.io.*;

public class fileException {
	public static void main(String[] args) {
		//Create the Scanner object to collect the user's input
		Scanner keyboard=new Scanner(System.in);
		//Define the String variables that will hold the names of the input and output files 
		String nameIn="";
		String nameOut="";
		//Create the PrintWriter and Scanner object for file input/processing and output
		Scanner fileIn=null;
		PrintWriter fileOut=null;
		//Define the variables we are going to need for the calculations
		double num=0;
		double sum=0;
		double avg=0;
		
		/*Use try and catch first the code inside the try executes
		and if an exception occurs the catch clause deals with it.*/
		
		try {
			//Use the scanner to collect the output and input file name
			System.out.print("Enter the name of the input file:");
			nameIn=keyboard.nextLine();
			fileIn=new Scanner(new File(nameIn));
			
			System.out.print("Enter the name of the output file:");
			nameOut=keyboard.nextLine();
			fileOut=new PrintWriter(new File(nameOut));
		//if the input or output file is not found the catch will print the	message
		}catch(FileNotFoundException notFound) {
			
			System.out.println("File not found");
		}
		
	//if fileIn is not null the following code will execute
	if(fileIn!=null) {
		//use a while loop to read the input file, while there is a next line
		while(fileIn.hasNextLine()) {
			/*Use a try and catch block, the try block calculates the sum
			and average of the numbers on each line and if an exception is found
			the catch clause deals with it */
			try {
				//use numbers to store the line and use split to get 2 strings
				String numbers=fileIn.nextLine();
				String numArr[]=numbers.split(":");
				
				sum=0;
				//we use a for loop to convert the strings to doubles and to calculate the sum
				for(int i=0;i<2;i++) {
					
					num=Double.parseDouble(numArr[i]);
					sum=sum+num;
					
				}
				//when we get the value of sum we calculate the average and save the output in the output file
				avg=sum/2.0;
				fileOut.println(sum+":"+avg);
				/*if the number can't be converted into a double due to the format 
				the error message will be written in the output file */
			}catch(NumberFormatException numForm) {
				
				fileOut.println( "Error converting numbers.");
				/*if the a number is missing there will 
				be an array index out of bound exception
				the error message will be written in the output file */
			}catch(ArrayIndexOutOfBoundsException outBound) {
				
				fileOut.println( "Missing column(s).");
			}
		}
	}
	//close the output file if it is not null
	if(fileOut!=null) {
		fileOut.close();
	}
	//close the input file if it is not null
	if(fileIn!=null) {
		fileIn.close();
	}
	//close the keyboard
		keyboard.close();
		System.out.println("Processing complete.");

	}

}


