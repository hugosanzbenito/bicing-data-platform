var stations_data;
var local_ip;

function get_stations() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var obj = JSON.parse(xmlhttp.responseText);
            stations_data = obj;

            var table = "<table border='1' style='border-collapse: collapse; width: 100%;'>";
            table += "<tr style='background-color: #007bff; color: white;'>";
            table += "<th>Station ID</th><th>Bikes Available</th><th>Docks Available</th><th>Charging Station</th><th>Status</th></tr>";

            for (let i = 0; i < obj.data.stations.length; i++) {
                var current_object = obj.data.stations[i];
                table += "<tr>";
                table += "<td>" + current_object.station_id + "</td>";
                table += "<td>" + current_object.num_bikes_available + "</td>";
                table += "<td>" + current_object.num_docks_available + "</td>";
                table += "<td>" + (current_object.is_charging_station ? "Yes" : "No") + "</td>";
                table += "<td>" + current_object.status + "</td>";
                table += "</tr>";
            }

            table += "</table>";

            document.getElementById("show-stations").innerHTML = table;
        }
    };
    xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
    xmlhttp.send();
}

/*
function get_stations2(){
	var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("show-stations").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
		xmlhttp.send();
}

function get_stations3() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var obj = JSON.parse(xmlhttp.responseText);
			stations_data = obj;
			var current_object;
			var message = ""
			let num = 1;
			var id = "station" + num
			for (let i = 0; i < obj.data.stations.length; i++){
				current_object = obj.data.stations[i]
				console.log(current_object)
				message += '<input type="checkbox" id="'+id+'" name="'+id+'" value="'+id+'"><label for="'+id+'">'
				message += "Station " + current_object.station_id + " has " + current_object.num_bikes_available + " bikes available and " + current_object.num_docks_available + " docks available. ";
				if (current_object.is_charging_station) {
					message += "It is a charging station. "
				} else {
					message += "It is not a charging station. "
				}
				message += current_object.status + "</label><br>";
			}
			document.getElementById("show-stations").innerHTML = message;
			// document.getElementById("show-stations").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
	xmlhttp.send();
}
*/
function get_clients() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var obj = JSON.parse(xmlhttp.responseText);
			clients_data = obj;
			var current_object;
			var message = ""
			for (let i = 0; i < clients_data.length; i++){
				current_object = clients_data[i]
				console.log(current_object)
				message += "Client " + current_object.id + " with name " + current_object.name + " and phone " + current_object.phone + " is subscribed to stations:<br>";
				for (let j = 0; j < current_object.stations.length; j++){
					message += "Station " + current_object.stations[j].station_id + ", ";
				}
				message += "<br>";
			}
			document.getElementById("show-stations").innerHTML = message;
			// document.getElementById("show-stations").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "/at-lab-0.1/at/clients", true);
	xmlhttp.send();
}

function get_air_quality(){
	var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var air_quality = JSON.parse(xmlhttp.responseText);
				var message = "Air quality is ";
				if (air_quality.aqi <= 50){
					message += "good"
				} else if (air_quality.aqi <= 100) {
					message += "moderate"
				} else if (air_quality.aqi <= 150) {
					message += "unhealthy for sensitive groups"
				} else if (air_quality.aqi <= 200) {
					message += "unhealthy"
				} else if (air_quality.aqi <= 300) {
					message += "very unhealthy"
				} else {
					message += "hazardous"
				}
				
				message += " (" + air_quality.aqi + ")";
				console.log(message)
				document.getElementById("show-air_quality").innerHTML = message;
			}
		};
		xmlhttp.open("GET", "/at-lab-0.1/at/notifications/airquality?ip="+local_ip, true);
		xmlhttp.send();
}



function get_public_ip(){
	console.log("Getting ip for geolocalizated WAQI")
	/*
	var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var obj = JSON.parse(xmlhttp.responseText);
				local_ip = obj.ip
				console.log(local_ip)
				
		};
		xmlhttp.open("GET", "https://api64.ipify.org?format=json", true);
		xmlhttp.send();
	}
	*/
	fetch('https://api64.ipify.org?format=json').then((response) => response.json()).then((responseJson)=> {
		local_ip = responseJson.ip;
	}).catch((error)=>{
		console.log(error);
	})
}	

function test(){
	console.log("test")
}
window.onload = get_public_ip;
		
		
		
		
		
		
		
		