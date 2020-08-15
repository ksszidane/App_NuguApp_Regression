package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_06_디바이스컨트롤러 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_054")
	public void TC_홈_054(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
	    util.click(By.xpath("//ul[@class='account-list']/li[2]"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[+]플로팅 버튼 노출 확인 "); 
	    boolean 플로팅버튼 = util.isElementPresent(By.id("ibDeviceFab"));
	    Assert.assertTrue(플로팅버튼);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_055")
	public void TC_홈_055(Method method) throws Exception {
		
		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
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
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "[+]플로팅 버튼 노출 확인 "); 
	    boolean NUGU컨트롤러화면 = util.isElementPresent((By.xpath("//android.view.ViewGroup[@content-desc='NUGU 컨트롤러 화면']")));
	    Assert.assertTrue(NUGU컨트롤러화면);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 닫기"); 
	    util.click(By.id("ivHeaderClose"));
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	   
	}


}
