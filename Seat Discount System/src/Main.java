import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String Filename = "C:\\Users\\prais\\eclipse-workspace\\Seat Discount System\\data\\seats.txt";
		FileReader File = new FileReader(Filename);
		Scanner Read = new Scanner(File);
		double DiscountRate = 10.00; //sets a variable of the discount rate as a double data type
		
		//initialisation and declaration of all/some variables
		Scanner Response = new Scanner(System.in);
		String Choice;
		String SeatType;
		double SeatPrice;
		int NoBookings;
		double DiscountAmount;
		double SalePrice;
		double TotalAmount = 0;
		double TotalDiscount = 0;
		
		
		System.out.print("Would you like to specify a custom discount rate? (yes/no): ");
		Choice = Response.nextLine();
		if (Choice .equals ( "Yes" ) || Choice .equals ("yes")) //an if statement to control what happens when the Response of the user is yes, it also covers a Response for a different case.
			{
			
			System.out.print("Please enter the discount rate (%): "); //Outputs the string that tells the user what to do (enter the discount rate) and 'print' is used so that the users keyboard input stays on the same line.		
			DiscountRate = Response.nextDouble();
			
			}
			
		else if (Choice .equals ("No") || Choice .equals ("no"))
			{
				
			System.out.println("The current default discount rate is: " + DiscountRate + "%" );
				
			}
			
		else 
			{			
			
			System.out.println("Please enter a valid Response"); //if the user has entered a Response that is not accepted then a message will output informing the user to try again.
			
			}

		System.out.println("\n- Seat Data - \n"); //This outputs the string to make the look of the output 
		System.out.println("Current Discount rate: " + DiscountRate + "%\n");
		while (Read.hasNext()) //this continues to loop through the File as long as there is another line in the File (until the File ends)
		{
			
			SeatType = Read.next(); 
			SeatPrice = Read.nextDouble();
			NoBookings = Read.nextInt();
			
			DiscountAmount = (DiscountRate/100) * (SeatPrice*NoBookings); 
			SalePrice = (SeatPrice * NoBookings) - DiscountAmount; 
			
			TotalAmount = TotalAmount + SalePrice;
			TotalDiscount = TotalDiscount + DiscountAmount; 
			
			System.out.println("Seat Type: " + SeatType);
			System.out.println("Price: �" + SeatPrice);
			System.out.println("No. of bookings: " + NoBookings);
			System.out.println("Discount: �" + String.format("%.2f", DiscountAmount)); //prints the DiscountAmount variable to 2 decimal points ('%.2f)'
			System.out.println("Income: �" + String.format("%.2f",SalePrice)); //prints the SalePrice variable to 2 decimal points ('%.2f)'
			System.out.println("\n");
		}
		
		System.out.println("Total Amount: �" + String.format("%.2f",TotalAmount)); //prints the TotalAmount variable to 2 decimal points ('%.2f)'
		System.out.println("Total Discount: �" + String.format("%.2f",TotalDiscount));//prints the TotalDiscount variable to 2 decimal points ('%.2f)'
		
		 //Closes the scanners.
		Read.close();
		Response.close();
	}
}
