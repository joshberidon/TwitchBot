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
}
