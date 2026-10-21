package com.example.testing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootTestingApplication

fun main(args: Array<String>) {
    runApplication<SpringBootTestingApplication>(*args)
}