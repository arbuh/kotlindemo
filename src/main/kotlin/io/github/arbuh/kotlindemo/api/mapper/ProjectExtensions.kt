package io.github.arbuh.kotlindemo.api.mapper

import io.github.arbuh.kotlindemo.api.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project

fun Project.toResponse() = ProjectResponse(
    id = id.toString(),
    name = name
)

fun CreateProjectRequest.toEntity() = Project(
    name = name
)
