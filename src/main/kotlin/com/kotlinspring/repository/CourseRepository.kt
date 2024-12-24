package com.kotlinspring.repository

import com.kotlinspring.entity.Course
import org.springframework.data.repository.CrudRepository

// this will interact with the database
interface CourseRepository : CrudRepository<Course, Int> {
}