package com.twitchbot;

import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;

/**
 * Created by JoshBeridon on 8/6/16.
 */
public class ChatListener implements IRCEventListener {

    @Override
    public void onRegistered() {
        System.out.println("Chat listener");
    int i = 1;
    }

    @Override
    public void onDisconnected() {
        System.out.println("Chat listener");
        int i = 1;
    }

    @Override
    public void onError(String msg) {
        System.out.println("Chat listener");
        System.out.println(msg);
    }

    @Override
    public void onError(int num, String msg) {
        System.out.println("Chat listener");
        System.out.println(msg);
    }

    @Override
    public void onInvite(String chan, IRCUser user, String passiveNick) {
        System.out.println("Chat listener");
        int i = 1;
    }

    @Override
    public void onJoin(String chan, IRCUser user) {
        System.out.println("Chat listener");
        int i = 1;
        System.out.println(chan);
    }

    @Override
    public void onKick(String chan, IRCUser user, String passiveNick, String msg) {
        System.out.println("Chat listener");
        int i = 1;
    }

    @Override
         public void onMode(String chan, IRCUser user, IRCModeParser modeParser) {
        System.out.println("Chat listener");
        int i = 1;
    }
    @Override
    public void onMode( IRCUser user, String i, String e) {
        System.out.println("Chat listener");

    }

    @Override
    public void onNick(IRCUser user, String newNick) {
        System.out.println("Chat listener");

    }

    @Override
    public void onNotice(String target, IRCUser user, String msg) {
        System.out.println("Chat listener");

    }

    @Override
    public void onPart(String chan, IRCUser user, String msg) {
        System.out.println("Chat listener");

    }

    @Override
    public void onPing(String ping) {
        System.out.println("Chat listener");

    }

    @Override
    public void onPrivmsg(String target, IRCUser user, String msg) {
        System.out.println("Chat listener");

    }

    @Override
    public void onQuit(IRCUser user, String msg) {
        System.out.println("Chat listener");

    }

    @Override
    public void onReply(int num, String value, String msg) {
        System.out.println("Chat listener");

    }

    @Override
    public void onTopic(String chan, IRCUser user, String topic) {
        System.out.println("Chat listener");

    }

    @Override
    public void unknown(String prefix, String command, String middle, String trailing) {
        System.out.println("Chat listener");
        System.out.println(command);
    }
}
