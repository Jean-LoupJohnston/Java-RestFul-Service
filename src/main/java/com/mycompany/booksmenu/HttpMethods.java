/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.booksmenu;

/**
 *
 * @author Jean-Loup
 */


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;


public class HttpMethods {

    
    
    public static void help()
    {
        System.out.println("This program lets you interact with the book system using RESTful web service");
    }
    
     public static void listBooks()
    {
        HttpGet request = new HttpGet("https://httpbin.org/get");
        
         try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
             
         
          HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
         }
         catch(Exception e)
         {
             System.out.println("Error");
         }
    }
      public static void displayBook(int id)
    {
        HttpGet request = new HttpGet("https://httpbin.org/get?id="+id);
         try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
             
         
          HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
         }
         catch(Exception e)
         {
             System.out.println("Error");
         }
    }
      public static void addBook()
    {
        System.out.println("uddbook");
    }
      public static void updateBook()
    {
        System.out.println("udatebook");
    }
       public static void deleteBook()
    {
        System.out.println("deletebook");
    }
        public static void quit()
    {
        System.exit(0);
    }
}
