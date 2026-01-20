package io.github.arbuh.kotlindemo.api.mapper

import io.github.arbuh.kotlindemo.api.dto.request.AddTaskRequest
import io.github.arbuh.kotlindemo.api.dto.response.TaskResponse
import io.github.arbuh.kotlindemo.model.Task
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

class TaskMapperTest {

    @Test
    fun `toResponse should map correctly`() {
        val task = Task(
            id = UUID.fromString("2514417b-67de-4799-a6cb-c2a187ad2e5b"),
            title = "Test Task",
            projectId = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473")
        )
        val expected = TaskResponse(id = "2514417b-67de-4799-a6cb-c2a187ad2e5b", title = "Test Task")

        val result = task.toResponse()
        assertThat(result).usingRecursiveComparison().isEqualTo(expected)
    }

    @Test
    fun `toEntity should map correctly`() {
        val request = AddTaskRequest(title = "Test Task")
        val expected = Task(
            title = "Test Task",
            projectId = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473")
        )

        val result = request.toEntity(UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473"))
        assertThat(result).usingRecursiveComparison().isEqualTo(expected)
    }
}