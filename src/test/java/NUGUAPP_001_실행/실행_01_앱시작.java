package NUGUAPP_001_실행;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 실행_01_앱시작 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 실행_004")
	public void TC_004_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "AppActivity으로 화면 확인");
	    util.switchContext("NATIVE_APP");
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "로그인 화면 이동 확인");
        String 로그인타이틀 = util.getText(By.className("title-main"));
        Assert.assertEquals(로그인타이틀, "T아이디 로그인");

	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_005")
	public void TC_005_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.context("NATIVE_APP");
		
		test.log(Status.INFO, "인트로 화면 이동 확인");
        String 인트로안내 = util.getText(By.id("loginDescriptionTextView"));
        Assert.assertEquals(인트로안내, "NUGU를 이용하려면 T아이디 로그인이 필요합니다.");
        
	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_007")
	public void TC_007_앱실행(Method method) throws Exception {
		
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
		
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
		
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
    
        test.log(Status.INFO, "T아이디로 가입 버튼 유효성 체크 및 클릭");
        util.click(By.id("newJoin"));
        
        test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.switchContext("NATIVE_APP");
		
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        
        /*
        test.log(Status.INFO, "약관동의 이동 확인");
        String 인트로안내 = util.getText(By.className("title-main"));
        Assert.assertEquals(인트로안내, "가입 약관 동의");
        
        There is an additional step necessary within your app build, unfortunately. 
        As described in the Android remote debugging docs it is necessary to set to true the setWebContentsDebuggingEnabled property on the android.webkit.WebView element.
         	개발자 확인이 필요함. 
        
        */
	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_008")
	public void TC_008_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();
	
		test.log(Status.INFO, "인트로 화면 이동 확인");
        String 인트로안내 = util.getText(By.id("loginDescriptionTextView"));
        Assert.assertEquals(인트로안내, "NUGU를 이용하려면 T아이디 로그인이 필요합니다.");
		
        
	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_010")
	public void TC_010_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
		
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
    
        test.log(Status.INFO, "아이디 찾기버튼 유효성 체크 및 클릭");
        util.click(By.id("findId")); //resetPwd
        
        test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.switchContext("NATIVE_APP");
		
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        
        test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();

	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_011")
	public void TC_011_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
		
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
    
        test.log(Status.INFO, "아이디 찾기버튼 유효성 체크 및 클릭");
        util.click(By.id("resetPwd"));
        
        test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.switchContext("NATIVE_APP");
		
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        
        test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();

	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_012~13")
	public void TC_012_013_앱실행(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
        util.click(By.className("c-ick"));
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
        util.type(By.id("userId"), "ksszidane@naver.com");
        
        test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '비유효' 암호입력");
        util.type(By.id("password"), "123456789");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "계정 유효 값 처리 확인");
	    String 유효성체크텍스트 = util.getText(By.className("form-msg"));
	    
	    Assert.assertEquals(유효성체크텍스트, "아이디 또는 비밀번호를 정확하게 입력해주세요.\n" + 
	    		"(10회 이상 실패하면 비밀번호를 다시 설정하셔야 합니다.)");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
        util.type(By.id("password"), "rlatjdtn10!!");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    util.switchTo().alert().accept();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    

    }
	
	//@Test(description = "누구앱 리그레이션 TC : 실행_014~15")
	public void TC_014_015_앱실행(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
        util.click(By.id("c-ick"));
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 전화번호 아이디 입력");
        util.type(By.id("userId"), "01032450613");
        
        test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '비유효' 암호입력");
        util.type(By.id("password"), "123456789");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "계정 유효 값 처리 확인");
	    String 유효성체크텍스트 = util.getText(By.className("form-msg"));
	    System.out.println("계정 유효 값 처리 확인 : "+ 유효성체크텍스트);
	    
	    Assert.assertEquals(유효성체크텍스트, "아이디 또는 비밀번호를 정확하게 입력해주세요.\n" + 
	    		"(10회 이상 실패하면 비밀번호를 다시 설정하셔야 합니다.)");
	  
		util.Android_BackKey();
		util.switchContext("NATIVE_APP");
		
		
		
    }
	
	
	public void TC_02_앱실행_로그인_Test(Method method) throws Exception {
		
		test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
	    WebElement 다른아이디로그인 = util.findElement(By.xpath("//a[@data-click-id='link_gotoLogin']"));
	    다른아이디로그인.click();
	    Thread.sleep(2000);
	            
	    test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
	    WebElement 자동로그인체크해제 = util.findElement(By.xpath("//span[@class='c-ick']"));
	    자동로그인체크해제.click();
	    
	    test.log(Status.INFO, "아이디입력필드 유효성 체크 및 아이디입력");
	    WebElement 아이디입력 = util.findElement(By.xpath("//input[@id='userId']"));
	    아이디입력.sendKeys("ksszidane@naver.com");
	    
	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및 패스워드입력");
	    WebElement 패스워드입력 = util.findElement(By.xpath("//input[@id='password']"));
	    패스워드입력.sendKeys("tjdtn10!!");
	    
	    test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		WebElement 로그인하기 = util.findElement(By.xpath("//button[@id='authLogin']"));
	    로그인하기.click();

	    test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.switchContext("NATIVE_APP");
	    Thread.sleep(5000);
			
	    test.log(Status.INFO, "퍼미션 확인");
	    util.switchTo().alert().accept();
    	Thread.sleep(2000);
    }
	
	
	

}
