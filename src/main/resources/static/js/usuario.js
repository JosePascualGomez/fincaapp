function listarUsuarios(){
    let urlA= urlApi() +"/User/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType:  "json",
        success: function(respuesta){
            console.log(respuesta);
            $("#listado").html("");
            pintarUsuarios(respuesta);
        },
        error:function(){
            console.log('error');
        }

    })
}

function pintarUsuarios(items){
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";
    
    myTable += "<th>Nombre</th>";
    myTable += "<th>eMail</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"
    
    for(i=0;i<items.length ;i++){
        //console.log(items[i]);
        //console.log(JSON.stringify(items[i]));
        myTable += "<tr>";
        myTable += "<td>"+items[i].name+"</td>";
        myTable += "<td>"+items[i].eMail+"</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarUsuario(' + items[i].id + ')">Eliminar</button>';
        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) +'" data-bs-title="Usuario">Actualizar</button> </td>';        
        myTable += "</tr>";        
    }
    myTable += "</tbody>";
    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarUsuario(){    
    let myData={
        name: $("#name").val(),
        eMail : $("#email").val(),
        password : $("#password").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA= urlApi() +"/User/save";
    $.ajax({
        url: urlA,
        type: "POST",
        dataType:  "json",
        data : dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function(respuesta){
            /*
            $("#listado").empty();
            $("#name").val(""),
            $("#email").val(""),
            $("#password").val("")
            listarUsuarios();
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


function actualizarUsuario(){    
    let myData={
        id: $("#m_id").val(),
        name: $("#m_name").val(),
        eMail : $("#m_email").val(),
        password : $("#m_password").val()
    };
    let dataToSend = JSON.stringify(myData);
    let urlA= urlApi() +"/User/update";
    $.ajax({
        url: urlA,
        type: "PUT",
        dataType:  "json",
        data : dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function(respuesta){
            window.location.reload();
            alert("Se actualizo correctamente");
        },
        error: function (textStatus) {
            alert("No se actualizo");
            console.log(textStatus)
        }
    })
}

function EliminarUsuario(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/User/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
        complete: function (repuesta) {
            /*
            $("#listado").empty();
            listarCategorias();
            */
           console.log("repuesta "+repuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (textStatus) {
            console.log("textStatus "+ textStatus);
        }
    })
}
