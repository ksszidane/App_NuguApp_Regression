package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_02_홈카드 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_002")
	public void TC_홈_002(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 허용 "); 
	    util.switchTo().alert().accept();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "아이디 영역 확인");
	    String userName = util.getText(By.id("userNameTextView"));
	    Assert.assertTrue(userName.contains("ksszidane"));
	    
	 
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_003")
	public void TC_홈_003(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 선택 셀렉박스 오픈"); 
		util.click(By.id("deviceNameTextView"));
		
		test.log(Status.INFO, "NU100 선택"); 
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout/android.widget.TextView[@text='NUGU (NUGU_4228C8) ']"));
		
		test.log(Status.INFO, "메뉴 닫기 클릭"); 
		util.click(By.id("ivHeaderClose"));
		
	    test.log(Status.INFO, "디바이스메세지 카드 유무 확인 "); 
	    boolean 디바이스메세지 = util.isElementPresent(By.id("deviceMessageViewPager"));
	    Assert.assertTrue(디바이스메세지);
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_004")
	public void TC_홈_004(Method method) throws Exception {
		
		if (util.isElementPresent(By.id("bannerImageView"))) {
			System.out.println("이벤트배너 [있음]");
			test.log(Status.INFO, "홈카드 스크롤 다운 (y-500) "); 
		    util.swipe(550, 1700, 550, 1200);
		} 
		
		
		test.log(Status.INFO, "현재시간 구하기"); 
	    String 현재시간 = util.DateTime();
	    String 현재분 = util.Time_min();
	    String 최근인기대화기준시간 = util.getText(By.id("tvCreatedDateTime"));

	    int min = Integer.parseInt(현재분);
		    
	    test.log(Status.INFO, "최근 인기 대화 기준시간 확인 "); 
	    if (min < 26) {
	    	String 한시간전 = util.Time_HOUR_after();
	    	System.out.println(한시간전);
		    Assert.assertEquals(최근인기대화기준시간, 한시간전+":25 기준");
	    } else { 
	    	System.out.println(현재시간);
	    	Assert.assertEquals(최근인기대화기준시간, 현재시간+":25 기준");
	    }
	    test.log(Status.INFO, "최근 인기 대화 리스트 갯수 확인"); 
	    int 갯수 = util.getSize(By.id("tvPopularUtteranceStart"));
	    if (갯수!=5) {
	    	갯수 = util.getSize(By.id("tvPopularUtteranceStart"));
	    	Assert.assertEquals(갯수, 5);
	    } else {
	    	Assert.assertEquals(갯수, 5);
	    }
  
	    for(int i=0; i<8; i++) {
	    	String 최근인기대화타이틀 = util.getText(By.id("tvDeviceName"));
	    	//int idx = 최근인기대화타이틀.indexOf(" 최근"); 
	    	//String PoC = 최근인기대화타이틀.substring(0, idx);

		    System.out.println(최근인기대화타이틀);
		    test.log(Status.INFO, "최근인기 대화 PoC 순서 확인");
		    Assert.assertEquals(최근인기대화타이틀, NUGU_data.data.PoC리스트[i] + " 최근 인기 대화");
		    

			if (util.isElementPresent(By.id("bannerImageView"))) {
				test.log(Status.INFO, "좌측플리킹 동작");
				util.swipe(900, 1250, 200, 1250);
			} else {
				test.log(Status.INFO, "좌측플리킹 동작");
				util.swipe(900, 1550, 200, 1550);
			}
		    
	    }
		    
		test.log(Status.INFO, "최근 인기 대화 페이지뷰 확인");
		util.click(By.id("tvDeviceName"));
		String 최근인기대화타이틀 = util.getText(By.xpath("//android.widget.TextView"));
		Assert.assertEquals(최근인기대화타이틀, "최근 인기 대화");
		    
		Thread.sleep(1500);
		test.log(Status.INFO, "화면캡쳐");
	    String screenShotPath = util.ErrorScreenshots(util, "screenShotName");
	    test.log(Status.INFO, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		    
		test.log(Status.INFO, "최근 인기 대화창 닫기");
		util.click(By.id("actionClose"));
		    
		    
	}

}
