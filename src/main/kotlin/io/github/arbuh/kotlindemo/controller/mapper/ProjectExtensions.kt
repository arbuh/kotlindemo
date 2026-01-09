package io.github.arbuh.kotlindemo.controller.mapper

import io.github.arbuh.kotlindemo.controller.dto.request.ProjectRequest
import io.github.arbuh.kotlindemo.controller.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project

fun Project.toResponse() = ProjectResponse(
    id = id.toString(),
    name = name
)

fun ProjectRequest.toEntity() = Project(
    name = name
)
