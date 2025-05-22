
//----------------------------------------------------------
//textos iguales

    function compararCampos() {
    if (textField1.value == textField2.value) {
        ImagenCambio.src = "media/tick.png"; 
    } else {
        ImagenCambio.src = "media/cruz.png"; 
    }
    if (textField2.value == textField1.value) {
        ImagenCambio.src = "media/tick.png"; 
    } else {
        ImagenCambio.src = "media/cruz.png"; 
    }

}
textField1.addEventListener("keyup", compararCampos);
textField2.addEventListener("keyup", compararCampos);

//----------------------------------------------------------
//letras
var ContarLetrasTextField = document.getElementById("ContarLetrasTextField");
var contador = document.getElementById("contador");
var num = 0;

function añadirNumero() {
    if (ContarLetrasTextField.value.length >= 30) {
        ContarLetrasTextField.value = ContarLetrasTextField.value.substring(0, 30);
    }
    num = ContarLetrasTextField.value.length;
    contador.innerHTML = num;
}

ContarLetrasTextField.addEventListener("keyup", añadirNumero);

//----------------------------------------------------------
//raiz 
document.getElementById("botonCalcular").addEventListener("click", function () {
    calcularRaiz();
});

function calcularRaiz() {
    let input = document.getElementById("RaizCuadrada").value;
    let resultado = document.getElementById("resultado");
    
    let numero = parseFloat(input);
    resultado.textContent = Math.sqrt(numero).toFixed(2);
}

//----------------------------------------------------------
//Colores
document.getElementById("colorHeader").addEventListener("input", function () {
    document.getElementById("header").style.backgroundColor = this.value;
});

document.getElementById("colorFooter").addEventListener("input", function () {
    document.getElementById("footer").style.backgroundColor = this.value;
});

//----------------------------------------------------------
//Milktank
document.getElementById("altura").addEventListener("input", function() {
    document.getElementById("imagen").style.height = this.value + "px";
});

document.getElementById("ancho").addEventListener("input", function() {
    document.getElementById("imagen").style.width = this.value + "px";
});

//------------------------------------------------------------------
//café

/*
1
    Té = 2
    Café = 1
2
    Sin leche = 0
    Leche = 1
    Sin Lactosa = 2
3
    Sin extras = 0
    Churro = 1
    Porra = 3
4
    Vaso Propio = 0
    Vaso de plástico = 1
    De Cristal = 3
*/

document.querySelectorAll('input[type="radio"]').forEach(radio => {
    radio.addEventListener('change', () => {
        let precio = 0;

        if (document.getElementById("te").checked) {
            precio += 2; 
        } else if (document.getElementById("cafe").checked) {
            precio += 1; 
        }

        if (document.getElementById("sin_leche").checked) {
            precio += 0;
        } else if (document.getElementById("leche").checked) {
            precio += 1; 
        } else if (document.getElementById("sin_lactosa").checked) {
            precio += 2; 
        }

        if (document.getElementById("sin_extras").checked) {
            precio += 0; 
        } else if (document.getElementById("churro").checked) {
            precio += 1; 
        } else if (document.getElementById("porra").checked) {
            precio += 3; 
        }

        if (document.getElementById("vaso_propio").checked) {
            precio += 0;
        } else if (document.getElementById("vaso_plastico").checked) {
            precio += 1; 
        } else if (document.getElementById("cristal").checked) {
            precio += 3;
        }

        document.getElementById("precioMarcador").innerHTML =  precio;
    });
});



