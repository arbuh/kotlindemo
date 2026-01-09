package io.github.arbuh.kotlindemo.io

import io.github.arbuh.kotlindemo.io.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.io.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.io.mapper.toResponse
import io.github.arbuh.kotlindemo.model.Project
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1")
class ProjectController {

    @PostMapping("/project")
    fun createProject(@RequestBody project: CreateProjectRequest) {
        println("Project ${project.name} created")
    }

    @GetMapping("/project/{id}")
    fun getProject(@PathVariable id: UUID): ProjectResponse {
        val project = Project(name = "Test Project")
        return project.toResponse()
    }
}