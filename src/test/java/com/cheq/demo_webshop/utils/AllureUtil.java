package com.cheq.demo_webshop.utils;

import io.qameta.allure.Allure;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cheq.demo_webshop.listener.StepListener;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
* Utility class for attaching text and screenshots to Allure reports.
*/
public class AllureUtil {
	private final WebDriver driver;
	private static final Logger logger = LoggerUtil.getLogger(AllureUtil.class);


	public AllureUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void attachText(String message) {
		Allure.getLifecycle().updateStep(s -> s.setName("📸 " + StepListener.currentStep));
		Allure.addAttachment("Sample Text", "text/plain", new ByteArrayInputStream(
			message.getBytes(StandardCharsets.UTF_8)), ".txt");
		}

	public void captureAndAttachScreenshot() {
		byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.getLifecycle().updateStep(s -> s.setName("📸 " + StepListener.currentStep)); // override name
		Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshotBytes), ".png");
	}

	public void writeAllureEnvironment(Map<String, String> env) {
		// Create the environment.properties file in allure-results directory
		File envFile = new File("target/allure-results/environment.properties");
		// Ensure parent directories exist
		envFile.getParentFile().mkdirs();
		try (FileWriter writer = new FileWriter(envFile)) {
			// Write each property as key=value
			for (Map.Entry<String, String> entry : env.entrySet()) {
				writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
				}
		} catch (IOException e) {
			logger.error("Failed to write Allure environment file", e);
		}
	}
}
 