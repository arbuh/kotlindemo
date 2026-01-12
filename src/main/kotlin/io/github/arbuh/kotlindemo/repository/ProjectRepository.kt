package io.github.arbuh.kotlindemo.repository

import io.github.arbuh.kotlindemo.model.Project
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ProjectRepository : CrudRepository<Project, UUID>