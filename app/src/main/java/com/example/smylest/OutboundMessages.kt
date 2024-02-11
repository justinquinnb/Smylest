package com.example.smylest

import com.example.smylest.types.OutboundMessage
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

@Serializable
data class OutboundMessages(
    val outboundMessagesList: PersistentList<OutboundMessage> = persistentListOf()
)