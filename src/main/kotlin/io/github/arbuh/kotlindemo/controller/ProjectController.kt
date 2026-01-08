package io.github.arbuh.kotlindemo.controller

import io.github.arbuh.kotlindemo.controller.dto.request.ProjectRequest
import io.github.arbuh.kotlindemo.controller.dto.response.ProjectResponse
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
    fun createProject(@RequestBody project: ProjectRequest) {
        println("Project ${project.name} created")
    }

    @GetMapping("/project/{id}")
    fun getProject(@PathVariable id: UUID): ProjectResponse {
        return ProjectResponse(id = UUID.randomUUID(), name = "Test Project")
    }
}