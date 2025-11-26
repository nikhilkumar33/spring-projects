<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Created - Amazon Reseller</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        height: 100vh;
        background: linear-gradient(135deg, #232f3e, #485769);
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
        color: #fff;
        position: relative;
    }

    /* Floating glowing orbs */
    .orb {
        position: absolute;
        border-radius: 50%;
        filter: blur(80px);
        opacity: 0.25;
        animation: float 15s infinite ease-in-out;
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

    /* Success Card */
    .card {
        background: rgba(255,255,255,0.95);
        width: 450px;
        padding: 45px;
        border-radius: 22px;
        text-align: center;
        box-shadow: 0 15px 35px rgba(0,0,0,0.25);
        animation: fadeInUp 0.8s ease-out;
        position: relative;
        z-index: 10;
        color:#232f3e;
    }

    @keyframes fadeInUp {
        from { opacity:0; transform:translateY(30px); }
        to { opacity:1; transform:translateY(0); }
    }

    /* Checkmark */
    .check {
        font-size: 70px;
        color: #34a853; /* premium green */
        font-weight: bold;
        animation: pop 0.6s ease-out;
        text-shadow: 0 0 15px rgba(52,168,83,0.7);
    }

    @keyframes pop {
        0% { transform: scale(0.2); opacity:0; }
        60% { transform: scale(1.2); opacity:1; }
        100% { transform: scale(1); }
    }

    h2 {
        color: #ff9900; /* premium gold/orange */
        font-size: 28px;
        margin-top: 15px;
        text-shadow: 0 0 8px rgba(255,153,0,0.6);
    }

    .stock-box {
        background: linear-gradient(135deg, #ffeb3b, #ffc107);
        color: #232f3e;
        padding: 16px;
        font-size: 18px;
        border-radius: 12px;
        font-weight: bold;
        margin-top: 12px;
        margin-bottom: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.15);
    }

    p {
        color: #444;
        font-size: 16px;
        margin-top: 10px;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        padding: 14px 28px;
        background: linear-gradient(135deg, #ff9900, #ff7a00);
        color: #fff;
        font-weight: bold;
        text-decoration: none;
        border-radius: 14px;
        font-size: 18px;
        box-shadow: 0 8px 22px rgba(255,153,0,0.45);
        transition: 0.3s;
    }

    a:hover {
        transform: scale(1.08) translateY(-3px);
        box-shadow: 0 12px 28px rgba(255,153,0,0.6);
    }

    /* Confetti Animation */
    .confetti {
        position: absolute;
        width: 12px;
        height: 12px;
        border-radius: 3px;
        opacity: 0.85;
        animation: confettiFall 4s linear infinite;
    }

    @keyframes confettiFall {
        0% { transform: translateY(-50px) rotate(0deg); }
        100% { transform: translateY(110vh) rotate(360deg); }
    }

</style>
</head>

<body>

    <!-- Floating Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <!-- Confetti Elements -->
    <script>
        const colors = ['#ffffff','#ffeb3b','#ff9900','#00e5ff','#69f0ae'];
        for(let i=0;i<40;i++){
            let conf = document.createElement('div');
            conf.classList.add('confetti');
            conf.style.left = Math.random()*100 + 'vw';
            conf.style.backgroundColor = colors[Math.floor(Math.random()*colors.length)];
            conf.style.animationDuration = (2 + Math.random()*3) + 's';
            conf.style.width = conf.style.height = (8 + Math.random()*6) + 'px';
            document.body.appendChild(conf);
        }
    </script>

    <!-- Success Card -->
    <div class="card">
        <div class="check">✓</div>
        <h2>Profile Created Successfully!</h2>
        <div class="stock-box">
             Your User ID: ${userId}
        </div>
        <p>Your Amazon Reseller account is ready 🎉</p>
        <a href="showLoginPage">Login</a>
    </div>

</body>
</html>
