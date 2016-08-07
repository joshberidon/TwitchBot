package com.twitchbot;

import org.jibble.pircbot.PircBot;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class MyBot extends PircBot {
    String nick = "jberidon";
    String user = "jberidon";
    String real = "jberidon";
    MyBot(){
        this.setName(nick);
    }

    @Override
    protected void onMessage(String s, String s1, String s2, String s3, String s4) {
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        if(s4.equals("!command")){
            sendMessage(s,"you used a command!");
        }


        super.onMessage(s, s1, s2, s3, s4);
    }
}
