package com.ralphmarondev.cowgpt.features.home.presentation

import androidx.lifecycle.ViewModel
import com.ralphmarondev.cowgpt.features.home.domain.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _messagesList = MutableStateFlow<List<Message>>(emptyList())
    val messagesList: StateFlow<List<Message>> get() = _messagesList

    private val _message = MutableStateFlow("")
    val message: StateFlow<String> get() = _message

    fun onMessageValueChanged(value: String) {
        _message.value = value
    }

    fun sendMessage(sender: String) {
        val newMessage = Message(sender, message.value)
        _messagesList.value += newMessage
        _message.value = ""

        getResponse()
    }

    private fun getResponse() {
        val userMessage = _messagesList.value.last().content
        val mooCount = userMessage.length

        val responseMessage = Message(
            sender = "CowGPT",
            content = List(mooCount) { "moo" }.joinToString(" ")
        )
        _messagesList.value += responseMessage
    }
}