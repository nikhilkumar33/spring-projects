<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MMT - Profile Created</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(120deg, #00bcd4, #0288d1, #512da8);
        background-size: 300% 300%;
        animation: bgMove 8s infinite alternate ease-in-out;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
    }

    @keyframes bgMove {
        0% { background-position: 0% 50%; }
        100% { background-position: 100% 50%; }
    }

    /* Floating bubbles */
    .bubble {
        position: absolute;
        border-radius: 50%;
        background: rgba(255,255,255,0.25);
        animation: float 7s infinite ease-in-out alternate;
    }

    .b1 { width: 90px; height: 90px; top: 10%; left: 20%; }
    .b2 { width: 130px; height: 130px; top: 60%; left: 5%; animation-delay: 2s; }
    .b3 { width: 70px; height: 70px; top: 30%; left: 75%; animation-delay: 3s; }
    .b4 { width: 100px; height: 100px; bottom: 10%; left: 50%; animation-delay: 1s; }

    @keyframes float {
        0% { transform: translateY(0px) translateX(0px); }
        50% { transform: translateY(-40px) translateX(30px); }
        100% { transform: translateY(0px) translateX(-30px); }
    }

    /* Success Card */
    .card {
        background: rgba(255,255,255,0.2);
        backdrop-filter: blur(14px);
        width: 450px;
        padding: 45px;
        border-radius: 22px;
        text-align: center;
        box-shadow: 0 12px 40px rgba(0,0,0,0.35);
        animation: fadeIn 1.2s ease;
        z-index: 10;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(30px); }
        to { opacity: 1; transform: translateY(0); }
    }

    /* Success tick animation */
    .tick {
        font-size: 70px;
        color: #00e676;
        animation: pop 0.6s ease forwards;
        transform: scale(0);
    }

    @keyframes pop {
        100% { transform: scale(1); }
    }

    h1 {
        color: white;
        margin-bottom: 10px;
        font-size: 32px;
        text-shadow: 0 3px 10px rgba(0,0,0,0.4);
    }

    .msg {
        color: #f0f0f0;
        font-size: 18px;
        margin-bottom: 20px;
    }

    .userid-box {
        background: rgba(255,255,255,0.8);
        padding: 14px;
        border-radius: 12px;
        color: #0277bd;
        font-size: 22px;
        font-weight: bold;
        width: 80%;
        margin: 0 auto 25px auto;
        box-shadow: 0 6px 18px rgba(2,136,209,0.35);
    }

    /* Button */
    .btn {
        display: inline-block;
        background: linear-gradient(45deg, #ff5722, #ff9800);
        padding: 14px 28px;
        color: white;
        text-decoration: none;
        font-size: 18px;
        font-weight: bold;
        border-radius: 50px;
        box-shadow: 0 8px 22px rgba(255,152,0,0.6);
        transition: 0.3s;
        animation: glow 2s infinite alternate;
    }

    .btn:hover {
        transform: scale(1.1);
        box-shadow: 0 12px 30px rgba(255,152,0,0.9);
    }

    @keyframes glow {
        0% { box-shadow: 0 0 12px rgba(255,152,0,0.4); }
        100% { box-shadow: 0 0 28px rgba(255,152,0,1); }
    }

    /* Confetti */
    .confetti {
        position: absolute;
        width: 8px;
        height: 14px;
        background: #fff;
        animation: fall 3s linear infinite;
        opacity: 0.9;
    }

    @keyframes fall {
        0% { transform: translateY(-100vh) rotate(0deg); }
        100% { transform: translateY(100vh) rotate(360deg); }
    }
</style>

</head>
<body>

    <!-- Floating bubbles -->
    <div class="bubble b1"></div>
    <div class="bubble b2"></div>
    <div class="bubble b3"></div>
    <div class="bubble b4"></div>

    <!-- Auto-generated confetti -->
    <% for(int i=0; i<25; i++) { %>
        <div class="confetti" style="
            left: <%= (int)(Math.random()*100)%>% ;
            background: rgb(<%= (int)(Math.random()*255) %>,
                            <%= (int)(Math.random()*255) %>,
                            <%= (int)(Math.random()*255) %>);
            animation-duration: <%= (Math.random()*2 + 2) %>s;
            animation-delay: <%= (Math.random()*1) %>s;
        "></div>
    <% } %>

    <div class="card">
        <div class="tick">✔</div>

        <h1>Profile Created!</h1>
        <p class="msg">Your MakeMyTrip profile is now active 🎉</p>

        <div class="userid-box">
            User ID: ${userId}
        </div>

        <a href="home" class="btn">Go to Home</a>
    </div>

</body>
</html>
