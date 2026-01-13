package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.request.CreateProjectRequest
import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.api.mapper.toResponse
import io.github.arbuh.kotlindemo.service.ProjectService
//import io.github.arbuh.kotlindemo.service.ProjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1")
class ProjectController(private val projectService: ProjectService) {

    @PostMapping("/project")
    fun createProject(@RequestBody project: CreateProjectRequest) {
        println("Project ${project.name} created")
    }

    @GetMapping("/project/{id}")
    fun getProject(@PathVariable id: UUID): ResponseEntity<ProjectResponse> {
        val project = projectService.findById(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(project.toResponse())
    }
}