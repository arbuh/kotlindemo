package io.github.arbuh.kotlindemo.api

import io.github.arbuh.kotlindemo.api.dto.request.AddTaskRequest
import io.github.arbuh.kotlindemo.api.dto.response.TaskResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.client.RestTestClient
import java.util.*

@WebMvcTest(TaskController::class)
@AutoConfigureRestTestClient
class TaskControllerTest(@Autowired private val webClient: RestTestClient) {

    @Test
    fun `should return new task on adding`() {
        val request = AddTaskRequest(title = "Test Task")

        webClient
            .post()
            .uri("/v1/project/ed3baaa1-8d14-4f21-9f27-48a822d59473/task")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(request)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(TaskResponse::class.java)
            .isEqualTo(TaskResponse("2514417b-67de-4799-a6cb-c2a187ad2e5b", "Test Task"))
    }

    @Test
    fun `should return a task`() {
        webClient
            .get()
            .uri("/v1/task/2514417b-67de-4799-a6cb-c2a187ad2e5b")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(TaskResponse::class.java)
            .isEqualTo(TaskResponse("2514417b-67de-4799-a6cb-c2a187ad2e5b", "Test Task"))
    }
}