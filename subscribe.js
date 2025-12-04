var stations;

function load_stations() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var obj = JSON.parse(xmlhttp.responseText);
            stations = obj.data.stations;

            let tableHTML = `<table border="1" style="border-collapse: collapse; width: 100%; text-align: center;">
                <thead>
                    <tr style="background-color: #007bff; color: white;">
                        <th>Estación</th>
                        <th>Seleccionar</th>
                    </tr>
                </thead>
                <tbody id="stationsBody">`;

            stations.forEach(station => {
                let id = station.station_id;
                tableHTML += `<tr class="station-row">
                    <td>Estación ${id}</td>
                    <td><input type="checkbox" class="station-checkbox" value="${id}"></td>
                </tr>`;
            });

            tableHTML += "</tbody></table>";
            document.getElementById('stationsContainer').innerHTML = tableHTML;
        }
    };
    xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
    xmlhttp.send();
}

// No sobrescribir window.onload
window.addEventListener('load', load_stations);

function filterStations() {
    const filter = document.getElementById('searchInput').value.trim();
    const rows = document.querySelectorAll("#stationsBody .station-row");

    rows.forEach(row => {
        const checkbox = row.querySelector('.station-checkbox');
        if (!checkbox) return;
        const stationNumber = checkbox.value.toString();
        row.style.display = (filter === "" || stationNumber.startsWith(filter)) ? "table-row" : "none";
    });
}

document.getElementById('searchInput').addEventListener('input', filterStations);

function subscribeClient() {
    const name = document.getElementById("clientName").value;
    const phone = document.getElementById("clientPhone").value;
    const checkboxes = document.querySelectorAll('.stations-container input[type="checkbox"]');
    const selectedStations = [];

    checkboxes.forEach((checkbox) => {
        if (checkbox.checked) {
            const station = stations.find(s => s.station_id == checkbox.value);
            if (station) selectedStations.push(station);
        }
    });

    if (name === "" || phone === "") {
        alert("Por favor, completa todos los campos.");
        return;
    }

    fetch("/at-lab-0.1/at/clients/add", {
        method: "POST",
        headers: { "Content-Type": "application/json; charset=UTF-8" },
        body: JSON.stringify({ id: 0, phone: phone, name: name, stations: selectedStations })
    })
    .then(response => response.json())
    .then(data => {
        alert(`Cliente: ${name}\nTeléfono: ${phone}\nEstaciones seleccionadas: ${selectedStations.map(s => s.station_id).join(', ')}`);
        window.location.href = "index.html";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Error al suscribirse. Inténtalo de nuevo.");
    });
}
