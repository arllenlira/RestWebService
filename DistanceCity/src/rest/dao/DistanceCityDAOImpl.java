package rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rest.dao.config.ConFactory;
import rest.model.City;

public class DistanceCityDAOImpl implements DistanceCityDAO{
    
    private Connection con;  
    private Statement command;  
    
    public City getByName(String name) {
        
        City city = new City();
        
        try {
            connect();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        ResultSet rs; 
        
        try {
            rs = command.executeQuery("SELECT * FROM city WHERE name = '" + name +"'");
            
            while (rs.next()) {  
                city = new City();  
                city.setId(rs.getLong("id"));
                city.setName(rs.getString("name"));  
                city.setLatitude(rs.getString("latitude"));  
                city.setLongitude(rs.getString("longitude"));  
             }
          } catch (SQLException e) {  
             e.getMessage();  
          } finally {              
             closeConnection();  
          }        
         return city;
    }    

      private void closeConnection() {  
          try {  
             command.close();  
             con.close();  
             System.out.println("Connection closed");  
          } catch (SQLException e) {  
             System.out.println("Error closing connection");
             e.getMessage();  
          }  
     }  
    
      
     private void connect() throws Exception {  
        try {           
           ConFactory c = new ConFactory();
           con = c.connection();  
           command = con.createStatement();  
           System.out.println("Connected!");  
        } catch (ClassNotFoundException e) {  
           System.out.println("Error loading mysql driver");
           e.getMessage();  
        } catch (SQLException e) {  
           System.out.println("Error trying connect database");
           e.getMessage();  
        }  
     } 

}
