package lession1;

import java.text.NumberFormat;
import java.util.Scanner;



public class Mortgage {
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;
        int principal;
        double annual_interest_rate;
        byte period;
        double a_i_r;
        int number_of_period;

        Scanner sc = new Scanner(System.in);  //input scanner
        System.out.print("Principal (1K - 1M) :");
        principal = sc.nextInt();

        //principal conditions
        while(true){
            if(principal < 1000 || principal > 1000000) {
                System.out.println("The loan amount should be between 1K and 1M");
                System.out.print("Principal (1K - 1M) :");
                principal = sc.nextInt();
            }else
                break;
        }

        //annual interest rate conditions
        while(true){
            System.out.print("Annual Interest Rate :");
            annual_interest_rate = sc.nextDouble();
            if (annual_interest_rate <= 0 || annual_interest_rate > 30) {
                System.out.println("Annual interest rate should be between 1 to 30");
            }else
                break;
        }

        //period conditions
        while(true){
            System.out.print("Period (Year):");
            period = sc.nextByte();
            if(period <= 0 || period > 30){
                System.out.println("Payback Period should be between 1 to 30");
            }else
                break;
        }

        a_i_r = (annual_interest_rate/PERCENTAGE)/MONTHS_IN_YEAR;
        number_of_period = period*MONTHS_IN_YEAR;

        double upper_case = a_i_r*(Math.pow(1+a_i_r, number_of_period));
        double lower_case = (Math.pow(1 + a_i_r, number_of_period))-1;
        double M = principal*(upper_case/lower_case);


        NumberFormat mortgage = NumberFormat.getCurrencyInstance();
        String result = mortgage.format(M);
        System.out.println("Mortgage : "+(result));
    }
}
