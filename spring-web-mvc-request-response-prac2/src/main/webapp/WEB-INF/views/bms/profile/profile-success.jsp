<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookMyShow – Profile Created</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: #f7f7f7;
    }

    /* Header */
    .header {
        background: #e91e63;
        padding: 18px;
        text-align: center;
        color: white;
        font-size: 32px;
        font-weight: bold;
        letter-spacing: 1px;
    }

    /* Success Message Section */
    .success-card {
        background: white;
        width: 420px;
        margin: 25px auto;
        padding: 25px;
        border-radius: 16px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        text-align: center;
    }

    .success-card h2 {
        margin: 0;
        color: #444;
        margin-bottom: 15px;
    }

    .userIdBox {
        background: #ffe4ec;
        padding: 12px;
        margin-top: 10px;
        border-radius: 10px;
        font-size: 20px;
        color: #e91e63;
        font-weight: 700;
    }

    /* Movie Grid */
    .movie-section-title {
        text-align: center;
        font-size: 28px;
        margin-top: 20px;
        color: #444;
    }

    .movies-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
        gap: 25px;
        padding: 20px 40px;
    }

    .movie-card {
        background: white;
        border-radius: 14px;
        overflow: hidden;
        box-shadow: 0 5px 18px rgba(0,0,0,0.15);
        text-align: center;
        transition: 0.3s;
    }

    .movie-card:hover {
        transform: scale(1.05);
    }

    .movie-card img {
        width: 100%;
        height: 300px;
        object-fit: cover;
    }

    .movie-title {
        font-size: 20px;
        font-weight: 600;
        padding: 10px;
        color: #333;
    }

    .book-btn {
        margin-bottom: 20px;
        padding: 10px 20px;
        background: #e91e63;
        color: white;
        border: none;
        border-radius: 25px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .book-btn:hover {
        background: #c2185b;
    }
</style>

</head>
<body>

    <!-- Header -->
    <div class="header">BookMyShow</div>

    <!-- Success Message -->
    <div class="success-card">
        <h2>Your profile is created successfully!</h2>
        <div>Your User ID:</div>
        <div class="userIdBox">${userId}</div>
    </div>

    <!-- Movie List -->
    <h2 class="movie-section-title">Now Showing 🎬</h2>

    <div class="movies-container">

        <!-- Movie 1 -->
        <div class="movie-card">
            <img src="https://i.ibb.co/6D0s6ts/kgf.jpg">
            <div class="movie-title">KGF: Chapter 2</div>
            <button class="book-btn">Book Now</button>
        </div>

        <!-- Movie 2 -->
        <div class="movie-card">
            <img src="https://i.ibb.co/QPsnwYp/jawan.jpg">
            <div class="movie-title">Jawan</div>
            <button class="book-btn">Book Now</button>
        </div>

        <!-- Movie 3 -->
        <div class="movie-card">
            <img src="https://i.ibb.co/VpVjN3p/avengers.jpg">
            <div class="movie-title">Avengers: Endgame</div>
            <button class="book-btn">Book Now</button>
        </div>

        <!-- Movie 4 -->
        <div class="movie-card">
            <img src="https://i.ibb.co/37pLyCh/pushpa.jpg">
            <div class="movie-title">Pushpa 2</div>
            <button class="book-btn">Book Now</button>
        </div>

    </div>

</body>
</html>
