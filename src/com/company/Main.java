package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice ;

        //instantiating new object for calculation class
        Calculation cal = new Calculation();

        List<Customer> customerList = new ArrayList<Customer>();

        //existing user data
        cal.preLoadedData(customerList);

        //Option Messages
        cal.info();

        //program starts
        do {

            System.out.print("Enter your choice :");
            choice = scan.nextInt();

            //switch condition
            switch (choice){
                case 1:
                    System.out.println("Adding customer");
                        cal.addCustomer(customerList);
                        break;
                case 2:
                    if(customerList.size() == 0){
                    System.out.println("No customer data");
                        }
                        else{
                           System.out.println(customerList);
                        }
                        break;
                case 3:
                    System.out.println(cal.display(customerList));
                        break;
                case 4:
                    cal.deposit(customerList);
                        break;
                case 5:
                    cal.withdraw(customerList);
                        break;
                case 6:
                    cal.transfer(customerList);
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

            cal.print("_________________________________________");

        }while(choice < 7 );

        System.out.println("Thank you for using the system!! Good Bye!!!");
    }


}
