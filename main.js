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
                var s = obj.data.stations[i];
                table += `<tr>
                    <td>${s.station_id}</td>
                    <td>${s.num_bikes_available}</td>
                    <td>${s.num_docks_available}</td>
                    <td>${s.is_charging_station ? "Yes" : "No"}</td>
                    <td>${s.status}</td>
                </tr>`;
            }
            document.getElementById("show-stations").innerHTML = table;
        }
    };
    xmlhttp.open("GET", "/at/stations", true);
    xmlhttp.send();
}

function get_clients() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var clients_data = JSON.parse(xmlhttp.responseText);
            var message = "";
            for (let c of clients_data) {
                message += `Client ${c.id} (${c.name}, ${c.phone}) subscribed to stations: `;
                message += c.stations.map(s => s.station_id).join(', ') + "<br>";
            }
            document.getElementById("show-stations").innerHTML = message;
        }
    };
    xmlhttp.open("GET", "/at/clients", true);
    xmlhttp.send();
}

function get_air_quality() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var air_quality = JSON.parse(xmlhttp.responseText);
            var message = "Air quality is ";
            var aqi = air_quality.aqi;
            if (aqi <= 50) message += "good";
            else if (aqi <= 100) message += "moderate";
            else if (aqi <= 150) message += "unhealthy for sensitive groups";
            else if (aqi <= 200) message += "unhealthy";
            else if (aqi <= 300) message += "very unhealthy";
            else message += "hazardous";

            message += ` (${aqi})`;
            document.getElementById("show-air_quality").innerHTML = message;
        }
    };
    xmlhttp.open("GET", `/at/notifications/airquality?ip=${local_ip}`, true);
    xmlhttp.send();
}

function get_public_ip() {
    fetch('https://api64.ipify.org?format=json')
        .then(res => res.json())
        .then(json => { local_ip = json.ip; })
        .catch(err => console.log(err));
}

window.onload = get_public_ip;
