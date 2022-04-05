package lession1;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        Scanner sc = new Scanner(System.in);
        System.out.print("Principal :");
        int principal = sc.nextInt();

        System.out.print("Annual Interest Rate :");
        double annual_interest_rate = sc.nextDouble();

        System.out.print("Period (Year):");
        byte period = sc.nextByte();

        double a_i_r = (annual_interest_rate/PERCENTAGE)/MONTHS_IN_YEAR;
        int number_of_period = period*MONTHS_IN_YEAR;

        double upper_case = a_i_r*(Math.pow(1+a_i_r, number_of_period));
        double lower_case = (Math.pow(1 + a_i_r, number_of_period))-1;
        double M = principal*(upper_case/lower_case);


        NumberFormat mortgage = NumberFormat.getCurrencyInstance();
        String result = (mortgage.format(M));
        System.out.println("Mortgage :"+result);
    }
}
