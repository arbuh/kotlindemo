package io.github.arbuh.kotlindemo.api.mapper

import io.github.arbuh.kotlindemo.api.dto.request.AddTaskRequest
import io.github.arbuh.kotlindemo.api.dto.response.TaskResponse
import io.github.arbuh.kotlindemo.model.Task
import java.util.UUID

fun Task.toResponse() = TaskResponse(
    id = id?.toString(),
    title = title
)

fun AddTaskRequest.toEntity(projectId: UUID) = Task(
    title = title,
    projectId = projectId
)