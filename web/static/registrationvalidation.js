/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validate(){
        console.log("test");
        var uName=document.reg.uname.value;
        var fName=document.reg.name.value;
        var lName=document.reg.lname.value;
        var dateOB=document.reg.dob.value;
        var panNo=document.reg.panno.value;
        var accNo=document.reg.accno.value;
        var bName=document.reg.bname.value;
        var addr=document.reg.bbranch.value;
        var pNo=document.reg.pno.value;
        var phone=document.reg.num.value;
        var phone2=document.reg.num2.value;
        var pwd=document.reg.pswd.value;
        var pwd2=document.reg.pswd2.value;
        var reg = /^\d+$/;
        var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        if(uName==""|| phone2=="" || phone=="" || fName=="" || lName == "" || dateOB==""|| panNo==""|| accNo==""|| bName==""|| addr==""|| pNo==""|| pwd=="" || pwd2==""){
            alert("please enter all details");
            return false;
        }
        if(!re.test(uName)){
            alert("Please provide a proper email ");
            // write code to empry password box
            return false;
        }
        if(pwd != pwd2){
            alert("Password Mismatch. Type password");
            // write code to empry password box
            return false;
        }
        if(!reg.test(accNo)){
            alert("Please type 16 digit account number");
            return false;
        }
        if(!reg.test(phone) || phone.length != 10){
            alert("Please type 10 dight phone number");
            return false;
        }
        if(phone2.length != 0){
            if(!reg.test(phone2) || phone.length != 10){
                alert("Please type 10 dight alternate phone number");
                return false;
            }
        }
        
        return true;
}