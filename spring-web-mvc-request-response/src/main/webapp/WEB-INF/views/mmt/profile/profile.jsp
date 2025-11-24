<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Profile - MMT</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(#00bcd4, #0288d1);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .form-card {
        background: white;
        width: 380px;
        padding: 35px;
        border-radius: 18px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.25);
        animation: fadeIn 0.8s ease-in-out;
    }

    h2 {
        text-align: center;
        color: #0288d1;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        color: #444;
        display: block;
        margin-bottom: 6px;
    }

    input[type=text] {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border-radius: 10px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    input[type=submit] {
        width: 100%;
        background: #0288d1;
        padding: 12px;
        border: none;
        border-radius: 10px;
        color: white;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        box-shadow: 0 5px 12px rgba(2,136,209,0.4);
        transition: 0.3s;
    }

    input[type=submit]:hover {
        background: #0277bd;
        transform: scale(1.03);
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>

</head>
<body>

    <div class="form-card">
        <h2>Create Your Profile</h2>

        <form action="createProfile" method="post">
            
            <label>First Name:</label>
            <input type="text" name="firstName" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" required>

            <label>Email Id:</label>
            <input type="text" name="email" required>

            <label>Mobile:</label>
            <input type="text" name="mobile" required>

            <input type="submit" value="Create Profile">
        </form>
    </div>

</body>
</html>
