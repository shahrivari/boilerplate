package com.github.boilerplate

import com.github.boilerplate.base.persistence.BaseEntity
import com.github.boilerplate.base.persistence.BaseTsidEntity
import com.github.boilerplate.base.persistence.BaseTsidJpaRepo
import jakarta.persistence.Entity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Repository

@Entity
open class TestTsidEntity(
    var name: String = "name"
) : BaseTsidEntity()

@Repository
interface TestTsidRepo : BaseTsidJpaRepo<TestTsidEntity>

@SpringBootTest
class PersistenceTests {

    @Autowired
    lateinit var repo : TestTsidRepo

    @Test
    fun testTsidEntity() {
        val entity = TestTsidEntity("alaki")
        repo.save(entity)
        val found = repo.findAll().first()
    }

}
