package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.NUGU_TestCase;

public class 메뉴_01_메뉴패널 extends NUGU_TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_001")
	public void TC_메뉴_001(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_002")
	public void TC_메뉴_002(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 패널 닫힘 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 홈화면이동확인 = util.isElementPresent(By.id("deviceMessageViewPager"));
	    Assert.assertTrue(홈화면이동확인);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_003")
	public void TC_메뉴_003(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	    test.log(Status.INFO, "좌측플리킹 동작");
		util.swipe(900, 1550, 200, 1550);
		
		test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 홈화면이동확인 = util.isElementPresent(By.id("deviceMessageViewPager"));
	    Assert.assertTrue(홈화면이동확인);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_004")
	public void TC_메뉴_004(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "하단 [자주 묻는 질문 메뉴] 확인 "); 
	    boolean 자주묻는질문 = util.isElementPresent(By.id("faqButton"));
	    Assert.assertTrue(자주묻는질문);
	    
	    test.log(Status.INFO, "하단 [이벤트] 확인 "); 
	    boolean 이벤트 = util.isElementPresent(By.id("eventButton"));
	    Assert.assertTrue(이벤트);
	    
	    test.log(Status.INFO, "하단 [공지사항] 확인 "); 
	    boolean 공지사항 = util.isElementPresent(By.id("noticeButton"));
	    Assert.assertTrue(공지사항);
	    
	    test.log(Status.INFO, "하단 [설정] 확인 "); 
	    boolean 설정 = util.isElementPresent(By.id("settingsButton"));
	    Assert.assertTrue(설정);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_005")
	public void TC_메뉴_005(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 이동");
	    util.scrollDown(3);
	    
	    test.log(Status.INFO, "우측 상단 [닫기] 버튼 확인"); 
	    boolean 우측상단닫기버튼 = util.isElementPresent(By.id("ivHeaderClose"));
	    Assert.assertTrue(우측상단닫기버튼);
	    
	    test.log(Status.INFO, "하단 [자주 묻는 질문 메뉴] 확인 "); 
	    boolean 자주묻는질문 = util.isElementPresent(By.id("faqButton"));
	    Assert.assertTrue(자주묻는질문);
	    
	    test.log(Status.INFO, "하단 [이벤트] 확인 "); 
	    boolean 이벤트 = util.isElementPresent(By.id("eventButton"));
	    Assert.assertTrue(이벤트);
	    
	    test.log(Status.INFO, "하단 [공지사항] 확인 "); 
	    boolean 공지사항 = util.isElementPresent(By.id("noticeButton"));
	    Assert.assertTrue(공지사항);
	    
	    test.log(Status.INFO, "하단 [설정] 확인 "); 
	    boolean 설정 = util.isElementPresent(By.id("settingsButton"));
	    Assert.assertTrue(설정);
	    
	    test.log(Status.INFO, "메뉴 패널 닫힘 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_006")
	public void TC_메뉴_006(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "스크롤 이동");
	    util.scrollUp(4);
	    
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_007")
	public void TC_메뉴_007(Method method) throws Exception {
		
		test.log(Status.INFO, "개인정보 리스트 확인 ");
	    util.click(By.id("userNameTextView"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "사용자 설정 화면 이동 확인"); 
		boolean 사용자설정화면 = util.isElementPresent(By.id("rvMain"));
	    Assert.assertTrue(사용자설정화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_008")
	public void TC_메뉴_008(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[주문내역] 버튼 클릭");
	    util.click(By.id("purchaseListButton"));
	    
	    test.log(Status.INFO, "주문내역 페이지 이동 확인"); 
		boolean 주문내역화면 = util.isElementPresent(By.id("rvPurchase"));
	    Assert.assertTrue(주문내역화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_009")
	public void TC_메뉴_009(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "이용권 페이지 이동 확인"); 
		boolean 이용권구매화면 = util.isElementPresent(By.id("rvTicketServices"));
	    Assert.assertTrue(이용권구매화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
		
	}

}
