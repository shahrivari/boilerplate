package com.github.boilerplate

import com.github.boilerplate.util.AppContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableCaching
class BootApplication

fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)

    val a = AppContext.getBean<Alaki>()
    println(a)
}
