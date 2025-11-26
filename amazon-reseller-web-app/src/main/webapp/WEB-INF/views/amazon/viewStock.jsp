<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Stock</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', Arial, sans-serif;
        background: linear-gradient(135deg,#232f3e,#485769);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
        position: relative;
        color:white;
    }

    /* Floating glowing orbs */
    .orb {
        position: absolute;
        border-radius: 50%;
        filter: blur(80px);
        opacity: 0.25;
        animation: float 18s infinite ease-in-out;
        mix-blend-mode: screen;
    }
    .orb1 { width:250px; height:250px; top:10%; left:15%; background: rgba(255,202,82,0.25); animation-duration:16s; }
    .orb2 { width:180px; height:180px; bottom:15%; right:10%; background: rgba(26,115,232,0.2); animation-duration:18s; }
    .orb3 { width:220px; height:220px; top:20%; right:20%; background: rgba(52,168,83,0.15); animation-duration:20s; }

    @keyframes float {
        0% { transform: translateY(0px) translateX(0px); }
        50% { transform: translateY(-40px) translateX(20px); }
        100% { transform: translateY(0px) translateX(0px); }
    }

    /* White container */
    .container {
        background: white;
        width: 420px;
        padding: 35px;
        border-radius: 18px;
        text-align: center;
        box-shadow: 0 8px 25px rgba(0,0,0,0.25);
        animation: fadeIn 0.6s ease-out;
        position: relative;
        z-index: 10;
        color:#232f3e;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(25px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h1 {
        color: #232f3e;
        font-size: 28px;
        margin-bottom: 15px;
        font-weight: 700;
    }

    .stock-box {
        background: linear-gradient(135deg, #84fab0, #8fd3f4);
        color: #003c57;
        padding: 18px;
        font-size: 22px;
        border-radius: 12px;
        font-weight: bold;
        box-shadow: 0 5px 15px rgba(0,0,0,0.15);
        margin-bottom: 30px;
    }

    .back-btn {
        display: inline-block;
        padding: 12px 20px;
        background: linear-gradient(135deg, #ff9900, #ff7a00);
        color: white;
        text-decoration: none;
        font-size: 15px;
        border-radius: 10px;
        font-weight: 600;
        box-shadow: 0 6px 15px rgba(255,153,0,0.4);
        transition: 0.3s;
    }

    .back-btn:hover {
        transform: scale(1.06);
    }

</style>

</head>
<body>

    <!-- Floating Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <div class="container">
        <h1>📦 Current Stock</h1>

        <div class="stock-box">
            Your Current Stock: ${currStock}
        </div>

        <a href="home" class="back-btn">← Back to Home</a>
    </div>

</body>
</html>
