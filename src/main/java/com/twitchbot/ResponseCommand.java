package com.twitchbot;

import java.util.ArrayList;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class ResponseCommand extends Command{
    String commandName;
    String response;
    ArrayList <String> arguments;

    public ResponseCommand(String command, String response) {
        super(command, response);
    }

    public void execute(){
        myBot.sendMessage(Utility.channel, response);
    }

    public String getCommandName(){
        return commandName;
    }

    @Override
    public boolean validate(String userCommand) {
        return userCommand.equals(commandName);
    }


}
