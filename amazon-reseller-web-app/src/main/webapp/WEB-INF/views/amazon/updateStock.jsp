<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Stock - Amazon Reseller</title>

<style>

    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', Arial, sans-serif;
        background: linear-gradient(135deg, #0f1111, #232f3e);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .card {
        background: #ffffff;
        width: 430px;
        padding: 35px;
        border-radius: 20px;
        text-align: center;
        box-shadow: 0 12px 30px rgba(0,0,0,0.35);
        animation: fadeIn 0.8s ease-in-out;
    }

    h2 {
        font-size: 26px;
        margin-bottom: 12px;
        font-weight: 700;
    }

    .title-amz {
        color: #232f3e;
    }

    .title-stock {
        color: #ff9900;
    }

    .stock-box {
        background: linear-gradient(135deg, #e8f1ff, #cfe0fc);
        padding: 14px;
        border-radius: 12px;
        color: #1a73e8;
        font-size: 19px;
        font-weight: bold;
        margin-bottom: 22px;
        box-shadow: 0 4px 18px rgba(26,115,232,0.3);
    }

    input[type="text"] {
        width: 100%;
        padding: 12px;
        border-radius: 10px;
        border: 1px solid #b3b3b3;
        font-size: 15px;
        margin-bottom: 18px;
        transition: 0.3s;
    }

    input[type="text"]:focus {
        border-color: #1a73e8;
        box-shadow: 0 0 6px rgba(26,115,232,0.4);
        outline: none;
    }

    input[type="submit"] {
        width: 100%;
        padding: 13px;
        background: linear-gradient(135deg, #1a73e8, #0c47a1);
        border: none;
        color: white;
        font-size: 17px;
        font-weight: bold;
        border-radius: 12px;
        cursor: pointer;
        box-shadow: 0 6px 18px rgba(26,115,232,0.5);
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        transform: scale(1.06);
        background: linear-gradient(135deg, #1669c1, #0b3a85);
    }

    .back-btn {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #d93025;
        font-weight: bold;
        font-size: 14px;
        transition: 0.3s;
    }

    .back-btn:hover {
        transform: translateX(-3px);
        color: #a3201b;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(25px); }
        to { opacity: 1; transform: translateY(0); }
    }

</style>

</head>

<body>

    <div class="card">

        <h2>
            <span class="title-amz">Update</span>
            <span class="title-stock">Stock</span>
        </h2>

        <div class="stock-box">
            📦 Current Stock: ${currStock}
        </div>

        <h3 style="color:#444; margin-bottom:15px;">Enter New Stock Value</h3>

        <form action="updateStock" method="post">
            <input type="text" name="stock" placeholder="Enter updated stock..." required>
            <input type="submit" value="Update Stock">
        </form>

        <a href="home" class="back-btn">← Back to Home</a>

    </div>

</body>
</html>