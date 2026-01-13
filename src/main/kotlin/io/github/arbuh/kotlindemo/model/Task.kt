package io.github.arbuh.kotlindemo.model

import java.util.UUID

data class Task(val id: UUID? = null, val title: String, val projectId: UUID)
