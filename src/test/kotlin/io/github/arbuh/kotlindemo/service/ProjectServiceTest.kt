package io.github.arbuh.kotlindemo.service

import io.github.arbuh.kotlindemo.model.Project
import io.github.arbuh.kotlindemo.repository.ProjectRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager

@DataJpaTest
class ProjectServiceTest(
    @Autowired val entityManager: TestEntityManager,
    @Autowired val repository: ProjectRepository
) {

    private val sut = ProjectService(repository)

    private val project = Project(name = "Test Project")


    @Test
    fun `ProjectService should save projects`() {
        val saved = sut.save(project)

        val result = entityManager.find(Project::class.java, saved.id!!)
        assertThat(result).isNotNull
        assertThat(result?.name).isEqualTo("Test Project")
    }

    @Test
    fun `ProjectService should get a project by its id`() {
        val saved = entityManager.persist(project)

        val result = sut.findById(saved.id!!)
        assertThat(result).isNotNull
        assertThat(result).isEqualTo(project)
    }
}