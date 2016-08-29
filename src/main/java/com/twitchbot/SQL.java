package com.twitchbot;

import java.sql.*;

/**
 * Created by JoshBeridon on 8/22/16.
 */
public class SQL {//TODO make sure that the find and find response are doing what they are supposed to, efficiently
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    final String USER = "root";
    final String PASS = "secrets";
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String databaseName = "TWITCH";
    String commandTable = "COMMANDS";
    private int uniqueID = 0;
    private static SQL sql = new SQL();

    public static SQL getInstance(){
        return sql;
    }

    private SQL() {
        getUniqueID();
    }



    public void makeDatabase() throws Exception {


        final String DB_URL = "jdbc:mysql://localhost/";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating database..");
            statement = connect.createStatement();
            String sql = "CREATE DATABASE " + databaseName;

            statement.executeUpdate(sql);
            System.out.println("Database created");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    public void connectDatabase() {
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            statement = connect.createStatement();
            String sql = "CREATE DATABASE COMMANDS";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    public void makeTable(){
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Creating table..");
            statement = connect.createStatement();
            String sql = "CREATE TABLE COMMANDS " +
                    "(id INTEGER not NULL, " +
                    " command VARCHAR(255), " +
                    " response VARCHAR(255), " +
                    " PRIMARY KEY ( command ))";

            statement.executeUpdate(sql);
            System.out.println("Created table");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void dropTable(){
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Deleting table..");
            statement = connect.createStatement();
            String sql = "DROP TABLE COMMANDS";

            statement.executeUpdate(sql);
            System.out.println("Deleted table");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    public void addCommand(String commandName, String commandResponse){
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Adding command..");
            statement = connect.createStatement();
            String sql = "INSERT INTO " + commandTable +
                    " VALUES (" + uniqueID + ", '" + commandName + "', '" + commandResponse + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Command added");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        uniqueID++;
    }
    public int getUniqueID(){
        //TODO get unique id from size of tables + 1
        return 0;
    }

    public String findCommandResponse(String userCommand) {
        String commandResponse = null;
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Creating Statement..");
            statement = connect.createStatement();
            String sql = "SELECT id, command, response FROM " + commandTable;
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String command = resultSet.getString("command");
                String response = resultSet.getString("response");
                System.out.println(id);
                System.out.println("USER COMMAND IS " + command);
                if(command.equals(userCommand)){
                    System.out.println("THEY MATCH!");
                    commandResponse = response;
                }
            }
            System.out.println("Created table");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return commandResponse;
    }
    public Boolean findCommand(String userCommand) {
        Boolean hasCommand = false;
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Creating Statement..");
            statement = connect.createStatement();
            String sql = "SELECT id, command, response FROM " + commandTable;
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String command = resultSet.getString("command");
                String response = resultSet.getString("response");
                System.out.println(id);
                System.out.println("USER COMMAND IS " + command);
                if(command.equals(userCommand)){
                    System.out.println("THEY MATCH!");
                    hasCommand = true;
                }
            }
            System.out.println("Created table");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return hasCommand;
    }

    public void removeCommand(String userCommand) {
        final String DB_URL = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting..");
            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected to database");
            System.out.println("Creating Statement..");
            statement = connect.createStatement();

            String sql =  "DELETE FROM " + commandTable + " WHERE command=\'" + userCommand + "\';";
            System.out.println(sql);
            statement.executeUpdate(sql);

            System.out.println("Deleted command");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
