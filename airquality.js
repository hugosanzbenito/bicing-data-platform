var clients; // Para almacenar las estaciones

var client; 


function load_clients() {
	var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var obj = JSON.parse(xmlhttp.responseText);
				clients = obj.data.clients;
				console.log(obj)
				console.log(clients)
				console.log(clients.length)
				
				for (let i = 0; i < clients.length; i++){
					let id = clients[i].client_id
					const labelContainer = document.createElement('div');
				
					const clientLabel = document.createElement('label');
				    clientLabel.className = 'client-label';
					clientLabel.innerHTML = 'Cliente ' + id;
					const clientCheck = document.createElement('input');
					// stationCheck.nodeValue = id
					clientCheck.value = id
					clientCheck.type = "checkbox"
				    // stationLabel.innerHTML = `<input type="checkbox" value="${id}"> Estación ${id}</input>`;
					labelContainer.appendChild(clientLabel);
					labelContainer.appendChild(clientCheck);
					document.getElementById('clientContainer').appendChild(labelContainer);
				}
			}
		};
		xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
		xmlhttp.send();
}


window.onload = load_stations;

function filterClients() {
    const filter = document.getElementById('searchInput').value;
    const checkboxes = document.querySelectorAll('.clients-container input[type="checkbox"]');
    let index = 0;

    // Filtrar las estaciones
    checkboxes.forEach((checkbox) => {
        const div = checkbox.parentNode;
        const clientNumber = checkbox.value; // id de la estación
        // Verifica si el número de la estación comienza con el texto de búsqueda
        if (filter === '' || clientNumber.toString().startsWith(filter)) {
            div.style.display = "block"; // Mostrar si coincide
        } else {
            div.style.display = "none"; // Ocultar si no coincide
        }
        index++;
    });
}
