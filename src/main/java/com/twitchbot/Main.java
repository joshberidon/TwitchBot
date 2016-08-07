package com.twitchbot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;

/**
 * Created by JoshBeridon on 8/6/16.
 */
public class Main {
    public static void main (String [] args) throws IrcException, IOException {
            System.out.print("Hello world!");
        String host = "irc.chat.twitch.tv.";
        int port = 6667;
        String pass = "oauth:kdxfewbfx8m5calno7a9wmfo9o1sr6";
        String nick = "jberidon";
        String user = "jberidon";
        String real = "jberidon";
/*
        IRCConnection connection = new IRCConnection(host,port,pass,nick,user,real);
        connection.addIRCEventListener(new ChatListener());
        connection.setDaemon(true);
        connection.setColors(false);
        connection.setPong(true);
        try{
            connection.connect();
            System.out.println("Try");

        } catch (IOException exception){
            System.out.println("Catch");
            exception.printStackTrace();
        }
        System.out.println(connection.getName());
        System.out.println(connection.getHost());
        System.out.println(connection.isConnected());
        System.out.println("Hello");
        connection.doJoin("#conquerosrs",pass);
        connection.send("Test");
        connection.doJoin("#conquerosrs");

        System.out.println(connection.getName());
        System.out.println(connection.getHost());
        System.out.println(connection.isConnected());
        System.out.println(connection);
        connection.send("test test test");
        */

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
    }
}
