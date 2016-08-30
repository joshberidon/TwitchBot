package com.twitchbot;

import com.twitchbot.Commands.Command;
import com.twitchbot.Commands.ResponseCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class Utility {

    public static String host = "irc.chat.twitch.tv.";
    public static int port = 6667;
    public static String pass;
    public static String name = "jberidon";
    public static String channel = "#conquerosrs";
    private static SQL sql = SQL.getInstance();
   // public static ArrayList<Command> commands = new ArrayList<Command>();
    //public static ArrayList<Command> addedCommands = new ArrayList<Command>();
    public static HashMap<String, Command> addedCommands = new HashMap<String, Command>();
    public static HashMap<String, Command> commands = new HashMap<String, Command>();


    public static void readPass() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("secrets"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        pass = line;
    }

    public static String getTime(){
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
        String formattedDate = df.format(d1);
        return formattedDate;
    }

    public static void getAllCommands() {
           sql.getCommands();
    }

    public static void addResponseCommand(String command, String response){
        commands.put(command,new ResponseCommand(command,response));
    }
}
