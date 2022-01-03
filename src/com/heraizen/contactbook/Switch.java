package com.heraizen.contactbook;

import java.util.Scanner;

public class Switch {

    
    public static void switchIn(int num, Contact c) {
        Scanner sc = new Scanner(System.in);
        switch(num) 
        {
            case 1:
                UserAdder.addFName(c);
                break;
            default :
                System.out.println("Invalid choice. Please enter 1 through 6 only.");
                System.out.println();
                DisplayMenu.display();
                num = sc.nextInt();
                switchIn(num, c);
                break;
        }
    }
}

