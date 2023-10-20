/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalyzeUserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author HI
 */
public class AnalyzeString {
    private static final Scanner in = new Scanner(System.in);

    private static boolean checkSquareNumber(int n) {
        return Math.sqrt(n) * Math.sqrt(n) == n;
    }

    private static void getNumber(String inputString) {
        HashMap<String, ArrayList<Integer>> hmNumber = new HashMap<>();
        String number = inputString.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;

        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }
            if (checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);

        for (Map.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    private static void getCharacter(String inputString) {
        HashMap<String, String> hmString = new HashMap<>();
        String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = inputString.replaceAll("\\w", "");
        String allCharacter = inputString.replaceAll("\\W", "");
        hmString.put("Uppercase: ", uppercase);
        hmString.put("Lowercase: ", lowercase);
        hmString.put("Special: ", special);
        hmString.put("All Character: ", allCharacter);
        for (Map.Entry m : hmString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    public static void main(String[] args) {
        System.out.println("----------- Analysis String program -----------");
        System.out.print("Enter a string: ");
        String inputString = in.nextLine();
        
        System.out.println("--------------- Analysis Result ---------------");
        getNumber(inputString);
        getCharacter(inputString);
       
    }
}
