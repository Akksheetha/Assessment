from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.get("https://automationexercise.com/")
driver.maximize_window()
wait = WebDriverWait(driver,10)
home = driver.find_element(By.XPATH,"//a[normalize-space()='Home']")
if home.is_displayed():
    print("Home page is visible")
subscription = wait.until(EC.visibility_of_element_located((By.XPATH, "//h2[normalize-space()='Subscription']")))
driver.execute_script("arguments[0].scrollIntoView(true);", subscription)
if subscription.is_displayed():
    print("SUBSCRIPTION is visible")
arrow = driver.find_element(By.ID, "scrollUp")
driver.execute_script("arguments[0].click();", arrow)
wait.until(EC.visibility_of_element_located((By.XPATH, "//h2[normalize-space()='Full-Fledged practice website for Automation Engineers']")))
text = driver.find_element(By.XPATH, "//h2[normalize-space()='Full-Fledged practice website for Automation Engineers']")
if text.is_displayed():
    print("Page was scrolled up and header text is visible")
driver.quit()