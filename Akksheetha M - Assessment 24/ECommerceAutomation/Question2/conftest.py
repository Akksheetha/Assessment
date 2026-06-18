import pytest
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from config.read_config import get_data

@pytest.fixture(scope="function")
def setup_and_teardown():
    driver = webdriver.Firefox()
    wait = WebDriverWait(driver, 10)
    driver.get(get_data("basic info", "url"))
    driver.maximize_window()
    yield driver, wait  
    driver.quit()
