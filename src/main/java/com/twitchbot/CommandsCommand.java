package com.twitchbot;

/**
 * Created by JoshBeridon on 8/17/16.
 */
public class CommandsCommand extends Command {

    public CommandsCommand(){
        command = "commands";
    }


    @Override
    public void execute(String userCommand) {
        String allCommands = "";

        for (Command command1 : Utility.commands) {
            System.out.println("Commands:");
            System.out.println(command1);
            allCommands = allCommands + ", "+ command1;
            System.out.println(allCommands);
        }
        if(allCommands.startsWith(", "))
            allCommands = allCommands.substring(2,allCommands.length());
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
