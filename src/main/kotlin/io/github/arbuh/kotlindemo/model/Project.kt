package io.github.arbuh.kotlindemo.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "project")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column(nullable = false)
    val name: String
)