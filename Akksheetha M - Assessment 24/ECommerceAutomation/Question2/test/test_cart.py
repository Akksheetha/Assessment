import pytest
from pages.cart_page import CartPage

class TestAddToCart:

    @pytest.mark.regression
    def test_add_to_cart(self, setup_and_teardown):
        driver = setup_and_teardown
        cart_page = CartPage(driver)
        msg, total = cart_page.add_to_cart()
        assert "Success" in msg
        assert "1 item(s)" in total