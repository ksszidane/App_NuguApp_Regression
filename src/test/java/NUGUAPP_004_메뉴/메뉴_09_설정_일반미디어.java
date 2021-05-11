package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.NUGU_TestCase;

public class 메뉴_09_설정_일반미디어 extends NUGU_TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_116")
	public void TC_메뉴_116(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "설정 메뉴 버튼 클릭");
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "설정 페이지 이동 확인"); 
		boolean 설정  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='설정']"));
	    Assert.assertTrue(설정);

	    test.log(Status.INFO, "리스트의 사용자설정 메뉴 확인"); 
		boolean 사용자설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
	    Assert.assertTrue(사용자설정);
	    
	    test.log(Status.INFO, "리스트의 디바이스설정 메뉴 확인"); 
		boolean 디바이스설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='디바이스 설정']"));
	    Assert.assertTrue(디바이스설정);
	    
	    test.log(Status.INFO, "리스트의 앱설정 메뉴 확인"); 
		boolean 앱설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='앱 설정']"));
	    Assert.assertTrue(앱설정);
	    
	    test.log(Status.INFO, "리스트의 고객센터 메뉴 확인"); 
		boolean 고객센터 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='고객센터']"));
	    Assert.assertTrue(고객센터);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_117")
	public void TC_메뉴_117(Method method) throws Exception {
		
		test.log(Status.INFO, "사용자 설정 리스트 클릭");
        util.click(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
        
        test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "사용자 설정 구성 T아이디  확인"); 
		boolean T아이디 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='T아이디']"));
	    Assert.assertTrue(T아이디);
	    
	    test.log(Status.INFO, "사용자 설정 구성 뮤직기본서비스  확인"); 
		boolean 뮤직기본서비스 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='뮤직 기본 서비스']"));
	    Assert.assertTrue(뮤직기본서비스);
	    
	    test.log(Status.INFO, "사용자 설정 구성 배송지관리  확인"); 
		boolean 배송지관리 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='배송지 관리']"));
	    Assert.assertTrue(배송지관리);
	    
	    test.log(Status.INFO, "사용자 설정 구성 음성주문설정  확인"); 
		boolean 음성주문설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='음성 주문 설정']"));
	    Assert.assertTrue(음성주문설정);
	    
	    test.log(Status.INFO, "사용자 설정 구성 환율정보  확인"); 
		boolean 환율정보 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='환율정보']"));
	    Assert.assertTrue(환율정보);
	    
	    test.log(Status.INFO, "사용자 설정 구성 서비스 설정  확인"); 
		boolean 서비스설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='서비스 설정']"));
	    Assert.assertTrue(서비스설정);
        
	    test.log(Status.INFO, "페이지 스크롤 다운"); 
	    util.scrollDown(4);
	    
	    test.log(Status.INFO, "사용자 설정 구성 로그아웃 버튼 확인"); 
		boolean 로그아웃 = util.isElementPresent(By.id("btnSettingLogout"));
	    Assert.assertTrue(로그아웃);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_118")
	public void TC_메뉴_118(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	    test.log(Status.INFO, "설정 메뉴 버튼 클릭");
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "사용자 설정 리스트 클릭");
        util.click(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
        
        test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_119")
	public void TC_메뉴_119(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	    test.log(Status.INFO, "설정 메뉴 버튼 클릭");
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "사용자 설정 리스트 클릭");
        util.click(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
        
        test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_120")
	public void TC_메뉴_120(Method method) throws Exception {
		
		test.log(Status.INFO, "앱에 로그인한 TID 정보 노출"); 
		String T아이디 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
	    Assert.assertEquals(T아이디, "ksszidane@naver.com");
	    
	    test.log(Status.INFO, "T아이디  클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='T아이디']"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
		Thread.sleep(3000);
		util.ProgressBar_Loading();
	    
	    Thread.sleep(1500);
	    test.log(Status.INFO, "화면캡쳐");
        String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
        test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
	    
	    test.log(Status.INFO, "페이지 뒤로가기");
	    util.Android_BackKey();
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_122")
	public void TC_메뉴_122(Method method) throws Exception {
		
		test.log(Status.INFO, "뮤직 기본서비스 안내문구 확인"); 
		String 뮤직기본 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout[1]/android.widget.TextView[2]"));
	    Assert.assertEquals(뮤직기본, "우선 재생 음악 서비스를 설정해주세요.");
		
		test.log(Status.INFO, "뮤직기본서비스  클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='뮤직 기본 서비스']"));
		
		test.log(Status.INFO, "전체 설정하기 버튼 확인"); 
	    boolean 전체설정하기 = util.isElementPresent(By.id("btnServiceSetAll"));
	    Assert.assertTrue(전체설정하기);
	    
	    test.log(Status.INFO, "연결된 디바이스 목록 확인"); 
		for(int i=1; i < 10; i++) {
	    	String 디바이스목록 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]"));
		    System.out.println(i + "번 : " + 디바이스목록);
		    	
		    Assert.assertTrue(util.dataCheck_Contains(디바이스목록, data.연결된디바이스목록_set));
	    }
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "사용자 설정 확인"); 
		boolean 사용자설정 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
	    Assert.assertTrue(사용자설정);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_123")
	public void TC_메뉴_123(Method method) throws Exception {
		
		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
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
	    
	    test.log(Status.INFO, "설정 메뉴 버튼 클릭");
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "사용자 설정 리스트 클릭");
        util.click(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
        
        test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뮤직기본서비스  클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='뮤직 기본 서비스']"));
		
		test.log(Status.INFO, "뮤직 기본서비스 안내문구 확인"); 
		String 연결된디바이스없음 = util.getText(By.id("tvNotFoundInfo"));
	    Assert.assertEquals(연결된디바이스없음, "설정 가능한 디바이스가 없습니다.");
	    
	    test.log(Status.INFO, "전체 설정하기 버튼 미노출 확인"); 
	    boolean 전체설정하기 = util.isElementPresent(By.id("btnServiceSetAll"));
	    Assert.assertFalse(전체설정하기);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_124")
	public void TC_메뉴_124(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "설정 메뉴 버튼 클릭");
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "사용자 설정 리스트 클릭");
        util.click(By.xpath("//android.widget.TextView[@text='사용자 설정']"));
        
        test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뮤직기본서비스  클릭"); 
		util.click(By.xpath("//android.widget.TextView[@text='뮤직 기본 서비스']"));
	
	    test.log(Status.INFO, "전체 설정하기 버튼 버튼 클릭"); 
	    util.click(By.id("btnServiceSetAll"));
	    
	    test.log(Status.INFO, "action sheet 리스트 확인"); 
		for(int i=1; i < 4; i++) {
	    	String 뮤직CP목록 = util.fast_getText(By.xpath("//android.widget.ListView"
	    	+"/android.widget.TextView["+i+"]"));
		    System.out.println(i + "번 : " + 뮤직CP목록);
		    
		    Assert.assertEquals(뮤직CP목록, data.뮤직CP목록[i-1]);
	    }
		
		test.log(Status.INFO, "멜론선택"); 
	    util.click(By.xpath("//android.widget.ListView/android.widget.TextView[2]"));
	    
	    test.log(Status.INFO, "안내팝업 메세지 확인");
	    String 멜론안내팝업 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(멜론안내팝업, "멜론을 모든 디바이스의 뮤직 기본 서비스로 설정합니다.");
	    
	    test.log(Status.INFO, "안내팝업 [확인] 클릭");
	    util.click(By.id("positiveButton"));
	    
	    test.log(Status.INFO, "멜론으로 전체 변경 확인"); 
		for(int i=1; i < 10; i++) {
	    	String CP변경확인 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.LinearLayout["+i+"]/android.widget.TextView[2]"));
		    System.out.println(i + "번 : " + CP변경확인);
		    	
		    Assert.assertEquals(CP변경확인, "멜론");
	    }
		
		test.log(Status.INFO, "전체 설정하기 버튼 버튼 클릭"); 
	    util.click(By.id("btnServiceSetAll"));
	    
	    test.log(Status.INFO, "FLO 선택"); 
	    util.click(By.xpath("//android.widget.ListView/android.widget.TextView[1]"));
	    
	    test.log(Status.INFO, "안내팝업 메세지 확인");
	    String FLO안내팝업 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(FLO안내팝업, "FLO를 모든 디바이스의 뮤직 기본 서비스로 설정합니다.");
	    
	    test.log(Status.INFO, "안내팝업 [확인] 클릭");
	    util.click(By.id("positiveButton"));
	    
	    test.log(Status.INFO, "FLO으로 전체 변경 확인"); 
		for(int i=1; i < 11; i++) {
	    	String CP변경확인 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.LinearLayout["+i+"]/android.widget.TextView[2]"));
		    System.out.println(i + "번 : " + CP변경확인);
		    	
		    Assert.assertEquals(CP변경확인, "FLO");
	    }
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_127")
	public void TC_메뉴_127(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU_4228C8 기본뮤직 서비스 변경 버튼 클릭"); 
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView"
		    	+"/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
		
		test.log(Status.INFO, "멜론선택"); 
	    util.click(By.xpath("//android.widget.ListView/android.widget.TextView[2]"));
	    
	    test.log(Status.INFO, "멜론으로 변경 확인"); 
	    String 멜론CP변경확인 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
		    	+"/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
	    Assert.assertEquals(멜론CP변경확인, "멜론");
	    
	    test.log(Status.INFO, "테스트를 위한 볼륨1 설정"); 
	    util.sendPost("볼륨 1", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "노래 들려줘 발화 후 멜론 실행 확인"); 
	    util.sendPost("노래 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    String tts1 = util.TTS_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 7);
	    Assert.assertTrue(tts1.contains("멜론"));
	    
	    test.log(Status.INFO, "미디어 중지 발화"); 
	    util.sendPost("그만", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "NUGU_4228C8 기본뮤직 서비스 변경 버튼 클릭"); 
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView"
		    	+"/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
		
		test.log(Status.INFO, "FLO선택"); 
	    util.click(By.xpath("//android.widget.ListView/android.widget.TextView[1]"));
	    
	    test.log(Status.INFO, "FLO으로 변경 확인"); 
	    String FLOCP변경확인 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
		    	+"/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
	    Assert.assertEquals(FLOCP변경확인, "FLO");
	    
	    test.log(Status.INFO, "테스트를 위한 볼륨1 설정"); 
	    util.sendPost("볼륨 1", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "노래 들려줘 발화 후 멜론 실행 확인"); 
	    util.sendPost("노래 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    String tts2 = util.TTS_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(tts2.contains("Flo"));
	    
	    test.log(Status.INFO, "미디어 중지 발화"); 
	    util.sendPost("그만", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	
	}

}
