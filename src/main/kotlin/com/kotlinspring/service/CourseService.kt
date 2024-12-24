package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository){
    companion object : KLogging()
    fun addCourse(courseDTO : CourseDTO) : CourseDTO {
        // converting courseDTO into an entity
       val courseDTOEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }
        courseRepository.save(courseDTOEntity)
        logger.info("Saved course is: $courseDTOEntity")
        // TRANSFER IT BACK TO DTO
        return courseDTOEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }
}