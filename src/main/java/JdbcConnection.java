import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class JdbcConnection {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt","root","1998");
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from credentials where scenario = 'rewardscard'");
        while(rs.next()){
            WebDriver driver = new ChromeDriver();
            driver.get("https://login.salesforce.com/?locale=ca");
            driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
        }
    }
}
