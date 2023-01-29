<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Ragisteration Form</title>
        <style>
        *{
    margin: 0;
    padding:0;
}
body{
    background-image:url(http://sciencestudent.in/wp-content/uploads/2022/12/airplane-g0ba3435a3_1920-1.jpg);
    
}
div.main{
    width:500px;
    margin:100px auto 0px auto;

}
h2{
    text-align:center;
    padding:20px;
    font-family:sans-serif;
    font-size:200%;

}
div.register{
    background-color:whitesmoke;
    width:780px;
    height: 650px;
    font-size:18px;
    border-radius:0px;
    border:1px solid white;
    box-shadow:2px 2px 15px
    rgba(0,0,0,0.3);
    color:black;
    margin:auto;
    margin-top: 50px;
    
}
form#register{
    margin:40px;
   
}
div.inputs{
    display:flex;
    justify-content:space-between;
    flex-direction:row;
    flex-wrap:wrap;
}
label{
    font-family:sans-serif;
    font-size:18px;
    font-style:normal;
}
input#name{
    padding:12px;
    width:300px;
    margin:15px;
    margin-left: -3px;
    border:1px solid black;
    outline:none;
    border-radius:20px;
}
#submit{
    padding:12px 30px;
    width:40%;
    margin-top:30px;
    margin-bottom: 10px;
    
    background-color:black;
    color:white;
    font-weight:bolder;
    border:none;
    outline:none;
    border-radius:20px;
    
    

}
#submit:hover{
    cursor:pointer;
    background-color:rgba(0, 162, 255, 0.507);
  }
.center{
    display: flex;  
justify-content: center;  
align-items: center;  
}
 label,span,h2{
    text-shadow:1px 1px 5px rgba(0,0,0,0.3);
 }
        </style>
    </head>

<body>
    <div class="form">
        <div class="register">
            <h2>Register Here</h2>
            <form id="register" action="registeruser" method="post">
            <div class="inputs">
            <div id="1">
                <label>First Name:</label>
                <br>
                <input type="text" name="fname"
                id="name" placeholder="Enter Your First Name" required>
                <br>
            </div>
            <div id="2">
                <label>Last Name:</label>
                <br>
                <input type="text" name="lname" id="name" placeholder="Enter Your Last Name" required>
                <br>
            </div>
            <div id="3">
                <label>D.O.B</label>
                <br>
                <input type="date" name="dob" id="name" value="" min="1990-01-01" max="2023-12-31" placeholder="Date Of Birth" required>
                <br>
            </div>
            <div id="4">
                <label>Your Age:</label>
                <br>
                <input type="number" name="age"id="name"placeholder="age" required>
                <br>
            </div>
            <div id="5">
                <label>Email:</label>
                <br>
                <input type="email" name="email"id="name"placeholder="Enter your valid Email" required>
                <br>
            </div>
            <div id="6">
                <label>Mobile no.:</label>
                <br>
                <input type="number" placeholder="**********" name="phone"id="name" required>
                <br>
            </div>
            <div id="7">
                <label>Password:</label>
                <br>
                <input type="text" placeholder="password" name="password"id="name" required>
                <br>
                
            </div>
            <div id="8">
                <label>Confirm Password:</label>
                <br>
                <input type ="password" placeholder=" confirm password"name="co-password"id="name" required>
            </div>
            </div>
            <br>
            <div id="9">
                <label>Gender :   </label>
            
                <input type="radio"name="gender" value="male"id="male" required>
                <span id="male">Male</span>
                <input type="radio" name="gender" value="female" id="female">
                <span  id="female">Female</span>
            
            </div>
        <div class="center">
            <input type="submit" value="SUBMIT"id="submit">
        </div>
        <div class="center" style="font-size: 15px;">
        <a href="login.jsp" >Login here</a>
        </div>
        </form>
    </div><!--end register-->
    </div><!--end main-->
</body>
</html>