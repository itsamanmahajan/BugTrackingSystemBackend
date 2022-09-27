package com.bugtracking.user;

import java.awt.Color;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;



public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	//	String path = "C:\\Users\\abhay.kolhe\\Downloads\\lte-pdsch_PDSCHCNI_Common_5000.json";
	  //    JSONParser p =new JSONParser();
	    //  Object obj1=p.parse(new FileReader(path));
	      
		String ste="{ \"nullIndex\": 51, \"indexes\": [ { \"index\": 0, \"min\": -20.0, \"color\": \"#000EFE\" }, { \"index\": 1, \"min\": -19.0, \"color\": \"#000EFE\" }, { \"index\": 2, \"min\": -18.0, \"color\": \"#001DFE\" }, { \"index\": 3, \"min\": -17.0, \"color\": \"#002CFE\" }, { \"index\": 4, \"min\": -16.0, \"color\": \"#003BFE\" }, { \"index\": 5, \"min\": -15.0, \"color\": \"#004DFE\" }, { \"index\": 6, \"min\": -14.0, \"color\": \"#005CFE\" }, { \"index\": 7, \"min\": -13.0, \"color\": \"#006BFE\" }, { \"index\": 8, \"min\": -12.0, \"color\": \"#007AFE\" }, { \"index\": 9, \"min\": -11.0, \"color\": \"#0089FE\" }, { \"index\": 10, \"min\": -10.0, \"color\": \"#0098FE\" }, { \"index\": 11, \"min\": -9.0, \"color\": \"#00A7FE\" }, { \"index\": 12, \"min\": -8.0, \"color\": \"#00B6FE\" }, { \"index\": 13, \"min\": -7.0, \"color\": \"#00C8FE\" }, { \"index\": 14, \"min\": -6.0, \"color\": \"#00D7FE\" }, { \"index\": 15, \"min\": -5.0, \"color\": \"#00E6FE\" }, { \"index\": 16, \"min\": -4.0, \"color\": \"#00F5FE\" }, { \"index\": 17, \"min\": -3.0, \"color\": \"#05FEF9\" }, { \"index\": 18, \"min\": -2.0, \"color\": \"#14FEEA\" }, { \"index\": 19, \"min\": -1.0, \"color\": \"#23FEDB\" }, { \"index\": 20, \"min\": 0.0, \"color\": \"#32FECC\" }, { \"index\": 21, \"min\": 1.0, \"color\": \"#44FEBA\" }, { \"index\": 22, \"min\": 2.0, \"color\": \"#53FEAB\" }, { \"index\": 23, \"min\": 3.0, \"color\": \"#62FE9C\" }, { \"index\": 24, \"min\": 4.0, \"color\": \"#71FE8D\" }, { \"index\": 25, \"min\": 5.0, \"color\": \"#80FE7E\" }, { \"index\": 26, \"min\": 6.0, \"color\": \"#8FFE6F\" }, { \"index\": 27, \"min\": 7.0, \"color\": \"#9EFE60\" }, { \"index\": 28, \"min\": 8.0, \"color\": \"#ADFE51\" }, { \"index\": 29, \"min\": 9.0, \"color\": \"#BCFE42\" }, { \"index\": 30, \"min\": 10.0, \"color\": \"#CEFE30\" }, { \"index\": 31, \"min\": 11.0, \"color\": \"#DDFE21\" }, { \"index\": 32, \"min\": 12.0, \"color\": \"#ECFE12\" }, { \"index\": 33, \"min\": 13.0, \"color\": \"#FBFE03\" }, { \"index\": 34, \"min\": 14.0, \"color\": \"#FEF300\" }, { \"index\": 35, \"min\": 15.0, \"color\": \"#FEE400\" }, { \"index\": 36, \"min\": 16.0, \"color\": \"#FED500\" }, { \"index\": 37, \"min\": 17.0, \"color\": \"#FEC600\" }, { \"index\": 38, \"min\": 18.0, \"color\": \"#FEB400\" }, { \"index\": 39, \"min\": 19.0, \"color\": \"#FEA500\" }, { \"index\": 40, \"min\": 20.0, \"color\": \"#FE9600\" }, { \"index\": 41, \"min\": 21.0, \"color\": \"#FE8700\" }, { \"index\": 42, \"min\": 22.0, \"color\": \"#FE7800\" }, { \"index\": 43, \"min\": 23.0, \"color\": \"#FE6900\" }, { \"index\": 44, \"min\": 24.0, \"color\": \"#FE5A00\" }, { \"index\": 45, \"min\": 25.0, \"color\": \"#FE4B00\" }, { \"index\": 46, \"min\": 26.0, \"color\": \"#FE3900\" }, { \"index\": 47, \"min\": 27.0, \"color\": \"#FE2A00\" }, { \"index\": 48, \"min\": 28.0, \"color\": \"#FE1B00\" }, { \"index\": 49, \"min\": 29.0, \"color\": \"#FE0C00\" }, { \"index\": 50, \"min\": 30.0, \"color\": \"#FE0000\" } ] }";
		JSONObject json =new JSONObject(ste);
	      JSONArray array = json.getJSONArray("indexes");
	      JSONObject result =new JSONObject();
	      for(Object o:array) {
	        JSONArray resultarray=new JSONArray();
	        JSONObject obj=(JSONObject) o;
	        Color a=Color.decode(obj.getString("color"));
	        resultarray.put(a.getRed());
	        resultarray.put(a.getGreen());
	        resultarray.put(a.getBlue());
	        Integer ab =  (int) obj.getDouble("min");
	        result.put(ab.toString(), resultarray);
	      }
	      System.out.println("ab:::"+result);

	}

}
