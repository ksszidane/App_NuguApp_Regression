package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_03_디바이스메시지 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_006")
	public void TC_홈_006(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
	    util.click(By.id("loginButton"));
	    
	    test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
	    util.click(By.className("btn-secondary-text"));
	    
	    test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
	    util.click(By.className("c-ick"));
	    
	    test.log(Status.INFO, "디바이스 연결없는 계정 로그인");
	    
	    test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
	    util.type(By.id("userId"), "ksszidane1@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
	    util.type(By.id("password"), "rlatjdtn10!!");
	    
	    test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 확인");
	    String 연결하기홈카드 = util.getText(By.id("tvDescription"));
	    Assert.assertEquals(연결하기홈카드, "NUGU 디바이스를 연결해주세요.");
	    
	    test.log(Status.INFO, "첫번째 홈카드 재 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 홈카드 클릭");
	    util.click(By.id("deviceMessageViewPager"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));

	    test.log(Status.INFO, "건너뛰기로 홈 화면 복귀");
	    util.click(By.id("skipButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_007~008")
	public void TC_홈_007_from_008(Method method) throws Exception {
		
		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
	    util.click(By.className("btn-secondary-text"));
	    
	    test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
	    util.click(By.className("c-ick"));
	    
	    test.log(Status.INFO, "디바이스 연결없는 계정 로그인");
	    
	    test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
	    util.type(By.id("userId"), "ksszidane1@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
	    util.type(By.id("password"), "rlatjdtn10!!");
	    
	    test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice_SkipCheck();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 확인");
	    String 연결하기홈카드 = util.getText(By.id("tvDescription"));
	    Assert.assertEquals(연결하기홈카드, "연결을 기다리는 NUGU 디바이스가 있어요.");
	    
	    test.log(Status.INFO, "첫번째 홈카드 재 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금설정하기' 홈카드 클릭");
	    util.click(By.id("deviceMessageViewPager"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.id("descriptionTextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("디바이스 전원을 켜고"));

	}
	
	

}
