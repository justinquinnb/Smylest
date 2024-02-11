package com.example.smylest

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object OutboundMessagesSerializer : Serializer<OutboundMessages> {
    override val defaultValue: OutboundMessages
        get() = OutboundMessages()

    override suspend fun readFrom(input: InputStream): OutboundMessages {
        return try {
            Json.decodeFromString(
                deserializer = OutboundMessages.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: OutboundMessages, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = OutboundMessages.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}