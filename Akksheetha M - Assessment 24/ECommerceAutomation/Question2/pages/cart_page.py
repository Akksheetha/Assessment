from selenium.webdriver.common.by import By
from utils.wait import wait_for

class CartPage:
    cart_total = (By.ID, "cart-total")

    def get_cart_total(self, driver):
        return wait_for(driver, self.cart_total).text