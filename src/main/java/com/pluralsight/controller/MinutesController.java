package com.pluralsight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute ("exerciseCommand") Exercise exercise){
		
		System.out.println("exercise: " + exercise.getMinutes());
		System.out.println("exercise activity: " + exercise.getActivity());
		
		//return "forward:addMoreMinutes.html";		// request forwarded to another request inside server
		//return "redirect:addMoreMinutes.html";		// new request triggered by client/browser
		return "addMinutes";
	}

	@RequestMapping(value="/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute ("exerciseCommand") Exercise exercise){
		
		System.out.println("exercising: " + exercise.getMinutes());
		
		return "addMinutes";
	}	
	
	@RequestMapping(value="/activities", method=RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities(){
		return exerciseService.findAllActivities();
	}
}
