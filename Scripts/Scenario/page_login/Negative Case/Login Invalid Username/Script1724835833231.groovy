import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Blocks/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('page_home/lbl_CURA-Healthcare-Service'), 15)

WebUI.verifyElementVisible(findTestObject('page_home/lbl_CURA-Healthcare-Service'))

WebUI.click(findTestObject('Object Repository/page_home/a_menu-toggle'))

WebUI.click(findTestObject('page_home/a_login'))

WebUI.waitForElementVisible(findTestObject('page_login/lbl_login'), 15)

WebUI.verifyElementVisible(findTestObject('page_login/lbl_login'))

WebUI.setText(findTestObject('Object Repository/page_login/input_username'), 'Jon Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/page_login/input_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('page_login/button_login'))

WebUI.waitForElementVisible(findTestObject('page_login/txt-error_login'), 15)

WebUI.verifyElementVisible(findTestObject('page_login/txt-error_login'))

WebUI.callTestCase(findTestCase('Blocks/Close Browser'), [:], FailureHandling.STOP_ON_FAILURE)

