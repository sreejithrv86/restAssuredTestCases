package apiTesting.restAssuredBasic;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  public static RequestSpecification httpRequest;
  public static Response response;
  protected static Logger logger;
  
  public String KeyPhraseID = "Local";
 public String StepID = "1";
 

  @BeforeClass
  public void beforeClass() {
	  logger=Logger.getLogger(BaseTest.class.getName());
	  PropertyConfigurator.configure("Log4j.properties");
	  logger.setLevel(Level.INFO);
  }


}
