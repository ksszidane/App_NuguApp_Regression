package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.nativekey.AndroidKey;
import junit.framework.Assert;
import unit.TestCase;

public class 연결_07_NUGU_Tmap extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_334")
	public void TC_연결_334(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "TMap PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='T map']"));
		
		test.log(Status.INFO, "TMap PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "NUGU 서비스 연결을 위해 T map 인증을 해주세요.");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
	}
	
	
	@Test(description = "누구앱 리그레이션 TC : 연결_336")
	public void TC_연결_336(Method method) throws Exception {
		
		test.log(Status.INFO, "TMap 연결 [T Map 앱에서 인증하기 >]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "TMap 실행 후 연결 로딩 확인");
	    util.ProgressBar_Loading();
		
		test.log(Status.INFO, "TMap PoC 연결 완료 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "연결이 완료되었습니다.\n이제 T map에서 NUGU와 대화해보세요.");
			
		test.log(Status.INFO, "TMap PoC 가이드 문구 확인");
		String 가이드문구 = util.getText(By.id("guideTextView"));
		Assert.assertEquals(가이드문구, "“아리아, 길안내해줘”");
		
		test.log(Status.INFO, "NUGU 서비스 시작하기 버튼 클릭");
		util.click(By.id("startButton"));
		
		test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결된 PoC TMap 확인");
		String 연결된PoC = util.getText(By.id("btnDeviceSelect"));
		Assert.assertEquals(연결된PoC, "T map");
		
		test.log(Status.INFO, "(이전설정으로 복귀)디바이스 설정 버튼 클릭"); 
	    util.click(By.id("ivDeviceSetting"));
	    
	    test.log(Status.INFO, "(이전설정으로 복귀)연결해제 버튼 클릭"); 
	    util.click(By.id("btnDisconnect"));
	    
	    test.log(Status.INFO, "(이전설정으로 복귀)연결해제 완료 클릭"); 
	    util.click(By.id("positiveButton"));


	}
	
	
	
}
