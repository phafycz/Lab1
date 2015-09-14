/*
 * Paul Hafycz & Kelly Baldino
 * Retirement Plan
 * The user inputs:
 * How many Years they plan to work, Annual Return on Investment during those years,
 * How many years they plan to be retired, Annual return on investment during those years,
 * Required income per month, and your monthy SSI
 * Returned using FinanceLib formulas PV(Present Value), which indicates
 * how much you will need saved to be able to sustain yourself to the point that you want
 * and PMT(Payment), which indicates while you're working how much you will have to put away
 * per month
 * All of the user input has been translated into a double because those are the types that FinanceLib.pv() and FinanceLib.pmt() accepts
 */

package lab1;
import java.util.Scanner; //Imports scanner which will be very essential as it obtains user input
import org.apache.poi.ss.formula.functions.FinanceLib; 
//Imports FinanceLib which is also essential as it allows for you to use the built in formulas included in it
public class RetirementPlans 
{ //Class delclaration
	public static void main(String[] args)
	{//Main method declaration
		Scanner yearsWorking = new Scanner(System.in);//Allows user input for amount of years working
		System.out.println("How many years do you plan on working?");//prompt for user 
		double yearsWorking1 = yearsWorking.nextDouble();//Converts user input into a double
		double monthsWorking = yearsWorking1*12;//Converts years into months in order to have the amount of payment periods
		
		Scanner annualReturnWork = new Scanner(System.in);//Allows user input for annual return while working
		System.out.println("What will your annual return on your investment be while working?");//Prompt for user
		double annualReturnWork1 = annualReturnWork.nextDouble();//Converts user input into a double
		double monthlyReturnWork = annualReturnWork1/12;//Converts the annual return into monthly in order to be able to use it in the pv and pmt functions
		
		Scanner yearsRetired = new Scanner(System.in);//Allows user input for amount of years retired
		System.out.println("How many years do you plan on being retired for?");//prompt for user 
		double yearsRetired1 = yearsRetired.nextDouble();//Converts user input into a double
		double monthsRetired = yearsRetired1*12;//Converts years into months in order to figure out the amount of periods necessary for payment
		
		Scanner annualReturn = new Scanner(System.in);//Allows user input for annual return while retired
		System.out.println("What will your annual return on your investment be while retired?");//Prompt for user
		double annualReturn1 = annualReturn.nextDouble();//Converts user input into a double
		double monthlyReturn = annualReturn1/12;//Converts the annual return into monthly in order to be able to use in the pv and pmt functions
		
		Scanner required$ = new Scanner(System.in);//Allows user input for required monthly income while retired
		System.out.println("What will your required monthly income be while retired?");//Prompt for user
		double required$1 = required$.nextDouble();//Converts user input into a double
		
		Scanner ssi$ = new Scanner(System.in);//Allows user input for their SSI
		System.out.println("What will your Social Security monthly income be while retired?");//Prompt for user
		double ssi$1 = ssi$.nextDouble();//Converts user input into a double
		
		double income = required$1 - ssi$1;//Shows the needed amount per month after taking in consideration the ssi
		boolean paymentTime = false;//The pmt and pv functions both need a boolean indicating whether the payment will be made at the beginning of the period or the end of it
		//false indicated the end and true indicated the beginning(Neither should affect the final answer)
		double leftOver = 0;//Indicates that at the end of the payments I want 0 money left over
		double presentValue = 0;//We start with 0 in our present value
		double futureValue;
		double pv = FinanceLib.pv(monthlyReturn, monthsRetired, income, leftOver, paymentTime );
		futureValue=pv; //Made pv = futurevalue so it could be used without being modified in the pmt function
		pv = -pv; //inversed pv because it comes out negative
		System.out.printf("The amount you will need to save is $%4.2f", pv); //Used the printf function in order to round the number and reduce the decimals
		double pmt = FinanceLib.pmt(monthlyReturnWork, monthsWorking, presentValue, futureValue, paymentTime); //calling the method pmt and inputting the variables inside of it
		System.out.println(""); //used println to create a newline because \n would not work for some reason
		System.out.printf("The amount you will need to pay each month is $%4.2f", pmt); //Same reason I used the printf function up there^

	}
}
