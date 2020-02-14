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


import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpMethods {

    
    
    public static void help()
    {
        System.out.println("This program lets you interact with the book system using RESTful web service");
    }
    
     public static void listBooks()
    {
        HttpGet request = new HttpGet("http://localhost:8080/ServiceSystem/resources/library/listbooks");
        
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
        HttpGet request = new HttpGet("http://localhost:8080/ServiceSystem/resources/library/displaybook?id="+id);
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
      public static void addBook(String[] bookInfo)
    {
        
        
            List<NameValuePair> form = new ArrayList<>();
            form.add(new BasicNameValuePair("title", bookInfo[0]));
            form.add(new BasicNameValuePair("description", bookInfo[1]));
            form.add(new BasicNameValuePair("isbn", bookInfo[2]));
            form.add(new BasicNameValuePair("author", bookInfo[3]));
            form.add(new BasicNameValuePair("publisher", bookInfo[4]));
            UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(form, Consts.UTF_8);
            
            HttpPost request = new HttpPost("http://localhost:8080/ServiceSystem/resources/library/addbook");
            
            request.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
            request.setEntity(entity2);
         
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
      public static void updateBook(String[] str)
    {

            List<NameValuePair> form = new ArrayList<>();
            form.add(new BasicNameValuePair("id", str[0]));
            form.add(new BasicNameValuePair("Attribute", str[1]));
            form.add(new BasicNameValuePair("NewValue", str[2]));
          
            UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(form, Consts.UTF_8);
            
            HttpPut request = new HttpPut("http://localhost:8080/ServiceSystem/resources/library/updatebook");
            request.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
            request.setEntity(entity2);
         
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
       public static void deleteBook(String i)
    {

            
            HttpDelete request = new HttpDelete("http://localhost:8080/ServiceSystem/resources/library/deletebook/"+i);
         
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
        public static void quit()
    {
        System.exit(0);
    }
}
