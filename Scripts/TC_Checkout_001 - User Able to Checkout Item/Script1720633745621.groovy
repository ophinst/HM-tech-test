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

//Arrange
'User Login'
WebUI.callTestCase(findTestCase('Resources/Logics/LoginLogic/TC_LoginLogic_001 - User Login'), [:], FailureHandling.STOP_ON_FAILURE)
'Add 1 Random Item to Cart'
WebUI.callTestCase(findTestCase('Resources/Logics/HomepageLogic/TC_HomepageLogic_001 - Add Product to Cart'), [:], FailureHandling.STOP_ON_FAILURE)
'View Cart'
WebUI.callTestCase(findTestCase('Resources/Logics/HomepageLogic/TC_HomepageLogic_002 - View Cart'), [:], FailureHandling.STOP_ON_FAILURE)

//Action
'Checkout Item in Cart'
WebUI.callTestCase(findTestCase('Resources/Logics/CartLogic/TC_CartLogic_001 - Checkout Item in Cart'), [:], FailureHandling.STOP_ON_FAILURE)
'Verify on Checkout Page'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/CartPage/CartPage_txtCheckout Your Information'))
'Input First Name'
WebUI.setText(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_inputfirstName'), GlobalVariable.firstName)
'Input Last Name'
WebUI.setText(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_inputLastName'), GlobalVariable.lastName)
'Input Postal Code'
WebUI.setText(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_inputPostalCode'), GlobalVariable.lastName)
'Click Continue Button'
WebUI.click(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_btnContinue'))
'Verfiy Checkout Button Visible'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/CheckoutPage/CheckoutPage_txtCheckoutOverview'))
'Click Checkout Button'
WebUI.click(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_btnFinish'))

//Assertion
'Verify Checkout Successfull'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/CheckoutPage/CheckOutPage_txtThankyou'))

