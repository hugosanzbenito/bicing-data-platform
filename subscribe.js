var stations; // Para almacenar las estaciones

var station; 



function load_stations() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var obj = JSON.parse(xmlhttp.responseText);
            stations = obj.data.stations;

            // Crear la tabla con clases para facilitar el filtrado
            let tableHTML = `
                <table border="1" style="border-collapse: collapse; width: 100%; text-align: center;">
                    <thead>
                        <tr style="background-color: #007bff; color: white;">
                            <th>Estación</th>
                            <th>Seleccionar</th>
                        </tr>
                    </thead>
                    <tbody id="stationsBody">
            `;

            // Llenar la tabla con los datos de las estaciones
            stations.forEach(station => {
                let id = station.station_id;
                tableHTML += `
                    <tr class="station-row">
                        <td>Estación ${id}</td>
                        <td><input type="checkbox" class="station-checkbox" value="${id}"></td>
                    </tr>
                `;
            });

            tableHTML += "</tbody></table>";

            document.getElementById('stationsContainer').innerHTML = tableHTML;
        }
    };
    xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
    xmlhttp.send();
}

// Cargar las estaciones al cargar la página
window.onload = load_stations;

function filterStations() {
    const filter = document.getElementById('searchInput').value.trim();
    const rows = document.querySelectorAll("#stationsBody .station-row"); // Obtener filas de la tabla

    rows.forEach(row => {
        const checkbox = row.querySelector('.station-checkbox');
        if (!checkbox) return; // Si no hay checkbox, ignorar

        const stationNumber = checkbox.value.toString(); // Asegurar que sea string

        // Mostrar solo las filas que coincidan con el filtro
        if (filter === "" || stationNumber.startsWith(filter)) {
            row.style.display = "table-row"; // Mantener la fila visible
        } else {
            row.style.display = "none"; // Ocultar la fila
        }
    });
}

// Vincula la función al input de búsqueda
document.getElementById('searchInput').addEventListener('input', filterStations);


function subscribeClient() {
    const name = document.getElementById("clientName").value;
    const phone = document.getElementById("clientPhone").value;
    const checkboxes = document.querySelectorAll('.stations-container input[type="checkbox"]');
    const selectedStations = [];
	const selectedStations_id = [];

    checkboxes.forEach((checkbox, index) => {
        if (checkbox.checked) {
			for(let i = 0; i < stations.length; i++) {
				if (checkbox.value == stations[i].station_id) {
					selectedStations.push(stations[i]);
				}
			}
            selectedStations_id.push(checkbox.value); // Usar el array de estaciones
        }
    });
	
	console.log(selectedStations)
	console.log(selectedStations_id)

    if (name === "" || phone === "") {
        alert("Por favor, completa todos los campos.");
        return;
    }
	
	// Enviar datos con AJAX (fetch API)
    fetch("/at-lab-0.1/at/clients/add", {  // Cambia la URL según el servidor
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: JSON.stringify({
			id: 0,
			phone: phone,
			name: name,
			stations: selectedStations
			
		}),
		headers: {
			    "Content-type": "application/json; charset=UTF-8"
			  }
    })
    .then(response => response.json())
    .then(data => {
        alert(`Cliente: ${name}\nTeléfono: ${phone}\nEstaciones seleccionadas: ${selectedStations_id.join(', ')}`);
        window.location.href = "index.html"; // Redirigir a index.html
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Error al suscribirse. Inténtalo de nuevo.");
    });
	/*
	fetch("https://jsonplaceholder.typicode.com/todos", {
	  method: "POST",
	  body: JSON.stringify({
	    userId: 1,
	    title: "Fix my bugs",
	    completed: false
	  }),
	  headers: {
	    "Content-type": "application/json; charset=UTF-8"
	  }
	});
	*/

    
    // Aquí puedes añadir la lógica para procesar la suscripción	
}