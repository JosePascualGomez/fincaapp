
function comboFinca() {
    comboFinca1("#farm", "combofinca", "");
}

function comboFincaModal(opcion) {
    comboFinca1("#m_farm", "m_combofinca", opcion);
}

function comboFinca1(idDiv, idSelect, opcion) {
    let urlA = urlApi() + "/Farm/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $(idDiv).html("");
            let myselect = '<select class="form-select" id="' + idSelect + '" required>';
            myselect += '<option></<option>';
            for (i = 0; i < respuesta.length; i++) {
                selec = "";
                if (opcion == respuesta[i].id) {
                    selec = "selected";
                }
                myselect += "<option " + selec + " value=" + respuesta[i].id + ">" + respuesta[i].name + "</option>";

            }
            myselect += "</select >";
            myselect += '<label for="' + idSelect + '">Finca</label>';
            $(idDiv).html(myselect);
        },
        error: function () {
            console.log('error');
        }

    })
}

function listarFincas() {
    let urlA = urlApi() + "/Farm/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $("#listado").html("");
            pintarFincas(respuesta);
        },
        error: function () {
            console.log('error');
        }

    })
}

function pintarFincas(items) {
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";
    myTable += "<th>Nombre</th>";
    myTable += "<th>Dirección</th>";
    myTable += "<th>Exensión</th>";
    myTable += "<th>Categoria</th>";
    myTable += "<th>Descripcion</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"

    for (i = 0; i < items.length; i++) {
        nameCategory = items[i]?.category?.name == null ? "" : items[i].category?.name;
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].address + "</td>";
        myTable += "<td>" + items[i].extension + "</td>";
        myTable += "<td>" + nameCategory + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarFinca(' + items[i].id + ')">Eliminar</button>';
        
        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) +'" data-bs-title="Finca">Actualizar</button> </td>';    
        
    }
    myTable += "</tbody>";
    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarFinca() {
    var e = document.getElementById("combocategory");
    var category = e.options[e.selectedIndex].value;
    let myCate = { id: category };

    let myData = {
        name: $("#name").val(),
        address: $("#address").val(),
        extension: $("#extension").val(),
        category: myCate,
        description: $("#description").val()

    };
    let dataToSend = JSON.stringify(myData);

    let urlA = urlApi() + "/Farm/save";
    $.ajax({
        url: urlA,
        type: "POST",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
            /*
            $("#ListadoFinca").empty();
            $("#name").val(""),
            $("#address").val(""),
            $("#extension").val(""),
            $("#combocategory").val(""),
            $("#description").val("")
            listarFincas();
            */
            window.location.reload();
            alert("Se guardo correctamente");
        },
        error: function (textStatus) {
            alert("No se guardo correctamente");
            console.log(textStatus)
        }
    })
}

function actualizarFinca() {
    var e = document.getElementById("m_combocategory");
    var category = e.options[e.selectedIndex].value;
    let myCate = { id: category };

    let myData = {
        id:$("#m_id").val(),
        name: $("#m_name").val(),
        address: $("#m_address").val(),
        extension: $("#m_extension").val(),
        category: myCate,
        description: $("#m_description").val()

    };
    let dataToSend = JSON.stringify(myData);

    let urlA = urlApi() + "/Farm/update";
    $.ajax({
        url: urlA,
        type: "PUT",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
            window.location.reload();
            alert("Se guardo correctamente");
        },
        error: function (textStatus) {
            alert("No se guardo correctamente");
            console.log(textStatus)
        }
    })
}

function EliminarFinca(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Farm/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
        complete: function (repuesta) {
            /*
            $("#ListadoFinca").empty();
            $("#idFinca").val(""),
            $("#nameFinca").val(""),
            $("#addressFinca").val(""),
            $("#extensionFinca").val(""),
            $("#categoriaFinca").val("")
            listarFincas();
            */
            console.log("repuesta " + repuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (xhr, textStatus) {
            console.log("textStatus " + textStatus);
        }
    })
}

function EliminarFincas(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Farm/delete" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
    }).done(function () {
        /*
        $("#ListadoFinca").empty();
        $("#idFinca").val(""),
        $("#nameFinca").val(""),
        $("#addressFinca").val(""),
        $("#extensionFinca").val(""),
        $("#categoriaFinca").val("")
        listarFincas();
        */
        window.location.reload();
        alert("Se elimino correctamente");
    }).fail(function () {
        alert("No se elimino");
    }).always(function (msg) {
        console.log('ALWAYS');
    })
};