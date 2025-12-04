var clients; // Para almacenar los clientes
var client;

function load_clients() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var obj = JSON.parse(xmlhttp.responseText);
            clients = obj.data.clients;
            console.log(obj);
            console.log(clients);

            const container = document.getElementById('clientContainer');
            if (!container) return; // evitar errores si no existe
            container.innerHTML = ""; // limpiar contenedor

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
    xmlhttp.open("GET", "/at-lab-0.1/at/stations", true);
    xmlhttp.send();
}

function filterClients() {
    const filter = document.getElementById('searchInput').value;
    const checkboxes = document.querySelectorAll('#clientContainer input[type="checkbox"]');

    checkboxes.forEach((checkbox) => {
        const div = checkbox.parentNode;
        const clientNumber = checkbox.value;
        if (filter === '' || clientNumber.toString().startsWith(filter)) {
            div.style.display = "block";
        } else {
            div.style.display = "none";
        }
    });
}

// Llamar a load_clients cuando se cargue la página
window.addEventListener('load', load_clients);
