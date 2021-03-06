package com.twitchbot.Commands;

import com.twitchbot.SQL;
import com.twitchbot.Utility;

/**
 * Created by JoshBeridon on 8/16/16.
 */

public class AddCommand extends Command {
    SQL sql = SQL.getInstance();

    public AddCommand() {
        System.out.println("added add command");
        command = "!add";
    }

    @Override
    public void execute(String userCommand) {
        String newCommandName;
        String response;
        if(userCommand.length()<=4){
            error("To add a command, type \"!add <Command name> <What the command will say>\".");
        } else {
            newCommandName = userCommand.substring(5, userCommand.length());
            response = newCommandName;
            newCommandName = newCommandName.substring(0, newCommandName.indexOf(' '));
            newCommandName = "!" + newCommandName;
            System.out.println("This is the command " + newCommandName + "######");
            if (sql.findCommand(newCommandName) || Utility.commands.get(newCommandName)!=null) {
                error("This command already exists!");
            } else {
                response = response.substring(response.indexOf(' ') + 1, response.length());
                System.out.println("This is the response " + response);
                Utility.addResponseCommand(newCommandName,response);
                myBot.sendMessage("Added new command: \"" + newCommandName + "\".");
                sql.addCommand(newCommandName, response);
            }
        }
    }

    @Override
    public boolean validate(String userCommand) {
        return userCommand.toLowerCase().startsWith("!add");
    }

    @Override
    public String toString() {
        return command;
    }



}
