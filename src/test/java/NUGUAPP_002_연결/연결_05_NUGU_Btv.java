package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.nativekey.AndroidKey;
import junit.framework.Assert;
import unit.NUGU_TestCase;

public class 연결_05_NUGU_Btv extends NUGU_TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_218 | 중복 : 연결_248, 연결_260, 연결_267")
	public void TC_연결_218(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_248, 연결_260, 연결_267");
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().accept();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
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
	
	@Test(description = "누구앱 리그레이션 TC : 연결_219 | 중복 : 연결_246, 연결_261, 연결_268")
	public void TC_연결_219(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_246, 연결_261, 연결_268");
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU inside 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.xpath("//android.widget.TextView[@text='NUGU inside']"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("NUGU inside"));
	    
	    test.log(Status.INFO, "Btv PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='B tv']"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_220 | 중복 : 연결_247, 연결_270, 연결_271")
	public void TC_연결_220(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_247, 연결_270, 연결_271");
		test.log(Status.INFO, "Btv 연결화면 헬프버튼 문구 확인");
		String help = util.getText(By.id("helpButton"));
		Assert.assertEquals(help, "Btv 연결 도움말 보기");
		
		test.log(Status.INFO, "Btv 연결화면 헬프버튼 클릭");
		util.click(By.id("helpButton"));
		/*	
		test.log(Status.INFO, "Btv 연결화면 헬프 연결 문구 확인");
		String 안내문구 = util.getTextWait(By.className("android.widget.TextView"));
		Assert.assertEquals(안내문구, "B tv 연결 도움말");
		        
        There is an additional step necessary within your app build, unfortunately. 
        As described in the Android remote debugging docs it is necessary to set to true the setWebContentsDebuggingEnabled property on the android.webkit.WebView element.
     	개발자 확인이 필요함. 	        
        */
		
		Thread.sleep(1500);
		test.log(Status.INFO, "화면캡쳐");
		String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
	
		test.log(Status.INFO, "WebView 영역 확인");
		boolean WebView = util.isElementPresent(By.className("android.webkit.WebView"));
		Assert.assertTrue(WebView);
		
		test.log(Status.INFO, "닫기 버튼 클릭");
		util.click(By.id("actionClose"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_224 | 중복 : 연결_248, 연결_262, 연결_260, 연결_276")
	public void TC_연결_224(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_248, 연결_262, 연결_260, 연결_276");
		test.log(Status.INFO, "Btv  연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
	    test.log(Status.INFO, "Btv 인증번호 입력 안내텍스트 확인");
		String 인증번호입력안내 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(인증번호입력안내, "TV 화면에 표시된\n인증번호 6자리를 입력하세요.");
		
		test.log(Status.INFO, "Btv 인증번호 입력필드(******) 노출 확인");
		boolean 인증번호입력필드 = util.isElementPresent(By.id("otpEditText"));
		Assert.assertTrue(인증번호입력필드);
		
		test.log(Status.INFO, "하단 연결버튼 비활성화 확인");
		boolean 버튼활성화 = util.isEnabled(By.id("connectButton"));
		Assert.assertFalse(버튼활성화);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_225 | 중복 : 연결_249, 연결_263, 연결_277")
	public void TC_연결_225(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_249, 연결_263, 연결_277");
		test.log(Status.INFO, "인증번호 입력 필드 클릭");
		util.click(By.id("otpEditText"));
		
		test.log(Status.INFO, "인증번호 6자리 입력");
		util.AndroidKey_Num1();util.AndroidKey_Num2();util.AndroidKey_Num3();
		util.AndroidKey_Num4();util.AndroidKey_Num5();util.AndroidKey_Num6();
		
		test.log(Status.INFO, "인증번호 7번째 자리수 입력");
		util.AndroidKey_Num7();
		
		Thread.sleep(1500);
		test.log(Status.INFO, "화면캡쳐");
		String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		
		test.log(Status.INFO, "처음 6자리만 입력되고 7번째 자리수 입력안됨 확인");
		String 인증번호입력 = util.getText(By.id("otpEditText"));
		Assert.assertEquals(인증번호입력, "123456");
		
		test.log(Status.INFO, "기타 영역 클릭하여 입력 키패드 숨김");
		util.touchTab(400, 520);
		
		test.log(Status.INFO, "하단 연결버튼비활성화 확인");
		boolean 버튼활성화 = util.isEnabled(By.id("connectButton"));
		Assert.assertTrue(버튼활성화);
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_226 | 중복 : 연결_250, 연결_264, 연결_278")
	public void TC_연결_226(Method method) throws Exception {
		
		test.log(Status.INFO, "중복 : 연결_250, 연결_264, 연결_278");
		test.log(Status.INFO, "인증번호 입력 필드 클릭");
		util.click(By.id("connectButton"));
		
		test.log(Status.INFO, "인증번호 실패 팝업 메시지");
		String 팝업메세지 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(팝업메세지, "인증번호 확인 후 다시 시도해주세요.");
		
		test.log(Status.INFO, "인증번호 실패 팝업 확인");
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO, "입력된 숫자 제거 확인");
		String 인증번호입력 = util.getText(By.id("otpEditText"));
		Assert.assertEquals(인증번호입력, "******");
	}
	
}
