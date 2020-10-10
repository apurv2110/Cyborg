package com.hello;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UrlShortener
{
	 Map<String, String> index = new HashMap<String, String>();
	 Map<String, String> repeatIndex = new HashMap<String, String>();
	 static String BASE_URL="http.//tinyurl.com/";
	 public String encode(String longUrl) {
		 if (repeatIndex.containsKey(longUrl)) 
			 return BASE_URL + repeatIndex.get(longUrl);
	     String charactrSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  //   System.out.println("check");
	     String key = null;
	     do {
	         StringBuilder sbr = new StringBuilder();
	         for (int j = 0; j < 6; j++) {
	         int r = (int) (Math.random() * charactrSet.length());
	         sbr.append(charactrSet.charAt(r));
	  //     System.out.println("check");
            }
	        key = sbr.toString();
	        }while (index.containsKey(key));
	        index.put(key, longUrl);
	        repeatIndex.put(longUrl, key);
	        return BASE_URL + key;
	    }

	    
	    public String decode(String shortUrl) {
	        return index.get(shortUrl.replace(BASE_URL, ""));
	    }
	    
	    public static void main(String[] args) 
		 {
			UrlShortener us=new UrlShortener(); 
			Scanner sc=new Scanner(System.in); 
			String largeUrl=sc.nextLine();
	    	String outpt=us.encode(largeUrl);
			System.out.println(outpt); 
		 }
	    
	}


