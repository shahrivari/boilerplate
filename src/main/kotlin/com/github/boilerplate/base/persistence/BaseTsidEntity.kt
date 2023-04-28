package com.github.boilerplate.base.persistence

import com.github.boilerplate.base.util.Injection
import com.github.boilerplate.base.util.TsidGenerator
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseTsidEntity : BaseEntity() {

    companion object {
        val idGenerator: TsidGenerator by Injection
    }

    @Id
    var id: Long? = null

    fun setIdFromTsid(): Long {
        return idGenerator.nextLong().also { id = it }
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun onPrePersist() {
        if (id == null) setIdFromTsid()
        super.onPrePersist()
    }

}
