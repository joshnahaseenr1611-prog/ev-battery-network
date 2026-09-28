const API_URL = "http://localhost:8081/api/batteries";

// ===============================
// LOAD BATTERIES
// ===============================
async function loadBatteries() {
    try {
        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to load batteries");
        }

        const batteries = await response.json();

        displayBatteries(batteries);

    } catch (error) {
        console.error("Error:", error);
        alert("Unable to connect to Spring Boot backend");
    }
}


// ===============================
// DISPLAY BATTERIES
// ===============================
function displayBatteries(batteries) {

    const tableBody = document.getElementById("batteryTableBody");

    if (!tableBody) return;

    tableBody.innerHTML = "";

    batteries.forEach(battery => {

        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${battery.id ?? "-"}</td>
            <td>${battery.batteryCode ?? "-"}</td>
            <td>${battery.model ?? "-"}</td>
            <td>${battery.capacity ?? "-"}</td>
            <td>${battery.stateOfHealth ?? "-"}%</td>
            <td>${battery.stationLocation ?? "-"}</td>
            <td>
                <span class="status ${getStatusClass(battery.status)}">
                    ${battery.status ?? "UNKNOWN"}
                </span>
            </td>
        `;

        tableBody.appendChild(row);
    });
}


// ===============================
// STATUS CLASS
// ===============================
function getStatusClass(status) {

    if (!status) return "unknown";

    switch (status.toUpperCase()) {

        case "ACTIVE":
            return "active";

        case "INACTIVE":
            return "inactive";

        case "MAINTENANCE":
            return "maintenance";

        default:
            return "unknown";
    }
}


// ===============================
// ADD BATTERY
// ===============================
async function addBattery(event) {

    event.preventDefault();

    const battery = {

        batteryCode: document.getElementById("batteryCode").value,

        model: document.getElementById("model").value,

        capacity: parseFloat(
            document.getElementById("capacity").value
        ),

        stateOfHealth: parseFloat(
            document.getElementById("stateOfHealth").value
        ),

        stationLocation:
            document.getElementById("stationLocation").value,

        status:
            document.getElementById("status").value
    };

    try {

        const response = await fetch(API_URL, {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(battery)
        });

        if (!response.ok) {
            throw new Error("Failed to add battery");
        }

        const result = await response.json();

        alert("Battery added successfully!");

        console.log(result);

        document.getElementById("batteryForm").reset();

        loadBatteries();

    } catch (error) {

        console.error("Error:", error);

        alert("Failed to add battery");
    }
}


// ===============================
// DELETE BATTERY
// ===============================
async function deleteBattery(id) {

    if (!confirm("Are you sure you want to delete this battery?")) {
        return;
    }

    try {

        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) {
            throw new Error("Delete failed");
        }

        alert("Battery deleted successfully!");

        loadBatteries();

    } catch (error) {

        console.error("Error:", error);

        alert("Unable to delete battery");
    }
}


// ===============================
// PAGE LOAD
// ===============================
document.addEventListener("DOMContentLoaded", () => {

    // Battery list page
    loadBatteries();

    // Add battery form
    const form = document.getElementById("batteryForm");

    if (form) {
        form.addEventListener("submit", addBattery);
    }

});