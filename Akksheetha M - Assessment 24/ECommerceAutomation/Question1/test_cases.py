import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.mark.smoke
def test_price():
    driver = webdriver.Chrome()
    driver.get("https://practice.automationtesting.in/shop/")
    driver.maximize_window()
    price = driver.find_element(By.XPATH,"//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[contains(@class,'products masonry-done')]/li[3]/a[1]/span[1]/span[1]").text
    assert "₹280.00" in price

@pytest.mark.smoke
def test_js():
    driver = webdriver.Chrome()
    driver.get("https://practice.automationtesting.in/shop/")
    driver.maximize_window()
    driver.find_element(By.XPATH, "//h3[normalize-space()='JS Data Structures and Algorithm']").click()
    title = driver.find_element(By.CSS_SELECTOR, "#product-180 > div.summary.entry-summary > h1").text
    assert "JS Data Structures" in title
    driver.quit()

@pytest.mark.regression
def test_count():
    driver = webdriver.Chrome()
    driver.get("https://practice.automationtesting.in/shop/")
    driver.maximize_window()
    driver.find_element(By.XPATH, "//a[contains(text(),'HTML')]").click()
    books = driver.find_elements(By.CLASS_NAME, "product")
    assert len(books) == 3
    driver.quit()

@pytest.mark.regression
def test_sort():
    driver = webdriver.Chrome()
    driver.get("https://practice.automationtesting.in/shop/")
    driver.maximize_window()
    dropdown = driver.find_element(By.CLASS_NAME, "orderby")
    dropdown.click()
    driver.find_element(By.CSS_SELECTOR, "#content > form > select > option:nth-child(5)").click()
    book1 = driver.find_element(By.CSS_SELECTOR,"body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > a:nth-child(1) > span:nth-child(3) > span:nth-child(1)").text
    book2 = driver.find_element(By.CSS_SELECTOR,"body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(4) > li:nth-child(2) > a:nth-child(1) > span:nth-child(3) > span:nth-child(1)").text
    assert book1<book2
    driver.quit()

def test_subscribe_button():
    driver = webdriver.Chrome()
    driver.get("https://practice.automationtesting.in/shop/")
    driver.maximize_window()
    subscribe = driver.find_element(By.XPATH, "//input[@value='Subscribe']")
    driver.execute_script("arguments[0].scrollIntoView(true);",subscribe)
    assert subscribe.is_displayed()
    print("Subscribe button is visible")
    driver.quit()
