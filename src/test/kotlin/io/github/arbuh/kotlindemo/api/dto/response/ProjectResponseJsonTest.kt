package io.github.arbuh.kotlindemo.api.dto.response

import org.springframework.boot.test.json.JacksonTester
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest

@JsonTest
class ProjectResponseJsonTest {

    @Autowired
    private lateinit var json: JacksonTester<ProjectResponse>

    @Test
    fun `ProjectResponse should be properly serialized`() {
        val response = ProjectResponse(id = "ed3baaa1-8d14-4f21-9f27-48a822d59473", name = "Test Name")

        val expected = """
                {
                    "id": "ed3baaa1-8d14-4f21-9f27-48a822d59473",
                    "name": "Test Name"
                }
                
                """.trimIndent()

        val result = json.write(response)
        assertThat(result).isEqualTo(expected)
    }
}