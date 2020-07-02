package NUGUAPP_003_홈;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_04_최근인기대화 extends TestCase {

	@Test(description = "누구앱 리그레이션 TC : 홈_038")
	public void TC_홈_038_01(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
	    util.click(By.className("account-list"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU (NUGU_4228C8) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    ArrayList<String> 최근인기대화넘버링리스트 = new ArrayList<String>();
	    ArrayList<String> 최근인기대화값리스트 = new ArrayList<String>();
	    
	    for(int i=1; i < 11; i++) {
	    	최근인기대화넘버링리스트.add(util.getText(By.xpath("//*[@class='d.t.a.b']/android.widget.LinearLayout["+i+"]"
		    		+ "android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout"
		    		+ "android.widget.TextView[1]")));
	    	
	    	최근인기대화값리스트.add(util.getText(By.xpath("//*[@class='d.t.a.b']/android.widget.LinearLayout["+i+"]"
		    		+ "android.widget.LinearLayout/android.widget.ViewFlipper/android.widget.LinearLayout"
		    		+ "android.widget.TextView[2]")));
	    }
	    System.out.println(최근인기대화넘버링리스트);
	    System.out.println(최근인기대화값리스트);
	    
	    
	  
	    
	  
		
	}
}
