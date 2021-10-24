function comboReserva() {
    let urlA = urlApi() + "/Farm/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function(respuesta) {
            console.log(respuesta);
            $("#farm").html("");
            let myselect = '<select class="form-select" id="comboReserva" required>';
            myselect +='<option></<option>';
            for (i = 0; i < respuesta.length; i++) {
                myselect += "<option value=" + respuesta[i].idReservation + ">" + respuesta[i].name + "</option>";
            }
            myselect += "</select >";
            myselect += '<label for="comboReserva">Reserva</label>';
            $("#farm").html(myselect);
        },
        error: function() {
            console.log('error');
        }

    })
}

function listarReservas(){
    let urlA= urlApi() +"/Reservation/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType:  "json",
        success: function(respuesta){
            console.log(respuesta);
            $("#listado").html("");
            pintarReservas(respuesta);
        },
        error:function(){
            console.log('error');
        }

    })
}

function pintarReservas(items){
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";
    myTable += "<th>Id</th>";
    myTable += "<th>Finca</th>";
    myTable += "<th>Inicio</th>";
    myTable += "<th>Final</th>";
    myTable += "<th>Id Cliente</th>";
    myTable += "<th>Nombre Cliente</th>";
    myTable += "<th>eMail Cliente</th>";
    myTable += "<th>Calificación</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"
    for(i=0;i<items.length ;i++){
        var score = (items[i]?.score)==null?"":items[i]?.score;
        var eMail = (items[i]?.client?.email)==null?"":items[i]?.client?.email;        
        myTable += "<tr>";
        myTable += "<td>"+items[i].idReservation+"</td>";
        myTable += "<td>"+items[i]?.farm?.name+"</td>";
        myTable += "<td>"+formatDate(items[i].startDate)+"</td>";
        myTable += "<td>"+formatDate(items[i].devolutionDate)+"</td>";
        myTable += "<td>"+items[i]?.client?.idClient+"</td>";        
        myTable += "<td>"+items[i]?.client?.name+"</td>";
        myTable += "<td>"+eMail+"</td>";
        myTable += "<td>"+score+"</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarReserva(' + items[i].idReservation + ')">Eliminar</button>';
        
        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) +'" data-bs-title="Reserva">Actualizar</button> </td>';  


    }
    myTable += "</tbody>";
    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarReserva(){    
    var e = document.getElementById("combocliente");
    var client = e.options[e.selectedIndex].value;
    let myCli={idClient: client};

    var f = document.getElementById("combofinca");
    var farm   = f.options[f.selectedIndex].value;
    let myFarm = {id: farm};

    let myData={
        client:myCli,
        farm:myFarm,
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val()        
    };
    let dataToSend = JSON.stringify(myData);
    let urlA= urlApi() +"/Reservation/save";
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

function actualizarReserva(){    
    var e = document.getElementById("m_combocliente");
    var client = e.options[e.selectedIndex].value;
    let myCli={idClient: client};

    var f = document.getElementById("m_combofinca");
    var farm   = f.options[f.selectedIndex].value;
    let myFarm = {id: farm};

    let myData={
        idReservation: $("#m_idReservation").val(),
        client:myCli,
        farm:myFarm,
        startDate: $("#m_startDate").val(),
        devolutionDate: $("#m_devolutionDate").val()        
    };
    let dataToSend = JSON.stringify(myData);
    let urlA= urlApi() +"/Reservation/update";
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
            console.log(textStatus);
        }
    })
}

function EliminarReserva(id){
    /*
    let myData={
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    */
    let urlA = urlApi() + "/Reservation/delete/" + id;    
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType:  "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
        complete: function (repuesta) {
            /*
            $("#combofinca").val(""),
            $("#combocliente").val(""),
            $("#startDate").empty();
            $("#devolutionDate").val("")
            listarReservas();
            */
           console.log("repuesta "+repuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (textStatus) {
            console.log("textStatus "+ textStatus);
        }
    });
}

