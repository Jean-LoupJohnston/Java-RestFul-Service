/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.booksmenu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jean-Loup
 */

public class Home {
    
    public static int takeIdInput()
{      
    Scanner inp = new Scanner(System.in);
    while(true)
    {
        System.out.println("\nEnter an id");
        try{
        int id = inp.nextInt();
        return id;}
        catch(InputMismatchException e)
        {
             System.out.println("Invalid input, try again");
             inp.next();
        }
      
    }
}
      public static String[] takeAddBookInput()
{      
    Scanner inp = new Scanner(System.in);
    String[] info = new String[5];
    
        System.out.println("\nEnter a title");
        info[0] = inp.nextLine();
        System.out.println("\nEnter a description");
        info[1] = inp.nextLine();
        System.out.println("\nEnter an isbn");
        info[2] = inp.nextLine();
        System.out.println("\nEnter an author");
        info[3] = inp.nextLine();
        System.out.println("\nEnter a pubisher");
        info[4] = inp.nextLine();
           
        return info;
}
    
    public static void main(String[] args)
    {
        
        Scanner kb = new Scanner(System.in);
        while(true)
        {
        
        System.out.println("\nSelect an option\n1:Help\n2:List books\n3:Display book\n4:Add book\n"+
                "5:Update book\n6:Delete book\n7:Quit");
        
         try{
             int input = kb.nextInt();
             if(input<1 ||input>7)
                 {
                     System.out.println("Invalid input, try again");
                     
                 }
             switch(input)
             {
                 case(1):HttpMethods.help();break;
                 case(2):HttpMethods.listBooks();break;
                 case(3):int id = takeIdInput();
                         HttpMethods.displayBook(id);break;
                 case(4):String[] info = takeAddBookInput();
                     HttpMethods.addBook(info);break;
                 case(5):HttpMethods.updateBook();break;
                 case(6):HttpMethods.deleteBook();break;
                 case(7):HttpMethods.quit();break;
             }
         }
         catch(InputMismatchException e)
         {
             System.out.println("Invalid input, try again");
             kb.next();
         }
         
        }
    }
    
}
