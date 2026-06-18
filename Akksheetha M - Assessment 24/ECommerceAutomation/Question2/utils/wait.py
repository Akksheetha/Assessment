from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

def wait_for(driver, locator, timeout=10, condition=EC.visibility_of_element_located):
    return WebDriverWait(driver, timeout).until(condition(locator))