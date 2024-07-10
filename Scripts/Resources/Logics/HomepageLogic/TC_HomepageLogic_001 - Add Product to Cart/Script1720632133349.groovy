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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Random as Random

'Verify On Homepage'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/HomepagePage/HomepagePage_txtProducts'))

'Generate Random Number to Choose 1 Item'
WebUI.callTestCase(findTestCase('Resources/TC_Resources_002 - Generate Random Number to Choose Item'), [:], FailureHandling.STOP_ON_FAILURE)

String dynamicLocator = "//a[@id='item_${GlobalVariable.item}_img_link']"

TestObject randomItem = new TestObject()

randomItem.addProperty('xpath', ConditionType.EQUALS, dynamicLocator)

'Pick Random Item'
WebUI.click(randomItem)

'Verify Product Detail Visible'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/HomepagePage/HomepagePage_txtProductDetail'))

'Add Item to Cart'
WebUI.click(findTestObject('Page_Swag Labs/HomepagePage/HomepagePage_btnAddtoCart'))

'Verify Item Added to Cart'
WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/HomepagePage/HomepagePage_btnRemove'))

