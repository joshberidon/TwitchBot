package com.twitchbot.Commands;

import com.twitchbot.SQL;
import com.twitchbot.Utility;

import java.util.Arrays;

/**
 * Created by JoshBeridon on 8/29/16.
 */
public class DeleteCommand extends Command {
    String [] arguments;
    SQL sql = SQL.getInstance();

    public DeleteCommand(){
        command = "!delete";
    }
    @Override
    public void execute(String userCommand) {
        Utility.commands.remove(arguments[1]);
        System.out.println(arguments[1]);
        if(!arguments[1].startsWith("!")){
            arguments[1] = "!" + arguments[1];
            System.out.print(arguments[1]);
        }
        if(sql.findCommand(arguments[1])){
            sql.removeCommand(arguments[1]);
        }
        if(Utility.commands.get(arguments[1]) instanceof ResponseCommand){
            myBot.sendMessage("Command deleted!");
            Utility.commands.remove(arguments[1]);
            System.out.println("Argument 0" + arguments[1]);
        }
    }

    @Override public boolean validate(String usercommand){
        if(usercommand.toLowerCase().startsWith("!delete")){
            arguments = usercommand.split(" ", 2);
            System.out.print(Arrays.toString(arguments));
            if(arguments.length==2){
                System.out.println("Delete it!");

                return true;
            }
            error("To delete a command, type \"!delete <Command name>\".");
        }
        return false;
    }

}
