package NUGUAPP_003_홈;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_05_날씨 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_042")
	public void TC_홈_042(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");

	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
	    util.click(By.xpath("//ul[@class='account-list']/li[1]"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 허용 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	}
	    
    @Test(description = "누구앱 리그레이션 TC : 홈_043")
	public void TC_홈_043(Method method) throws Exception {
	  
    	test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
		    
	    if (util.isElementPresent(By.id("bannerImageView"))) {
			System.out.println("이벤트배너 [있음]");
			test.log(Status.INFO, "홈카드 스크롤 다운 (y-500) "); 
		    util.swipe(550, 1700, 550, 1000);
		} 
		    
	    test.log(Status.INFO, "홈카드 스크롤 다운 (y-600) "); 
	    util.swipe(550, 1700, 550, 1100);
	    
	    test.log(Status.INFO, "위치정보 갱신"); 
	    util.click(By.id("locationTextView"));
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 허용 "); 
	    util.switchTo().alert().accept();

    }
    
    @Test(description = "누구앱 리그레이션 TC : 홈_044")
	public void TC_홈_044(Method method) throws Exception {
	  
    	test.log(Status.INFO, "위치정보 갱신 후 현재 위치 확인"); 
	    String 위치 = util.getText(By.id("locationTextView"));
	    Assert.assertTrue(위치.contains("서울특별시"));
	    
	    test.log(Status.INFO, "날씨 정보 홈카드 정보 노출 확인 "); 
	    boolean 날씨스테이터스 = util.isElementPresent(By.id("statusImageView"));
	    Assert.assertTrue(날씨스테이터스);

    }
    
    @Test(description = "누구앱 리그레이션 TC : 홈_045")
	public void TC_홈_045(Method method) throws Exception {
    	
    	test.log(Status.INFO, "현재온도 확인"); 
	    String 현재온도  = util.getText(By.id("temperatureTextView"));
	    Assert.assertTrue(현재온도.contains("°"));
	    
	    test.log(Status.INFO, "최고온도 확인"); 
	    String 최고온도 = util.getText(By.id("maxTemperatureTextView"));
	    Assert.assertTrue(최고온도.contains("최고"));
	    
	    test.log(Status.INFO, "최저온도 확인"); 
	    String 최저온도 = util.getText(By.id("minTemperatureTextView"));
	    Assert.assertTrue(최저온도.contains("최저"));
	    
	    test.log(Status.INFO, "강수확률 확인"); 
	    String 강수확률 = util.getText(By.id("rainTextView"));
	    Assert.assertTrue(강수확률.contains("강수확률"));
	    
	    test.log(Status.INFO, "미세먼지 확인"); 
	    String 미세먼지 = util.getText(By.id("dustTextView"));
	    Assert.assertTrue(미세먼지.contains("미세먼지"));
    	

    }
	    	
	    
	  
		
	

}
