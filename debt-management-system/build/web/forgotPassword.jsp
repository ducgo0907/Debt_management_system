<!DOCTYPE html>
<html>
    <head>
        <title>Forgot password</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
            }

            .container {
                max-width: 500px;
                margin: 50px auto;
                padding: 20px;
                background-color: #f2f2f2;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            }

            h2 {
                margin-top: 0;
            }

            form label {
                display: block;
                margin-bottom: 10px;
            }

            input[type="email"],
            select,
            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 15px;
                border-radius: 4px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 16px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Forgot password</h2>
            <form action="forgot" method="POST">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Input email address">

                <label for="security-question">Secret Question:</label>
                <select id="security-question" name="secretQuestion">
                    <option value="0">--Question--</option>
                    <option value="1">Where do you from?</option>
                    <option value="2">What is your lover name?</option>
                    <option value="3">What is favorite animal?</option>
                </select>

                <label for="security-answer">Answer:</label>
                <input type="text" id="security-answer" name="answer" placeholder="Input your answer">

                <button type="submit">Send Request</button>
            </form>
        </div>
    </body>
</html>
