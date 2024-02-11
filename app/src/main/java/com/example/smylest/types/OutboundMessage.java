package com.example.smylest.types;

/**
 * Represents a pending request or resonse
 */
public class OutboundMessage extends Message {
    private MessageVisibility visibility;

    OutboundMessage(String text, MessageType messageType, MessageVisibility messageVisibility) {
        super(text, messageType);
        this.visibility = messageVisibility;
    }

    public MessageVisibility getVisibility() {
        return visibility;
    }
}