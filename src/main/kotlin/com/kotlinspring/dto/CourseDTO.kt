package com.kotlinspring.dto

//import javax.validation.constraints.NotBlank
//import javax.validation.constraints.NotNull

// dto means data transfer object
data class CourseDTO (
    val id: Int?,
    val name: String,
    val category: String,
    val instructorId: Int? = null
)