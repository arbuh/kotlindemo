package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.client.RestTestClient

@SpringBootTest
class ProjectControllerTest {

    @Autowired
    private lateinit var testClient: RestTestClient

//    @Test
//    fun `should return id when project is saved`() {
//
//    }

    @Test
    fun `should return requested project`() {
        val response = testClient
            .get()
            .uri("/v1/project/ed3baaa1-8d14-4f21-9f27-48a822d59473")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(ProjectResponse::class.java)
            .isEqualTo(ProjectResponse("ed3baaa1-8d14-4f21-9f27-48a822d59473", "Test Project"))
    }

//    @Test
//    fun `should return 404 on unknown project`() {
//
//    }
}