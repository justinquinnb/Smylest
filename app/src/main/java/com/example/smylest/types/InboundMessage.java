package com.example.smylest.types;

import com.example.smylest.R;

/**
 * Represents a message sent as a response to a user's request
 */
public class InboundMessage extends Message {
    private String authorName = "Anonymous";
    private int authorImage = R.drawable.smylestanonymoususer;

    public InboundMessage(
            String text,
            String authorName,
            int authorImage,
            MessageVisibility messageVisibility
    ) {
        super(text, MessageType.INBOUND_RESPONSE, messageVisibility);
        this.authorName = authorName;
        this.authorImage = authorImage;
    }

    public InboundMessage(String text, MessageType messageType, MessageVisibility messageVisibility) {
        super(text, messageType, messageVisibility);
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAuthorImage() {
        return authorImage;
    }
}
