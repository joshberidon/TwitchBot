package com.twitchbot;


/**
 * Created by JoshBeridon on 8/7/16.
 */
public class ResponseCommand extends Command{

    public ResponseCommand(String command, String response) {
        super(command, response);
    }

    public void execute(String userCommand){
        myBot.sendMessage(Utility.channel, response);
    }


    @Override
    public boolean validate(String userCommand) {
        return userCommand.equals(command);
    }

    @Override
    public String toString() {
        return command;
    }
}
