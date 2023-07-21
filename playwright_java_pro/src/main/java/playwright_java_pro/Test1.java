package playwright_java_pro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try (Playwright playwright = Playwright.create()) {
			 Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		       playwright.webkit().launch();
		      Page page = browser.newPage();
		      page.navigate("https://playwright.dev/java/docs/test-runners");
		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		      System.out.println("Completed");
		      String name = page.locator("xpath=.//span[@itemprop='name']").textContent();
		      System.out.println(name);
		      assertEquals("Test Runners", name);
		      }
	}

}
