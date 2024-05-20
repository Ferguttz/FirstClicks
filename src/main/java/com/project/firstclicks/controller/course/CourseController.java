package com.project.firstclicks.controller.course;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.firstclicks.dto.CoursePublicDTO;
import com.project.firstclicks.entity.Course;
import com.project.firstclicks.service.CourseService;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("courses")
@RestController
public class CourseController {
	private CourseService courseService;
	
	@GetMapping("/last")
	public List<CoursePublicDTO> getLast() {
		return courseService.findLast6Courses();
	}
	
	@GetMapping("/search")
	public List<CoursePublicDTO> getCoursesById(@RequestParam  String name) {
		return courseService.findByName(name);
	}
	
	@GetMapping
	public Page<CoursePublicDTO> paginate(@PageableDefault(sort = "name", size = 5) Pageable pageable) {
		return courseService.paginate(pageable);
	}
	
	
	@GetMapping("/{courseId}")
	public CoursePublicDTO getCourse(@PathVariable Integer courseId) {
		return courseService.findById(courseId);
	}
}
	

