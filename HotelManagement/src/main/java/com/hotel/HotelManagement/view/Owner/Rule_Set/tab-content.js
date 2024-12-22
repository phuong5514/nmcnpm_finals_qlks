document.addEventListener("DOMContentLoaded", function () {
    const tabs = document.querySelectorAll(".tab-link"); // Chọn tất cả các tab
    const contents = document.querySelectorAll(".content"); // Chọn tất cả nội dung của tab

    // Hiển thị tab đầu tiên và nội dung tương ứng khi trang tải lần đầu
    if (tabs.length > 0 && contents.length > 0) {
        tabs[0].classList.add("active"); // Đặt tab đầu tiên là active
        contents[0].classList.add("active"); // Hiển thị nội dung của tab đầu tiên
    }

    // Xử lý sự kiện click cho từng tab
    tabs.forEach(tab => {
        tab.addEventListener("click", function (event) {
            event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a

            // Loại bỏ class active khỏi tất cả các tab
            tabs.forEach(t => t.classList.remove("active"));

            // Ẩn tất cả nội dung
            contents.forEach(content => content.classList.remove("active"));

            // Thêm class active cho tab được chọn
            this.classList.add("active");

            // Hiển thị nội dung của tab tương ứng
            const tabId = this.getAttribute("data-tab");
            document.getElementById(tabId).classList.add("active");
        });
    });
});

// Lấy danh sách các mục <li> trong <ul>
const listItems = document.querySelectorAll('.list li');

// Thêm sự kiện click cho mỗi <li>
listItems.forEach(item => {
  item.addEventListener('click', () => {
    // Xóa lớp "active" khỏi tất cả các mục
    listItems.forEach(i => i.classList.remove('active'));

    // Thêm lớp "active" vào mục được click
    item.classList.add('active');
  });
});
