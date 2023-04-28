package com.github.boilerplate.base.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GeneralBeanConfiguration {
    companion object {
        val JACKSON_MAPPER: ObjectMapper = ObjectMapper().let {
            it.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            val kotlinModule = KotlinModule.Builder().build()
            it.registerModules(kotlinModule)
        }
    }

    @Bean
    fun getObjectMapper(): ObjectMapper {
        return JACKSON_MAPPER
    }

}