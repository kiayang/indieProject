<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
            margin-bottom: 0;
            border-radius: 0;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
            padding-top: 20px;
            background-color: #86a4f1;
            height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
            background-color: #1d1d1d;
            color: white;
            padding: 15px;
            }

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
        .sidenav {
        height: auto;
        padding: 15px;
        }
        .row.content {height:auto;}
        }
        .navbar-inverse .navbar-header .navbar-brand {
        color: #d3e9fc;
        }

        .button {
        background-color: #cbeed4;
        border: none;
        border-radius: 12px;
        color: #0a0a0a;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        width: 50%;
        }

        .button:hover {
        background-color: #7ad357;
        color: red;
        }

        input[type=text], [type=email], [type=number], [type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border: none;
        background-color: #c8d3c3;
        color: #1d1d1d;
        }
</style>

