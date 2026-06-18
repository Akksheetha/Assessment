from selenium.webdriver.common.by import By

class SearchPage:
    def __init__(self, driver):
        self.driver = driver

    def search_product(self, keyword):
        self.driver.find_element(By.NAME,"search").send_keys(keyword)
        self.driver.find_element(By.XPATH,"//button[@class='btn btn-default btn-lg']").click()
        results = self.driver.find_elements(By.XPATH,"//div[@class='caption']/h4/a")
        return [result.text for result in results]