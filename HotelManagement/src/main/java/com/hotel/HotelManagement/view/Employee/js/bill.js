const customerData = [
    { id: 12345, name: "Nguyễn Văn A", type: "VIP", idCard: "123456789", address: "123 Đường X, Quận Y, TP.HCM" },
    { id: 12356, name: "Trần Thị B", type: "Thường", idCard: "987654321", address: "456 Đường Z, Quận T, Hà Nội" },
    { id: 12378, name: "Lê Văn C", type: "Doanh nghiệp", idCard: "456789123", address: "789 Đường K, Quận L, Đà Nẵng" },
    { id: 12390, name: "Phạm Thị D", type: "VIP", idCard: "789123456", address: "012 Đường M, Quận N, Cần Thơ" },
    { id: 12400, name: "Nguyễn Văn E", type: "Thường", idCard: "321654987", address: "345 Đường P, Quận Q, Hải Phòng" }
];

const searchInput = document.getElementById('customer-search');
const customerId = document.getElementById('customer-id');
const customerName = document.getElementById('customer-name');
const customerType = document.getElementById('customer-type');
const customerIdCard = document.getElementById('customer-id-card');
const customerAddress = document.getElementById('customer-address');

searchInput.addEventListener('input', function() {
    const searchTerm = searchInput.value.toLowerCase();
    const foundCustomer = customerData.find(customer => customer.name.toLowerCase().includes(searchTerm));

    if (foundCustomer) {
        customerId.textContent = foundCustomer.id;
        customerName.textContent = foundCustomer.name;
        customerType.textContent = foundCustomer.type;
        customerIdCard.textContent = foundCustomer.idCard;
        customerAddress.textContent = foundCustomer.address;
	rentalVouchersList.innerHTML = '';
	orgName.textContent = foundCustomer.name;
	orgAddress.textContent = foundCustomer.address;
        selectedVouchers = []; // Reset mảng vouchers đã chọn khi tìm kiếm khách hàng mới
        const customerVouchers = rentalVouchersData.filter(voucher => voucher.customerId === foundCustomer.id);
        customerVouchers.forEach(voucher => {
            const li = document.createElement('li');
            li.textContent = `Room ${voucher.roomId} (${voucher.stayDuration} days)`;

            li.addEventListener('click', () => {
                li.classList.toggle('selected'); // Thêm/xóa class 'selected'

                const index = selectedVouchers.findIndex(v => v.id === voucher.id);
                if (index > -1) {
                    selectedVouchers.splice(index, 1); // Xóa voucher nếu đã được chọn
                } else {
                    selectedVouchers.push(voucher); // Thêm voucher nếu chưa được chọn
                }
                displayInvoice(selectedVouchers); // Cập nhật preview
            });

            rentalVouchersList.appendChild(li);
        });
    } else {
        customerId.textContent = "";
        customerName.textContent = "";
        customerType.textContent = "";
        customerIdCard.textContent = "";
        customerAddress.textContent = "";
	rentalVouchersList.innerHTML = '';
        invoiceItems.innerHTML = '';
        invoiceTaxes.textContent = '';
        invoiceTotal.textContent = '';
        orgName.textContent = '';
        orgAddress.textContent = '';
        billNumber.textContent = '';
        selectedVouchers = [];
    }
});

const rentalVouchersData = [
    { id: 1, customerId: 12345, roomId: "B24", stayDuration: 4, baseCost: 25, extraFees: 25 },
    { id: 2, customerId: 12356, roomId: "B12", stayDuration: 5, baseCost: 30, extraFees: 0 },
    { id: 3, customerId: 12356, roomId: "CS", stayDuration: 1, baseCost: 40, extraFees: 0 },
    { id: 4, customerId: 12356, roomId: "A12", stayDuration: 2, baseCost: 50, extraFees: 50 },
    { id: 5, customerId: 12400, roomId: "A32", stayDuration: 2, baseCost: 10, extraFees: 50 },
];

const rentalVouchersList = document.getElementById('rental-vouchers');
const orgName = document.getElementById('org-name');
const orgAddress = document.getElementById('org-address');
const billNumber = document.getElementById('bill-number');
const invoiceItems = document.getElementById('invoice-items');
const invoiceTaxes = document.getElementById('invoice-taxes');
const invoiceTotal = document.getElementById('invoice-total');


let selectedVouchers = []; // Mảng lưu trữ các vouchers đã chọn

function generateBillNumber() {
    return Math.floor(Math.random() * 1000000);
}

function displayInvoice(vouchers) {
    billNumber.textContent = generateBillNumber();

    invoiceItems.innerHTML = '';
    let totalBeforeTax = 0;
    let no = 1;

    if (vouchers.length === 0) {
        invoiceTaxes.textContent = '';
        invoiceTotal.textContent = '';
        return; // Không có vouchers nào được chọn
    }

    vouchers.forEach(voucher => {
        const row = invoiceItems.insertRow();
        const noCell = row.insertCell();
        const roomIdCell = row.insertCell();
        const stayDurationCell = row.insertCell();
        const baseCostCell = row.insertCell();
        const extraFeesCell = row.insertCell();
        const totalCell = row.insertCell();

        noCell.textContent = no++;
        roomIdCell.textContent = voucher.roomId;
        stayDurationCell.textContent = voucher.stayDuration + " days";
        baseCostCell.textContent = voucher.baseCost + "$/day";
        extraFeesCell.textContent = voucher.extraFees + "$";
        const total = voucher.stayDuration * voucher.baseCost + voucher.extraFees;
        totalCell.textContent = total + "$";
        totalBeforeTax += total;
    });


    const taxes = totalBeforeTax * 0.1;
    const finalTotal = totalBeforeTax + taxes;

    invoiceTaxes.textContent = taxes.toFixed(2) + "$";
    invoiceTotal.textContent = finalTotal.toFixed(2) + "$";
}
