package com.example.smylest.types;

/**
 * Represents the three types of messages displayed in-app
 */
public enum MessageType {
    /**
     * A response to a user's request from another user
     */
    INBOUND_RESPONSE,

    /**
     * A request for another user's response
     */
    OUTBOUND_REQUEST,

    /**
     * A response delivered/being delivered to fulfill a user's request
     */
    OUTBOUND_RESPONSE
}
