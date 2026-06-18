import pytest
from pages.login_page import LoginPage
from utils.csv_reader import read_login_data

class TestLogin:

    @pytest.mark.regression
    @pytest.mark.parametrize("email,password,expected",read_login_data())
    def test_login(self,setup_and_teardown,email,password,expected):
        driver = setup_and_teardown
        login_page = LoginPage(driver)
        login_page.open_login()
        result = login_page.login(email, password)
        assert expected in result