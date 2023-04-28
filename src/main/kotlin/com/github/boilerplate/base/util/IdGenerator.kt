package com.github.boilerplate.base.util

import com.github.boilerplate.base.config.AppConfig
import io.hypersistence.tsid.TSID
import org.springframework.stereotype.Service
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.max


@Service
class TsidGenerator(
    config: AppConfig,
) {
    private val factory =
        TSID.Factory.builder()
            .withNodeBits(max(ceil(log2(config.totalNodes.toDouble())).toInt(),1))
            .withNode(config.nodeNumber)
            .build()

    fun next(): TSID = factory.generate()

    fun nextLong(): Long = factory.generate().toLong()
}