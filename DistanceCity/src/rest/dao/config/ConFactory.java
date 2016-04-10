package rest.dao.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {
    
    private static String USER = "root";  
    private static String PASSWORD = "root";
    private static String HOST = "localhost";
    private static String DATABASE = "hub";
    private static String PORT = "3306";
    private static final String MySQLDriver = "com.mysql.jdbc.Driver";

    
    public ConFactory() throws Exception{
        try{
            Properties props = new Properties();  
            InputStream in = getClass().getClassLoader().getResourceAsStream("database.properties");   
                       props.load(in);  
                       in.close();              
                       USER = props.getProperty("jdbc.user");
                       PASSWORD = props.getProperty("jdbc.password");
                       HOST = props.getProperty("jdbc.host");
                       DATABASE = props.getProperty("jdbc.database");
                       PORT = props.getProperty("jdbc.port");
            }  
        catch(Exception e){  
            throw e;  
        }  
    }   
      
    public Connection connection() throws ClassNotFoundException, SQLException { 
    
        Class.forName(MySQLDriver);        
        
        String urlProperties = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;    
        
        return DriverManager.getConnection(urlProperties, USER, PASSWORD);    
    }

}
