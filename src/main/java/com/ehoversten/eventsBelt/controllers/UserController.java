package com.ehoversten.eventsBelt.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehoversten.eventsBelt.models.User;
import com.ehoversten.eventsBelt.services.UserService;

@Controller
public class UserController {
	// --- DEPENDENCY INJECTION --- //
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user, Model model) {
		
        List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT","DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA","KS","KY","LA","ME","MD","MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH","NJ","NM",
        		"NY","NC" ,"ND" ,"OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
        model.addAttribute("states", states);
		
		return "registration";
	}
	
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        // if result has errors, return the registration page (don't worry about validations just now)

    	if(result.hasErrors()) {
            List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT","DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA","KS","KY","LA","ME","MD","MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH","NJ","NM",
            		"NY","NC" ,"ND" ,"OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
            model.addAttribute("states", states);
    		return "registration";
    	}
        // else, save the user in the database, save the user id in session ...
    	User newUser = userService.registerUser(user);
    	session.setAttribute("user", newUser.getId());
    	// and redirect them to the /home route
    	return "redirect:/index";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if(userService.authenticateUser(email, password)) {
    		User user = userService.findByEmail(email);
    		Long id = user.getId();
    		session.setAttribute("user", id);
    		return "redirect:/index";
    	}
        // else, add error messages and return the login page
    	else {
            List<String> states = Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT","DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA","KS","KY","LA","ME","MD","MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH","NJ","NM",
            		"NY","NC" ,"ND" ,"OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");
            model.addAttribute("states", states);
    		model.addAttribute("error", "Could not log you in");
    		return "login";
    	}
    }
    
    @RequestMapping("/index")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("user");
    	if(id == null) {
    		return "redirect:/login";
    	}
    	
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "index";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.setAttribute("user", null);
        // redirect to login page
    	return "redirect:/";
    }
	 
}
