
function comboCategoria() {
    comboCategoria1("#category", "combocategory", "");
}

function comboCategoriaModal(opcion) {
    comboCategoria1("#m_category", "m_combocategory", opcion);
}

function comboCategoria1(idDiv, idSelect, opcion) {
    let urlA = urlApi() + "/Category/all";
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
            myselect += '<label for="' + idSelect + '">Categoría</label>';
            $(idDiv).html(myselect);
        },
        error: function () {
            console.log('error');
        }

    })
}

function listarCategorias() {
    let urlA = urlApi() + "/Category/all";
    $.ajax({
        url: urlA,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $("#listado").html("");
            pintarCategorias(respuesta);
        },
        error: function () {
            console.log('error');
        }

    })
}

function pintarCategorias(items) {
    /*
    let myTable = '<table  class="table caption-top table-bordered">';
    myTable += "<caption>Listado de Categorias</caption>"
    */
    let myTable = '<table class="table table-bordered">';
    myTable += '<thead class="table-dark">';
    myTable += "<tr>";
    myTable += "<th>Nombre</th>";
    myTable += "<th>Descripcion</th>";
    myTable += "<th>Acciones</th>";
    myTable += "</tr>";
    myTable += "</thead><tbody>"
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += '<td>';
        myTable += '<button class="btn btn-danger btn-sm" onclick="EliminarCategoria(' + items[i].id + ')">Eliminar</button>';

        myTable += '<button class="btn btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#ModalEstatico" data-bs-id="' + escape(JSON.stringify(items[i])) + '" data-bs-title="Categoria">Actualizar</button> </td>';
        myTable += "</tr>";
    }
    myTable += "</tbody>";

    myTable += "</table>";
    $("#listado").html(myTable);
}

function guardarCategoria() {
    let myData = {
        name: $("#name").val(),
        description: $("#description").val()

    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Category/save";
    $.ajax({
        url: urlA,
        type: "POST",
        dataType: "json",
        data: dataToSend,
        contentType: "application/json; charset=utf-8",
        complete: function (respuesta) {
            /*
            $("#listado").empty();
            $("#name").val(""),
            $("#description").val("")
            listarCategorias();*/
            window.location.reload();
            alert("Se guardo correctamente");
        },
        error: function (textStatus) {
            alert("No se guardo correctamente");
            console.log(textStatus)
        }
    })
}

function actualizarCategoria() {
    let myData = {
        id: $("#m_id").val(),
        name: $("#m_name").val(),
        description: $("#m_description").val()

    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Category/update";
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
            alert("No se actualizo");
            console.log(textStatus)
        }
    })
}

function EliminarCategoria(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Category/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        complete: function (repuesta) {
            console.log("repuesta " + repuesta);
            window.location.reload();
            alert("Se elimino correctamente");
        },
        error: function (textStatus) {
            console.log("textStatus " + textStatus)            
        }
    });
}

function EliminarCategoriaiNI(id) {
    let myData = {
        id: id
    };
    let dataToSend = JSON.stringify(myData);
    let urlA = urlApi() + "/Category/delete/" + id;
    $.ajax({
        url: urlA,
        type: "DELETE",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        /*data: dataToSend,*/
    })
        .done(function () {
            /*
            $("#listado").empty();
            listarCategorias();
            */
            window.location.reload();
            alert("Se elimino correctamente");
        }).fail(function () {
            alert("No se elimino");
        }).always(function (msg) {
            console.log('ALWAYS');
        });
}