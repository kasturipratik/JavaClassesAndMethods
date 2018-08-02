package com.company;

import java.util.List;
import java.util.Scanner;


public class Calculation {

    public void preLoadedData(List<Customer> customerList){
        //data for easier user
        Customer customer = new Customer("pratik",500000);
        Customer customer1 = new Customer("pratap", 5000);
        Customer customer2 = new Customer("pramila", 50000);

        //adding customer into the list
        customerList.add(customer);
        customerList.add(customer1);
        customerList.add(customer2);
    }

    /**
     * adding new customer data
     * @param customerList
     */
    public  void addCustomer(List<Customer> customerList){
        Scanner scan = new Scanner(System.in);
        print("Enter name :");
        String name = scan.nextLine();

        print("Enter amount :");
        double amount = scan.nextDouble();

        Customer customer = new Customer(name , amount);
        customerList.add(customer);
    }

    /**
     * display customer by id
     * @param customerList
     * @return
     */
    public  String display(List<Customer> customerList){
        Scanner scan = new Scanner(System.in);
        String custInfo="";
        boolean account = false;
        if(customerList.size() == 0 ){
            return "No Customer Data found";
        }
        else {
            print("Enter id to find customer");
            int id = scan.nextInt();

            for (Customer cust : customerList){
                if(cust.getId() == id){
                    custInfo = "Id: "+ cust.getId() + "\nName: "+ cust.getName() + "\nBalance: "+ cust.getAmount();
                    account = true;
                }
            }
            if(account == false) {
                custInfo ="No account exist with that id";
            }
            return custInfo;
        }


    }

    /**
     * deposit method
     * @param customerList
     */
    public void deposit(List<Customer> customerList){
        Scanner scan = new Scanner(System.in);
        boolean account= false;
        if(customerList.size() == 0){
            print("No account exists to deposit money");
        }
        else{
            print("Enter Id for your account");
            int id = scan.nextInt();
            for(Customer cust : customerList){
                if(cust.getId() == id){
                    print("Enter amount to deposit: ");
                    double amount = scan.nextDouble();
                    cust.setAmount(cust.getAmount() + amount);
                    print(amount +" successfully deposited to your account.");
                    print("Your current balance is: " + cust.getAmount());
                    print("Thank you");
                    account = true;
                }

            }
            if(account == false) {
                print("No account exist with that id");
            }
        }

    }

    /**
     *
     * @param customerList
     * with draw method
     */
    public void withdraw(List<Customer> customerList){
        Scanner scan = new Scanner(System.in);
        boolean account = false;
        if(customerList.size() == 0){
            print("No data Exists");
        }
        else{
            print("Enter id for your account to withdraw: ");
            int id = scan.nextInt();
            for(Customer cust : customerList){
                if(cust.getId() == id){
                    if(cust.getAmount() <= 10){
                        print("Insufficient fund to withdraw. Please deposit fund for future withdrawals");
                        print("Your balance is :" + cust.getAmount());
                    }
                    else{
                        print("Enter withdrawal amount: ");
                        double withdraw = scan.nextDouble();

                        if(cust.getAmount() - withdraw < 10){
                            print("You don't have sufficient fund to withdraw: "+ withdraw);
                            print("Your balance is: "+ cust.getAmount());
                            print("Your withdrawal limit is: "+ (cust.getAmount() - 10));
                        }
                        else {
                            cust.setAmount(cust.getAmount() - withdraw);
                            print("You have successfully withdrawn: "+ withdraw);
                            print("Remaining balance: "+ cust.getAmount()+"\nThank You");
                        }
                    }
                    account = true;
                }

            }
            if(account == false) {
                print("No account matches the id you have provided");
            }
        }
    }

    /**
     * Transfer balance method
     * @param customerList
     */
    public void transfer(List<Customer> customerList){

        Scanner scan = new Scanner(System.in);
        int id, transferId;

        /*condition for printing no account exist message*/
        boolean account = false;
        boolean transferAccount = false;

        if(customerList.size()==0){
            print("No customer data");
        }
        else{
            print("Enter your account id: ");
            id = scan.nextInt();

            for(Customer cust : customerList){
                if(cust.getId() == id){

                    if(cust.getAmount() <= 10.0){

                        print("Insufficient fund to transfer. Please deposit fund for future transfer");
                        print("Your balance is :" + cust.getAmount());
                        transferAccount = true;
                    }
                    else{
                        print("Your have "+ cust.getAmount() + " in your account");
                        print("Enter id where the money is to be sent.");
                        transferId = scan.nextInt();

                        if(id != transferId) {
                            for (Customer transferCust : customerList) {

                                if (transferCust.getId() == transferId) {

                                    print("Enter amount to be sent: ");
                                    double amount = scan.nextDouble();

                                    if (cust.getAmount() - amount < 10) {

                                        print("Not enough balance to transfer" + amount);
                                        print("Your balance is: " + cust.getAmount());
                                        print("Transferable amount: "+ (cust.getAmount()-10));

                                    } else {
                                        cust.setAmount(cust.getAmount() - amount);
                                        transferCust.setAmount(transferCust.getAmount() + amount);
                                        print(amount + " transfer successful to " + transferCust.getName());
                                        print("Your available balance is: " + cust.getAmount());
                                    }

                                    transferAccount = true;
                                }
                            }
                        }
                        else {
                            print("Transfer cannot be done is same account");
                        }
                    }
                    account = true;
                }
            }
            //end of main for loop
            if(account == false || transferAccount == false) {
                print("No account exist with that id");
            }
        }
        //end of else statement if data exist in the list
    }

    /**
     * begining message
     */
    public  void info(){
        print("************** Customer Application ************");
        print("Enter 1 : for adding customer");
        print("Enter 2 : for displaying all the customer");
        print("Enter 3 : for displaying customer by ID");
        print("Enter 4 : for deposit");
        print("Enter 5 : for withdrawal");
        print("Enter 6 : for transfer");
        print("Enter 7 to EXIT");
        print("-------------------------------------------------");
    }

    /**
     * print short cut method
     * @param s
     */
    public  void print(String s){
        System.out.println(s);
    }
}
