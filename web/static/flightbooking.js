

function validateForm() {
    var radios = document.getElementsByName("flightSelected");
    var formValid = false;

    var i = 0;
    while (!formValid && i < radios.length) {
        if (radios[i].checked) formValid = true;
        i++;        
    }

    if (!formValid) alert("Must select some flight!");
    return formValid;
}