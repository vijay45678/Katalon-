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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.lang.String;

WebUI.openBrowser('')

WebUI.navigateToUrl('https://trisyspos:9o$TRstr@apps.trisysit.com/pos/login\n')
WebDriver driver=DriverFactory.getWebDriver()

WebUI.setText(findTestObject('username'), GlobalVariable.username)

WebUI.setText(findTestObject('password'), GlobalVariable.password)

WebUI.click(findTestObject('Click'))

WebUI.click(findTestObject('Deal_mgt'))

WebUI.click(findTestObject('Account'))
List<String> list1 = new ArrayList<String>();
List<String> list2 = new ArrayList<String>();
flag=0
flag1=0


for(def row=1;row<=findTestData('Data Files/Account data').getRowNumbers();row++)
{
	name=findTestData('Data Files/Account data').getValue(1,row)
	
	list1.add(name);
	
	}
List<WebElement> pages_count=driver.findElements(By.className("paginate_button"))
println(" size "+ pages_count.size())
count = pages_count.size() - 2
int k=1
while( k<=count)
{
	List<WebElement> list_names=driver.findElements(By.className("sorting_1"))
	println(" size "+ list_names.size())
for(def i=1;i <= list_names.size();i++)
{
	WebElement list_name=driver.findElement(By.xpath("(//td[@class='sorting_1'])[" + i + "]"))
	list2.add(list_name.getText())
    
	
}
k++;
WebUI.click(findTestObject('Object Repository/Next'))
}

for(def j=0;j<list1.size();j++)
{
	String acName = list1.get(j)
	//acName.toUpperCase()
	//println("Upper case " + acName)
	if(list2.contains(acName))
	{
		//list1.remove(acName)
		//list3.add(acName)
		println(acName +" Account present")
		flag++
	}
	else
	{
		println(acName +" Account not present")
		flag1++
	}
}
println("Total Account Present " + flag)
println("Total Account Not Present " + flag1)
println("List 1" + list1)
println("List 2" + list2)

if(list1==list2)
{
	println("passed")
}
else {
	println("failed")
}



//String xpathval = ((('//*[@id=' + '\"rso\"') + ']/div/div/div[') + j) + ']/div/div/h3/a'
 

