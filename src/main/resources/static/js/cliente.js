

function comboCliente() {
    comboCliente1("#client", "combocliente", "");
}

function comboClienteModal(opcion) {
    comboCliente1("#m_client", "m_combocliente", opcion);
}
function comboCliente1(idDiv, idSelect, opcion) {
    let urlA = urlApi() + "/Client/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $(idDiv).html("");
            let myselect = '<select class="form-select" id="' + idSelect + '" required>';
            myselect += '<option></<option>';
            for (i = 0; i < respuesta.length; i++) {
                selec = "";
                if (opcion == respuesta[i].idClient) {
                    selec = "selected";
                }
                myselect += "<option " + selec + " value=" + respuesta[i].idClient + ">" + respuesta[i].name + "</option>";
            }
            myselect += "</select >";
            myselect += '<label for="' + idSelect + '">Cliente</label>';

            $(idDiv).html(myselect);
        },
        error: function () {
            console.log('error');
        }

    })
}

function listarClientes() {
    let urlA = urlApi() + "/Client/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $("#listado").html("");
            pintarClientes(respuesta);
        },
        error: function () {
            console.log('error');
        }

    })
}

function pintarClientes(items) {
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";

    myTable += "<th>Nombre</th>";
    myTable += "<th>eMail</th>";
    myTable += "<th>Edad</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"

    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarCliente(' + items[i].idClient + ')">Eliminar</button>';

        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) + '" data-bs-title="Cliente">Actualizar</button> </td>';

        myTable += "</tr>";

    }
    myTable += "</tbody>";
    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarCliente() {
    let myData = {
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Client/save";
    $.ajax({
        url: urlA,
        type: "POST",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
                /*
                $("#listado").empty();
                $("#idCliente").val(""),
                $("#name").val(""),
                $("#email").val(""),
                $("#age").val(""),
                $("#password").val("")
                listarClientes();
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

function actualizarCliente() {
    let myData = {
        idClient: $("#m_idClient").val(),
        name: $("#m_name").val(),
        email: $("#m_email").val(),
        age: $("#m_age").val(),
        password: $("#m_password").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Client/update";
    $.ajax({
        url: urlA,
        type: "PUT",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
            window.location.reload();
            alert("Se actualizo correctamente");
        },
        error: function (textStatus) {           
            console.log(textStatus)
        }
    })
}


function EliminarCliente(id) {
    let urlA = urlApi() + "/Client/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        complete: function (repuesta) {
            /*
            $("#listado").empty();
            listarCategorias();
            */
            console.log("repuesta " + repuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (textStatus) {
            console.log("textStatus " + textStatus)
        }
    })
}

function EliminarClienteIni(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Client/delete";
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
    }).done(function (repuesta) {
        /*
        $("#listado").empty();
        $("#idCliente").val(""),
        $("#name").val(""),
        $("#email").val(""),
        $("#age").val("")
        listarClientes();
        */
        console.log("repuesta " + repuesta);
        window.location.reload();
        alert("Se elimino correctamente");
    })
        .error(function (textStatus) {
            console.log("textStatus " + textStatus)
            alert("No se elimino");
        });
}
