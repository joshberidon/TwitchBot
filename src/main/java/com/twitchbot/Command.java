package com.twitchbot;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JoshBeridon on 8/16/16.
 */
public abstract class Command implements Comparable<String> {

    String command;
    String response;
    MyBot myBot = MyBot.getInstance();
    ArrayList<String> arguments;
    public Command(){
    }
    public Command(String command){
        this.command = command;
    }

    public Command(String command, String response){
        this.command = command;
        this.response = response;
    }

    public Command(String command, String response, String... Arguments) {
        this.command = command;
        this.response = response;
    }

    public abstract void execute(String userCommand);
    public boolean validate(String userCommand){
        if(!command.startsWith("!"))
        command = "!" + command;
        return userCommand.startsWith(command);
    }
    public String toString(){
        return command;
    }

    @Override
    public int compareTo(String command) {
        command = "!" + command;
        return command.compareTo(command);
    }
}
