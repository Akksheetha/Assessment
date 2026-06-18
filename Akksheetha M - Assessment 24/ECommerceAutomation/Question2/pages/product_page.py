from selenium.webdriver.common.by import By
from utils.wait import wait_for

class ProductPage:
    product_link = (By.LINK_TEXT, "MacBook")
    add_to_cart = (By.ID, "button-cart")
    success_msg = (By.XPATH, "//div[@class='alert alert-success alert-dismissible']")

    def add_product_to_cart(self, driver):
        wait_for(driver, self.product_link).click()
        wait_for(driver, self.add_to_cart).click()
        return wait_for(driver, self.success_msg).text
