<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Profile - MMT</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(120deg, #00bcd4, #0288d1, #512da8);
        background-size: 300% 300%;
        animation: bgMove 10s infinite alternate ease-in-out;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
    }

    /* Animated background */
    @keyframes bgMove {
        0% { background-position: 0% 50%; }
        100% { background-position: 100% 50%; }
    }

    /* Floating circles */
    .bubble {
        position: absolute;
        border-radius: 50%;
        background: rgba(255,255,255,0.25);
        animation: float 7s infinite ease-in-out alternate;
    }

    /* Multiple bubble designs */
    .b1 { width: 90px; height: 90px; top: 10%; left: 20%; animation-delay: 0s; }
    .b2 { width: 120px; height: 120px; bottom: 15%; right: 10%; animation-delay: 2s; }
    .b3 { width: 70px; height: 70px; bottom: 30%; left: 10%; animation-delay: 1.5s; }
    .b4 { width: 100px; height: 100px; top: 40%; right: 30%; animation-delay: 0.8s; }

    @keyframes float {
        0% { transform: translateY(0px) translateX(0px); }
        50% { transform: translateY(-40px) translateX(25px); }
        100% { transform: translateY(0px) translateX(-20px); }
    }

    /* Card style */
    .form-card {
        background: rgba(255,255,255,0.2);
        backdrop-filter: blur(12px);
        width: 420px;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 10px 35px rgba(0,0,0,0.3);
        animation: fadeIn 1.2s ease;
        z-index: 10;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(30px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h2 {
        text-align: center;
        color: white;
        font-size: 30px;
        margin-bottom: 25px;
        text-shadow: 0 3px 8px rgba(0,0,0,0.4);
    }

    label {
        font-weight: bold;
        color: #f8f8f8;
        display: block;
        margin-bottom: 6px;
    }

    input[type=text] {
        width: 100%;
        padding: 12px 15px;
        margin-bottom: 18px;
        border-radius: 10px;
        border: none;
        outline: none;
        font-size: 14px;
        background: rgba(255,255,255,0.85);
        box-shadow: 0 3px 10px rgba(0,0,0,0.15);
        transition: 0.3s;
    }

    input[type=text]:focus {
        transform: scale(1.03);
        box-shadow: 0 0 15px rgba(0, 188, 212, 0.8);
        border: 1px solid #0288d1;
    }

    input[type=submit] {
        width: 100%;
        background: linear-gradient(45deg, #ff5722, #ff9800);
        padding: 14px;
        border: none;
        border-radius: 12px;
        color: white;
        font-size: 18px;
        font-weight: bold;
        cursor: pointer;
        box-shadow: 0 6px 18px rgba(255,87,34,0.6);
        transition: 0.3s;
        animation: glow 2s infinite alternate;
    }

    input[type=submit]:hover {
        transform: scale(1.08);
        box-shadow: 0 10px 25px rgba(255,152,0,0.8);
    }

    @keyframes glow {
        0% { box-shadow: 0 0 10px rgba(255,152,0,0.4); }
        100% { box-shadow: 0 0 25px rgba(255,152,0,1); }
    }
</style>
</head>

<body>

    <!-- Floating Bubbles -->
    <div class="bubble b1"></div>
    <div class="bubble b2"></div>
    <div class="bubble b3"></div>
    <div class="bubble b4"></div>

    <div class="form-card">
        <h2>Create Your Profile</h2>

        <form action="createProfile" method="post">
            
            <label>First Name:</label>
            <input type="text" name="firstName" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" required>

            <label>Email Id:</label>
            <input type="text" name="email" required>

            <label>Mobile:</label>
            <input type="text" name="mobile" required>

            <input type="submit" value="Create Profile">
        </form>
    </div>

</body>
</html>
