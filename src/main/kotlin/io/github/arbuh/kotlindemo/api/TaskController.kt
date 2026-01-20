package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.request.AddTaskRequest
import io.github.arbuh.kotlindemo.api.dto.response.TaskResponse
import io.github.arbuh.kotlindemo.api.mapper.toEntity
import io.github.arbuh.kotlindemo.api.mapper.toResponse
import io.github.arbuh.kotlindemo.model.Task
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1")
class TaskController {

    @PostMapping("/project/{projectId}/task")
    fun addTask(@PathVariable projectId: UUID, @RequestBody request: AddTaskRequest): ResponseEntity<TaskResponse> {
        val task = request.toEntity(projectId).copy(id = UUID.fromString("2514417b-67de-4799-a6cb-c2a187ad2e5b"))
        return ResponseEntity.status(HttpStatus.CREATED).body(task.toResponse())
    }

    @GetMapping("/task/{taskId}")
    fun listTasks(@PathVariable taskId: UUID): ResponseEntity<TaskResponse> {
        val task = Task(
            id = taskId,
            title = "Test Task",
            projectId = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473")
        )
        return ResponseEntity.ok(task.toResponse())
    }
}