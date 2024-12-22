// Simulated Database
const rooms = [
    { name: "Room A1", type: "A", availability: "Vacant", condition: "Good" },
    { name: "Room A2", type: "A", availability: "Reserved", condition: "Average" },
    { name: "Room B1", type: "B", availability: "Occupied", condition: "Needs Repair" },
    { name: "Room B2", type: "B", availability: "Vacant", condition: "Good" },
    { name: "Room C1", type: "C", availability: "Reserved", condition: "Good" },
];

const roomList = document.getElementById("room-list");
const searchInput = document.getElementById("search");

const filters = {
    types: ["A", "B", "C"],
    availability: ["Vacant", "Reserved", "Occupied"],
    search: ""
};

function renderRooms() {
    const filteredRooms = rooms.filter(room => 
        filters.types.includes(room.type) &&
        filters.availability.includes(room.availability) &&
        room.name.toLowerCase().includes(filters.search.toLowerCase())
    );

    roomList.innerHTML = "";
    filteredRooms.forEach(room => {
        const div = document.createElement("div");
        div.classList.add("room-item");
        div.textContent = room.name;
        div.onclick = () => showDetails(room);
        roomList.appendChild(div);
    });
}

function showDetails(room) {
    document.getElementById("room-name").textContent = room.name;
    document.getElementById("room-type").textContent = room.type;
    document.getElementById("room-availability").textContent = room.availability;
    document.getElementById("room-condition").textContent = room.condition;
}

// Event Listeners
document.querySelectorAll(".type-filter").forEach(input =>
    input.addEventListener("change", () => {
        filters.types = Array.from(document.querySelectorAll(".type-filter:checked"))
                            .map(input => input.value);
        renderRooms();
    })
);

document.querySelectorAll(".availability-filter").forEach(input =>
    input.addEventListener("change", () => {
        filters.availability = Array.from(document.querySelectorAll(".availability-filter:checked"))
                                   .map(input => input.value);
        renderRooms();
    })
);

searchInput.addEventListener("input", event => {
    filters.search = event.target.value;
    renderRooms();
});

function redirectToBookPage() {
    window.location.href = "book.html";
}


renderRooms();
