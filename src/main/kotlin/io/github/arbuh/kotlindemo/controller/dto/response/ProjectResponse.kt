package io.github.arbuh.kotlindemo.controller.dto.response

import java.util.UUID

data class ProjectResponse(
    val id: UUID,
    val name: String
)