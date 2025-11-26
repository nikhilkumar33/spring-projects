<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Stock</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', Arial, sans-serif;
        height: 100vh;
        background: linear-gradient(135deg,#232f3e,#485769);
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
        width: 480px;
        background: white;
        padding: 35px;
        border-radius: 18px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        text-align: center;
        animation: pop 0.6s ease;
        position: relative;
        z-index: 10;
    }

    @keyframes pop {
        0% { transform: scale(0.6); opacity: 0; }
        100% { transform: scale(1); opacity: 1; }
    }

    h2 {
        font-size: 30px;
        color: #ff4d4d;
        margin-bottom: 10px;
        font-weight: 700;
    }

    .stock {
        font-size: 22px;
        font-weight: bold;
        color: #333;
        margin-bottom: 10px;
    }

    .question {
        font-size: 18px;
        color: #444;
        margin-bottom: 25px;
    }

    .btn-box a {
        text-decoration: none;
        padding: 14px 35px;
        border-radius: 10px;
        font-size: 16px;
        font-weight: 600;
        margin: 0 10px;
        transition: 0.3s ease;
        display: inline-block;
    }

    .yes-btn {
        background: linear-gradient(135deg, #ff416c, #ff4b2b);
        color: white;
        box-shadow: 0 4px 12px rgba(255,65,108,0.4);
    }
    .yes-btn:hover { transform: scale(1.05); }

    .no-btn {
        background: linear-gradient(135deg, #42e695, #3bb2b8);
        color: white;
        box-shadow: 0 4px 12px rgba(66,230,149,0.4);
    }
    .no-btn:hover { transform: scale(1.05); }

</style>

</head>
<body>

    <!-- Floating Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <div class="container">
        <h2>Delete Stock?</h2>

        <div class="stock">Current Stock: ${currStock}</div>

        <div class="question">Are you sure you want to delete this stock?</div>

        <div class="btn-box">
            <a href="deleteStock" class="yes-btn">Yes, Delete</a>
            <a href="home" class="no-btn">No, Go Back</a>
        </div>
    </div>

</body>
</html>
