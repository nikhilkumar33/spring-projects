<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success - Zepto</title>
</head>

<body style="
    margin:0;
    padding:0;
    font-family:Arial, sans-serif;
    background: linear-gradient(135deg, #ff4d6d, #ff7b54, #ffd95a, #00c2ff);
    background-size:400% 400%;
    animation: bgmove 14s ease infinite;
">

    <div style="
        width:100%;
        height:100vh;
        display:flex;
        justify-content:center;
        align-items:center;
    ">

        <div style="
            background:rgba(255,255,255,0.9);
            padding:50px 40px;
            width:420px;
            border-radius:22px;
            text-align:center;
            box-shadow:0 10px 30px rgba(0,0,0,0.25);
            backdrop-filter:blur(6px);
            animation: pop 0.6s ease;
        ">

            <!-- Success Icon -->
            <div style="
                width:90px;
                height:90px;
                background:#4caf50;
                color:white;
                margin:auto;
                display:flex;
                justify-content:center;
                align-items:center;
                border-radius:50%;
                font-size:42px;
                font-weight:bold;
                box-shadow:0 6px 15px rgba(0,0,0,0.3);
            ">✓</div>

            <h2 style="
                margin-top:25px;
                font-size:32px;
                color:#333;
            ">Login Successful!</h2>

            <p style="
                font-size:18px;
                margin:10px 0 30px 0;
                color:#444;
            ">
                Welcome back! Redirecting you to the Zepto Store.
            </p>

            <a href="products" 
               style="
                    display:inline-block;
                    background:#4caf50;
                    padding:14px 40px;
                    color:white;
                    text-decoration:none;
                    border-radius:14px;
                    font-size:20px;
                    font-weight:bold;
                    letter-spacing:1px;
                    box-shadow:0 5px 15px rgba(0,0,0,0.25);
                    transition:0.3s;
               "
               onmouseover="this.style.background='#43a047'"
               onmouseout="this.style.background='#4caf50'"
            >
                Continue →
            </a>

        </div>

    </div>

    <style>
        @keyframes bgmove {
            0% { background-position:0% 50%; }
            50% { background-position:100% 50%; }
            100% { background-position:0% 50%; }
        }
        @keyframes pop {
            0% { transform:scale(0.3); opacity:0; }
            100% { transform:scale(1); opacity:1; }
        }
    </style>

</body>
</html>
