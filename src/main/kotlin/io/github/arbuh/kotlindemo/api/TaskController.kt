package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.request.AddTaskRequest
import io.github.arbuh.kotlindemo.api.dto.response.TaskResponse
import io.github.arbuh.kotlindemo.api.mapper.toEntity
import io.github.arbuh.kotlindemo.api.mapper.toResponse
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
        val task = request.toEntity(projectId)
        return ResponseEntity.status(HttpStatus.CREATED).body(task.toResponse())
    }

    @GetMapping("/project/{projectId}/task")
    fun listTasks(@PathVariable projectId: UUID): List<TaskResponse> {
        return emptyList()
    }
}