package com.twitchbot.Commands;

import com.twitchbot.IRCBot.MyBot;

import java.util.ArrayList;

/**
 * Created by JoshBeridon on 8/16/16.
 */





//TODO add a cool down for all except moderator.
public abstract class Command implements Comparable<String> {

    String command;
    String response;
    boolean deleteable = false;
    MyBot myBot = MyBot.getInstance();

    public Command(){
    }

    public Command(String command){
        this.command = command;
    }

    public Command(String command, String response){
        this.command = command;
        this.response = response;
    }

    public abstract void execute(String userCommand);
    public boolean validate(String userCommand){
        if(!command.startsWith("!"))
        command = "!" + command;
        return userCommand.equals(command);
    }
    public String toString(){
        return command;
    }

    @Override
    public int compareTo(String command) {
        command = "!" + command;
        return command.compareTo(command);
    }

    public String error(String response){
        if(response!=null){
            myBot.sendMessage(response);
            return response;
        }
        myBot.sendMessage("There was an error");
        return "There was an error";
    }
}
