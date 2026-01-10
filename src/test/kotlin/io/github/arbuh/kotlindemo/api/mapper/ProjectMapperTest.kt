package io.github.arbuh.kotlindemo.api.mapper

import io.github.arbuh.kotlindemo.api.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectMapperTest {
    @Test
    fun `toResponse should map correctly`() {
        val project = Project(id = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473"), name = "Test name")
        val expected = ProjectResponse(id = "ed3baaa1-8d14-4f21-9f27-48a822d59473", name = "Test name")

        val result = project.toResponse()
        assertThat(result).usingRecursiveComparison().isEqualTo(expected)
    }

    @Test
    fun `toEntity should map correctly`() {
        val request = CreateProjectRequest(name = "Test name")
        val expected = Project(name = "Test name")

        val result = request.toEntity()
        assertThat(result).usingRecursiveComparison().isEqualTo(expected)
    }
}