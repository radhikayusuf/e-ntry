package com.app.entry.utils.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author radhikayusuf
 */
 
public class ConnectionBuilder {
    
    private String username = "";
    private String password = "";
    private String dbName = "";
    private boolean isDisableSsl = false;

    private ConnectionBuilder(String username, String password, String dbName) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }
    
    public ConnectionBuilder isDisableSsl(boolean disable){
        isDisableSsl = disable;
        return this;
    }

    public static ConnectionBuilder with(String username, String password, String dbName){
        return new ConnectionBuilder(username, password, dbName);
    }

    public Connection create(){   
        try {
            Class.forName("com.mysql.jdbc.Driver");       
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName + (isDisableSsl ? "?autoReconnect=true&useSSL=false" : ""), username, password);
            return connection;            

        } catch (Exception e) {
            System.out.println("Connection Failed! Check output console " + e.getMessage());
            return null;
        }           
    }
    
}