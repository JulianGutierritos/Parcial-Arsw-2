var apiclient = apiclient;
var app = (function () {

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
            '<tr class="table-row" onclick="app.prueba(\'' + row.nombre +  '\')"><td>'+ row.nombre + '</td><td>' + row.numDeaths + '</td><td>' + row.numInfected + '</td><td>' + row.numCured + '</td></tr>'
        );
    }

    var prueba = function(val){
        console.log(val);
    }

    
    return{
        getCountries : getCountries, 
        prueba : prueba
    };
  })();