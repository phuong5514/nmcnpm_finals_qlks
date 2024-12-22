const peopleCountInput = document.getElementById("people-count");
const guestSectionsContainer = document.getElementById("guest-sections");

peopleCountInput.addEventListener("input", function() {
    const numberOfGuests = parseInt(this.value);

    guestSectionsContainer.innerHTML = ""; // Xóa các phần thông tin khách cũ

    for (let i = 0; i < numberOfGuests; i++) {
        const guestSection = document.createElement("div");
        guestSection.classList.add("guest");

        guestSection.innerHTML = `
            <p><strong>Guest ${i + 1}:</strong></p>
            <p><strong>Name:</strong> <input type="text" id="guest-name-${i + 1}"></p>
            <p><strong>ID:</strong> <input type="text" id="guest-id-${i + 1}"></p>
            <p><strong>Address:</strong> <input type="text" id="guest-address-${i + 1}"></p>
            <p><strong>Guest type:</strong> <select id="guest-type-${i + 1}">
                <option value="Domestic">Domestic</option>
                <option value="International">International</option>
            </select></p>
        `;

        guestSectionsContainer.appendChild(guestSection);
    }
});

// Dữ liệu phòng (Simulated Database)
const rooms = [
    { name: "Room A1", type: "A", availability: "Vacant", condition: "Good" , price: 100},
    { name: "Room A2", type: "A", availability: "Reserved", condition: "Average", price: 120 },
    { name: "Room B1", type: "B", availability: "Occupied", condition: "Needs Repair", price: 80 },
    { name: "Room B2", type: "B", availability: "Vacant", condition: "Good", price: 150 },
    { name: "Room C1", type: "C", availability: "Reserved", condition: "Good", price: 200 },
];

const roomList = document.getElementById("room-list");
const searchInput = document.getElementById("search");
const roomNameDisplay = document.getElementById("room-name");
const roomTypeDisplay = document.getElementById("room-type");
const totalPriceDisplay = document.getElementById("total-price");

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
    roomNameDisplay.textContent = room.name;
    roomTypeDisplay.textContent = room.type;
    totalPriceDisplay.textContent = room.price;
}

// Xử lý sự kiện
document.querySelectorAll(".type-filter").forEach(input =>
    input.addEventListener("change", () => {
        filters.types = Array.from(document.querySelectorAll(".type-filter:checked")).map(input => input.value);
        renderRooms();
    })
);

document.querySelectorAll(".availability-filter").forEach(input =>
    input.addEventListener("change", () => {
        filters.availability = Array.from(document.querySelectorAll(".availability-filter:checked")).map(input => input.value);
        renderRooms();
    })
);

searchInput.addEventListener("input", event => {
    filters.search = event.target.value;
    renderRooms();
});

renderRooms();