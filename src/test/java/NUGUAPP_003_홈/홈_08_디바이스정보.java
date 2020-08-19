package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_08_디바이스정보 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_080")
	public void TC_홈_80(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
	    util.click(By.xpath("//ul[@class='account-list']/li[1]"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 1);
	    
	    test.log(Status.INFO, " 디바이스 리스트에 Android Tmap 표시 확인 "); 
	    boolean Android_Tmap = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='T map (Android) '])"));
	    Assert.assertTrue(Android_Tmap);
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 550, 2);
	    
	    test.log(Status.INFO, " 디바이스 리스트에 iOS Tmap 표시 확인 "); 
	    boolean iOS_Tmap = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='T map (iOS) '])"));
	    Assert.assertTrue(iOS_Tmap);
  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_080")
	public void TC_홈_81(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 리스트에 별명이 [우리집]인 PoC 확인 "); 
	    boolean 우리집 = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='우리집 (AI700_70AC) '])"));
	    Assert.assertTrue(우리집);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_080")
	public void TC_홈_82(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 닫기");
	    util.click(By.id("layerDeviceName"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, " 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 추가 [+] 버튼 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "디바이스 추가 화면으로 이동 확인"); 
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));
	    
	 
	}


}
