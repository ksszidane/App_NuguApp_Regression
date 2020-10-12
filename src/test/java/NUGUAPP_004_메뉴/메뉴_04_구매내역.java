package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_04_구매내역 extends TestCase {
	
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_052")
	public void TC_메뉴_052(Method method) throws Exception {
		
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
		
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();

		test.log(Status.INFO, "이용중인 NUGU 이용권 영역 클릭"); 
		util.click(By.id("tvTicketCurrentUse"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));
	    
	    test.log(Status.INFO, "[멜론] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "구매 가능한 이용권 없음 확인"); 
		String 구매가능한이용권없음 = util.getText(By.id("tvNotFoundInfo"));
	    Assert.assertEquals(구매가능한이용권없음, "NUGU 이용권 구매 내역이 없습니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_053")
	public void TC_메뉴_053(Method method) throws Exception {
		
		test.log(Status.INFO, "구매한 이용권 정보");
		String 구매한이용권정보 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.TextView"));
	    Assert.assertEquals(구매한이용권정보, "NUGU 서비스에서 구매한 이용권 정보만 확인 가능합니다.");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_054")
	public void TC_메뉴_054(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "NUGU 이용권 구매 화면으로 이동"); 
	    boolean 쿠폰등록 = util.isElementPresent(By.id("btnTicketMenuGuide"));
		Assert.assertTrue(쿠폰등록);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_055")
	public void TC_메뉴_055(Method method) throws Exception {
		
		test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("tvTicketCurrentUse"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(2);
	    
	    test.log(Status.INFO, "필터 리스트 고정 영역 노출 확인"); 
	    boolean 고정영역 = util.isElementPresent(By.id("layerTicketPurchaseAgent"));
	    Assert.assertTrue(고정영역);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_056")
	public void TC_메뉴_056(Method method) throws Exception {
		
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));

	    test.log(Status.INFO, "판매중인 [이용권 리스트] 영역 노출 확인"); 
		for(int i=1; i < 8; i++) {

	    	String 이용권리스트 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.RelativeLayout["+i+"]/android.widget.TextView"));
		    System.out.println(i + "번 : " + 이용권리스트);
		    	
		    Assert.assertTrue(이용권리스트.contains(NUGU_data.data.구매내역도메인[i-1]));
	    }
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_057")
	public void TC_메뉴_057(Method method) throws Exception {
		
		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='전체']"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "스크롤 업 이동");
	    util.scrollUp(3);
	    
	    test.log(Status.INFO, "구매한 이용권 [오디오북] 확인"); 
	    String 오디오북구매 = util.getText(By.id("tvTicketPurchaseName"));
		Assert.assertTrue(오디오북구매.contains("오디오북"));
		
		test.log(Status.INFO, "스크롤 다운 이동");
	    util.scrollDown(3);
	    
	    test.log(Status.INFO, "구매한 이용권 [FLO] 확인"); 
	    String FLO구매 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout"
	    		+ "/android.widget.TextView"));
		Assert.assertEquals(FLO구매, "FLO");

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_060")
	public void TC_메뉴_060(Method method) throws Exception {
		
		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));
		
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='FLO']"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[FLO] 도메인 확인"); 
	    boolean FLO도메인 = util.isElementPresent(By.id("tvTicketPurchaseAgent"));
		Assert.assertTrue(FLO도메인);
		
		test.log(Status.INFO, "[FLO] 이미지 확인"); 
		boolean FLO이미지 = util.isElementPresent(By.id("ivTicketPurchase"));
	    Assert.assertTrue(FLO이미지);
		
		test.log(Status.INFO, "[FLO] 이용권명 확인"); 
		boolean FLO이용권명= util.isElementPresent(By.id("ivTicketPurchase"));
	    Assert.assertTrue(FLO이용권명);
	    
	    test.log(Status.INFO, "[FLO] 서비스ID 확인"); 
		boolean FLO서비스ID= util.isElementPresent(By.id("tvTicketPurchaseServiceId"));
	    Assert.assertTrue(FLO서비스ID);
	    
	    test.log(Status.INFO, "[FLO] 프로모션명 확인"); 
		boolean FLO프로모션명 = util.isElementPresent(By.id("tvTicketPurchaseName"));
	    Assert.assertTrue(FLO프로모션명);
	    
	    test.log(Status.INFO, "[FLO] 시작일 확인"); 
		boolean FLO시작일 = util.isElementPresent(By.id("tvTicketPurchaseDate"));
	    Assert.assertTrue(FLO시작일);
	    
	    test.log(Status.INFO, "[FLO] 이용권상태 확인"); 
		boolean FLO이용권상태 = util.isElementPresent(By.id("tvTicketPurchaseState"));
	    Assert.assertTrue(FLO이용권상태);


	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_061")
	public void TC_메뉴_061(Method method) throws Exception {
		
		 test.log(Status.INFO, "[FLO] 이용권상세 이동"); 
		 util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));

		 test.log(Status.INFO, "[FLO] 이미지 노출 확인"); 
		 boolean 이미지 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[1]/android.widget.Image"));
		 Assert.assertTrue(이미지);
		 
		 test.log(Status.INFO, "[FLO] 도메인 노출 확인"); 
		 String 도메인 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[2]"));
		 Assert.assertEquals(도메인, "FLO");
		 
		 test.log(Status.INFO, "[FLO] 구매일 노출 확인"); 
		 boolean 구매일 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[3]"));
		 Assert.assertTrue(구매일);
		 
		 test.log(Status.INFO, "[FLO] 도메인 노출 확인"); 
		 String 이용권명 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[4]"));
		 Assert.assertEquals(이용권명, "FLO NUGU 무제한 이용권");
		 
		 test.log(Status.INFO, "[FLO] 프로모션 노출 확인"); 
		 String 프로모션 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[5]"));
		 Assert.assertEquals(프로모션, "첫 3개월 무료");
		 
		 test.log(Status.INFO, "[FLO] 이벤트아이콘 노출 확인"); 
		 String 이벤트 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[6]/android.view.View[1]"));
		 Assert.assertEquals(이벤트, "EVENT");
		 
		 test.log(Status.INFO, "[FLO] 상태 노출 확인"); 
		 String 상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[6]/android.view.View[2]"));
		 Assert.assertEquals(상태, "직권해지");
		 
		 test.log(Status.INFO, "[FLO] 주문번호 노출 확인"); 
		 String 주문번호 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View[1]"));
		 Assert.assertEquals(주문번호, "주문번호");
		 
		 test.log(Status.INFO, "[FLO] 주문번호상세 노출 확인"); 
		 String 주문번호상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(주문번호상세, "201812281457009460");
		 
		 test.log(Status.INFO, "[FLO] 구매ID 노출 확인"); 
		 String 구매ID = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[1]"));
		 Assert.assertEquals(구매ID, "구매ID");
		 
		 test.log(Status.INFO, "[FLO] 구매ID상세 노출 확인"); 
		 String 구매ID상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(구매ID상세.contains("**@naver.com"));
		 
		 test.log(Status.INFO, "[FLO] 이용권명 노출 확인"); 
		 String 이용권명1 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[1]"));
		 Assert.assertEquals(이용권명1, "이용권명");
		 
		 test.log(Status.INFO, "[FLO] 이용권명상세 노출 확인"); 
		 String 이용권명상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(이용권명상세, "FLO NUGU 무제한 이용권");
		 
		 test.log(Status.INFO, "[FLO] 이용항목 노출 확인"); 
		 String 이용항목 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View[1]"));
		 Assert.assertEquals(이용항목, "이용항목");
		 
		 test.log(Status.INFO, "[FLO] 이용항목상세 노출 확인"); 
		 String 이용항목상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(이용항목상세, "첫 3개월 무료");
		 
		 test.log(Status.INFO, "[FLO] 이용기간 노출 확인"); 
		 String 이용기간 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[5]/android.view.View[1]"));
		 Assert.assertEquals(이용기간, "이용기간");
		 
		 test.log(Status.INFO, "[FLO] 이용기간상세ID상세 노출 확인"); 
		 String 이용기간상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[5]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(이용기간상세.contains("시작일"));
		 
		 test.log(Status.INFO, "[FLO] 결제수단 노출 확인"); 
		 String 결제수단 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[6]/android.view.View[1]"));
		 Assert.assertEquals(결제수단, "결제수단");
		 
		 test.log(Status.INFO, "[FLO] 결제수단상세 노출 확인"); 
		 String 결제수단상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[6]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(결제수단상세, "신용카드");
		 
		 test.log(Status.INFO, "[FLO] 이메일 노출 확인"); 
		 String 이메일 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[7]/android.view.View[1]"));
		 Assert.assertEquals(이메일, "이메일");
		 
		 test.log(Status.INFO, "[FLO] 이메일상세 노출 확인"); 
		 String 이메일상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[7]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(이메일상세.contains("@naver.com"));
		 
		 test.log(Status.INFO, "[FLO] 결제정보 노출 확인"); 
		 String 결제정보 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View[1]"));
		 Assert.assertEquals(결제정보, "결제정보");
		 
		 test.log(Status.INFO, "[FLO] 결제정보상세 노출 확인"); 
		 boolean 결제정보상세 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View[2]/android.widget.ListView"));
		 Assert.assertTrue(결제정보상세);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_063")
	public void TC_메뉴_063(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
		
		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));
		
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='오디오북']"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[오디오북] 도메인 확인"); 
	    boolean 도메인 = util.isElementPresent(By.id("tvTicketPurchaseAgent"));
		Assert.assertTrue(도메인);
		
		test.log(Status.INFO, "[오디오북] 이미지 확인"); 
		boolean 이미지 = util.isElementPresent(By.id("ivTicketPurchase"));
	    Assert.assertTrue(이미지);
		
		test.log(Status.INFO, "[오디오북] 이용권명 확인"); 
		boolean 이용권명= util.isElementPresent(By.id("ivTicketPurchase"));
	    Assert.assertTrue(이용권명);
	    
	    test.log(Status.INFO, "[오디오북] 서비스ID 확인"); 
		boolean 서비스ID= util.isElementPresent(By.id("tvTicketPurchaseServiceId"));
	    Assert.assertTrue(서비스ID);
	    
	    test.log(Status.INFO, "[오디오북] 프로모션명 확인"); 
		boolean 프로모션명 = util.isElementPresent(By.id("tvTicketPurchaseName"));
	    Assert.assertTrue(프로모션명);
	    
	    test.log(Status.INFO, "[오디오북] 시작일 확인"); 
		boolean 시작일 = util.isElementPresent(By.id("tvTicketPurchaseDate"));
	    Assert.assertTrue(시작일);
	    
	    test.log(Status.INFO, "[오디오북] 이벤트아이콘 확인"); 
		boolean 이벤트아이콘 = util.isElementPresent(By.id("ivTicketPurchaseEventIcon"));
	    Assert.assertTrue(이벤트아이콘);
	    
	    test.log(Status.INFO, "[오디오북] 이용권상태 확인"); 
		boolean 이용권상태 = util.isElementPresent(By.id("tvTicketPurchaseState"));
	    Assert.assertTrue(이용권상태);


	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_064")
	public void TC_메뉴_064(Method method) throws Exception {
		
		 test.log(Status.INFO, "[오디오북] 이용권상세 이동"); 
		 util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));

		 test.log(Status.INFO, "[오디오북] 이미지 노출 확인"); 
		 boolean 이미지 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[1]/android.widget.Image"));
		 Assert.assertTrue(이미지);
		 
		 test.log(Status.INFO, "[오디오북] 도메인 노출 확인"); 
		 String 도메인 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[2]"));
		 Assert.assertEquals(도메인, "오디오북");
		 
		 test.log(Status.INFO, "[오디오북] 구매일 노출 확인"); 
		 boolean 구매일 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[3]"));
		 Assert.assertTrue(구매일);
		 
		 test.log(Status.INFO, "[오디오북] 도메인 노출 확인"); 
		 String 이용권명 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[4]"));
		 Assert.assertEquals(이용권명, "[오디오북]NUGU 전용 무제한 스트리밍");
		 
		 test.log(Status.INFO, "[오디오북] 프로모션 노출 확인"); 
		 String 프로모션 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[5]"));
		 Assert.assertEquals(프로모션, "매월 정기결제 (첫 1개월 무료)");
		 
		 test.log(Status.INFO, "[오디오북] 이벤트아이콘 노출 확인"); 
		 String 이벤트 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[6]/android.view.View[1]"));
		 Assert.assertEquals(이벤트, "EVENT");
		 
		 test.log(Status.INFO, "[오디오북] 상태 노출 확인"); 
		 String 상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.view.View[6]/android.view.View[2]"));
		 Assert.assertEquals(상태, "기간만료");
		 
		 test.log(Status.INFO, "[오디오북] 주문번호 노출 확인"); 
		 String 주문번호 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View[1]"));
		 Assert.assertEquals(주문번호, "주문번호");
		 
		 test.log(Status.INFO, "[오디오북] 주문번호상세 노출 확인"); 
		 String 주문번호상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(주문번호상세, "201907181010284600");
		 
		 test.log(Status.INFO, "[오디오북] 구매ID 노출 확인"); 
		 String 구매ID = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[1]"));
		 Assert.assertEquals(구매ID, "구매ID");
		 
		 test.log(Status.INFO, "[오디오북] 구매ID상세 노출 확인"); 
		 String 구매ID상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(구매ID상세.contains("@naver.com"));
		 
		 test.log(Status.INFO, "[오디오북] 이용권명 노출 확인"); 
		 String 이용권명1 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[1]"));
		 Assert.assertEquals(이용권명1, "이용권명");
		 
		 test.log(Status.INFO, "[오디오북] 이용권명상세 노출 확인"); 
		 String 이용권명상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(이용권명상세, "[오디오북]NUGU 전용 무제한 스트리밍");
		 
		 test.log(Status.INFO, "[오디오북] 이용항목 노출 확인"); 
		 String 이용항목 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View[1]"));
		 Assert.assertEquals(이용항목, "이용항목");
		 
		 test.log(Status.INFO, "[오디오북] 이용항목상세 노출 확인"); 
		 String 이용항목상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(이용항목상세, "매월 정기결제 (첫 1개월 무료)");
		 
		 test.log(Status.INFO, "[오디오북] 이용기간 노출 확인"); 
		 String 이용기간 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[5]/android.view.View[1]"));
		 Assert.assertEquals(이용기간, "이용기간");
		 
		 test.log(Status.INFO, "[오디오북] 이용기간상세 노출 확인"); 
		 String 이용기간상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[5]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(이용기간상세.contains("시작일"));
		 
		 test.log(Status.INFO, "[오디오북] 결제수단 노출 확인"); 
		 String 결제수단 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[6]/android.view.View[1]"));
		 Assert.assertEquals(결제수단, "결제수단");
		 
		 test.log(Status.INFO, "[오디오북] 결제수단상세 노출 확인"); 
		 String 결제수단상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[6]/android.view.View[2]/android.view.View"));
		 Assert.assertEquals(결제수단상세, "신용카드");
		 
		 test.log(Status.INFO, "[오디오북] 이메일 노출 확인"); 
		 String 이메일 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[7]/android.view.View[1]"));
		 Assert.assertEquals(이메일, "이메일");
		 
		 test.log(Status.INFO, "[오디오북] 이메일상세 노출 확인"); 
		 String 이메일상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[7]/android.view.View[2]/android.view.View"));
		 Assert.assertTrue(이메일상세.contains("@naver.com"));
		 
		 test.log(Status.INFO, "[오디오북] 결제정보 노출 확인"); 
		 String 결제정보 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View[1]"));
		 Assert.assertEquals(결제정보, "결제정보");
		 
		 test.log(Status.INFO, "[오디오북] 결제정보상세 노출 확인"); 
		 boolean 결제정보상세 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				 + "/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View[2]/android.widget.ListView"));
		 Assert.assertTrue(결제정보상세);

	}
	


}
