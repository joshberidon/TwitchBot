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
    public abstract String getCommandName();
    public abstract boolean validate(String userCommand);
    public abstract String toString();

    @Override
    public int compareTo(String command) {
        command = "!" + command;
        return command.compareTo(getCommandName());
    }
}
