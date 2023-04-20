package com.github.boilerplate

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

@SpringBootApplication
@EnableScheduling
@EnableCaching
class BootApplication : ApplicationContextAware {
    companion object {
        val JACKSON_MAPPER: ObjectMapper = ObjectMapper().let {
            it.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            val kotlinModule = KotlinModule.Builder().build()
            it.registerModules(kotlinModule)
        }

        private lateinit var context: ApplicationContext

        internal inline fun <reified T : Any> getBean(): T {
            return context.getBean(T::class.java)
        }

        fun getBean(beanName: String): Any {
            return context.getBean(beanName)
        }
    }

    @Bean
    fun getObjectMapper(): ObjectMapper = JACKSON_MAPPER

    @Bean
    fun transactionTemplate(transactionManager: PlatformTransactionManager): TransactionTemplate {
        return TransactionTemplate(transactionManager)
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }
}


fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)
}
