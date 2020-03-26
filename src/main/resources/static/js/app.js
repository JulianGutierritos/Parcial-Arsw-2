var apiclient = apiclient;
var app = (function () {
    var pais;

    var getCountries = function (){
        apiclient.getCountries(table);
    }
  
    var table = function(countries) {
        for (var i = 0, keys = Object.keys(countries), ii = keys.length; i < ii; i++) {
            appendTable(countries[keys[i]]);

        }
    }

    var appendTable = function(row){
        $("#countries").append(
            '<tr class="table-row" onclick="app.ventana(\'' + row.nombre +  '\')"><td>'+ row.nombre + '</td><td>' + row.numDeaths + '</td><td>' + row.numInfected + '</td><td>' + row.numCured + '</td></tr>'
        );
    }

    var ventana = function(row){
        localStorage.setItem('pais', row);
        window.open("/detalle.html","ventana1","width=500,height=500,scrollbars=NO");
    }

    var getDetalle = function(){
        apiclient.getCountry(detalle, localStorage.getItem('pais'));
    }

    var detalle = function(resp){
        $("#country").append('<tr class="table-row"><td>Num Deaths</td><td>'+ resp.numDeaths +'</td></tr>');
        $("#country").append('<tr class="table-row"><td>Num Infected</td><td>'+ resp.numInfected +'</td></tr>');
        $("#country").append('<tr class="table-row"><td>Num Cured</td><td>'+ resp.numCured +'</td></tr>');
        for (i = 0; i < resp.provincias.length ; i++){
            row = resp.provincias[i];
            $("#provinces").append(
                '<tr class="table-row" onclick="app.prueba(\'' + row.nombre +  '\')"><td>'+ row.nombre + '</td><td>' + row.numDeaths + '</td><td>' + row.numInfected + '</td><td>' + row.numCured + '</td></tr>'
            );
        }
    }

    var prueba = function(nombre){
        alert(nombre);
    }

    
    return{
        getCountries : getCountries, 
        ventana : ventana,
        getDetalle : getDetalle
    };
  })();