package pl.com.aay.pageObject;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.com.aay.testData.dataReaders.TestDataReader;
import pl.com.aay.test_data.model.Login;
import pl.com.aay.test_data.model.Registration;
import pl.com.aay.test_data.model.Registration2;


import java.io.*;
import java.util.*;

public class TestDataReading extends TestDataReader {


    public TestDataReading() {
        super();
    }

    public Login readProperty() {
        Login login = new Login();
        String propertiesName = "aplication.properties";
        try (InputStream in = new FileInputStream(pathToTestData + propertiesName)) {
            Properties prop = new Properties();
            prop.load(in);
            login.setUrl(prop.getProperty("url"));
            login.setLogin("login");
            login.setPassword("password");
        } catch (Exception e) {
            System.err.println("Brak pliku" + e.toString());
        }
        return login;
    }

    public Registration2 readDataFromExcel() {
        Registration2 registration = null;

        try {
            String excelName2 = "registration2.xlsx";
            FileInputStream excel = new FileInputStream(new File(pathToTestData + excelName2));
            Workbook workbook = new XSSFWorkbook(excel);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iteratorSheet = sheet.iterator();

            while (iteratorSheet.hasNext()) {
                Row currentRow = iteratorSheet.next();
                //Iterator<Cell> cellIterator = currentRow.iterator();
                String name = currentRow.getCell(0).getStringCellValue();
                String value = currentRow.getCell(1).getStringCellValue();

                switch (name) {
                    case "first name":
                        registration.firstName = value;
                        break;
                    case "last name":
                        registration.lastName = value;
                        break;
                    case "phone number":
                        registration.phoneNumber = value;
                        break;
                    case "user name":
                        registration.userName = value;
                        break;
                    case "email":
                        registration.email = value;
                        break;
                    case "password":
                        registration.password = value;
                        break;
                    case "confirm password":
                        registration.confirmPassword = value;
                        break;
                    case"ulica":
                        registration.streetName = value;
                        break;
                    case "Miasto":
                        registration.city=value;
                        break;
                    case"Stan":
                        registration.state=value;
                        break;
                    case"kod":
                        registration.zipCode=value;
                        break;
                    default:
                        System.out.println("no match");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return registration;
    }
}









