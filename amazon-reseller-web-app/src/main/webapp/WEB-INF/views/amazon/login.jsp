<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reseller Login</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        height: 100vh;
        background: linear-gradient(135deg,#232f3e,#485769);
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
        color: #fff;
    }

    /* Floating orbs */
    .orb {
        position: absolute;
        border-radius: 50%;
        background: rgba(255, 200, 77, 0.15);
        filter: blur(60px);
        animation: float 12s infinite ease-in-out;
    }
    .orb1 { width:200px; height:200px; top:10%; left:15%; animation-duration:14s; }
    .orb2 { width:150px; height:150px; bottom:15%; right:10%; animation-duration:18s; background: rgba(26,115,232,0.12); }
    .orb3 { width:180px; height:180px; top:20%; right:20%; animation-duration:16s; background: rgba(217,48,37,0.1); }

    @keyframes float {
        0% { transform: translateY(20px) translateX(0); }
        50% { transform: translateY(-20px) translateX(15px); }
        100% { transform: translateY(20px) translateX(0); }
    }

    /* Login Card */
    .login-card {
        background: rgba(255,255,255,0.15);
        backdrop-filter: blur(12px);
        width:400px;
        padding:35px;
        border-radius:20px;
        box-shadow:0 15px 35px rgba(0,0,0,0.25);
        text-align:center;
        position: relative;
        z-index: 10;
        animation: fadeInUp 0.8s ease-out;
    }

    @keyframes fadeInUp {
        from { opacity:0; transform: translateY(30px); }
        to { opacity:1; transform: translateY(0); }
    }

    h2 {
        color: #ffca52;
        font-size:28px;
        margin-bottom:25px;
        text-shadow: 0 0 10px rgba(255,202,82,0.6);
    }

    input[type=text], input[type=password] {
        width:100%;
        padding:12px;
        margin:10px 0 15px 0;
        border-radius:10px;
        font-size:15px;
        border:1px solid #bbb;
        transition:0.3s;
    }

    /* Input focus glow */
    input[type=text]:focus, input[type=password]:focus {
        border-color:#1a73e8;
        box-shadow:0 0 10px rgba(26,115,232,0.5);
        outline:none;
    }

    input[type=submit] {
        width:100%;
        padding:14px;
        margin-top:10px;
        border:none;
        border-radius:12px;
        font-size:17px;
        font-weight:bold;
        cursor:pointer;
        color:#232f3e;
        background: linear-gradient(135deg, #ffca52, #ffb020);
        box-shadow:0 8px 22px rgba(255,200,77,0.45);
        transition:0.3s;
    }

    input[type=submit]:hover {
        transform: scale(1.08) translateY(-2px);
        box-shadow:0 12px 28px rgba(255,200,77,0.6);
    }

    p {
        font-size:14px;
        margin-top:18px;
        color:#e0e0e0;
    }

    p a {
        color:#ffca52;
        font-weight:bold;
        text-decoration:none;
    }

    p a:hover {
        text-decoration:underline;
    }
</style>

</head>
<body>

    <!-- Floating orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <!-- Login Card -->
    <div class="login-card">
        <h2>Reseller Login</h2>

        <form action="validateLogin" method="post">
            <input type="text" name="email" placeholder="Enter Email" required>
            <input type="password" name="password" placeholder="Enter Password" required>
            <input type="submit" value="Login">
        </form>

        <p>
            Don't have an account? 
            <a href="showProfilePage">Register</a>
        </p>
    </div>

</body>
</html>
