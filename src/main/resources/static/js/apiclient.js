var apiclient = (function () {
    var appUrl = "http://localhost:8080/CoronaVirus/countries";
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
        }
		
        
    };
})();