package io.github.arbuh.kotlindemo.io.mapper

import io.github.arbuh.kotlindemo.io.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.io.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project
import org.junit.jupiter.api.Assertions.*
import java.util.UUID
import kotlin.test.Test

class ProjectMapperTest {
    @Test
    fun `toResponse should map correctly`() {
        val project = Project(id = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473"), name = "Test name")
        val expected = ProjectResponse(id = "ed3baaa1-8d14-4f21-9f27-48a822d59473", name = "Test name")

        val result = project.toResponse()
        assertEquals(result, expected)
    }

    fun `toEntity should map correctly`() {
        val request = CreateProjectRequest(name = "TestName")
        val expected = Project(name = "Test name")

        val result = request.toEntity()
        assertEquals(result, expected)
    }
}