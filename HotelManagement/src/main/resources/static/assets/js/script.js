const apiUrl = "http://localhost:8080/admin"; // API URL of your server

// Fetch and display user list
async function fetchUsers() {
    const response = await fetch(apiUrl); // Adjusted to get users from '/users'
    const users = await response.json();
    const userList = document.getElementById("userList");
    userList.innerHTML = "";

    users.forEach((user) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.accountType}</td>
            <td>
                <button onclick="showModal('update', ${user.id})">✏</button>
                <button onclick="deleteUser(${user.id})">🗑</button>
            </td>
        `;
        userList.appendChild(row);
    });
}

// Delete user
async function deleteUser(userId) {
    await fetch(`${apiUrl}/users/${userId}`, { method: "DELETE" }); // Adjusted to '/users/{id}'
    fetchUsers();
}

// Show modal
function showModal(mode, userId = null) {
    const modal = document.getElementById("userModal");
    const closeModal = document.getElementById("closeModal");
    const modalTitle = document.getElementById("modalTitle");
    const form = document.getElementById("userForm");

    modal.style.display = "block";

    if (mode === "add") {
        modalTitle.textContent = "Add User";
        form.reset();
    } else if (mode === "update") {
        modalTitle.textContent = "Update User";
        fetch(`${apiUrl}/users/${userId}`) // Adjusted to '/users/{id}'
            .then((response) => response.json())
            .then((user) => {
                document.getElementById("username").value = user.username;
                document.getElementById("password").value = user.password;
                document.getElementById("accountType").value = user.accountType;
            });
    }

    form.onsubmit = async (event) => {
        event.preventDefault();
        const userData = {
            username: document.getElementById("username").value,
            password: document.getElementById("password").value,
            accountType: document.getElementById("accountType").value,
        };

        const method = mode === "add" ? "POST" : "PUT";
        const endpoint = mode === "add" ? `${apiUrl}/create-user` : `${apiUrl}/users/${userId}`;

        await fetch(endpoint, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData),
        });

        modal.style.display = "none";
        fetchUsers();
    };

    closeModal.onclick = () => {
        modal.style.display = "none";
    };

    window.onclick = (event) => {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}

// Initial load
fetchUsers();

// DOM Elements
const addUserBtn = document.getElementById("addUserBtn");
const modal = document.getElementById("userModal");
const closeModal = document.getElementById("closeModal");
const userForm = document.getElementById("userForm");
const modalTitle = document.getElementById("modalTitle");

// Display modal when "Add" button is clicked
addUserBtn.addEventListener("click", () => {
    modal.style.display = "block";
    modalTitle.textContent = "New User";
    userForm.reset();
});

// Hide modal when "x" is clicked
closeModal.addEventListener("click", () => {
    modal.style.display = "none";
});

// Hide modal if clicked outside modal
window.addEventListener("click", (event) => {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});

// Add account types to dropdown
document.addEventListener("DOMContentLoaded", () => {
    const accountTypeDropdown = document.getElementById("accountType");
    if (accountTypeDropdown) {
        const accountTypes = ["Admin", "Hotel Management", "Employee"];
        accountTypeDropdown.innerHTML = accountTypes
            .map((type) => `<option value="${type}">${type}</option>`)
            .join("");
    } else {
        console.error("Account type dropdown not found");
    }
});
