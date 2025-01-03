package com.kotlinspring.controller

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(courseDTO : CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping()
    fun getAllCourses() : List<CourseDTO> = courseService.getAllCourses()

    @PutMapping("/{course_id}")
    fun updateCourse(@RequestBody courseDTO : CourseDTO, @PathVariable("course_id") courseId: Int) : CourseDTO = courseService.updateCourse(courseId, courseDTO)

    @DeleteMapping("/{course_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable("course_id") courseId : Int) {
        courseService.deleteCourse(courseId)
    }

}