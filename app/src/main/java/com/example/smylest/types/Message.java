package com.example.smylest.types;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Represents the core parts of a message in Smylest
 */
public abstract class Message {
    private String text;
    private String timeStamp;
    private MessageType messageType;
    private MessageVisibility messageVisibility;
    private int uniqueIdentifier;

    private static int identifierCount;

    Message(String text, MessageType messageType, MessageVisibility messageVisibility) {
        this.text = text;
        this.messageType = messageType;
        this.messageVisibility = messageVisibility;

        long randomMinutesToAdd = -100L + (long) (Math.random() * (200L));
        LocalDateTime currentTimeAndDay = LocalDateTime.now(ZoneId.of("UTC-5")).plusMinutes(randomMinutesToAdd);
        this.timeStamp = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(currentTimeAndDay);

        this.uniqueIdentifier = getNewUniqueIdentifier();
    }

    private static int getNewUniqueIdentifier() {
        identifierCount++;
        return identifierCount;
    }

    public String getText() {
        return this.text;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public String getMessageVisibility() {return MessageVisibility.asString(this.messageVisibility);}

    public int getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }
}
