package com.twitchbot.Commands;


import com.twitchbot.SQL;
import com.twitchbot.Utility;

/**
 * Created by JoshBeridon on 8/7/16.
 */
public class ResponseCommand extends Command {
    SQL sql = SQL.getInstance();

    public ResponseCommand(String command, String response) {
        super(command, response);
        deleteable = true;

    }

    public void execute(String userCommand) {
        String response = sql.findCommandResponse(userCommand);
        if (response != null)
            myBot.sendMessage(Utility.channel, response);
    }


    @Override
    public boolean validate(String userCommand) {//TODO fix this, look in database or cache
        System.out.println(sql.findCommand(userCommand));
        return sql.findCommand(userCommand);
    }

    @Override
    public String toString() {
        return command;
    }
}
