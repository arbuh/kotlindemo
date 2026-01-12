package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.response.ProjectResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.client.RestTestClient

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class ProjectControllerTest {

//    @Test
//    fun `should return id when project is saved`() {
//
//    }

    @Test
    fun `should return requested project`(@Autowired webClient: RestTestClient) {
        val response = webClient
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