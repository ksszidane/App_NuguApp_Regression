package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.NUGU_TestCase;

public class 홈_01_홈카드 extends NUGU_TestCase {
	
	int eventbanner;
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_01")
	public void TC_홈_001_01(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "디바이스메세지 카드 유무 확인 "); 
	    boolean 디바이스메세지 = util.isElementPresent(By.id("deviceMessageViewPager"));
	    Assert.assertTrue(디바이스메세지);
	
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001-02")
	public void TC_홈_001_02(Method method) throws Exception {

		if (util.isElementPresent(By.id("bannerImageView"))) {
			eventbanner = 400;
			System.out.println("이벤트배너 [있음]");
		} 
		
	    test.log(Status.INFO, "홈카드 스크롤 다운 (y-500) "); 
	    util.swipe(550, 1700, 550, 1200-eventbanner);
	    
	    test.log(Status.INFO, "인기대화 카드 유무 확인 "); 
	    boolean 인기대화 = util.isElementPresent(By.id("popularCardViewPager"));
	    Assert.assertTrue(인기대화);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001-03")
	public void TC_홈_001_03(Method method) throws Exception {
	    
	    test.log(Status.INFO, "홈카드 스크롤 다운 (y-500) "); 
	    util.swipe(550, 1700, 550, 1200);
	    
	    test.log(Status.INFO, "날씨 카드 유무 확인 "); 
	    boolean 날씨 = util.isElementPresent(By.id("weatherLayout"));
	    Assert.assertTrue(날씨);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_04")
	public void TC_홈_001_04(Method method) throws Exception {
	    
	    test.log(Status.INFO, "홈카드 페이지 이동카드 유무 확인 "); 
	    String 홈카드페이지이동카드1 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    												+"android.widget.RelativeLayout/android.widget.TextView"));
	    Assert.assertTrue(util.dataCheck_Equals(홈카드페이지이동카드1, data.홈카드페이지이동카드_set));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_05")
	public void TC_홈_001_05(Method method) throws Exception {
	    
	    test.log(Status.INFO, "홈카드 스크롤 다운 (y-600) "); 
	    util.swipe(550, 1700, 550, 1100);
	    
	    test.log(Status.INFO, "테마 발화문 카드 유무 확인 "); 
	    String 테마발화문 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
												+"/android.widget.LinearLayout"+"/android.widget.LinearLayout"
												+"/android.widget.LinearLayout"+"/android.widget.TextView"));
	    Assert.assertTrue(util.dataCheck_Contains(테마발화문, data.테마발화문카드_set));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_06")
	public void TC_홈_001_06(Method method) throws Exception {
	 
	    test.log(Status.INFO, "홈카드 스크롤 다운 (y-600) "); 
	    util.swipe(550, 1700, 550, 1100);
	    
	    test.log(Status.INFO, "미디어 카드 유무 확인 "); 
	    String 미디어타이틀 = util.getText(By.id("titleTextView"));
	    Assert.assertTrue(util.dataCheck_Equals(미디어타이틀, data.미디어카드_set));
	    boolean 미디어카드플레이뷰 = util.isElementPresent(By.id("playImageView"));
	    Assert.assertTrue(미디어카드플레이뷰);
	    boolean 미디어카드플레이이미지뷰 = util.isElementPresent(By.id("contentImageView"));
	    Assert.assertTrue(미디어카드플레이이미지뷰);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_07")
	public void TC_홈_001_07(Method method) throws Exception {
		
		test.log(Status.INFO, "홈카드 스크롤 다운 (y-400) "); 
	    util.swipe(550, 1700, 550, 1300);
	    
	    test.log(Status.INFO, "테마 발화문 카드 유무 확인 "); 
	    String 테마발화문 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
												+"/android.widget.LinearLayout"+"/android.widget.LinearLayout"
												+"/android.widget.LinearLayout"+"/android.widget.TextView"));
	    Assert.assertTrue(util.dataCheck_Contains(테마발화문, data.테마발화문카드_set));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_08")
	public void TC_홈_001_08(Method method) throws Exception {

		test.log(Status.INFO, "홈카드 스크롤 다운 (y-400) "); 
	    util.swipe(550, 1700, 550, 1300);
	    
	    test.log(Status.INFO, "홈카드 페이지 이동카드 유무 확인 "); 
	    String 홈카드페이지이동카드 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    												+"android.widget.RelativeLayout/android.widget.TextView"));
	    Assert.assertTrue(util.dataCheck_Equals(홈카드페이지이동카드, data.홈카드페이지이동카드_set));
   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_09")
	public void TC_홈_001_09(Method method) throws Exception {
		
		test.log(Status.INFO, "홈카드 스크롤 다운 (y-550) "); 
	    util.swipe(550, 1700, 550, 1150);
		    
		 test.log(Status.INFO, "미디어 카드 유무 확인 "); 
		 String 미디어카드타이틀 = util.getTextWait(By.id("titleTextView"));
		 Assert.assertTrue(util.dataCheck_Equals(미디어카드타이틀, data.미디어카드_set));
		 boolean 미디어카드플레이뷰 = util.isElementPresent(By.id("playImageView"));
		 Assert.assertTrue(미디어카드플레이뷰);
		 boolean 미디어카드플레이이미지뷰 = util.isElementPresent(By.id("contentImageView"));
		 Assert.assertTrue(미디어카드플레이이미지뷰);
		 
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_10")
	public void TC_홈_001_10(Method method) throws Exception {
		   
		test.log(Status.INFO, "테마 발화문 카드 유무 확인 "); 
	    String 테마발화문 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
												+"/android.widget.LinearLayout"+"/android.widget.LinearLayout"
												+"/android.widget.LinearLayout"+"/android.widget.TextView"));
	    Assert.assertTrue(util.dataCheck_Contains(테마발화문, data.테마발화문카드_set));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_11")
	public void TC_홈_001_11(Method method) throws Exception {
		    
		test.log(Status.INFO, "홈카드 스크롤 다운 (y-300) "); 
		 util.swipe(550, 1700, 550, 1400);
		 
		test.log(Status.INFO, "추천 NUGU Play 유무 확인 "); 
	    String 오픈Play타이틀 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
												+"/android.widget.LinearLayout[2]"+"/android.widget.TextView"));
	    Assert.assertEquals(오픈Play타이틀, "추천 NUGU play");
	    String 오픈Play = util.getText(By.id("serviceName"));
	    Assert.assertTrue(util.dataCheck_Equals(오픈Play, data.오픈Play_set));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_001_12")
	public void TC_홈_001_12(Method method) throws Exception {

		test.log(Status.INFO, "홈카드 스크롤 다운 (y-600) "); 
	    util.swipe(550, 1700, 550, 1100);
		
	    test.log(Status.INFO, "고객센터 바로가기 버튼 확인"); 
	    String 고객센터바로가기  = util.getText(By.id("customerCenterTextView"));
	    Assert.assertEquals(고객센터바로가기, "고객센터 바로가기");
	    
	    test.log(Status.INFO, "SK Telecom 펼치기 버튼 클릭"); 
	    util.click(By.id("expandButton"));
	    
	    test.log(Status.INFO, "Footer 메세지 확인"); 
	    String Footer메세지  = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(Footer메세지, "SK텔레콤(주)은 통신판매중개자로서 거래 당사자가 아니며, "
	    		+ "입점 판매자가 등록한 상품 정보 및 거래에 대해 SK텔레콤(주)은 일체 책임을 지지 않습니다.\n\n" + 
	    		"대표이사/사장 박정호 사업자등록번호 104-81-37225 판매허가번호 중구 02923호 주소 서울특별시 중구 을지로");
	    
	    test.log(Status.INFO, "SK Telecom 접기 버튼 클릭"); 
	    util.click(By.id("expandButton"));
	    
	    test.log(Status.INFO, "Footer 영역 사라짐 확인"); 
	    boolean Footer사라짐 = util.isElementPresent(By.id("contentTextView"));
	    Assert.assertFalse(Footer사라짐);

	}

}
