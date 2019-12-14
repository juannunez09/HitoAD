package com.campusfp.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.campusfp.xml.Item;


public class PruebaLeer {

	static ArrayList<String> almacenjson = new ArrayList<String>();
	static ArrayList<String> almacentxt = new ArrayList<String>();
	static StaXParser read = new StaXParser();
	static List<Item> readConfig = read.readConfig("prueba.xml");
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
       System.out.println("****Mostra XML******");
        for (Item item : readConfig) {
            System.out.println(item);
            almacenjson.add("{"+item.toString()+"}");
        }
        
	}
        
        

}
