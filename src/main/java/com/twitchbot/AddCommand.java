package com.twitchbot;

/**
 * Created by JoshBeridon on 8/16/16.
 */
public class AddCommand extends Command {

    public AddCommand() {
        System.out.println("added add command");
    }

    @Override
    public void execute(String userCommand) {
        String newCommandName;
        String response;

        newCommandName = userCommand.substring(5,userCommand.length());
        response = newCommandName;
        newCommandName = newCommandName.substring(0,newCommandName.indexOf(' '));
        newCommandName = "!" + newCommandName;
        System.out.println("This is the command " + newCommandName + "######");
        response = response.substring(response.indexOf(' ') + 1 , response.length());
        System.out.println("This is the response " + response);
        Utility.addedCommands.add(new ResponseCommand(newCommandName, response));
    }


    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public boolean validate(String userCommand) {
        return userCommand.toLowerCase().startsWith("!add");
    }

    @Override
    public String toString() {
        return "Add command " + command;
    }
}
