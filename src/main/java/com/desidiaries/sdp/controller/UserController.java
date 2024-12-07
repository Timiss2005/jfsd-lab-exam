package com.desidiaries.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.desidiaries.sdp.model.User;
import com.desidiaries.sdp.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@GetMapping("userreg")
	public ModelAndView userreg() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userreg");
		return mv;
	}
		
	@PostMapping("insertuser")
	public ModelAndView insertuser(HttpServletRequest request) {
			String name = request.getParameter("usname");
			String gender = request.getParameter("usgender");
			String email = request.getParameter("usemail");
			String password = request.getParameter("uspassword");
			String contactno = request.getParameter("uscontactno");
			
			User user=new User();
			
			user.setName(name);
			user.setGender(gender);
			user.setEmail(email);
			user.setPassword(password);
			user.setContactno(contactno);
			
			String message = userService.userRegistration(user);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("regsuccess");
			mv.addObject("message",message);
			
			return mv;
		
	}
	@GetMapping("userlogin")
	public ModelAndView userlogin() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("userlogin");
	    return mv;
	}

	@PostMapping("userlogin")
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
	    String email = request.getParameter("usemail");
	    String password = request.getParameter("uspassword");

	    User user = userService.checkUserLogin(email, password);
	    ModelAndView mv = new ModelAndView();

	    if (user != null) {
	        session.setAttribute("user", user);
	        mv.setViewName("redirect:/dashboard"); // Redirect to dashboard on successful login
	    } else {
	        mv.setViewName("userlogin");
	        mv.addObject("error", "Invalid email or password. Please try again.");
	    }

	    return mv;
	}

	@GetMapping("/gallery")
    public String showGallery() {
        return "gallery"; // This looks for gallery.jsp in the /WEB-INF/views folder
    }
	@GetMapping("/blogs")
    public String showBlogs() {
        return "blogs"; // This looks for gallery.jsp in the /WEB-INF/views folder
    }
	@GetMapping("/virtual-tours")
    public String showVirtualTours() {
        return "virtual-tours"; // This looks for gallery.jsp in the /WEB-INF/views folder
    }
	
	
}
