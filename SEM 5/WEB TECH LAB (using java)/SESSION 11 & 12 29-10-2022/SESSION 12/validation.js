

const dict = {};
document.querySelector(".reg_submit").addEventListener("click",store_data);
document.querySelector(".reg_submit").addEventListener("click",aftersubmit);
document.querySelector(".login_submit").addEventListener("click", login_ver);

document.querySelector("#reg").addEventListener('click',function()
{
      document.querySelector(".reg_cont").style.display = 'block';
      document.querySelector(".login_cont").style.display = 'none';
      
});



document.querySelector("#log").addEventListener('click', function () {
      document.querySelector(".reg_cont").style.display = 'none';
      document.querySelector(".login_cont").style.display = 'block';
});



function store_data()
{
      dict["name"]=document.querySelector("#name").value;
      dict["mobile"]=document.querySelector("#mobile").value;
      dict["email"] = document.querySelector("#email").value;
      dict["address"] = document.querySelector("#address").value;
      dict["city"] = document.querySelector("#city").value;
      dict["state"] = document.querySelector("#state").value;
      dict["pincode"] = document.querySelector("#pincode").value;
      dict["dob"] = document.querySelector("#dob").value;
      dict["gender"] = document.querySelector("#gender").value;
      dict["username"] = document.querySelector("#uname").value;
      dict["password"] = document.querySelector("#password").value;
      dict["confirm_password"] = document.querySelector("#confirm_password").value;
      console.log(dict);
}


function aftersubmit()
{
      if(dict["password"]!=dict["confirm_password"])
      {
            document.querySelector("#err_msg").innerHTML="Password Mismatch";
      }
      else{
      document.querySelector(".reg_cont").style.display = 'none';
      document.querySelector(".login_cont").style.display = 'block';}
}

function login_ver()
{
      if (((document.querySelector("#login_username").value == null)||(document.querySelector("#login_username").value != dict["username"]))) 
      {
            alert("Username mismastch");
      }
      if ((document.querySelector("#login_password").value == null)||(document.querySelector("#login_password").value != dict["password"])) {
            alert("PAssword mismastch");
      }
      else{
            alert("Successfully logged IN");
            document.querySelector(".reg_cont").style.display = 'none';
            document.querySelector(".login_cont").style.display = 'none';
            document.querySelector("#profile").style.display = 'block';
            document.querySelector("#catalog").style.display = 'block';
            document.querySelector("#cart").style.display = 'block';
            document.querySelector(".p_details").style.display = 'block';
            
      }
}



//user profile page
document.querySelector("#profile").addEventListener("click",Userdetails);
function Userdetails()
{
      document.querySelector(".p_name").innerHTML="Welcome "+dict["name"];
      document.querySelector(".p_mobile").innerHTML =dict["mobile"];
      document.querySelector(".p_email").innerHTML =dict["email"];
      document.querySelector(".p_address").innerHTML =dict["address"];
      document.querySelector(".p_city").innerHTML =dict["city"];
      document.querySelector(".p_pincode").innerHTML =dict["pincode"];
      document.querySelector(".p_dob").innerHTML =dict["dob"];
      document.querySelector(".p_gender").innerHTML =dict["gender"];   
}


document.querySelector("#catalog").addEventListener("click", function()
{
      document.querySelector(".catalog_details").style.display = 'block';
      document.querySelector(".p_details").style.display = 'none';
});



const cart={}

function cata(event)
{
      cart[event.id]=1;
      console.log(cart);
}

document.querySelector("#cart").addEventListener("click", crt);

function crt()
{
      alert("Clicked");

      for (var key in cart) {
            console.log(key, cart[key]);
            const child=document.querySelector(".cart");
            var node=document.createElement("li");
            var textnode=document.createTextNode(key+" -> "+cart[key]);
            node.appendChild(textnode);
            child.appendChild(node);
      }
      document.querySelector(".cart").style.display='block';
      document.querySelector(".catalog_details").style.display = 'none';
      document.querySelector(".p_details").style.display = 'none';
}
