package io.github.arbuh.kotlindemo.service

import io.github.arbuh.kotlindemo.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(private val projectRepository: ProjectRepository) {
}