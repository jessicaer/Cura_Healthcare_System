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

CustomKeywords.'verify.verificationPage.LoginPageVerif'()

WebUI.setText(findTestObject('Object Repository/page_login/input_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/page_login/input_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('page_login/button_login'))

WebUI.verifyElementPresent(findTestObject('page_make-appointment/lbl_make-appointment'), 0)

WebUI.verifyElementPresent(findTestObject('page_make-appointment/input_facility'), 0)

WebUI.selectOptionByValue(findTestObject('page_make-appointment/input_facility'), facility, false)

//WebUI.check(findTestObject('page_make-appointment/input_hospital-readmission'))
if (hospital_readmission == true) {
    WebUI.check(findTestObject('page_make-appointment/input_hospital-readmission'))
}

//WebUI.click(findTestObject('page_make-appointment/input_medicaid-programs'))
'Step Memilih Healthcare Program'
def select_radio = healthcare_program

switch (select_radio) {
    case select_radio = 'Medicare':
        println(select_radio)

        WebUI.click(findTestObject('page_make-appointment/input_medicare-programs'))

        break
    case select_radio = 'Medicaid':
        println(select_radio)

        WebUI.click(findTestObject('page_make-appointment/input_medicaid-programs'))

        break
    case select_radio = 'None':
        println(select_radio)

        WebUI.click(findTestObject('page_make-appointment/input_none-programs'))

        break
    default:
        println(select_radio)

        WebUI.click(findTestObject('page_make-appointment/input_none-programs'))

        break
}

WebUI.setText(findTestObject('page_make-appointment/input_visit-date'), visit_date)

WebUI.sendKeys(findTestObject('page_make-appointment/textarea_comment'), comment)

WebUI.click(findTestObject('page_make-appointment/button_book-appointment'))

WebUI.verifyElementPresent(findTestObject('page_appointment-confirmation/lbl_appointment-confirmation'), 0)

WebUI.verifyElementPresent(findTestObject('page_appointment-confirmation/lbl_subtitle'), 0)

WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_facility'), facility)

//WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_hospital-readmission'), hospital_readmission)
'Step Verify Hospital Readmission'
if (hospital_readmission == true) {
    WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_hospital-readmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_hospital-readmission'), 'No')
}

//WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_healthcare-program'), healthcare_program)
'Step Verify Healthcare Program'
switch (select_radio) {
    case select_radio = 'Medicare':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_healthcare-program'), 'Medicare')

        break
    case select_radio = 'Medicaid':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_healthcare-program'), 'Medicaid')

        break
    case select_radio = 'None':
        println(select_radio)

        WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_healthcare-program'), 'None')

        break
    default:
        println(select_radio)

        WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_healthcare-program'), 'None')

        break
}

WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_visit-date'), visit_date)

WebUI.verifyElementText(findTestObject('page_appointment-confirmation/lbl_comment'), comment)

WebUI.callTestCase(findTestCase('Blocks/Close Browser'), [:], FailureHandling.STOP_ON_FAILURE)

