from selenium.webdriver.common.by import By
from utils.wait import wait_for

class LoginPage:

    def __init__(self, driver):
        self.driver = driver

    def open_login(self):
        wait_for(self.driver,(By.XPATH, "//span[text()='My Account']")).click()
        wait_for(self.driver,(By.XPATH, "//ul//a[text()='Login']")).click()

    def login(self, email, password):
        wait_for(self.driver,(By.ID, "input-email")).send_keys(email)
        self.driver.find_element(By.ID, "input-password").send_keys(password)
        self.driver.find_element(By.XPATH, "//input[@value='Login']").click()
        try:
            return wait_for(self.driver,(By.XPATH, "//h2[text()='My Account']")).text
        except:
            return wait_for(self.driver,(By.XPATH, "//div[@class='alert alert-danger alert-dismissible']")).text