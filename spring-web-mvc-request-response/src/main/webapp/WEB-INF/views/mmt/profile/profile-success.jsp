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
        font-family: Arial, sans-serif;
        background: linear-gradient(#00bcd4, #0288d1);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .card {
        background: white;
        width: 420px;
        padding: 35px;
        border-radius: 18px;
        text-align: center;
        box-shadow: 0 10px 30px rgba(0,0,0,0.25);
        animation: fadeIn 0.9s ease-in-out;
    }

    h1 {
        color: #0288d1;
        margin-bottom: 10px;
        font-size: 26px;
    }

    .msg {
        color: #444;
        font-size: 16px;
        margin-bottom: 20px;
    }

    .userid-box {
        background: #e0f7fa;
        padding: 12px;
        border-radius: 10px;
        color: #0277bd;
        font-size: 20px;
        font-weight: bold;
        width: 80%;
        margin: 0 auto 20px auto;
        box-shadow: 0 4px 12px rgba(2,136,209,0.3);
    }

    .btn {
        display: inline-block;
        background: #0288d1;
        padding: 12px 22px;
        color: white;
        text-decoration: none;
        font-size: 16px;
        font-weight: bold;
        border-radius: 12px;
        box-shadow: 0 5px 15px rgba(2,136,209,0.4);
        transition: 0.3s;
    }

    .btn:hover {
        background: #0277bd;
        transform: scale(1.05);
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(25px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>

</head>
<body>

    <div class="card">
        <h1>Profile Created Successfully</h1>

        <p class="msg">Your MakeMyTrip profile is ready!</p>

        <div class="userid-box">
            Your User ID: ${userId}
        </div>

        <a href="home" class="btn">Go to Home</a>
    </div>

</body>
</html>
