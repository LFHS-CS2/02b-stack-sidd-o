/**
*
* Handles Calling Unit Test Programs
*
*/
import java.util.*;

class Main {
	public static void main(String[] args) {
		System.out.println("-Running Tests on ArrayStack Class...");
		ArrayStackTest.main(null);
		System.out.println("-ArrayStack Class Passed Successfully!");
		System.out.println("-Running Tests on PostfixCalculator Class...");
		PostfixCalculatorTest.main(null);
		System.out.println("-PostfixCalculator Class Passed Successfully!");
		System.out.println("-All Test Passed!");
	}

}
