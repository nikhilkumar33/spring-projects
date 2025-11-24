<html>
<head>
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

    .card {
        background: white;
        padding: 40px;
        border-radius: 15px;
        text-align: center;
        width: 350px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        animation: fadeIn 1s ease-in-out;
    }

    h2 {
        color: #0288d1;
        font-size: 26px;
        margin: 0 0 15px 0;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        background: #0288d1;
        padding: 12px 25px;
        color: white;
        text-decoration: none;
        font-weight: bold;
        border-radius: 10px;
        box-shadow: 0 5px 12px rgba(2,136,209,0.4);
        transition: 0.3s;
    }

    a:hover {
        background: #0277bd;
        transform: scale(1.05);
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>
</head>

<body>
    <div class="card">
        <h2>Welcome to MMT!</h2>
        <a href="showProfilePage">Create Profile</a>
    </div>
</body>
</html>
