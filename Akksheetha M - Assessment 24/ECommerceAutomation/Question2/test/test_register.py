import pytest
from pages.register_page import RegisterPage
from config.read_config import get_data

class TestRegister:

    @pytest.mark.smoke
    def test_register(self, setup_and_teardown):

        driver = setup_and_teardown
        firstname = get_data("register info", "name")
        lastname = get_data("register info", "lastname")
        email = get_data("register info", "email")
        phone = get_data("register info", "phone_number")
        password = get_data("register info", "password")
        register_page = RegisterPage(driver)
        msg = register_page.register_user(firstname,lastname,email,phone,password)
        assert msg == "Your Account Has Been Created!"