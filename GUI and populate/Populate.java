/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coen.pkg280.parse.and.populate;

/**
 *
 * @author Qi
 */

import java.io.*;
import java.sql.*;
import java.util.*;
import java.lang.Long.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Populate {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParseException {
        // TODO code application logic here
        Populate poprun = new Populate();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = null;
        //connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
        try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"hr");
                        System.out.println("connection suc");
		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}
        
        poprun.Populate_business(connection);
        poprun.Populate_user(connection);
        poprun.Populate_Checkin(connection);
        poprun.Populate_reviews(connection);
        connection.close();

    }


    private void Populate_business(/*String name,*/ Connection con) throws IOException, SQLException, ClassNotFoundException {
        JSONParser parser = new JSONParser();
        Statement statement = null;
        statement = con.createStatement();
        statement.executeUpdate("delete YELP_BUSINESS");
        try {

		String jsonFile = "C:/Users/Qi/Desktop/YelpDataset/YelpDataset-CptS451/yelp_business.json";
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                String line = null;
                
                while((line = br.readLine()) != null){
                    Object obj = parser.parse(line);
                    JSONObject jobj = (JSONObject) obj;
                    String id = (String) jobj.get("business_id");
                    String address = (String) jobj.get("full_address");
                    String cat = (String) jobj.get("categories").toString();
                    String city = (String) jobj.get("city");
                    //int rCount = (int) jobj.get("review_count").intValue();
                    int rCount = Integer.parseInt(jobj.get("review_count").toString());
                    //Integer rCount = new Integer(jobj.get("review_count").intValue());
                    String full_name = (String) jobj.get("name");
                    String state = (String) jobj.get("state");
                    String stars = (String) jobj.get("stars").toString();
                    String type = (String) jobj.get("type");
                    System.out.println("id:" + id + " ");
                    System.out.println("info:" + address + " ");
                    System.out.println("categories:" + cat + " ");
                    System.out.println("city:" + city + " ");
                    System.out.println("rCount:" + rCount + " ");
                    System.out.println("full_name:" + full_name + " ");
                    System.out.println("state:" + state + " ");
                    System.out.println("stars:" + stars + " ");
                    System.out.println("type:" + type + " ");
                    
                    PreparedStatement preparedStmt = con.prepareStatement("INSERT into YELP_BUSINESS VALUES(?,?,?,?,?,?,?,?,?)");
                    preparedStmt.setString (1, id);
                    preparedStmt.setString (2, address);
                    preparedStmt.setString (3, cat);
                    preparedStmt.setString (4, city);
                    preparedStmt.setInt (5, rCount);
                    preparedStmt.setString (6, full_name);
                    preparedStmt.setString (7, state);
                    preparedStmt.setString (8, stars);
                    preparedStmt.setString (9, type);

                    /*String insertTableSQL = "INSERT INTO YELP_BUSINESS"
				+ " VALUES "
				+ "(" + id +"','" + address +"','" + cat +"','" 
                                + city +"'," + rCount +",'" + full_name +"','"
                                + state +"','" + stars +"','"
                                        + type +"')";
                    System.out.println(insertTableSQL);*/
                    
                    preparedStmt.executeUpdate();
                    preparedStmt.close();
                }
		}catch (Exception e){
                    e.printStackTrace();
                }
    }

    private void Populate_user(/*String name,*/ Connection con) throws IOException, SQLException, ClassNotFoundException {
        JSONParser parser = new JSONParser();
        Statement statement = null;
        statement = con.createStatement();
        statement.executeUpdate("DELETE YELP_USER");
        try {

		String jsonFile = "C:/Users/Qi/Desktop/YelpDataset/YelpDataset-CptS451/yelp_user.json";
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                String line = null;
                
                while((line = br.readLine()) != null){
                    Object obj = parser.parse(line);
                    JSONObject jobj = (JSONObject) obj;
                    String yelping_since = (String) jobj.get("yelping_since");
                    int rCount = Integer.parseInt(jobj.get("review_count").toString());
                    String full_name = (String) jobj.get("name");
                    String id = (String) jobj.get("user_id");
                    JSONArray jArray = (JSONArray) jobj.get("friends");
                    int friends = (int) jArray.size();
                    String stars = (String) jobj.get("average_stars").toString();
                    
                    System.out.println("yelping_since:" + yelping_since + " ");
                    System.out.println("rCount:" + rCount + " ");
                    System.out.println("full_name:" + full_name + " ");
                    System.out.println("id:" + id + " ");
                    System.out.println("friends:" + friends + " ");
                    System.out.println("stars:" + stars + " ");
                    PreparedStatement preparedStmt = con.prepareStatement("INSERT into YELP_USER VALUES(?,?,?,?,?,?)");
                    preparedStmt.setString (1, yelping_since);
                    preparedStmt.setInt (2, rCount);
                    preparedStmt.setString (3, full_name);
                    preparedStmt.setString (4, id);
                    preparedStmt.setInt (5, friends);
                    preparedStmt.setString (6, stars);
                    
                    preparedStmt.executeUpdate();
                    preparedStmt.close();
                    /*String insertTableSQL = "INSERT INTO YELP_USER"
				+ " VALUES "
				+ "('" + yelping_since + "'," + rCount +",'" + full_name +"','"
                                + id +"'," + friends +",'"
                                        + stars +"')";
                    
                    statement.executeUpdate(insertTableSQL);*/
                    
                }
		}catch (Exception e){
                    e.printStackTrace();
                }
    }

    private void Populate_Checkin(/*String name,*/ Connection con) throws IOException, SQLException, ClassNotFoundException {
        JSONParser parser = new JSONParser();
        Statement statement = null;
        statement = con.createStatement();
        statement.executeUpdate("DELETE YELP_CHECKIN");
        try {

		String jsonFile = "C:/Users/Qi/Desktop/YelpDataset/YelpDataset-CptS451/yelp_checkin.json";
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                String line = null;
                while((line = br.readLine()) != null){
                    Object obj = parser.parse(line);
                    JSONObject jobj = (JSONObject) obj;
                    String info = jobj.get("checkin_info").toString();
                    String type = (String) jobj.get("type");
                    String id = (String) jobj.get("business_id");
                    System.out.println("info:" + info + " ");
                    System.out.println("type:" + type + " ");
                    System.out.println("id:" + id + " ");
                    String insertTableSQL = "INSERT INTO YELP_CHECKIN"
				+ " VALUES "
				+ "('" + info +"','" + id +"')";
                    statement.executeUpdate(insertTableSQL);
                }
		}catch (Exception e){
                    e.printStackTrace();
                }
    }

    private void Populate_reviews(/*String name,*/ Connection con) throws IOException, SQLException, ClassNotFoundException {
        JSONParser parser = new JSONParser();
        Statement statement = null;
        statement = con.createStatement();
        statement.executeUpdate("DELETE YELP_REVIEW");
        try {

		String jsonFile = "C:/Users/Qi/Desktop/YelpDataset/YelpDataset-CptS451/yelp_review.json";
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                String line = null;
                
                while((line = br.readLine()) != null){
                    Object obj = parser.parse(line);
                    JSONObject jobj = (JSONObject) obj;
                    String u_id = (String) jobj.get("user_id");
                    JSONObject votes = (JSONObject) jobj.get("votes");
                    int vote_sum = 0;
                    vote_sum += (int) Integer.parseInt(votes.get("funny").toString());
                    vote_sum += (int) Integer.parseInt(votes.get("useful").toString());
                    vote_sum += (int) Integer.parseInt(votes.get("cool").toString());
                    ///vote_sum = (int) jArray.get(0) +(int) jArray.get(1) + (int)jArray.get(2);
                    
                    
                    String r_id = (String) jobj.get("review_id");
                    String stars = (String) jobj.get("stars").toString();
                    String create_date = (String) jobj.get("date");
                    String business_id = (String) jobj.get("business_id");
                    
                    System.out.println("votes:" + vote_sum + " ");
                    System.out.println("u_id:" + u_id + " ");
                    System.out.println("r_id:" + r_id + " ");
                    System.out.println("business_id:" + business_id + " ");
                    System.out.println("create_date:" + create_date + " ");
                    System.out.println("stars:" + stars + " ");
                    PreparedStatement preparedStmt = con.prepareStatement("INSERT into YELP_REVIEW VALUES(?,?,?,?,?,?)");
                    preparedStmt.setInt (1, vote_sum);
                    preparedStmt.setString (2, u_id);
                    preparedStmt.setString (3, r_id);
                    preparedStmt.setString (4, stars);
                    preparedStmt.setString (5, create_date);
                    preparedStmt.setString (6, business_id);
                    
                    preparedStmt.executeUpdate();
                    preparedStmt.close();
                    /*String insertTableSQL = "INSERT INTO YELP_USER"
				+ " VALUES "
				+ "('" + yelping_since + "'," + rCount +",'" + full_name +"','"
                                + id +"'," + friends +",'"
                                        + stars +"')";
                    
                    statement.executeUpdate(insertTableSQL);*/
                }
		}catch (Exception e){
                    e.printStackTrace();
                }

    }
}
