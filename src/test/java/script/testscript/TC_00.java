package script.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import script.basescript.BaseTest;
import script.pageobject.Test_Page;

public class TC_00 extends BaseTest {

	Test_Page test_po = new Test_Page();
	String get1;

	@Test
	public void scenario1() {
		test_po.clickOnDraggable();
		get1 = test_po.getAttribute();
		test_po.dragAndDropToElement();

	}

	@Test
	public void scenario2() {
		String get2 = test_po.getAttribute();
		if (get1.equals(get2)) {
			assertTrue(false);
			System.out.println();
		}
	}

}