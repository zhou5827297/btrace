package com.zhoukai.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhoukai on 2016/12/22.
 */
public class Selenium2Example1Test {

    @Test
    public void test() {
        // Instantiate a webDriver implementation
//        System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");
//        String proxyIp = "localhost";
//        int proxyPort = 8080;
//        FirefoxProfile profile = new FirefoxProfile(); // 使用代理
//        profile.setPreference("network.proxy.type", 1); // http协议代理配置
//        profile.setPreference("network.proxy.http", proxyIp);
//        profile.setPreference("network.proxy.http_port", proxyPort); // 所有协议公用一种代理配置，如果单独配置，这项设置为false，再类似于http的配置
//        profile.setPreference("network.proxy.share_proxy_settings", true); // 对于localhost的不用代理，这里必须要配置，否则无法和webdriver通讯
//        profile.setPreference("network.proxy.no_proxies_on", "localhost"); // 以代理方式启动firefox
//        FirefoxDriver ff = new FirefoxDriver(profile);
//        ff.get("");
//        ff.quit();
//        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//        WebDriver webdriver = new FirefoxDriver();
        System.setProperty("phantomjs.binary.path", "D:\\phantomjs-2.1.1\\bin\\phantomjs.exe");
        WebDriver webdriver = new PhantomJSDriver();


        webdriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webdriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
        webdriver.get("https://www.baidu.com/");


        WebElement keywordEle = webdriver.findElement(By.id("kw"));
        WebElement submitEle = webdriver.findElement(By.xpath("//*[@id=\"su\"]"));

        keywordEle.sendKeys("zhoukai");


        submitEle.click();
//        Actions action = new Actions(webdriver) ;
//        action.moveToElement(webdriver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/p[4]/button"))) ;

        WebElement sourceArticleEle = webdriver.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));
        sourceArticleEle.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(webdriver.getTitle());
        System.out.println(webdriver.getPageSource());
//        webdriver.close();
        webdriver.quit();
    }
}
