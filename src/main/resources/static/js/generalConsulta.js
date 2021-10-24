function urlApi() {
  return "http://168.138.146.59:81/api";
};
/*
#############################
##### Manejo de Fechas
##############################
*/
function formatDate(date) {
  var d = new Date(date),
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear();

  if (month.length < 2)
    month = '0' + month;
  if (day.length < 2)
    day = '0' + day;

  return [year, month, day].join('-');
};

/*
#############################
##### Funciones para el panel de navegacion
##############################
*/
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
};

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
};

/*
#############################
##### Funciones para el manejo de las validaciones
##############################
*/
function validacion() {
  'use strict'
  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')
  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
        form.classList.add('was-validated')
      }, false)
    })
}

/*
#############################
##### Permite controlar el modal
##############################
*/
function modal() {

  var exampleModal = document.getElementById('ModalEstatico')
    exampleModal.addEventListener('show.bs.modal', function (event) {
    // Button that triggered the modal
    var button = event.relatedTarget
    // Extract info from data-bs-* attributes
    //var recipient = button.getAttribute('data-bs-whatever')
    let obj = JSON.parse(unescape(button.getAttribute('data-bs-id')));
    var recipient = button.getAttribute('data-bs-title')
    // If necessary, you could initiate an AJAX request here
    // and then do the updating in a callback.
    //
    // Update the modal's content.
    var modalTitle = exampleModal.querySelector('.modal-title')
    modalTitle.textContent = 'Actualizando ' + recipient
    //var modalBodyInput = exampleModal.querySelector('.modal-body input')
    //var modalBodyInput = exampleModal.querySelector('.modal-body #id')
    //modalBodyInput.value = obj.id;
   
    var elements = document.querySelectorAll("#fModal input, #fModal textarea")
    for (var i = 0, element; element = elements[i++];) {
      for (var detalle in obj) {
        var campo = ("M_") + ((detalle).toUpperCase());
        //console.log("campo =" + campo +", Elemento = "+ element.id + " , valor=" +element.value);
        if(campo == element.id.toUpperCase()){
          element.value=obj[detalle];
          //console.log(element.id + " " +element.value);
        }
      }       
    }

    if (recipient=="Finca" ){
      comboCategoriaModal(obj.category.id);
    }

    /*
    var elements = document.querySelectorAll("#fModal select")
    for (var i = 0, element; element = elements[i++];) {
      for (var detalle in obj) {
        var campo = ("M_COMBO") + ((detalle).toUpperCase());
        if(campo == element.id.toUpperCase()){
          //element.selected =obj[detalle]; 
          //document.getElementById(element.id).getElementsByTagName('option')[obj[detalle]].selected = 'selected'    
          //element.value=(obj[detalle]);
          setSelectBoxByText(element.id ,obj[detalle]);

          //element.getElementsByTagName('option')[(obj[detalle])].selected = 'selected'       
        }
      }       
    }
  */
    

    //document.getElementById('personlist').getElementsByTagName('option')[11].selected = 'selected'
    /*
    if (recipient=="Categoria"){
      var modalBodyInput = exampleModal.querySelector('.modal-body #m_id')
      console.log(obj.id);
      modalBodyInput.value = obj.id;
      modalBodyInput = exampleModal.querySelector('.modal-body #m_name')
      modalBodyInput.value = obj.name;
      modalBodyInput = exampleModal.querySelector('.modal-body #m_description')
      modalBodyInput.value = obj.description;
    }
    */
    /*
    for (var detalle in obj) {
      console.log(detalle)
      console.log(obj[detalle])  
      for (var dato in obj[detalle]) {
        // console.log (obj[detalle][dato]); // Y aquí exploras cada dato del viaje
      }
    }
    */
  });
}

function setSelectBoxByText(eid, etxt) {
  var eid = document.getElementById(eid);
  for (var i = 0; i < eid.options.length; ++i) {
      if (eid.options[i].value === etxt)
          eid.options[i].selected = true;
  }
}