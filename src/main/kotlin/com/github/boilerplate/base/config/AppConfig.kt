package com.github.boilerplate.base.config

import jakarta.validation.constraints.Min
import org.springframework.beans.factory.annotation.Value
import java.io.Serializable

abstract class AppConfig : Serializable {
    @Value("\${spring.application.name}")
    var applicationName: String = "BootApp"

    @Min(1, message = "must be a unique number greater than 0.")
    @Value("\${spring.application.nodeNumber}")
    var nodeNumber: Int = 0

    @Min(1, message = "must be a unique number greater than 0.")
    @Value("\${spring.application.totalNodes}")
    var totalNodes: Int = 1
}