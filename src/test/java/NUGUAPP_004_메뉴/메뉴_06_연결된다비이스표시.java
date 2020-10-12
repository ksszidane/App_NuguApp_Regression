package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_06_연결된다비이스표시 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_085")
	public void TC_메뉴_085(Method method) throws Exception {
		
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
	
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인"); 
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "디바이스정보 미표시 확인"); 
		boolean 디바이스정보 = util.isElementPresent(By.id("deviceNameTextView"));
		Assert.assertFalse(디바이스정보);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_086")
	public void TC_메뉴_086(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(2);
	    
	    test.log(Status.INFO, "구글캘린더 도메인 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='Google 캘린더']")));
	    
	    test.log(Status.INFO, "디바이스 연결 필요 안내 노출 확인"); 
		String 디바이스연결필요 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
				+ "/android.view.View/android.view.View[2]/android.view.View"));
	    Assert.assertEquals(디바이스연결필요, "디바이스 연결이 필요합니다.");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_089")
	public void TC_메뉴_089(Method method) throws Exception {
		
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
	
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인"); 
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결된 디바이스 이름 클릭");
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "연결된 디바이스 목록 스크롤 다운");
	    util.swipe(700, 1220, 700, 830, 2);
	    
	    test.log(Status.INFO, "B tv (AI 2_23A4) PoC 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='B tv (AI 2_23A4) ']")));
	    
	    test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(3);
	    
	    test.log(Status.INFO, "SK스토아 도메인 표시 확인"); 
		boolean SK스토아 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='SK스토아']"));
		Assert.assertTrue(SK스토아);
		
		test.log(Status.INFO, "CJ오쇼핑 도메인 표시 확인"); 
		boolean CJ오쇼핑  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='CJ오쇼핑']"));
		Assert.assertTrue(CJ오쇼핑);
	       
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_090")
	public void TC_메뉴_090(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 업 이동");
	    util.scrollUp(4);
	    
	    test.log(Status.INFO, "연결된 디바이스 이름 클릭");
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "연결된 디바이스 목록 스크롤 다운");
	    util.swipe(700, 1220, 700, 830, 2);
	    
	    test.log(Status.INFO, "T map (iOS) PoC 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='T map (iOS) ']")));
	    
	    test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(3);
	    
	    test.log(Status.INFO, "SK스토아 도메인 표시 확인"); 
		boolean SK스토아 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='SK스토아']"));
		Assert.assertFalse(SK스토아);
		
		test.log(Status.INFO, "CJ오쇼핑 도메인 표시 확인"); 
		boolean CJ오쇼핑  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='CJ오쇼핑']"));
		Assert.assertFalse(CJ오쇼핑);
	       
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_092")
	public void TC_메뉴_092(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 업 이동");
	    util.scrollUp(4);
	    
	    test.log(Status.INFO, "연결된 디바이스 이름 클릭");
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "T map (iOS) PoC 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU (NUGU_4228C8) ']")));
	    
	    test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(8);
	    
	    test.log(Status.INFO, "[이런 서비스도 있어요] 확인");
	    boolean 이런서비스 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='이런 서비스도 있어요']"));
		Assert.assertTrue(이런서비스);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_093")
	public void TC_메뉴_093(Method method) throws Exception {
		
		test.log(Status.INFO, "[이런 서비스도 있어요] 클릭");
		util.click(By.xpath("//android.widget.ImageView[@content-desc='이런 서비스도 있어요 열기버튼']"));
	    
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "스타벅스 도메인 표시 확인"); 
		boolean 스타벅스  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		Assert.assertTrue(스타벅스);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_094")
	public void TC_메뉴_094(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 업 이동");
	    util.scrollUp(10);
	    
	    test.log(Status.INFO, "연결된 디바이스 이름 클릭");
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "연결된 디바이스 목록 스크롤 다운");
	    util.swipe(700, 1220, 700, 830, 2);
	    
	    test.log(Status.INFO, "JLR T map (Android) PoC 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='JLR T map (Android) ']")));
	    
	    test.log(Status.INFO, "JLR T map 길안내 도메인 표시 확인"); 
		boolean 길안내  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='JLR T map 길안내']"));
		Assert.assertTrue(길안내);
		
		test.log(Status.INFO, "FLO 도메인 표시 확인"); 
		boolean FLO  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='FLO']"));
		Assert.assertTrue(FLO);
		
		test.log(Status.INFO, "멜론 도메인 표시 확인"); 
		boolean 멜론  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='멜론']"));
		Assert.assertTrue(멜론);
		
		test.log(Status.INFO, "ASMR 도메인 표시 확인"); 
		boolean ASMR  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='ASMR']"));
		Assert.assertTrue(ASMR);
		
		test.log(Status.INFO, "멜론 어린이 도메인 표시 확인"); 
		boolean 멜론어린이  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='멜론 어린이']"));
		Assert.assertTrue(멜론어린이);
		
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "[NUGU play] 확인");
	    boolean 누구플레이 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='NUGU play']"));
		Assert.assertFalse(누구플레이);
	    
	    test.log(Status.INFO, "[이런 서비스도 있어요] 확인");
	    boolean 이런서비스 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='이런 서비스도 있어요']"));
		Assert.assertTrue(이런서비스);
		
		test.log(Status.INFO, "[이런 서비스도 있어요] 클릭");
		util.click(By.xpath("//android.widget.ImageView[@content-desc='이런 서비스도 있어요 열기버튼']"));
	    
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "스타벅스 도메인 표시 확인"); 
		boolean 스타벅스  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		Assert.assertTrue(스타벅스);
		
		test.log(Status.INFO, "스타벅스 도메인 클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		
		test.log(Status.INFO, "사용할 수 없는 서비스 안내 노출 확인"); 
		String 디바이스연결필요 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
				+ "/android.view.View/android.view.View[2]/android.view.View"));
	    Assert.assertEquals(디바이스연결필요, "현재 선택된 디바이스에서\n사용할 수 없는 서비스입니다.");
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
		
	       
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_095")
	public void TC_메뉴_095(Method method) throws Exception {
		
		test.log(Status.INFO, "스크롤 업 이동");
	    util.scrollUp(4);
	    
	    test.log(Status.INFO, "연결된 디바이스 이름 클릭");
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "NUGU (NUGU_4228C8) PoC 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU (NUGU_4228C8) ']")));
	    
	    test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(8);
	    
	    test.log(Status.INFO, "[NUGU Play] 확인");
	    boolean NUGUplay = util.isElementPresent(By.xpath("//android.widget.TextView[@text='NUGU play']"));
		Assert.assertTrue(NUGUplay);
		
		test.log(Status.INFO, "[NUGU Play] 클릭");
		util.click(By.xpath("//android.widget.ImageView[@content-desc='NUGU play 열기버튼']"));
	    
		test.log(Status.INFO, "뮤직/엔터 카테고리 확인"); 
		boolean 뮤직_엔터 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='뮤직/엔터']"));
	    Assert.assertTrue(뮤직_엔터);
	    
	    test.log(Status.INFO, "정보/생활 카테고리 확인"); 
		boolean 정보_생활 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='정보/생활']"));
	    Assert.assertTrue(정보_생활);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='유용한 기능']"))) {
	    	
	    	test.log(Status.INFO, "유용한기능 카테고리 확인"); 
			boolean 유용한기능 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='유용한 기능']"));
		    Assert.assertTrue(유용한기능);
	    } 
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='유용한 기능']"))) {
	    	
	    	test.log(Status.INFO, "유용한기능 카테고리 확인"); 
			boolean 유용한기능 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='유용한 기능']"));
		    Assert.assertTrue(유용한기능);
	    } 
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "교육/유아 카테고리 확인"); 
		boolean 교육_유아 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='교육/유아']"));
	    Assert.assertTrue(교육_유아);
	    
	    test.log(Status.INFO, "비즈니스/경제 카테고리 확인"); 
		boolean 비즈니스_경제  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='비즈니스/경제']"));
	    Assert.assertTrue(비즈니스_경제);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='종교']"))) {
	    	
	    	test.log(Status.INFO, "종교 카테고리 확인"); 
			boolean 종교  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='종교']"));
		    Assert.assertTrue(종교);
	    } 
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='종교']"))) {
	    	
	    	test.log(Status.INFO, "종교 카테고리 확인"); 
			boolean 종교  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='종교']"));
		    Assert.assertTrue(종교);
	    } 
	    
	    test.log(Status.INFO, "게임 카테고리 확인"); 
		boolean 게임  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='게임']"));
	    Assert.assertTrue(게임);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "스마트홈기능 카테고리 확인"); 
		boolean 스마트홈기능  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='스마트홈 기능']"));
	    Assert.assertTrue(스마트홈기능);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='기타']"))) {
	    	
	    	test.log(Status.INFO, "기타 카테고리 확인"); 
			boolean 기타  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='기타']"));
		    Assert.assertTrue(기타);
	    } 
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='기타']"))) {
	    	
	    	test.log(Status.INFO, "기타 카테고리 확인"); 
			boolean 기타  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='기타']"));
		    Assert.assertTrue(기타);
	    } 
	       
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_096")
	public void TC_메뉴_096(Method method) throws Exception {
	    
	    test.log(Status.INFO, "NUGU 활용하기 Tip"); 
		boolean tip  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='NUGU 활용하기 Tip']"));
	    Assert.assertTrue(tip);
	    
	    test.log(Status.INFO, "NUGU 활용하기 Tip 상세"); 
		boolean tip상세  = util.isElementPresent(By.id("useTextView"));
	    Assert.assertTrue(tip상세);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_096")
	public void TC_메뉴_097(Method method) throws Exception {
	    
		test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "[이런 서비스도 있어요] 클릭");
		util.click(By.xpath("//android.widget.ImageView[@content-desc='이런 서비스도 있어요 열기버튼']"));
	    
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "스타벅스 도메인 표시 확인"); 
		boolean 스타벅스  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		Assert.assertTrue(스타벅스);
		
		test.log(Status.INFO, "스타벅스 도메인 클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		
		test.log(Status.INFO, "사용할 수 없는 서비스 안내 노출 확인"); 
		String 디바이스연결필요 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
				+ "/android.view.View/android.view.View[2]/android.view.View"));
	    Assert.assertEquals(디바이스연결필요, "현재 선택된 디바이스에서\n사용할 수 없는 서비스입니다.");
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	}
	

}
