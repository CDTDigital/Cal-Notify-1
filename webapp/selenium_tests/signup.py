from selenium import webdriver
from selenium.webdriver.support.ui import Select
import common, time

def signup(fname, lname, address1, address2, city, state, zipcode, phone, email, password, confPassword, driver):

	inputs = []

	all_inputs = driver.find_elements_by_tag_name("input")
	inputs = common.updateInputs(driver)

	inputs[0].send_keys(fname)
	inputs[1].send_keys(lname)
	inputs[2].send_keys(address1)
	inputs[3].send_keys(address2)
	inputs[4].send_keys(city)
	driver.find_element_by_xpath("//select[@id='state']/option[text()='CA']").click()
	inputs[5].send_keys(zipcode)
	inputs[6].send_keys(phone)
	inputs[7].send_keys(email)
	inputs[8].send_keys(password)
	inputs[9].send_keys(confPassword)

	button = driver.find_element_by_id('submit')
	button.click()

	time.sleep(2)