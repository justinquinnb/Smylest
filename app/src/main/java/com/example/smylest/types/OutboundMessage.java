package com.example.smylest.types;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Represents a pending request or resonse
 */
public class OutboundMessage extends Message {
    private String visibility;

    public OutboundMessage(String text, MessageType messageType, MessageVisibility messageVisibility) {
        super(text, messageType);
        this.visibility = MessageVisibility.asString(messageVisibility);
    }

    public String getVisibility() {
        return visibility;
    }

    public void save() {
        Gson gson = new Gson();
        try {
            PrintWriter fileOut = new PrintWriter(new File("res/raw/outbound_messages.txt"));
            fileOut.println(gson.toJson(this));
        } catch (Exception e) {
            System.out.println("Error saving outbound message.");
        }
    }

    public static OutboundMessage[] loadAll() {
        OutboundMessage[] outboundMessages = new OutboundMessage[]{};
        Gson gson = new Gson();
        ArrayList<OutboundMessage> outboundMessagesList = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("res/raw/outbound_messages.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                outboundMessagesList.add(gson.fromJson(line, OutboundMessage.class));
            }
            OutboundMessage[] outboundMessagesFound = new OutboundMessage[outboundMessagesList.size()];
            int i = 0;
            for (OutboundMessage outboundMessage : outboundMessagesList) {
                outboundMessagesFound[i] = outboundMessage;
                i++;
            }
            outboundMessages = outboundMessagesFound;
        } catch (Exception e){
            System.out.println("Error reading outbound message.");
        }

        return outboundMessages;
    }
}