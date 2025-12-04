<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto - Order Details</title>

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

    .card {
        background: rgba(255, 255, 255, 0.15);
        padding: 40px 50px;
        border-radius: 20px;
        backdrop-filter: blur(12px);
        box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
        animation: slideUp 1.2s ease-out;
        width: 350px;
    }

    h3 {
        text-align: center;
        color: white;
        font-size: 28px;
        margin-bottom: 25px;
        text-shadow: 0px 0px 8px rgba(255,255,255,0.3);
    }

    input[type="text"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 15px;
        border-radius: 10px;
        border: none;
        outline: none;
        font-size: 15px;
        background: rgba(255,255,255,0.8);
        transition: 0.3s;
    }

    input[type="text"]:focus {
        transform: scale(1.03);
        box-shadow: 0px 0px 8px rgba(255,255,255,0.8);
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        font-size: 18px;
        background: #ff2e63;
        border: none;
        border-radius: 40px;
        color: #fff;
        cursor: pointer;
        transition: 0.3s;
        box-shadow: 0px 6px 15px rgba(255, 46, 99, 0.4);
    }

    input[type="submit"]:hover {
        background: #ff174f;
        transform: scale(1.05);
    }

    label {
        color: white;
        font-weight: 500;
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

<div class="card">
    <h3>Order Details</h3>

    <form action="placeOrder" method="post">
        <label>Item Name</label>
        <input type="text" name="item" required>

        <label>Qty</label>
        <input type="text" name="qty" required>

        <label>Price</label>
        <input type="text" name="price" required>

        <label>Address</label>
        <input type="text" name="address" required>

        <input type="submit" value="Place Order">
    </form>
</div>

</body>
</html>
