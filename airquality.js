var clients; // Para almacenar las estaciones
var client;

function load_clients() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var obj = JSON.parse(xmlhttp.responseText);
            clients = obj.data.clients;

            const container = document.getElementById('clientContainer');
            if (!container) {
                console.warn("No se encontró clientContainer en la página");
                return;
            }
            container.innerHTML = "";

            for (let i = 0; i < clients.length; i++) {
                let id = clients[i].client_id;
                const labelContainer = document.createElement('div');

                const clientLabel = document.createElement('label');
                clientLabel.className = 'client-label';
                clientLabel.innerHTML = 'Cliente ' + id;

                const clientCheck = document.createElement('input');
                clientCheck.value = id;
                clientCheck.type = "checkbox";

                labelContainer.appendChild(clientLabel);
                labelContainer.appendChild(clientCheck);
                container.appendChild(labelContainer);
            }
        }
    };
    xmlhttp.open("GET", "/at/stations", true);
    xmlhttp.send();
}

window.onload = load_clients;

function filterClients() {
    const filter = document.getElementById('searchInput').value;
    const checkboxes = document.querySelectorAll('.stations-container input[type="checkbox"]');

    checkboxes.forEach((checkbox) => {
        const div = checkbox.parentNode;
        const clientNumber = checkbox.value;
        div.style.display = (filter === '' || clientNumber.startsWith(filter)) ? "block" : "none";
    });
}

function Funcionparaciudad() {
    // Aquí iría la lógica para buscar cliente por ciudad
    alert("Función placeholder para buscar cliente por ciudad");
}
