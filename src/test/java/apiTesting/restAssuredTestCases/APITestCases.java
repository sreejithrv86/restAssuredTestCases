package apiTesting.restAssuredTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterMethod;

public class APITestCases {
  @Test
  public void apiTest() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  public static HashMap<String, String[]> readData(String KeyPhrase, String Type) throws IOException{
      HashMap<String, String[]> hObjectDesc  = new HashMap<String, String[]>();
      try
      {
     // String userdir = "\\\\t1nafs707\\Dept_Shares\\IT\\QA\\Automation\\DEVELOPMENT\\APITesting";
     String userdir = "C:\\SeleniumDist1.1";
      File file = new File(userdir + "\\restAssuredAPI.xls");
      FileInputStream inputStream = new FileInputStream(file);
      HSSFWorkbook wbk = new HSSFWorkbook(inputStream);
      HSSFSheet sht;
      if(Type.equalsIgnoreCase("HEADER")) {
      sht = wbk.getSheetAt(0);}
      else {
             sht = wbk.getSheetAt(1);  
      }
      String shtName = sht.getSheetName();
      
      int j=1;
      int k=1;
      
      for(int i=1; i< sht.getLastRowNum()+1;i++) {
             if( sht.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(KeyPhrase)) {
                    
                    
                    if(Type.equalsIgnoreCase("HEADER")) {
                          
                    String hheader[]=new String[2];
                    hheader[0] = sht.getRow(i).getCell(1).getStringCellValue();
                    hheader[1] = sht.getRow(i).getCell(2).getStringCellValue();
                    hObjectDesc.put("Header"+j, hheader);
                    j=j+1;
                    }
                    else{
                          
                          String bbody[] = new String[2];
                          bbody[0] = sht.getRow(i).getCell(1).getStringCellValue();
                          bbody[1] = "";
                          hObjectDesc.put("Body"+k, bbody);
                          k=k+1;
                          
                          
                    }
                    
                    }
                    
      }
      inputStream.close();
      
      }
      catch (Exception e){
            e.printStackTrace();
        }
      return hObjectDesc;
      
      }  

}
