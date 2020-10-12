package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_08_이벤트_공지사항 extends TestCase {

	@Test(description = "누구앱 리그레이션 TC : 메뉴_110")
	public void TC_메뉴_110(Method method) throws Exception {
		
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
	
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인"); 
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "이벤트 메뉴 버튼 클릭");
	    util.click(By.id("eventButton"));
	    
	    test.log(Status.INFO, "이벤트 페이지 이동 확인"); 
		boolean 이벤트 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='이벤트']"));
	    Assert.assertTrue(이벤트);
	    
	    test.log(Status.INFO, "리스트내 이벤트 타이틀 이동 확인"); 
		boolean 이벤트타이틀 = util.isElementPresent(By.id("tvTitle"));
	    Assert.assertTrue(이벤트타이틀);
	    
	    test.log(Status.INFO, "리스트내 이벤트 날짜 이동 확인"); 
		boolean 이벤트날짜 = util.isElementPresent(By.id("tvDate"));
	    Assert.assertTrue(이벤트날짜);
	    
	    test.log(Status.INFO, "리스트내 이벤트 진행상태 이동 확인"); 
		boolean 이벤트진행상태 = util.isElementPresent(By.id("tvState"));
	    Assert.assertTrue(이벤트진행상태);
   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_111")
	public void TC_메뉴_111(Method method) throws Exception {
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	    test.log(Status.INFO, "이벤트 메뉴 버튼 클릭");
	    util.click(By.id("eventButton"));
	    
	    test.log(Status.INFO, "이벤트 페이지 이동 확인"); 
		boolean 이벤트 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='이벤트']"));
	    Assert.assertTrue(이벤트);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_112")
	public void TC_메뉴_112(Method method) throws Exception {
	    
		test.log(Status.INFO, "리스트내 이벤트 타이틀 저장"); 
		String 이벤트타이틀 = util.getText(By.id("tvTitle"));
	    
	    test.log(Status.INFO, "리스트내 이벤트 날짜 저장"); 
	    String 이벤트날짜 = util.getText(By.id("tvDate"));

	    test.log(Status.INFO, "리스트내 이벤트 진행상태 저장"); 
	    String 이벤트진행상태 = util.getText(By.id("tvState"));
		
	    test.log(Status.INFO, "최신 이벤트 클릭 후 상세 이동"); 
	    util.click(By.id("tvTitle"));
	
	    test.log(Status.INFO, "이벤트 상세 페이지 이동 확인"); 
		boolean 이벤트상세 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='이벤트 상세']"));
	    Assert.assertTrue(이벤트상세);
	    
	    test.log(Status.INFO, "상세 이벤트 타이틀 확인"); 
	    String 상세이벤트타이틀 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertTrue(이벤트타이틀.contains(상세이벤트타이틀));
	    
	    test.log(Status.INFO, "상세 이벤트 날짜/상태 확인"); 
	    String 날짜와상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[2]"));
	    날짜와상태 = 날짜와상태.replace("-", "");
	    이벤트날짜 = 이벤트날짜.replace(".", "");
	    Assert.assertTrue(날짜와상태.contains(이벤트진행상태));
	    Assert.assertTrue(날짜와상태.contains(이벤트날짜));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_113")
	public void TC_메뉴_113(Method method) throws Exception {
	    
	    test.log(Status.INFO, "페이지 뒤로가기"); 
	    util.Android_BackKey();util.Android_BackKey();util.Android_BackKey();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "공지사항 메뉴 버튼 클릭");
	    util.click(By.id("noticeButton"));
	    
	    test.log(Status.INFO, "공지사항 페이지 이동 확인"); 
		boolean 공지사항 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='공지사항']"));
	    Assert.assertTrue(공지사항);
	    
	    test.log(Status.INFO, "리스트내 공지사항타이틀 이동 확인"); 
		boolean 공지사항타이틀 = util.isElementPresent(By.id("tvNoticeTitle"));
	    Assert.assertTrue(공지사항타이틀);
	    
	    test.log(Status.INFO, "리스트내 공지사항날짜 이동 확인"); 
		boolean 공지사항날짜 = util.isElementPresent(By.id("tvDate"));
	    Assert.assertTrue(공지사항날짜);
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_114")
	public void TC_메뉴_114(Method method) throws Exception {
	    
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	    test.log(Status.INFO, "공지사항 메뉴 버튼 클릭");
	    util.click(By.id("noticeButton"));
	    
	    test.log(Status.INFO, "이벤트 페이지 이동 확인"); 
		boolean 공지사항 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='공지사항']"));
	    Assert.assertTrue(공지사항);
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_115")
	public void TC_메뉴_115(Method method) throws Exception {
	    
	    test.log(Status.INFO, "리스트내 공지사항 타이틀 저장"); 
		String 공지사항타이틀 = util.getText(By.id("tvNoticeTitle"));
		
		test.log(Status.INFO, "리스트내 공지사항 날짜 저장"); 
	    String 공지사항날짜 = util.getText(By.id("tvDate"));
		
		test.log(Status.INFO, "최신 공지사항 클릭 후 상세 이동"); 
	    util.click(By.id("tvNoticeTitle"));
	
	    test.log(Status.INFO, "공지사항 상세 페이지 이동 확인"); 
		boolean 공지사항상세 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='공지사항 상세']"));
	    Assert.assertTrue(공지사항상세);
	    
	    test.log(Status.INFO, "상세 공지사항 타이틀 확인"); 
	    String 상세공지사항타이틀 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertEquals(공지사항타이틀, 상세공지사항타이틀);
	    
	    test.log(Status.INFO, "상세 공지사항 날짜 확인"); 
	    String 공지사항날짜상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[2]"));
	    공지사항날짜상세 = 공지사항날짜상세.replace("-", "");
	    공지사항날짜 = 공지사항날짜.replace(".", "");
	    Assert.assertTrue(공지사항날짜상세.contains(공지사항날짜));
	   
	}
	
}
