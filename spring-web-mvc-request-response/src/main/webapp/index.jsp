<html>
<head>
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

    /* --- MANY BUBBLES WITH RANDOM MOTION --- */
    .bubble {
        position: absolute;
        border-radius: 50%;
        opacity: 0.45;
        animation: float 7s infinite ease-in-out alternate;
    }

    /* 15 bubbles with different sizes & animation delays */
    .b1 { width: 80px; height: 80px; top: 10%; left: 15%; background:#ffffff33; animation-delay:0s; }
    .b2 { width: 120px; height:120px; top: 60%; left: 5%; background:#ffffff44; animation-delay:1s; }
    .b3 { width: 90px; height:90px; top: 30%; left: 75%; background:#ffffff22; animation-delay:2s; }
    .b4 { width: 60px; height:60px; top: 75%; left: 40%; background:#ffffff33; animation-delay:0.5s; }
    .b5 { width: 140px; height:140px; top: 20%; left: 50%; background:#ffffff28; animation-delay:3s; }
    .b6 { width: 70px; height:70px; top: 85%; left: 20%; background:#ffffff30; animation-delay:2.5s; }
    .b7 { width: 110px; height:110px; top: 40%; left: 10%; background:#ffffff25; animation-delay:1.3s; }
    .b8 { width: 95px; height:95px; top: 5%; left: 80%; background:#ffffff35; animation-delay:2.8s; }
    .b9 { width: 65px; height:65px; top: 70%; left: 70%; background:#ffffff40; animation-delay:1.8s; }
    .b10 { width: 150px; height:150px; top: 45%; left: 55%; background:#ffffff22; animation-delay:0.9s; }
    .b11 { width: 55px; height:55px; top: 50%; left: 25%; background:#ffffff33; animation-delay:3.2s; }
    .b12 { width: 130px; height:130px; top: 15%; left: 30%; background:#ffffff27; animation-delay:0.7s; }
    .b13 { width: 75px; height:75px; top: 88%; left: 80%; background:#ffffff31; animation-delay:2.1s; }
    .b14 { width: 105px; height:105px; top: 55%; left: 85%; background:#ffffff29; animation-delay:1.6s; }
    .b15 { width: 85px; height:85px; top: 33%; left: 3%; background:#ffffff36; animation-delay:0.4s; }

    /* Bigger floating movement */
    @keyframes float {
        0% { transform: translateY(0px) translateX(0px) scale(1); }
        50% { transform: translateY(-60px) translateX(30px) scale(1.1); }
        100% { transform: translateY(-20px) translateX(-20px) scale(1); }
    }

    @keyframes bgMove {
        0% { background-position: 0% 50%; }
        100% { background-position: 100% 50%; }
    }

    /* Frosted card */
    .card {
        background: rgba(255, 255, 255, 0.25);
        backdrop-filter: blur(12px);
        padding: 50px;
        border-radius: 20px;
        text-align: center;
        width: 380px;
        box-shadow: 0 10px 35px rgba(0,0,0,0.3);
        animation: fadeIn 1.5s ease;
        z-index: 5;
    }

    h2 {
        color: white;
        font-size: 32px;
        font-weight: 600;
        margin-bottom: 10px;
        text-shadow: 0 3px 8px rgba(0,0,0,0.4);
    }

    p {
        color: #f2f2f2;
        margin-bottom: 25px;
    }

    a {
        display: inline-block;
        background: linear-gradient(45deg, #ff5722, #ff9800);
        padding: 14px 35px;
        color: white;
        text-decoration: none;
        font-weight: bold;
        border-radius: 50px;
        box-shadow: 0 6px 18px rgba(255, 87, 34, 0.6);
        transition: 0.3s;
        animation: glow 2s infinite alternate;
    }

    a:hover {
        transform: scale(1.1);
        box-shadow: 0 10px 25px rgba(255, 152, 0, 0.8);
    }

    @keyframes glow {
        0% { box-shadow: 0 0 10px rgba(255, 152, 0, 0.4); }
        100% { box-shadow: 0 0 25px rgba(255, 152, 0, 1); }
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(30px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>
</head>

<body>

    <!-- MANY bubbles -->
    <div class="bubble b1"></div><div class="bubble b2"></div><div class="bubble b3"></div>
    <div class="bubble b4"></div><div class="bubble b5"></div><div class="bubble b6"></div>
    <div class="bubble b7"></div><div class="bubble b8"></div><div class="bubble b9"></div>
    <div class="bubble b10"></div><div class="bubble b11"></div><div class="bubble b12"></div>
    <div class="bubble b13"></div><div class="bubble b14"></div><div class="bubble b15"></div>

    <div class="card">
        <h2>Welcome to MMT!</h2>
        <p>Your travel journey starts here ✈️</p>
        <a href="showProfilePage">Create Profile</a>
    </div>

</body>
</html>
