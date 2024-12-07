<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
    /* Style for full-page background video */
    .background-video {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
        z-index: -1;
    }
    /* Add styles for page content */
    .content {
        position: relative;
        z-index: 1;
        color: white;
        text-align: center;
        padding-top: 20px;
    }
</style>
</head>
<body>

<!-- Background video element -->
<video class="background-video" autoplay loop muted>
    <source src="media/bg.mp4" type="video/mp4">
    <!-- Fallback message for browsers that don't support the video element -->
    Your browser does not support the video tag.
</video>

<div class="content">
    <%@include file="mainnavbar.jsp" %>
    <!-- Additional page content goes here -->
</div>

</body>
</html>
