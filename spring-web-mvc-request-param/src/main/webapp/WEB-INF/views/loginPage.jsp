<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto Login</title>
</head>

<body style="
    margin:0;
    padding:0;
    font-family:Arial, sans-serif;
    background: linear-gradient(135deg, #ff4d6d, #ff7b54, #ffd95a, #00c2ff);
    background-size:400% 400%;
    animation: bgmove 12s ease infinite;
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
            padding:40px;
            width:350px;
            border-radius:16px;
            text-align:center;
            box-shadow:0 6px 20px rgba(0,0,0,0.2);
            backdrop-filter:blur(6px);
        ">

            <h2 style="
                margin-bottom:25px;
                color:#333;
                font-size:28px;
            ">Zepto Login</h2>

            <form action="validateLogin" method="post">

                <label style="font-size:16px; font-weight:bold; color:#333;">Username</label><br/>
                <input type="text" name="userName" required
                    style="
                        width:90%;
                        padding:12px;
                        margin:10px 0 20px 0;
                        border-radius:10px;
                        border:1px solid #ccc;
                        font-size:15px;
                        outline:none;
                        transition:0.3s;
                    "
                    onfocus="this.style.border='1px solid #4caf50'"
                    onblur="this.style.border='1px solid #ccc'"
                /><br/>

                <label style="font-size:16px; font-weight:bold; color:#333;">Password</label><br/>
                <input type="password" name="password" required
                    style="
                        width:90%;
                        padding:12px;
                        margin:10px 0 25px 0;
                        border-radius:10px;
                        border:1px solid #ccc;
                        font-size:15px;
                        outline:none;
                        transition:0.3s;
                    "
                    onfocus="this.style.border='1px solid #4caf50'"
                    onblur="this.style.border='1px solid #ccc'"
                /><br/>

                <input type="submit" value="Login"
                    style="
                        background:#4caf50;
                        color:white;
                        padding:12px 30px;
                        border:none;
                        border-radius:10px;
                        font-size:18px;
                        font-weight:bold;
                        cursor:pointer;
                        width:100%;
                        transition:0.3s;
                        box-shadow:0 4px 12px rgba(0,0,0,0.2);
                    "
                    onmouseover="this.style.background='#43a047'"
                    onmouseout="this.style.background='#4caf50'"
                />

            </form>

        </div>

    </div>

    <style>
        @keyframes bgmove {
            0% { background-position:0% 50%; }
            50% { background-position:100% 50%; }
            100% { background-position:0% 50%; }
        }
    </style>

</body>
</html>
