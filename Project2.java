package edu.umw.project2;
import java.util.Scanner;

import java.util.Scanner;

public class Project2 {

        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a number for verification. Do not include spaces or dashes. ");
            String isbn = input.nextLine();
            int n =  isbn.length();
           //if isbn is 10 digits then checksum10 and validateIsbn10 will run.
            if (n ==10){
                checksum10(isbn);
                validateIsbn10(isbn);
            //if isbn is 13 digits checksum13 and validateIsbn13 will run.
            } else if (n == 13) {
                checksum13(isbn);
                validateIsbn13(isbn);
           //if the number entered is not 10 or 13 digits the program will output the following.
            }else {
                System.out.println("The number " + isbn + " is not a valid ISBN length.");
            }
    }
        public static int checksum10(String isbn10){
            char a1;
            int count = 10;
            int var = 0;


            String input = "";
            String isbnStr [] = new
                    String[(isbn10.length())];
            int isbn[] = new int[isbn10.length()];
            for (int i = 0; i < isbn10.length(); i++){
                a1 = isbn10.charAt(i);
                input = isbn10.valueOf(a1);
                isbnStr[i] = input;
            }

            for (int i = 0; i<isbn10.length(); i++){
                isbn[i] = Integer.parseInt(isbnStr[i]);
            }

            for (int i = 0; i < isbn10.length() -1; i++) {
                var = (isbn[i] * count) + var;
                count--;
            }

            int printChecksum10 = 11 - (var %11);
            System.out.println("The checksum is " + printChecksum10 + ".");

            return printChecksum10;
        }

        public static int checksum13(String isbn13){
            char a1;
            int var = 0;

            String input = "";
            String isbnStr[] = new
                    String[(isbn13.length())];
            int isbn[] = new int[isbn13.length()];

            for(int i = 0; i < isbn13.length(); i++){

                a1 = isbn13.charAt(i);
                input = isbn13.valueOf(a1);
                isbnStr[i] = input;
            }
            for (int i = 0; i < isbn13.length(); i++){
                isbn[i] = Integer.parseInt(isbnStr[i]);
            }
            int check = isbn[12];
            int cal[] = {1,3,1,3,1,3,1,3,1,3,1,3};

            for (int i = 0; i < isbn13.length() - 1; i++){
                var = (cal[i] * isbn[i]) + var;
            }
            var = var %10;
            var = 10 - var;

            System.out.println("The checksum is " + var + ".");

            return var;
        }
        public static boolean validateIsbn10(String isbn10){
            boolean s = false;

            char a1;
            int count = 10;
            int var = 0;

            String input = "";
            String isbnStr [] = new String[(isbn10.length())];
            int isbn[] = new int[isbn10.length()];
            for (int i = 0; i < isbn10.length(); i++){

                a1 = isbn10.charAt(i);
                input = isbn10.valueOf(a1);
                isbnStr[i] = input;

            }

            for (int i = 0; i < isbn10.length(); i++){
                isbn[i] = Integer.parseInt(isbnStr[i]);

            }

            for (int i = 0; i < isbn10.length(); i++){

                var = (isbn[i] * count) + var;
                count--;
            }

            if (((var % 11) + isbn[9])% 11 == 0){
                    System.out.println("The number " + isbn10 + " is a valid 13 digit ISBN.");
                    s = true;
                } else {
                    System.out.println("The number " + isbn10 + "is NOT a valid 13 digit ISBN.");
                }
                return s;
        }
        public static boolean validateIsbn13(String isbn13){
            boolean s = false;

            char a1;
            int var = 0;

            String input = "";
            String isbnStr [] = new
                    String[(isbn13.length())];
            int isbn[] = new int[isbn13.length()];
            for (int i = 0; i < isbn13.length(); i++){
                a1 = isbn13.charAt(i);
                input =isbn13.valueOf(a1);
                isbnStr[i] = input;

            }

            for (int i = 0; i < isbn13.length(); i++){
                isbn[i] = Integer.parseInt(isbnStr[i]);
            }

            int check = isbn[12];
            int cal[] = {1,3,1,3,1,3,1,3,1,3,1,3};

            for (int i = 0; i < isbn13.length() -1; i++){
                var = (cal[i] * isbn[i]) + var;
            }

            var = var % 10;
            var = 10 - var;

            if (var == isbn[12]){
                System.out.println("The number " + isbn13 + " is a valid 13 digit ISBN.");
                s = true;
            } else {
                System.out.println("The number " + isbn13 + "is NOT a valid 13 digit ISBN.");
            }
            return s;
        }

}
