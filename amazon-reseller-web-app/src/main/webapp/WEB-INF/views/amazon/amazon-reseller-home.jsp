<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amazon Reseller - Home</title>

<style>
    body {
        margin:0;
        padding:0;
        font-family:Arial, sans-serif;
        height:100vh;
        background: linear-gradient(135deg,#232f3e,#485769);
        display:flex;
        justify-content:center;
        align-items:center;
        overflow:hidden;
        color:white;
        position: relative;
    }

    /* Floating glowing orbs */
    .orb {
        position: absolute;
        border-radius: 50%;
        filter: blur(80px);
        opacity: 0.25;
        animation: float 15s infinite ease-in-out;
    }
    .orb1 { width:250px; height:250px; top:10%; left:15%; background: rgba(255,202,82,0.25); animation-duration:16s; }
    .orb2 { width:180px; height:180px; bottom:15%; right:10%; background: rgba(26,115,232,0.2); animation-duration:18s; }
    .orb3 { width:220px; height:220px; top:20%; right:20%; background: rgba(52,168,83,0.15); animation-duration:20s; }

    @keyframes float {
        0% { transform: translateY(0px) translateX(0px); }
        50% { transform: translateY(-40px) translateX(20px); }
        100% { transform: translateY(0px) translateX(0px); }
    }

    /* Dashboard Card */
    .card {
        background:white;
        width:450px;
        padding:35px;
        border-radius:18px;
        text-align:center;
        box-shadow:0 12px 30px rgba(0,0,0,0.3);
        color:#232f3e;
        animation:fadeIn 0.7s ease-in-out;
        position: relative;
        z-index: 10;
    }

    @keyframes fadeIn {
        from { opacity:0; transform:translateY(25px); }
        to { opacity:1; transform:translateY(0); }
    }

    /* Buttons hover effect */
    a:hover { transform:scale(1.05); }

</style>
</head>

<body>

    <!-- Floating Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <!-- Dashboard Card -->
    <div class="card">
        <h1 style="font-size:28px; margin:0 0 10px 0;">
            <span style="color:#232f3e;">Amazon</span>
            <span style="color:#ff9900;">Reseller</span>
        </h1>

        <p style="color:#555; font-size:16px; margin-bottom:25px;">
             Hello ${name} ! Welcome to your Amazon Reseller Dashboard!
        </p>

        <div style="display:flex; flex-direction:column; gap:15px;">
            <a href="createStockPage" style="padding:12px; background:#ff9900; color:white; text-decoration:none; font-size:16px; font-weight:bold; border-radius:10px; box-shadow:0 6px 15px rgba(255,153,0,0.4); transition:0.3s;">
                ➕ Create Stock
            </a>

            <a href="updateStockPage" style="padding:12px; background:#1a73e8; color:white; text-decoration:none; font-size:16px; font-weight:bold; border-radius:10px; box-shadow:0 6px 15px rgba(26,115,232,0.4); transition:0.3s;">
                ✏ Update Stock
            </a>

            <a href="deleteStockPage" style="padding:12px; background:#d93025; color:white; text-decoration:none; font-size:16px; font-weight:bold; border-radius:10px; box-shadow:0 6px 15px rgba(217,48,37,0.4); transition:0.3s;">
                🗑 Delete Stock
            </a>

            <a href="viewStockPage" style="padding:12px; background:#34a853; color:white; text-decoration:none; font-size:16px; font-weight:bold; border-radius:10px; box-shadow:0 6px 15px rgba(52,168,83,0.4); transition:0.3s;">
                👁 View Stock
            </a>
        </div>
    </div>

</body>
</html>
