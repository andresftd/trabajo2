function validarInformacion() {
    var v1 = parseInt(document.getElementById("c1").value);
    var v2 = parseInt(document.getElementById("c2").value);

    console.log(isNaN(v1));
    console.log(isNaN(v2));



    if (isNaN(v1) || isNaN(v2)) {

        alert("¡Por favor ingrese datos validos!");
        return false;
    } else {
        return true;
    }
}


function validarPunto1() {
    var v1 = parseInt(document.getElementById("numero").value);

    console.log(isNaN(v1));



    if (isNaN(v1)) {

        alert("¡Por favor ingrese datos validos!");
        return false;
    } else {
        return true;
    }
}
