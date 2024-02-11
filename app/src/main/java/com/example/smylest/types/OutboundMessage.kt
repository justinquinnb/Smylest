package com.example.smylest.types

import android.content.Context
import androidx.datastore.dataStore
import com.example.smylest.OutboundMessagesSerializer
import kotlinx.serialization.Serializable

@Serializable
data class OutboundMessage(
    val text: String = "",
    val timeStamp: String = "",
    val messageType: String = "",
    val visibility: String = ""
) {
    /*
    private String text;
    private String timeStamp;
    private MessageType messageType;
    private MessageVisibility messageVisibility;
    private int uniqueIdentifier;

    private static int identifierCount;

    Message(String text, MessageType messageType) {
        this.text = text;

        LocalDateTime currentTimeAndDay = LocalDateTime.now(ZoneId.of("UTC-5"));
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

    public MessageVisibility getMessageVisibility() {
        return this.messageVisibility;
    }

    public int getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }
     */
}

enum class OutboundMessageType {
    REQUEST, RESPONSE
}