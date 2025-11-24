<!DOCTYPE html>
<html>
<head>
<title>Zepto Welcome</title>
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
            background:rgba(255,255,255,0.85);
            padding:40px;
            width:350px;
            text-align:center;
            border-radius:16px;
            box-shadow:0 6px 20px rgba(0,0,0,0.15);
            backdrop-filter:blur(6px);
        ">
            
            <h2 style="
                color:#333;
                margin-bottom:25px;
                font-size:28px;
                font-weight:bold;
            ">
                Welcome to Zepto!
            </h2>

            <a href="showLogin" 
               style="
                    display:inline-block;
                    background:#4caf50;
                    color:white;
                    padding:14px 30px;
                    text-decoration:none;
                    border-radius:10px;
                    font-size:20px;
                    font-weight:bold;
                    letter-spacing:1px;
                    transition:0.3s;
                    box-shadow:0 4px 10px rgba(0,0,0,0.2);
               "
               onmouseover="this.style.background='#43a047'"
               onmouseout="this.style.background='#4caf50'"
            >
                Login
            </a>

        </div>

    </div>

    <!-- Gradient Animation -->
    <style>
        @keyframes bgmove {
            0% { background-position:0% 50%; }
            50% { background-position:100% 50%; }
            100% { background-position:0% 50%; }
        }
    </style>

</body>
</html>
