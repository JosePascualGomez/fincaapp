function listarMensajes() {
    let urlA = urlApi() + "/Message/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $("#listado").html("");
            pintarMensajes(respuesta);
        },
        error: function () {
            console.log('error');
        }

    })
}

function pintarMensajes(items) {
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";
    myTable += "<th>Finca</th>";
    myTable += "<th>Cliente</th>";
    myTable += "<th>Texto del Mensaje</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i]?.farm?.name + "</td>";
        myTable += "<td>" + items[i]?.client?.name + "</td>";
        myTable += "<td>" + items[i].messageText + "</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarMensaje(' + items[i].idMessage + ')">Eliminar</button>';
        
        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) +'" data-bs-title="Mensaje">Actualizar</button> </td>';  


    }
    myTable += "</tbody>";
    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarMensaje() {
    var e = document.getElementById("combocliente");
    var client = e.options[e.selectedIndex].value;
    let myCli = { idClient: client };

    var f = document.getElementById("combofinca");
    var farm = f.options[f.selectedIndex].value;
    let myFarm = { id: farm };

    let myData = {
        client: myCli,
        farm: myFarm,
        messageText: $("#messageText").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Message/save";
    $.ajax({
        url: urlA,
        type: "POST",
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


function actualizarMensaje() {
    var e = document.getElementById("m_combocliente");
    var client = e.options[e.selectedIndex].value;
    let myCli = { idClient: client };

    var f = document.getElementById("m_combofinca");
    var farm = f.options[f.selectedIndex].value;
    let myFarm = { id: farm };

    let myData = {
        idMessage:$("#m_idMessage").val(),
        client: myCli,
        farm: myFarm,
        messageText: $("#m_messageText").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Message/update";
    $.ajax({
        url: urlA,
        type: "PUT",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
            window.location.reload();
            alert("Se guardo actualizo");
        },
        error: function (textStatus) {
            console.log(textStatus);
        }
    })
}

function EliminarMensaje(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Message/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data : dataToSend,*/
        complete: function (respuesta) {
            /*
            $("#listado").empty();
            $("#idMensaje").val(""),
            $("#textoMensaje").val("")
            listarMensajes();        
            */
            console.log("repuesta " + respuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (textStatus) {
            console.log("textStatus " + textStatus);
        }
    });
}
