package com.twitchbot;

import org.jibble.pircbot.PircBot;

import java.util.ArrayList;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class MyBot extends PircBot {
    public ArrayList<Command> commands = new ArrayList<Command>();
    private static MyBot myBot = new MyBot();

    public static MyBot getInstance(){
        return myBot;
    }

    private MyBot() {
        this.setName(Utility.name);
    }

    @Override
    protected void onMessage(String s, String s1, String s2, String s3, String s4) {
        //s is channel, s1 is , s2 is , s3 is ,s4 is line
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        for (Command command : commands) {
            if(command.validate(s4)){
                command.execute();
            }
        }
            super.onMessage(s, s1, s2, s3, s4);
    }

    private boolean isMod(String name) {
        return true;
    }


}
