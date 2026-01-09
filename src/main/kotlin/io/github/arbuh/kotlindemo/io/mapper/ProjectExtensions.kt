package io.github.arbuh.kotlindemo.io.mapper

import io.github.arbuh.kotlindemo.io.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.io.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project

fun Project.toResponse() = ProjectResponse(
    id = id.toString(),
    name = name
)

fun CreateProjectRequest.toEntity() = Project(
    name = name
)
