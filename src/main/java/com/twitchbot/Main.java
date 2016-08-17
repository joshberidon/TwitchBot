package com.twitchbot;

import org.jibble.pircbot.IrcException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JoshBeridon on 8/6/16.
 */
public class Main {
    public static void main (String [] args) throws IrcException, IOException {
        Utility.readPass();
        MyBot myBot = MyBot.getInstance();
        System.out.println(myBot.getName());
        if (myBot.isConnected()){
            myBot.disconnect();
        }
        myBot.setVerbose(true);
        try {
            myBot.connect(Utility.host,Utility.port,Utility.pass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }
        myBot.joinChannel(Utility.channel, Utility.pass);
        myBot.sendMessage(Utility.channel, "Bot is up and running! "  + Utility.getTime());

        myBot.getChannels();
        System.out.println("sending raw linE");

    }
}
