package org.example;

import java.util.Scanner;

public class ValidateString {

    public static boolean isValid(String s) {

        boolean valid = false;
        int previousOperator = 0;

        for (int i=0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c) == true) {
                previousOperator = 0;
                valid = true;
                continue;
            }

            else if (c == '*' || c == '+' || c == '-' )
            {
                if (previousOperator == 1) {
                    valid = false;
                    break;

                }
                else {
                    previousOperator = 1;
                    valid = true;
                    continue;
                }
            }

            else
            {
                valid = false;
                break;
            }
        }
        return valid;

    }
}