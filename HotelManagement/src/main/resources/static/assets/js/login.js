// Lấy các phần tử HTML
const loginForm = document.getElementById('login-form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');
const errorMessage = document.querySelector('.error-message');

// Lắng nghe sự kiện submit của form
if (loginForm) {
    loginForm.addEventListener('submit', async function(event) {
        event.preventDefault();
        const formData = new FormData(loginForm);

        try {
            const response = await fetch('/logon', {
                method: 'POST',
                body: formData
            });

            if (response.ok) {
                window.location.href = '/';
            } else {
                showError('Tên đăng nhập hoặc mật khẩu không chính xác.');
            }
        } catch (error) {
            console.error('Lỗi khi gửi yêu cầu đăng nhập:', error);
            showError('Đã xảy ra lỗi khi kết nối đến máy chủ.');
        }
    });
}

// Hàm hiển thị thông báo lỗi
function showError(message) {
    errorMessage.textContent = message;
    errorMessage.style.display = 'block';
}
