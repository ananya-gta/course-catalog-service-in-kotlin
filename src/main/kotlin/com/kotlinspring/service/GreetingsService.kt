package com.kotlinspring.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {

    // The lateinit modifier is a keyword in Kotlin, used to mark a variable as late-initialized.
//     This is particularly useful for properties that cannot be initialized at the point of declaration but are guaranteed to be initialized before they are accessed
    @Value("\${message}")
    lateinit var message: String
    fun retrieveGreeting(name : String) = "$name, $message"
}