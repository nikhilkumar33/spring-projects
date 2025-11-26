<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Stock - Amazon Reseller</title>

<style>
    body {
        margin:0;
        padding:0;
        font-family:'Poppins', Arial, sans-serif;
        height:100vh;
        background: linear-gradient(135deg,#232f3e,#485769);
        display:flex;
        justify-content:center;
        align-items:center;
        overflow:hidden;
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

    /* Form Card (Solid White) */
    .form-card {
        background: #ffffff;
        width:400px;
        padding:35px;
        border-radius:18px;
        text-align:center;
        box-shadow: 0 12px 30px rgba(0,0,0,0.3);
        color:#232f3e;
        animation:fadeIn 0.8s ease-in-out;
        position: relative;
        z-index: 10;
    }

    h2 {
        font-size:28px;
        color:#ff9900;
        margin-bottom:20px;
        font-weight:700;
        text-shadow: 0 0 10px rgba(255,153,0,0.5);
    }

    label {
        display:block;
        text-align:left;
        font-weight:bold;
        color:#232f3e;
        margin-bottom:5px;
    }

    input[type=text] {
        width:100%;
        padding:12px;
        border-radius:10px;
        border:1px solid #ccc;
        margin-bottom:18px;
        font-size:15px;
        transition:0.3s;
    }
    input[type=text]:focus {
        border-color:#ff9900;
        box-shadow:0 0 10px rgba(255,153,0,0.4);
        outline:none;
    }

    input[type=submit] {
        width:100%;
        padding:12px;
        background:#ff9900;
        border:none;
        color:white;
        font-size:16px;
        font-weight:bold;
        border-radius:12px;
        cursor:pointer;
        box-shadow:0 8px 20px rgba(255,153,0,0.45);
        transition:0.3s;
    }
    input[type=submit]:hover {
        transform:scale(1.05);
        background:#e68a00;
        box-shadow:0 12px 25px rgba(255,153,0,0.55);
    }

    a {
        display:inline-block;
        margin-top:20px;
        text-decoration:none;
        color:#1a73e8;
        font-weight:bold;
        font-size:14px;
        transition:0.3s;
    }
    a:hover { color:#0f4db3; }

    @keyframes fadeIn {
        from { opacity:0; transform:translateY(25px); }
        to { opacity:1; transform:translateY(0); }
    }
</style>

</head>
<body>

    <!-- Floating Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <!-- Form Card -->
    <div class="form-card">
        <h2>Add Stock</h2>

        <form action="addStock" method="post">
            <label>Enter Stock:</label>
            <input type="text" name="stock" required>
            <input type="submit" value="Add Stock">
        </form>

        <a href="home">← Back to Home</a>
    </div>

</body>
</html>
