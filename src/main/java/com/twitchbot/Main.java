package com.twitchbot;

import org.jibble.pircbot.IrcException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JoshBeridon on 8/6/16.
 */
public class Main {
    public static void main (String [] args) throws IrcException, IOException {
            System.out.print("Hello world!");
        String host = "irc.chat.twitch.tv.";
        int port = 6667;
        String pass;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("secrets"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        pass = line;
        System.out.println(pass);

        String nick = "jberidon";
        String user = "jberidon";
        String real = "jberidon";
        String channel = "#conquerosrs";
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
        String formattedDate = df.format(d1);




        MyBot myBot = new MyBot();
        System.out.println(myBot.getName());
        if (myBot.isConnected()){
            myBot.disconnect();
        }
        myBot.setVerbose(true);
        try {
            myBot.connect(host,port,pass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }
        myBot.joinChannel(channel, pass);
        myBot.sendMessage(channel, "Bot is up and running! "  + formattedDate);

        myBot.getChannels();
        System.out.println("sending raw linE");




    }
}
