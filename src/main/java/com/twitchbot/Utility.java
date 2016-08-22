package com.twitchbot;

import com.twitchbot.Commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class Utility {

    public static String host = "irc.chat.twitch.tv.";
    public static int port = 6667;
    public static String pass;
    public static String name = "jberidon";
    public static String channel = "#conquerosrs";
    public static ArrayList<Command> commands = new ArrayList<Command>();
    public static ArrayList<Command> addedCommands = new ArrayList<Command>();


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

}
