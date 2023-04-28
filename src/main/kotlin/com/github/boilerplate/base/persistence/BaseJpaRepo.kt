package com.github.boilerplate.base.persistence

import io.hypersistence.tsid.TSID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface BaseJpaRepo<T : BaseTsidEntity, ID : Serializable> : JpaRepository<T, ID>, JpaSpecificationExecutor<T>

@NoRepositoryBean
interface BaseTsidJpaRepo<T : BaseTsidEntity> : JpaRepository<T, TSID>, JpaSpecificationExecutor<T>
