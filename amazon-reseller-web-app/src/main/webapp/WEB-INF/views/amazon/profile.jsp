<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Profile - Amazon Reseller</title>

<style>
    body {
        margin:0;
        padding:0;
        font-family:'Arial',sans-serif;
        height:100vh;
        background: linear-gradient(135deg,#232f3e,#485769);
        display:flex;
        justify-content:center;
        align-items:center;
        color:white;
        overflow:hidden;
    }

    /* Floating glowing circles in the background */
    .orb {
        position:absolute;
        border-radius:50%;
        background: rgba(255,153,0,0.2);
        filter: blur(50px);
        animation: float 12s infinite ease-in-out;
    }

    .orb1 { width:200px; height:200px; top:10%; left:15%; animation-duration:14s; }
    .orb2 { width:150px; height:150px; bottom:15%; right:10%; animation-duration:18s; background: rgba(26,115,232,0.15); }
    .orb3 { width:180px; height:180px; top:20%; right:20%; animation-duration:16s; background: rgba(217,48,37,0.12); }

    @keyframes float {
        0% { transform: translateY(20px) translateX(0); }
        50% { transform: translateY(-20px) translateX(15px); }
        100% { transform: translateY(20px) translateX(0); }
    }

    /* Form Card with entrance animation */
    .form-card {
        background:white;
        width:450px;
        padding:35px;
        border-radius:18px;
        text-align:center;
        box-shadow:0 12px 30px rgba(0,0,0,0.3);
        color:#232f3e;
        animation:fadeInUp 0.8s ease-out;
        position:relative;
        z-index:10;
    }

    @keyframes fadeInUp {
        from { opacity:0; transform: translateY(40px); }
        to { opacity:1; transform: translateY(0); }
    }

    h2 {
        font-size:28px;
        margin-bottom:20px;
        font-weight:bold;
        color:#232f3e;
        animation:fadeInText 1s ease forwards;
    }

    @keyframes fadeInText {
        from { opacity:0; transform: translateY(-10px); }
        to { opacity:1; transform: translateY(0); }
    }

    label {
        display:block;
        margin-bottom:6px;
        font-weight:bold;
        color:#232f3e;
        text-align:left;
        font-size:15px;
        animation:fadeInText 1s ease forwards;
    }

    input[type=text], input[type=password] {
        width:100%;
        padding:12px;
        border:1px solid #bbb;
        border-radius:10px;
        margin-bottom:15px;
        font-size:15px;
        transition:0.3s;
        animation:fadeInText 1s ease forwards;
    }

    /* Glow effect on focus */
    input[type=text]:focus, input[type=password]:focus {
        border-color:#1a73e8;
        box-shadow: 0 0 10px rgba(26,115,232,0.6);
        outline:none;
        animation:glowFocus 0.3s forwards;
    }

    @keyframes glowFocus {
        0% { box-shadow:0 0 2px rgba(26,115,232,0.4); }
        100% { box-shadow:0 0 12px rgba(26,115,232,0.6); }
    }

    input[type=submit] {
        width:100%;
        padding:14px;
        background:#ff9900;
        color:white;
        border:none;
        border-radius:12px;
        font-size:17px;
        font-weight:bold;
        cursor:pointer;
        transition:0.3s;
        box-shadow:0 6px 18px rgba(255,153,0,0.45);
        animation:fadeInText 1s ease forwards;
    }

    /* Button hover animation */
    input[type=submit]:hover {
        transform: scale(1.08) translateY(-3px);
        background:#e65c00;
        box-shadow:0 10px 25px rgba(255,153,0,0.6);
    }

</style>
</head>

<body>

    <!-- Background floating orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <!-- Form Card -->
    <div class="form-card">
        <h2>Create Your Profile</h2>

        <form action="createProfile" method="post">
            <label>First Name:</label>
            <input type="text" name="firstName" placeholder="Enter first name" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" placeholder="Enter last name" required>

            <label>Email:</label>
            <input type="text" name="email" placeholder="Enter email" required>

            <label>Mobile:</label>
            <input type="text" name="mobile" placeholder="Enter mobile number" required>

            <label>Password:</label>
            <input type="password" name="password" placeholder="Create password" required>

            <input type="submit" value="Create Profile">
        </form>
    </div>

</body>
</html>
