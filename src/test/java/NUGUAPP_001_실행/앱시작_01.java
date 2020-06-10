package NUGUAPP_001_실행;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 앱시작_01 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 실행_004")
	public void TC_앱실행_004(Method method) throws Exception {

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
	public void TC_앱실행_005(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NATIVE_APP으로 화면 전환");
	    util.context("NATIVE_APP");
		
		test.log(Status.INFO, "인트로 화면 이동 확인");
        String 인트로안내 = util.getText(By.id("loginDescriptionTextView"));
        Assert.assertEquals(인트로안내, "NUGU를 이용하려면 T아이디 로그인이 필요합니다.");
        
	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_007")
	public void TC_앱실행_007(Method method) throws Exception {
		
		
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
		
	    Thread.sleep(1500);
	    test.log(Status.INFO, "화면캡쳐");
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
	public void TC_앱실행_008(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();
	
		test.log(Status.INFO, "인트로 화면 이동 확인");
        String 인트로안내 = util.getText(By.id("loginDescriptionTextView"));
        Assert.assertEquals(인트로안내, "NUGU를 이용하려면 T아이디 로그인이 필요합니다.");
		
        
	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_010")
	public void TC_앱실행_010(Method method) throws Exception {

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
		
	    Thread.sleep(1500);
	    test.log(Status.INFO, "화면캡쳐");
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        
        test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();

	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_011")
	public void TC_앱실행_011(Method method) throws Exception {

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
		
	    Thread.sleep(1500);
	    test.log(Status.INFO, "화면캡쳐");
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
        
        test.log(Status.INFO, "인트로 화면 이동 위한 Back 키");
		util.Android_BackKey();

	}
	
	@Test(description = "누구앱 리그레이션 TC : 실행_012~13")
	public void TC_앱실행_012_from_013(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 확인"); 
	    util.switchTo().alert().accept();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    //util.swipe(0, 2000, 0, 0);
	    util.scrollDown(3);
	    util.click(By.id("btnSettingLogout"));
	    
	    

    }
	
	@Test(description = "누구앱 리그레이션 TC : 실행_014~15")
	public void TC_앱실행_014_from_015(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
        util.click(By.className("c-ick"));
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
        util.type(By.id("userId"), "01032450613");
        
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
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    util.scrollDown(3);
	    util.click(By.id("btnSettingLogout"));
		
    }
	
	@Test(description = "누구앱 리그레이션 TC : 실행_016")
	public void TC_앱실행_016(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
        util.click(By.className("c-ick"));
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
        util.type(By.id("userId"), "ksszidane10@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
        util.type(By.id("password"), "tjdtn10!!");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane10"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    util.scrollDown(3);
	    util.click(By.id("btnSettingLogout"));
	    
	    test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "자동로그인 저장 여부 확인(시나리오상 저장 안됨 확인)");
        String 자동저장ID = util.getText(By.className("id-email"));
        Assert.assertNotSame(자동저장ID, "ksszidane10@naver.com");

    }
	
	@Test(description = "누구앱 리그레이션 TC : 실행_017~018")
	public void TC_앱실행_017_from_018(Method method) throws Exception {
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 없음");
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
        util.type(By.id("userId"), "ksszidane@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
        util.type(By.id("password"), "rlatjdtn10!!");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    util.scrollDown(3);
	    util.click(By.id("btnSettingLogout"));
	    
	    test.log(Status.INFO, "자동로그인 로그 아웃시 자동로그인 체크 해제 팝업 확인");
        String 팝업메세지 = util.getText(By.id("contentTextView"));
        Assert.assertTrue(팝업메세지.contains("로그아웃하시려면 자동 로그인 해제에 체크 후 로그아웃 버튼을 눌러주세요."));
        
        test.log(Status.INFO, "취소버튼 확인 및 클릭");
        util.click(By.id("negativeButton"));
        
        test.log(Status.INFO, "로그아웃 재 클릭 로그아웃 하기");
        util.click(By.id("btnSettingLogout"));
        util.click(By.id("positiveButton"));
	    
	    test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "자동로그인 저장 여부 확인(시나리오상 저장 확인)");
        String 자동저장ID = util.getText(By.className("id-email"));
        Assert.assertEquals(자동저장ID, "ksszidane@naver.com");

    }
	
	@Test(description = "누구앱 리그레이션 TC : 실행_020")
	public void TC_앱실행_020(Method method) throws Exception {
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
    	
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	    test.log(Status.INFO, "로그아웃");
	    util.click(By.id("userNameTextView"));
	    util.scrollDown(3);
	    util.click(By.id("btnSettingLogout"));
	    
	    test.log(Status.INFO, "자동로그인 로그 아웃시 자동로그인 체크 해제 팝업 확인");
        String 팝업메세지 = util.getText(By.id("contentTextView"));
        Assert.assertTrue(팝업메세지.contains("로그아웃하시려면 자동 로그인 해제에 체크 후 로그아웃 버튼을 눌러주세요."));
        
        test.log(Status.INFO, "취소버튼 확인 및 클릭");
        util.click(By.id("negativeButton"));
        
        test.log(Status.INFO, "로그아웃 재 클릭 로그아웃 하기");
        util.click(By.id("btnSettingLogout"));
        util.click(By.id("positiveButton"));

    }
	
	@Test(description = "누구앱 리그레이션 TC : 실행_021")
	public void TC_앱실행_021(Method method) throws Exception {
        
        test.log(Status.INFO, "와이파이 / 셀룰러 데이터 Off");
        adb.ADB_WiFi_Off(udid);
        adb.ADB_cellular_Off(udid);
              
        test.log(Status.INFO, "앱 재 실행 후 네트워크 연결상태 팝업 확인");
        util.resetApp();
        String 팝업메세지 = util.getText(By.id("contentTextView"));
        Assert.assertTrue(팝업메세지.contains("데이터 네트워크 연결상태를 확인하고 다시 시도해주세요."));
        
        test.log(Status.INFO, "와이파이 / 셀룰러 데이터 On");
        adb.ADB_WiFi_On(udid);
        adb.ADB_cellular_On(udid);
        
    }

}
