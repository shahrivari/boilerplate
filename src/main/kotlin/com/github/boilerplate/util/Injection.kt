package com.github.boilerplate.util

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.jvmErasure

@Component
class Injection : ApplicationContextAware {
    companion object {
        lateinit var context: ApplicationContext
            private set

        fun <T : Any> getBean(clazz: KClass<T>): T {
            return context.getBean(clazz.java)
        }

        internal inline fun <reified T : Any> getBean(): T {
            return context.getBean(T::class.java)
        }

        operator fun <T : Any> getValue(thisRef: Any?, property: KProperty<*>): T {
            return getBean(property.returnType.jvmErasure) as T
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }
}

