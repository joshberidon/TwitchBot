package com.twitchbot.IRCBot;

import com.twitchbot.Commands.Command;
import com.twitchbot.Utility;
import org.jibble.pircbot.PircBot;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class MyBot extends PircBot {
    private static MyBot myBot = new MyBot();

    public static MyBot getInstance(){
        return myBot;
    }

    private MyBot() {
        this.setName(Utility.name);
    }
    public void sendMessage(Object message){
        myBot.sendMessage(Utility.channel,message.toString());

    }
    @Override
    protected void onMessage(String s, String s1, String s2, String s3, String s4) {
        //s is channel, s1 is , s2 is , s3 is ,s4 is line
        if(!s2.equals(Utility.name)) {
            //myBot.sendMessage(Utility.channel, "We recieved your message, " + s4 + ", from  " + s2);
            for (Command command : Utility.commands) {
                if (command.validate(s4)) {
                    command.execute(s4);
                }
            }

            Utility.commands.addAll(Utility.addedCommands);
            Utility.addedCommands.clear();
        } else{
            System.out.println("WE SENT THE MESSAGE");
        }
            super.onMessage(s, s1, s2, s3, s4);
    }

    private boolean isMod(String name) {
        return true;
    }


}
