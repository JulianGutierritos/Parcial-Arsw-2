var apiclient = (function () {
    var appUrl = "https://julian-gutierrez-arsw2.herokuapp.com/CoronaVirus/countries";
    return {
    	
        getCountries: function (callback) {
        	jQuery.ajax({
        		url: appUrl,
        		type: "GET",
        		success: function(respuesta) {
        			callback(respuesta);
        		}
        	});
        },

        getCountry: function (callback, country) {
        	jQuery.ajax({
        		url: appUrl + "/" + country,
        		type: "GET",
        		success: function(respuesta) {
        			callback(respuesta);
        		}
        	});
        },

        getCoordenada: function (callback, country) {
        	jQuery.ajax({
        		url: appUrl + "/" + country + "/coordinate",
        		type: "GET",
        		success: function(respuesta) {
        			callback(respuesta);
        		}
        	});
        }
		
        
    };
})();