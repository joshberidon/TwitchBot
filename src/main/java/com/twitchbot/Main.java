package com.twitchbot;

import com.twitchbot.Commands.AddCommand;
import com.twitchbot.Commands.CommandsCommand;
import com.twitchbot.Commands.DeleteCommand;
import com.twitchbot.IRCBot.MyBot;
import org.jibble.pircbot.IrcException;

import java.io.IOException;

/**
 * Created by JoshBeridon on 8/6/16.
 */
public class Main {//TODO update command?
    public static void main (String [] args) throws Exception {
        Utility.readPass();
        final MyBot myBot = MyBot.getInstance();
        System.out.println(myBot.getName());
        if (myBot.isConnected()){
            myBot.disconnect();
        }
        myBot.setVerbose(true);
        try {
            myBot.connect(Utility.host,Utility.port,Utility.pass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }
        myBot.joinChannel(Utility.channel, Utility.pass);
        myBot.sendMessage(Utility.channel, "Bot is up and running! "  + Utility.getTime());

        myBot.getChannels();
        Utility.commands.put("!add", new AddCommand());
        Utility.commands.put("!commands",new CommandsCommand());
        Utility.commands.put("!delete",new DeleteCommand());
        System.out.println(Utility.commands.size());

        SQL sql = SQL.getInstance();
        //if database doesnt exist create it, otherwise just connect
        //sql.makeDatabase();
        //sql.dropTable();
        //sql.makeTable();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                myBot.sendMessage("Turning off the bot! " + Utility.getTime());
            }
        }, "Shutdown-thread"));



    }
}
