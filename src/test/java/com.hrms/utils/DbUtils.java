package com.hrms.utils;

import java.sql.*;
import java.util.*;

public class DbUtils {

    private static Connection conn;
    private static Statement statement;
    private static  ResultSet rset;
    private static Map map;
    public static Connection getConnection(){
        try{
            conn=DriverManager.getConnection(
                    ConfigsReader.getPropertyValue("dbUrl"),
                    ConfigsReader.getPropertyValue("dbUsername"),
                    ConfigsReader.getPropertyValue("dbPassword"));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static ResultSet getResultSet(String query){
        try{
            statement=getConnection().createStatement();
            rset=statement.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rset;
    }
    public static List<Map<String,String>> getDBDataIntoList(String query){
        List<Map<String,String>> dbList=new ArrayList<>();
        try{
            ResultSetMetaData rsetMData=getResultSet(query).getMetaData();
            while (rset.next()){//loops through each row
                map=new LinkedHashMap<>();
                for(int c=1; c<=rsetMData.getColumnCount(); c++){//loops through each column
                    map.put(rsetMData.getColumnName(c),rset.getString(c));
                }
                dbList.add(map);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }return dbList;
    }
}