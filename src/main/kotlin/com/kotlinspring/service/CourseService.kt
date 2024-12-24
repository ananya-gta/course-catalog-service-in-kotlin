package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.exception.CourseNotFoundException
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

    fun getAllCourses(): List<CourseDTO> {
        return courseRepository.findAll()
            .map {
                CourseDTO(it.id, it.name, it.category)
            }
    }

    fun updateCourse(courseId : Int, courseDTO : CourseDTO) : CourseDTO {

        val existingCourse = courseRepository.findById(courseId)
        return if (existingCourse.isPresent){
            existingCourse.get()
                .let {
                    it.name = courseDTO.name
                    it.category = courseDTO.category
                    courseRepository.save(it)
    // let is a lambda expression last statement will always be a return value
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            // if the id is invalid then we will throw a custom exception
            throw CourseNotFoundException("No course found for the passed in Id : $courseId")
        }

    }
}