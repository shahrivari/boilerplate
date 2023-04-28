package com.github.boilerplate.base.persistence

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Column
    open var createdDate: Date? = null

    @Column
    open var modifiedDate: Date? = null


    protected open fun onPrePersist() {}

    protected open fun onPreUpdate() {}
    @PrePersist
    private fun executeBeforePersist() {
        onPrePersist()
        createdDate = Date()
        modifiedDate = Date()
    }

    @PreUpdate
    private fun executeBeforeUpdate() {
        onPreUpdate()
        modifiedDate = Date()
    }
}