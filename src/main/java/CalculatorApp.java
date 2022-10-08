import org.example.ValidateString;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CalculatorApp {


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression to compute: ");
        String userInput = input.next();


        // check validity of String
        if(ValidateString.isValid(userInput) == true)
        {
            CalculatorApp calc = new CalculatorApp(userInput);
        }
        else
        {
            System.out.println("Error that is not a valid string. ");
        }
        // if string is invalid print error message, otherwise calculate string


    }


    public CalculatorApp(String userInput) {


        // create two ArrayLists, one containing the integers and one containing the operators in the order they appear

        int len = userInput.length();
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        ArrayList<Character> operatorList = new ArrayList<Character>();

        int newOperatorIndex = 0;
        for (int i=0; i<len; i++) {
            char c = userInput.charAt(i);

            if (c == '*' || c == '+' || c == '-' )
            {
                String tempInt = userInput.substring(newOperatorIndex, i);
                char tempOperator = userInput.charAt(i);

                integerList.add(Integer.parseInt(tempInt));
                operatorList.add(tempOperator);
                newOperatorIndex = i+1;
            }
        }
        // add last integer to the array list
        String tempInt = userInput.substring(newOperatorIndex, len);
        integerList.add(Integer.parseInt(tempInt));



        // do all multiplications first (BEMDAS)
        for(int i=0; i<operatorList.size();i++) {

            if(operatorList.get(i) == '*' ) {

                int tempInt1 = (int) integerList.get(i);
                int tempInt2 = (int) integerList.get(i+1);

                int newInt = tempInt1*tempInt2;

                integerList.set(i+1, newInt);
                integerList.remove(i);

                operatorList.remove(i);
                i--;

            }

        }


        // do addition and subtraction
        for(int i=0; i<operatorList.size();i++) {

            int tempInt1;
            int tempInt2;
            int newInt;

            if(operatorList.get(i) == '+') {

                tempInt1 = (int) integerList.get(i);
                tempInt2 = (int) integerList.get(i+1);

                newInt = tempInt1+tempInt2;
            }

            else if(operatorList.get(i) == '-') {

                tempInt1 = (int) integerList.get(i);
                tempInt2 = (int) integerList.get(i+1);
                newInt = tempInt1-tempInt2;
            }
            else {
                continue;
            }

            integerList.set(i+1, newInt);
            integerList.remove(i);

            operatorList.remove(i);
            i--;

        }


        System.out.println("Result: "+ integerList.get(0));
    }

}