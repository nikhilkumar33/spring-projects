<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product - Amazon Reseller</title>

<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #232f3e, #485769);
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
    }

    /* Floating Lights */
    .orb {
        position: absolute;
        width: 200px;
        height: 200px;
        border-radius: 50%;
        filter: blur(90px);
        opacity: 0.25;
        animation: float 14s infinite ease-in-out;
    }

    .orb1 { background: rgba(255,202,82,0.25); top: 10%; left: 15%; }
    .orb2 { background: rgba(26,115,232,0.25); bottom: 12%; right: 10%; }
    .orb3 { background: rgba(52,168,83,0.18); top: 25%; right: 22%; }

    @keyframes float {
        0% { transform: translateY(0px); }
        50% { transform: translateY(-40px); }
        100% { transform: translateY(0px); }
    }

    .container {
        background: white;
        width: 480px;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 12px 30px rgba(0,0,0,0.3);
        animation: fadeIn 0.8s ease-out;
        position: relative;
        z-index: 10;
        text-align: center;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(25px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h2 {
        margin-bottom: 25px;
        color: #232f3e;
        font-size: 30px;
        font-weight: 700;
    }

    .highlight {
        color: #ffca52;
    }

    label {
        display: block;
        text-align: left;
        margin: 15px 0 5px;
        font-weight: 600;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 12px;
        border-radius: 12px;
        border: 1.5px solid #ccc;
        font-size: 15px;
        transition: 0.3s ease;
    }

    input[type="text"]:focus {
        border-color: #1a73e8;
        box-shadow: 0 0 10px rgba(26,115,232,0.35);
        outline: none;
    }

    input[type="submit"] {
        margin-top: 25px;
        width: 100%;
        padding: 14px;
        border: none;
        border-radius: 12px;
        background: linear-gradient(135deg, #ffca52, #ffb020);
        color: #232f3e;
        font-size: 18px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s ease;
        box-shadow: 0 8px 20px rgba(255,200,77,0.45);
    }

    input[type="submit"]:hover {
        transform: scale(1.05) translateY(-3px);
        box-shadow: 0 12px 28px rgba(255,200,77,0.6);
    }

    a {
        display: inline-block;
        margin-top: 20px;
        font-size: 15px;
        color: #1a73e8;
        font-weight: 600;
        text-decoration: none;
        transition: 0.3s;
    }

    a:hover { transform: translateX(-5px); }

</style>

</head>
<body>

    <!-- Background Orbs -->
    <div class="orb orb1"></div>
    <div class="orb orb2"></div>
    <div class="orb orb3"></div>

    <div class="container">
        <h2>Add <span class="highlight">Product</span></h2>

        <form action="addProduct" method="post">

            <label>Item Name:</label>
            <input type="text" name="itemName" required>

            <label>Item Description:</label>
            <input type="text" name="description" required>

            <label>Item Quantity:</label>
            <input type="text" name="quantity" required>

            <label>Item Price:</label>
            <input type="text" name="price" required>

            <input type="submit" value="Add Product">

        </form>

        <a href="home">← Back to Home</a>
    </div>

</body>
</html>
