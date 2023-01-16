package script.pageobject;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import script.basescript.BaseTest;

public class Test_Page extends BaseTest {

	private By draggable = By.linkText("Draggable");

	private By iframe = className("demo-frame");
	private By dragMeAround = id("draggable");

	public void clickOnDraggable() {
		driver.findElement(draggable).click();
	}

	public void dragAndDropToElement() {
		driver.switchTo().frame(driver.findElement(iframe));
		action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(dragMeAround), 10, 10).build().perform();
		driver.switchTo().defaultContent();
	}

	public String getAttribute() {
		driver.switchTo().frame(driver.findElement(iframe));
		String value = driver.findElement(dragMeAround).getAttribute("style");
		driver.switchTo().defaultContent();
		return value;
	}
}
