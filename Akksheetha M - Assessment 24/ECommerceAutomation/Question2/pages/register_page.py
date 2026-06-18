from selenium.webdriver.common.by import By
from utils.wait import wait_for

class RegisterPage:

    def __init__(self, driver):
        self.driver = driver

    def register_user(self, firstname, lastname, email, phone, password):
        wait_for(self.driver, (By.XPATH, "//span[text()='My Account']")).click()
        wait_for(self.driver, (By.XPATH, "//ul//a[text()='Register']")).click()
        self.driver.find_element(By.ID, "input-firstname").send_keys(firstname)
        self.driver.find_element( By.ID, "input-lastname").send_keys(lastname)
        self.driver.find_element(By.ID, "input-email").send_keys(email)
        self.driver.find_element(By.ID, "input-telephone").send_keys(phone)
        self.driver.find_element(By.ID, "input-password").send_keys(password)
        self.driver.find_element(By.ID, "input-confirm").send_keys(password)
        self.driver.find_element(By.NAME, "agree").click()
        self.driver.find_element(By.XPATH, "//input[@value='Continue']").click()
        success_msg = wait_for(self.driver,(By.XPATH, "//h1[text()='Your Account Has Been Created!']"))
        return success_msg.text