<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amazon Reseller</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        height: 100vh;
        background: linear-gradient(135deg, #0f0f0f, #1a1a1a, #111);
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
    }

    /* ==== Light Orbs ==== */
    .orb {
        position: absolute;
        width: 280px;
        height: 280px;
        background: radial-gradient(circle, rgba(255,153,0,0.55), transparent 70%);
        filter: blur(65px);
        animation: floatOrb 12s infinite ease-in-out;
    }

    @keyframes floatOrb {
        0% { transform: translate(-40px, 60px); }
        50% { transform: translate(40px, -40px); }
        100% { transform: translate(-40px, 60px); }
    }

    .orb2 {
        width: 230px;
        height: 230px;
        background: radial-gradient(circle, rgba(255,200,100,0.5), transparent 70%);
        right: 10%;
        top: 20%;
        animation-duration: 15s;
    }

    /* ==== Premium Animated Card ==== */
    .card {
        width: 500px;
        padding: 45px;
        border-radius: 25px;
        position: relative;
        text-align: center;
        z-index: 10;
        background: rgba(255,255,255,0.18);
        backdrop-filter: blur(12px);
        border: 2px solid rgba(255,153,0,0.6);
        box-shadow: 0 0 25px rgba(255,153,0,0.4), 
                    0 0 55px rgba(255,153,0,0.25) inset;
        animation: showUp 1.1s ease-out;
    }

    /* Entry animation */
    @keyframes showUp {
        from { opacity: 0; transform: translateY(40px) scale(0.95); }
        to { opacity: 1; transform: translateY(0) scale(1); }
    }

    /* Animated glossy overlay */
    .shine {
        position: absolute;
        top: 0;
        left: -120%;
        width: 80%;
        height: 100%;
        background: linear-gradient(120deg, 
                    transparent, 
                    rgba(255,255,255,0.45),
                    transparent);
        transform: skewX(-20deg);
        animation: shineMove 3s infinite;
    }

    @keyframes shineMove {
        0% { left: -120%; }
        60% { left: 150%; }
        100% { left: 150%; }
    }

h2 {
    font-size: 34px;
    color: #fff7c2; /* very visible soft white-gold */
    font-weight: 700;
    margin-bottom: 20px;
    text-shadow: 0 0 12px rgba(255,247,194,0.8);
}

h2::after {
    content: "";
    display: block;
    margin: 10px auto 0;
    width: 140px;
    height: 4px;
    background: linear-gradient(90deg, #f7d774, #fff7c2, #f7d774);
    border-radius: 5px;
    animation: underlineMove 2s infinite alternate;
}

    @keyframes underlineMove {
        from { transform: scaleX(0.7); }
        to { transform: scaleX(1); }
    }

    /* PREMIUM BUTTON */
    a {
        display: inline-block;
        margin-top: 15px;
        background: linear-gradient(135deg, #ffae00, #ff7a00);
        padding: 15px 35px;
        color: #000;
        font-size: 20px;
        font-weight: bold;
        text-decoration: none;
        border-radius: 16px;
        box-shadow: 0 8px 25px rgba(255,165,0,0.45);
        transition: 0.27s ease-in-out;
        position: relative;
        overflow: hidden;
    }

    /* Button hover shine */
    a::after {
        content: "";
        position: absolute;
        top: 0;
        left: -100%;
        width: 70%;
        height: 100%;
        background: rgba(255,255,255,0.3);
        transform: skewX(-20deg);
        transition: 0.4s;
    }

    a:hover::after {
        left: 120%;
    }

    a:hover {
        transform: scale(1.12) translateY(-4px);
        box-shadow: 0 12px 40px rgba(255,153,0,0.6);
    }
</style>
</head>

<body>

    <!-- Glowing orbs -->
    <div class="orb"></div>
    <div class="orb orb2"></div>

    <!-- Card -->
    <div class="card">
        <div class="shine"></div>

        <h2>Welcome to Amazon Reseller</h2>

        <a href="showProfilePage">Create Profile</a>
    </div>

</body>
</html>
