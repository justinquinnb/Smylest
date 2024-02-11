package com.example.smylest.types;

/**
 * Represents the three types of messages displayed in-app
 */
public enum MessageType {
    /**
     * Someone else's response to your request
     */
    INBOUND_RESPONSE,

    /**
     * Someone else's request waiting for you to respond
     */
    INBOUND_REQUEST,

    /**
     * Your request waiting for someone else to respond
     */
    OUTBOUND_REQUEST,

    /**
     * Your response to someone else's request
     */
    OUTBOUND_RESPONSE,
}
