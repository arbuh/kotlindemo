package io.github.arbuh.kotlindemo.api.dto.request

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@JsonTest
class CreateProjectRequestJsonTest {

    @Autowired
    private lateinit var json: JacksonTester<CreateProjectRequest>

    @Test
    fun `CreateProjectRequest should be properly deserialized`() {
        val request = """
                {
                    "name": "Test Name"
                }
                
                """.trimIndent()

        val expected = CreateProjectRequest(name = "Test Name")

        assertThat(json.parse(request)).isEqualTo(expected)
    }
}