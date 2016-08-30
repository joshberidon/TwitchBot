package com.twitchbot.Commands;

import com.twitchbot.Utility;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by JoshBeridon on 8/17/16.
 */
public class CommandsCommand extends Command {

    public CommandsCommand() {
        command = "commands";
    }


    @Override
    public void execute(String userCommand) {
        String allCommands   = "";
        Utility.getAllCommands();
        System.out.println("123all your commands are " + Utility.commands);
        Iterator iterator = Utility.commands.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            allCommands = allCommands + ", " + pair.getKey();
        }

        if (allCommands.startsWith(", "))
            allCommands = allCommands.substring(2, allCommands.length());
        allCommands = allCommands + ".";
        myBot.sendMessage("Your current commands are: " + allCommands);
    }

    @Override
    public boolean validate(String userCommand) {
        System.out.println("We are trying to validate commands");
        System.out.println(userCommand + "  " + command);
        return super.validate(userCommand);
    }

    @Override
    public String toString() {
        return command;
    }
}
