package com.example.smylest.types;

import com.example.smylest.R;

/**
 * Represents a message sent as a response to a user's request
 */
public class InboundMessage extends Message {
    private String authorName = "Anonymous";
    private int authorImage = R.drawable.smylestanonymoususer;

    public InboundMessage(String text, String authorName, int authorImage) {
        super(text, MessageType.INBOUND_RESPONSE);
        this.authorName = authorName;
        this.authorImage = authorImage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAuthorImage() {
        return authorImage;
    }
}
