<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>

<body style="margin:0; padding:0; font-family:Arial; background:#f0f4ff;">

<div style="
    width:100%;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
">

    <div style="
        background:white;
        padding:40px;
        width:350px;
        border-radius:10px;
        box-shadow:0 4px 20px rgba(0,0,0,0.2);
        text-align:center;
    ">

        <h2 style="margin-bottom:20px; color:#2a2a72;">Register</h2>

        <form action="register" method="post">

            <input type="text" name="name" placeholder="Full Name" required
            style="width:100%; padding:12px; margin:10px 0; border:1px solid #ccc; border-radius:5px;">

            <input type="email" name="email" placeholder="Email" required
            style="width:100%; padding:12px; margin:10px 0; border:1px solid #ccc; border-radius:5px;">

            <input type="text" name="phone" placeholder="Phone Number" required
            style="width:100%; padding:12px; margin:10px 0; border:1px solid #ccc; border-radius:5px;">

            <input type="password" name="password" placeholder="Password" required
            style="width:100%; padding:12px; margin:10px 0; border:1px solid #ccc; border-radius:5px;">

            <button type="submit"
                style="
                    width:100%;
                    padding:12px;
                    background:#6a5acd;
                    color:white;
                    border:none;
                    border-radius:8px;
                    font-size:16px;
                    margin-top:15px;
                    cursor:pointer;
                    transition:0.3s;
                "
                onmouseover="this.style.background='#483d8b'"
                onmouseout="this.style.background='#6a5acd'">
                Register
            </button>

        </form>

        <p style="margin-top:15px; color:#555;">
            Already have an account?
            <a href="login" style="color:#6a5acd; text-decoration:none;">Login</a>
        </p>
    </div>
</div>

</body>
</html>
