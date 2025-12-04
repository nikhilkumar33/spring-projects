<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto - Place Order</title>

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
        animation: fadeIn 1.5s ease-in-out;
    }

    .container {
        text-align: center;
        background: rgba(255, 255, 255, 0.15);
        padding: 40px 60px;
        border-radius: 20px;
        backdrop-filter: blur(10px);
        box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
        animation: slideUp 1.2s ease-out;
    }

    h2 {
        color: white;
        font-size: 32px;
        margin-bottom: 20px;
        font-weight: 600;
        text-shadow: 0px 0px 10px rgba(255,255,255,0.3);
    }

    a {
        text-decoration: none;
        display: inline-block;
        padding: 14px 30px;
        background: #ff2e63;
        color: #fff;
        font-size: 18px;
        border-radius: 40px;
        transition: 0.3s;
        box-shadow: 0px 6px 15px rgba(255, 46, 99, 0.4);
    }

    a:hover {
        background: #ff174f;
        transform: scale(1.05);
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

<div class="container">
    <h2>Zepto Place Your Order</h2>
    <a href="showOrderPage">Click To Order</a>
</div>

</body>
</html>
