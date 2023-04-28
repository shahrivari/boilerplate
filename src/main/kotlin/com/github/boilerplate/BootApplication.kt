package com.github.boilerplate

import com.github.boilerplate.base.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableCaching
class BootApplication {

    @Bean
    fun getConfig(): AppConfig = object : AppConfig() {}

}

fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)
}
