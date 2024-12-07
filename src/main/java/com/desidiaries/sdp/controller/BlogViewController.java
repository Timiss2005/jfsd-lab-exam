package com.desidiaries.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desidiaries.sdp.model.Blog;
import com.desidiaries.sdp.services.BlogService;

//Move BlogViewController to its own file outside BlogController
@Controller
@RequestMapping("/userblogs")
public class BlogViewController {

 private final BlogService blogService;

 @Autowired
 public BlogViewController(BlogService blogService) {
     this.blogService = blogService;
 }

 // Show all blogs in a view
 @GetMapping
 public String showUserBlogs(Model model) {
     List<Blog> blogs = blogService.getAllBlogs();  // Fetch blogs from service
     model.addAttribute("blogs", blogs);  // Add to model for view
     return "userblogs";  // This should be the name of your view (userblogs.html or userblogs.jsp)
 }
}
