package com.twitchbot.IRCBot;

import com.twitchbot.Commands.Command;
import com.twitchbot.Commands.ResponseCommand;
import com.twitchbot.SQL;
import com.twitchbot.Utility;
import org.jibble.pircbot.PircBot;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class MyBot extends PircBot {
    private static MyBot myBot = new MyBot();
    SQL sql = SQL.getInstance();
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
        System.out.println(Utility.commands);
        System.out.println(Utility.addedCommands);
        //s is channel, s1 is , s2 is , s3 is ,s4 is line
        if (!s2.equals(Utility.name)) {
            if (s4.startsWith("!")) {
                String start = s4.split(" ")[0];
                System.out.println(start);
                Command command = Utility.commands.get(start);
                System.out.println("All the commands are" + Utility.commands);
                System.out.println("Command we got is " + command);
                if (command != null) {
                    System.out.println("Inside of command");
                    if (command.validate(s4)) {
                        command.execute(s4);
                    }
                } else if (sql.findCommand(start)) {// is in database, we should cache it locally if it was called
                    System.out.println("Command is in database");
                    Utility.addedCommands.put(start, new ResponseCommand(start, sql.findCommandResponse(start)));
                    command = Utility.addedCommands.get(start);
                    System.out.println("All the commands are" + Utility.addedCommands);
                    if (command.validate(s4)) {
                        command.execute(s4);
                    }
                } else {
                    System.out.println("This was not a command");
                    //not a command
                }
                Utility.commands.putAll(Utility.addedCommands);
                Utility.addedCommands.clear();
            }
        }
        super.onMessage(s, s1, s2, s3, s4);
    }

    private boolean isMod(String name) {
        return true;
    }


}
