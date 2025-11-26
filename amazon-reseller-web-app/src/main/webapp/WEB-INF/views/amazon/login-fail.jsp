<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed</title>
</head>

<body style="margin:0; padding:0; font-family:Arial; background:linear-gradient(135deg, #ff512f, #dd2476); height:100vh; display:flex; justify-content:center; align-items:center;">

    <div style="background:white; width:400px; padding:30px; border-radius:18px; text-align:center; box-shadow:0 10px 25px rgba(0,0,0,0.3); animation:pop 0.4s ease;">
        
        <!-- ❌ Error Icon -->
        <div style="font-size:60px; color:#dd2476; margin-bottom:10px;">
            &#10060;
        </div>

        <h2 style="color:#333; margin-bottom:10px;">Invalid Credentials!</h2>

        <p style="color:#555; font-size:15px; margin-bottom:25px;">
            The email or password you entered is incorrect. Please try again.
        </p>

        <a href="showLoginPage" 
           style="display:inline-block; padding:12px 22px; background:#dd2476; color:white; text-decoration:none; font-weight:bold; border-radius:12px; box-shadow:0 5px 12px rgba(221,36,118,0.4); transition:0.3s;">
           Retry Login
        </a>
    </div>

    <!-- Animation -->
    <style>
        @keyframes pop {
            0%   { transform:scale(0.6); opacity:0; }
            100% { transform:scale(1); opacity:1; }
        }
    </style>

</body>
</html>
