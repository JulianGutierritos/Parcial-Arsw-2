var app = (function () {

    var getCountries = function (){
        table()
    }
  
    var table = function(countries) {
    console.log("entro");
    $("#countries").append(
        '<tr class="table-row"data-href="http://tutorialsplane.com"><td>lll</td><td>lll</td><td>lll</td><td>lll</td></tr>'
    )
    /*var i = 0;
    $("#blups").append(
    blueprintss.map(function(blueprint){
        i+= blueprint.points.length;
        return "<tr><td>" + blueprint.name + "</td><td>" + blueprint.points.length + "</td><td><button type='button' onclick='app.getp(\"" +blueprint.name + '" , "' + blueprint.author + "\")'>Open</button></td></tr>"
        })  
      );
      $("#total").text(i);*/
    }
  
  
    return{
        get : getCountries,
    };
  })();