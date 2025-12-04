<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

<style>

    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #8e2de2, #4a00e0);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        animation: fadeIn 1s ease-in-out;
    }

    .success-card {
        background: rgba(255, 255, 255, 0.15);
        width: 420px;
        padding: 40px;
        border-radius: 20px;
        text-align: center;
        color: white;
        backdrop-filter: blur(10px);
        box-shadow: 0px 0px 18px rgba(0,0,0,0.25);
        animation: slideUp 1.2s ease-out;
    }

    h3 {
        font-size: 26px;
        margin-bottom: 15px;
        font-weight: 600;
    }

    .order-id-box {
        margin-top: 20px;
        padding: 15px;
        background: rgba(255,255,255,0.2);
        border-radius: 12px;
        font-size: 20px;
        font-weight: bold;
        letter-spacing: 1px;
        box-shadow: 0px 0px 12px rgba(255,255,255,0.3);
    }

    /* Success check-circle */
    .checkmark {
        width: 80px;
        height: 80px;
        border-radius: 50%;
        border: 4px solid #4cff8f;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0 auto 20px auto;
        animation: pop 0.6s ease-out;
    }

    .checkmark::after {
        content: '✔';
        font-size: 40px;
        color: #4cff8f;
        font-weight: bold;
    }

    @keyframes pop {
        0% { transform: scale(0); }
        80% { transform: scale(1.2); }
        100% { transform: scale(1); }
    }

    @keyframes slideUp {
        from { transform: translateY(40px); opacity: 0; }
        to   { transform: translateY(0); opacity: 1; }
    }

    @keyframes fadeIn {
        from { opacity: 0; }
        to   { opacity: 1; }
    }
</style>

</head>

<body>

<div class="success-card">

    <div class="checkmark"></div>

    <h3>Your Order Has Been Placed Successfully!</h3>

    <div class="order-id-box">
        Order ID: ${orderId}
    </div>

</div>

</body>
</html>
