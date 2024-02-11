package com.example.smylest.types;

/**
 * Represents a pending request or resonse
 */
public class OutboundMessage extends Message {
    public OutboundMessage(
            String text,
            MessageType messageType,
            MessageVisibility messageVisibility) {
        super(text, messageType, messageVisibility);
    }
}