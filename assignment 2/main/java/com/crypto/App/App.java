package com.crypto.App;
import com.crypto.Enums.Choice;
import com.crypto.TransactionClasses.ParserThread;
import com.crypto.TransactionClasses.Transactions;
import com.crypto.userApps.UserApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileReader;
import java.util.Scanner;


public class App {



    public static void main(String[] args) {

        Choice methodToPerform;
        boolean displayAgain = true;
        String methodArguments;
        int waitingTime = 1000;

        try {


            MemoryLoader memoryLoader = new MemoryLoader(new FileReader("./src/main/resources/traders.csv"), new FileReader("./src/main/resources/coins.csv"));
            Transactions tx = new Transactions();
            UserApplication userApplication = new UserApplication(memoryLoader);
            FileReader transactionJSON = new FileReader("./src/main/resources/test_transaction.json");


            Runnable transactionThread = new ParserThread(tx,transactionJSON , memoryLoader);
            new Thread(transactionThread).start();
            while (displayAgain) {

                System.out.println("Press 1 (space) wallet address for show portfolio ");
                System.out.println("Press 2 for for top 50 coins");
                System.out.println("Press 3 for show top and bottom");
                System.out.println("Press 4 (space) (Coin name or symbol) for show coin details");
                System.out.println("Press 5 (space) wallet address for show profit");
                System.out.println("Press 6 to quit");
                Scanner sc = new Scanner(System.in);
                String userChoice = sc.nextLine();
                String typeofchoice = userChoice.split(" ")[0];

                if (typeofchoice.equals("1")) {
                    methodToPerform = Choice.SHOW_PORTFOLIO;
                    if(userChoice.split(" ").length == 2){
                        methodArguments = userChoice.split(" ")[1];
                        userApplication.showPortfolioOfTheTrader(methodArguments);
                    }
                    else{
                        System.out.println("Write in a proper format");
                    }
                } else if (typeofchoice.equals("2")) {
                    methodToPerform = Choice.DETAILS_TOP_FIFTY_COIN;
                    userApplication.detailsOfTopNCoin(50);
                } else if (typeofchoice.equals("3")) {
                    methodToPerform = Choice.SHOW_TOP_AND_BOTTOM;
                    userApplication.showTopAndBottomN(5);


                } else if (typeofchoice.equals("4")) {
                    methodToPerform = Choice.COIN_DETAILS;
                    if(userChoice.split(" ").length == 2){
                        methodArguments = userChoice.split(" ")[1];
                        userApplication.detailsOfAParticularCoin(methodArguments);
                    }
                    else{
                        System.out.println("Write in a proper format");
                    }

                } else if (typeofchoice.equals("5")) {
                    methodToPerform = Choice.SHOW_PROFIT;
                    if(userChoice.split(" ").length == 2){
                        methodArguments = userChoice.split(" ")[1];
                        userApplication.showProfitOfTheTrader(methodArguments);
                    }
                    else{
                        System.out.println("Write in a proper format");
                    }

                } else if (typeofchoice.equals("6")) {
                    System.out.println("Quitting");
                    displayAgain = false;
                } else {
                    System.out.println("Wrong input please try again! ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
