NopCommerce Full Automation Deliverable (Registered-user checkout)

This project contains an end-to-end Selenium TestNG + Cucumber framework targeting https://demo.nopcommerce.com/
It includes:
- Page Objects, TestNG tests, Cucumber feature & steps
- Data-driven sample Excel in src/test/resources/testdata/users.xlsx
- ExtentReports integration and screenshot helper

Prerequisites:
- Java 11+
- Maven
- Chrome or Firefox installed
- Internet access (WebDriverManager will download drivers)

Run tests:
1) Unzip the project.
2) From project root where pom.xml is located, run:
   mvn clean test -Dbrowser=chrome
   This will execute TestNG tests defined in testng.xml.

3) To run cucumber feature:
   mvn -Dtest=com.nopcommerce.runners.CucumberRunner test

Reports & screenshots:
- Extent HTML report: reports/ExtentReport.html
- Screenshots for tests: reports/screenshots/

Notes:
- The registered-user checkout flow assumes the test user (testuser@example.com) exists.
- If the user doesn't exist, first run RegisterTest or update users.xlsx with a known account.
- Modify timeouts and add explicit waits as needed for stability.

If you run locally and upload the generated reports/screenshots, I will:
- Replace placeholder files with real run evidence and repackage a final submission ZIP.

