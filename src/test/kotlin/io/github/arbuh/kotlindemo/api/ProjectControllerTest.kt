package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import io.github.arbuh.kotlindemo.model.Project
import io.github.arbuh.kotlindemo.service.ProjectService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.client.RestTestClient
import java.util.UUID

@WebMvcTest
@AutoConfigureRestTestClient
class ProjectControllerTest(@Autowired private val webClient: RestTestClient) {

    //    @Test
//    fun `should return id when project is saved`() {
//
//    }
    @MockitoBean
    private lateinit var projectService: ProjectService

    @Test
    fun `should return requested project`() {
        val id = UUID.fromString("ed3baaa1-8d14-4f21-9f27-48a822d59473")
        given(projectService.findById(id)).willReturn(
            Project(
                id = id,
                name = "Test Project"
            )
        )

        webClient
            .get()
            .uri("/v1/project/ed3baaa1-8d14-4f21-9f27-48a822d59473")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(ProjectResponse::class.java)
            .isEqualTo(ProjectResponse("ed3baaa1-8d14-4f21-9f27-48a822d59473", "Test Project"))
    }

    @Test
    fun `should return 404 on unknown project`() {
        webClient
            .get()
            .uri("/v1/project/ed3baaa1-8d14-4f21-9f27-48a822d59473")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound()
    }
}