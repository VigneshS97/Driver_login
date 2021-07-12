/**
 * 
 */
 
 //load cookies if exist
window.onload = loadCookies;

function loadCookies() {
	
	//reduce the cookies from array to name and values
	var cookies = document.cookie
							.split(';')
							.map(cookie => cookie.split('='))
							.reduce((total, [key, value]) => ({...total, [key.trim()]: value}), {});
	
	//if cookies not present
	if(cookies.email  == undefined || cookies.pass == undefined) {
	    return false;
    }

	document.getElementById("driverLoginId").value = cookies.email;
									//password stored in cookie is base64 encoded
    document.getElementById("Password").value = window.atob(cookies.pass);    
	
	document.getElementById('rememberCheck').checked = true;
}
 
 
 
 //**FieldEmptyCheck--Starts**//
 function validation(){
 				/*header('Content-Type: application/javascript');*/
 
 var letters = /^[0-9a-zA-Z]+$/;
 if(document.getElementById('driverLoginId').value == undefined ||
 	 document.getElementById('driverLoginId').value == ''||
 	 document.getElementById("driverLoginId").value.length <9||
 	 document.getElementById("driverLoginId").value.length >10||
 	 !document.getElementById('driverLoginId').value.match(letters) ){
           alert('Please Fill Valid LoginId');
           return;
       }
       var pass = /^[0-9]+$/;
       if(document.getElementById("Password").value==undefined || 
       	document.getElementById("Password").value=="" || 
       	document.getElementById("Password").value.length <10||
       	!document.getElementById('Password').value.match(pass)){
           alert("Please File Valid Password");
           return;
       }
       
       

       

 //**FieldEmptyCheck--end **//
 

 
 
 
 
 
 
 
 
 
 //save cookies
function saveCookie() {
	
    //save cookies
	if(document.getElementById('rememberCheck').checked == true) {
        
        var d = new Date();
        d.setTime(d.getTime() + 24*60*60*1000);
        d.toUTCString();
		console.log($("#driverLoginId").val())
        document.cookie = "email="+$("#driverLoginId").val()+";"+ "expires="+d + ";path=/";
        document.cookie = "pass="+window.btoa($("#Password").val() ) +";"+ "expires="+d + ";path=/";

    }

	//delete cookies if remember me not checked
	else {
		document.cookie = "email=" +";"+ "expires="+ (new Date() - 24*60)  + ";path=/";
        document.cookie = "pass="+";"+ "expires="+(new Date() - 24*60) + ";path=/";
	}
	
}
 //save cookies end
 
 
 
 
   
       
       var formData = {
    		loginId : $("#driverLoginId").val(),
    		password :  $("#Password").val()
    	}
    	
       

var xhr = new XMLHttpRequest();
    xhr.open("POST", 'http://localhost:8083/authenticate', true);
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.send(JSON.stringify(formData));

 

    xhr.onreadystatechange = function() {
    	
    	if(xhr.readyState == 4 && xhr.status ==200) {
    		saveCookie();
    		window.location.href="notification.html";
    		
    	}
    	if(xhr.readyState == 4 && xhr.status == 401){
    	alert("Invalid User");
    	}
    }

 }
 
 
 
    
    function storeTokenInLocal(token){
    	return window.localStorage.setItem("token",token);
    	
    }
    
    function getTokenFromLocal(){
    	
    	return window.localStorage.getItem(token);
    	
    }
    
     
//    	let data= response.json();
//    	return data;
//    }
    
    