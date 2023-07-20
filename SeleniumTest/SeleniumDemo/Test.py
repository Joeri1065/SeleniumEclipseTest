from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys




print("test case started")  
#open Google Chrome browser
driver = webdriver.Chrome()
#maximize the window size  
driver.maximize_window()  
#delete the cookies  
driver.delete_all_cookies()  
#navigate to the url  
driver.get("http://www.google.com")
#accept cookies
accept = driver.find_element(by="id", value="L2AGLb")
print(accept)
accept.click()
#identify the user name text box and enter the value
que = driver.find_element(by="name", value="q")
print(que)
time.sleep(1)
#send keys
que.send_keys("Selenium IDE ")
time.sleep(1)
#click on the next button
que.send_keys(Keys.RETURN)
time.sleep(4)
#close the browser
driver.close()  
print("Search has been successfully completed")  
