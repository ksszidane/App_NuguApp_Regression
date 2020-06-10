package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 연결_05_NUGU_Btv extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_218")
	public void TC_연결_218(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "+ 디바이스 추가 연결버튼 확인 및 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "Btv PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='B tv']"));
		
		test.log(Status.INFO, "Btv PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "B tv 셋톱박스 홈 메뉴에서\n" + 
									"[MY > 기기 연결 설정 > NUGU 서비스 연결]을 선택하세요.");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_124")
	public void TC_연결_124(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU inside 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("NUGU inside"));
	    
	    test.log(Status.INFO, "Btv PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='B tv']"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_220")
	public void TC_연결_220(Method method) throws Exception {
		
		test.log(Status.INFO, "Btv 연결화면 헬프버튼 문구 확인");
		String help = util.getText(By.id("helpButton"));
		Assert.assertEquals(help, "Btv 연결 도움말 보기");
		
		test.log(Status.INFO, "Btv 연결화면 헬프버튼 클릭");
		util.click(By.id("helpButton"));
		
		test.log(Status.INFO, "Btv 연결화면 헬프 연결 문구 확인");
		String 안내문구 = util.getText(By.className("android.widget.TextView"));
		Assert.assertEquals(안내문구, "B tv 연결 도움말");
		
		test.log(Status.INFO, "WebView 영역 확인");
		boolean WebView = util.isElementPresent(By.className("android.webkit.WebView"));
		Assert.assertTrue(WebView);
		
		test.log(Status.INFO, "닫기 버튼 클릭");
		util.click(By.id("actionClose"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_224")
	public void TC_연결_224(Method method) throws Exception {
		
		test.log(Status.INFO, "Btv  연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
	    test.log(Status.INFO, "Btv 인증번호 입력 안내텍스트 확인");
		String 인증번호입력안내 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(인증번호입력안내, "TV 화면에 표시된\n인증번호 6자리를 입력하세요.");
		
		test.log(Status.INFO, "Btv 인증번호 입력필드(******) 노출 확인");
		boolean 인증번호입력필드 = util.isElementPresent(By.id("otpEditText"));
		Assert.assertTrue(인증번호입력필드);
	    
	}
	
}
