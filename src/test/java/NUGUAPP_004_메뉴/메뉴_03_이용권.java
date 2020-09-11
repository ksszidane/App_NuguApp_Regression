package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_03_이용권 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_028")
	public void TC_메뉴_028(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "[쿠폰등록] 버튼 노출 확인"); 
	    boolean 쿠폰등록 = util.isElementPresent(By.id("btnTicketMenuGuide"));
		Assert.assertTrue(쿠폰등록);
		
		test.log(Status.INFO, "[이용중인 이용권] 영역 노출 확인"); 
	    boolean 이용중인이용권 = util.isElementPresent(By.id("tvTicketCurrentUse"));
		Assert.assertTrue(이용중인이용권);
		
		test.log(Status.INFO, "판매중인 [이용권 리스트] 영역 노출 확인"); 
		for(int i=1; i < 8; i++) {

	    	String 이용권리스트 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.RelativeLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView"));
		    System.out.println(i + "번 : " + 이용권리스트);
		    	
		    Assert.assertTrue(이용권리스트.contains(NUGU_data.data.판매중이용원리스트[i-1]));
	    }

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_029")
	public void TC_메뉴_029(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_030")
	public void TC_메뉴_030(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		 
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
		
		test.log(Status.INFO, "스크롤 다운 이동"); 
		util.scrollDown(2);
		
		test.log(Status.INFO, "[쿠폰등록] 버튼 노출 확인"); 
	    boolean 쿠폰등록 = util.isElementPresent(By.id("btnTicketMenuGuide"));
		Assert.assertTrue(쿠폰등록);
		
		test.log(Status.INFO, "[이용중인 이용권] 영역 노출 확인"); 
	    boolean 이용중인이용권 = util.isElementPresent(By.id("tvTicketCurrentUse"));
		Assert.assertTrue(이용중인이용권);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_031")
	public void TC_메뉴_031(Method method) throws Exception {
		
		test.log(Status.INFO, "[쿠폰등록] 버튼 클릭"); 
	    util.click(By.id("btnTicketMenuGuide"));
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [취소] 활성화 확인"); 
	    boolean 취소버튼 = util.isElementPresent(By.id("cancelButton"));
		Assert.assertTrue(취소버튼);
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [번호입력란] 노출 확인"); 
	    boolean 번호입력란 = util.isElementPresent(By.id("couponNumberEditText"));
		Assert.assertTrue(번호입력란);
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [인증] 비활성화 확인"); 
		boolean 인증버튼비활성 = util.isEnabled(By.id("registerButton"));
		Assert.assertFalse(인증버튼비활성);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_032")
	public void TC_메뉴_032(Method method) throws Exception {
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [번호입력란] 15자리 번호 입력"); 
	    util.type(By.id("couponNumberEditText"), "0123456789012345");
	    
	    test.log(Status.INFO, "[쿠폰등록] 팝업 [인증] 활성화 확인"); 
		boolean 인증버튼활성 = util.isEnabled(By.id("registerButton"));
		Assert.assertTrue(인증버튼활성);
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [인증]버튼 클릭");
		util.click(By.id("registerButton"));
		
		test.log(Status.INFO, "[쿠폰등록] 비유효 쿠폰 확인");
		String 에러메시지 = util.getText(By.id("errorMessageTextView"));
		Assert.assertEquals(에러메시지, "유효 하지 않는 쿠폰번호입니다. 쿠폰번호를 다시 확인해주세요.");
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [취소]버튼 클릭");
		util.click(By.id("cancelButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_034")
	public void TC_메뉴_034(Method method) throws Exception {
		
		test.log(Status.INFO, "보유중인 이용권 없을대 안내 확인"); 
		String 이용중인이용권 = util.getText(By.id("tvTicketCurrentUse"));
		Assert.assertEquals(이용중인이용권, "현재 이용중인 이용권이 없습니다.");
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_036")
	public void TC_메뉴_036(Method method) throws Exception {
		
		test.log(Status.INFO, "판매중인 [이용권 리스트] 영역 노출 상세 확인"); 
		for(int i=1; i < 7; i++) {
			
			boolean 인증버튼활성 = util.isElementPresent(By.xpath("//androidx.recyclerview.widget.RecyclerView"
			    	+"/android.widget.RelativeLayout["+i+"]/android.widget.LinearLayout/android.widget.ImageView"));
			Assert.assertTrue(인증버튼활성);

	    	String 이용권리스트 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.RelativeLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView"));
		    System.out.println(i + "번 : " + 이용권리스트);
		    	
		    Assert.assertTrue(이용권리스트.contains(NUGU_data.data.판매중이용원리스트[i-1]));
	    }
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_037")
	public void TC_메뉴_037(Method method) throws Exception {
		
		test.log(Status.INFO, "이용중인 NUGU 이용권 영역 클릭"); 
		util.click(By.id("tvTicketCurrentUse"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));
	    
	    test.log(Status.INFO, "[FLO] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='FLO']")));
		
		test.log(Status.INFO, "선택된 리스트 도메인 확인"); 
		String FLO이용권리스트확인 = util.getText(By.id("tvTicketPurchaseAgent"));
	    Assert.assertEquals(FLO이용권리스트확인, "FLO");
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerTicketPurchaseAgent"));
	    
	    test.log(Status.INFO, "[오디오북] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='오디오북']")));
		
		test.log(Status.INFO, "선택된 리스트 도메인 확인"); 
		String 오디오북이용권리스트확인 = util.getText(By.id("tvTicketPurchaseAgent"));
	    Assert.assertEquals(오디오북이용권리스트확인, "오디오북");
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_038")
	public void TC_메뉴_038(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "첫번째 [FLO 이용권] 버튼 클릭");
	    util.click(By.id("ticketAgentNameAndIconLayout"));
	    
	    test.log(Status.INFO, "선택 선택디바스의 이용 가능한 이용권 안내 비활성화 확인"); 
		boolean 현재선택디바이스이용권안내 = util.isElementPresent(By.id("tvTicketListHeader"));
		Assert.assertFalse(현재선택디바이스이용권안내);
		
		test.log(Status.INFO, "모바일 전용 이용권 노출 확인"); 
		String 모바일전용이용권 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"
				+ "/android.widget.TextView"));
	    Assert.assertEquals(모바일전용이용권, "FLO NUGU 무제한 이용권 (모바일 전용)");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_039")
	public void TC_메뉴_039(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 1);
	    
	    test.log(Status.INFO, "Tmap 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='T map (Android) '])"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[오디오북 이용권] 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]"));
	    
	    test.log(Status.INFO, "선택 선택디바스의 이용 가능한 이용권 안내 활성화 확인"); 
	    String 현재선택디바이스이용권안내 = util.getText(By.id("tvTicketListHeader"));
	    Assert.assertEquals(현재선택디바이스이용권안내, "현재 선택하신 디바이스(T map)에서 구매가능한 이용권입니다.");
		
		test.log(Status.INFO, "구매 가능한 이용권 없음 확인"); 
		String 구매가능한이용권없음 = util.getText(By.id("tvNotFoundInfo"));
	    Assert.assertEquals(구매가능한이용권없음, "구매 가능한 이용권이 없습니다.");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_040")
	public void TC_메뉴_040(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 패널 닫힘 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU100 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[오디오북 이용권] 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]"));
	    
	    test.log(Status.INFO, "선택 선택디바스의 이용 가능한 이용권 안내 활성화 확인"); 
	    String 현재선택디바이스이용권안내 = util.getText(By.id("tvTicketListHeader"));
	    Assert.assertEquals(현재선택디바이스이용권안내, "현재 선택하신 디바이스(NUGU)에서 구매가능한 이용권입니다.");
	    
	    test.log(Status.INFO, "[오디오북] 아이콘 노출 확인"); 
		boolean 아이콘 = util.isElementPresent(By.id("ivTicketListAgent"));
	    Assert.assertTrue(아이콘);
	    
	    test.log(Status.INFO, "[오디오북] 도메인명 노출 확인"); 
		boolean 도메인명 = util.isElementPresent(By.id("tvTicketListAgent"));
	    Assert.assertTrue(도메인명);
	
	    test.log(Status.INFO, "[오디오북] 이벤트아이콘 노출 확인"); 
		boolean 이벤트 = util.isElementPresent(By.id("ivTicketListEventIcon"));
	    Assert.assertTrue(이벤트);
	    
	    test.log(Status.INFO, "[오디오북] 이용권명 노출 확인"); 
		boolean 이용권명 = util.isElementPresent(By.id("tvTicketName"));
	    Assert.assertTrue(이용권명);
	    
	    test.log(Status.INFO, "[오디오북] 이용권설명 노출 확인"); 
		boolean 이용권설명 = util.isElementPresent(By.id("tvTicketProvide"));
	    Assert.assertTrue(이용권설명);
	    
	    test.log(Status.INFO, "[오디오북] 가격 노출 확인"); 
		boolean 가격 = util.isElementPresent(By.id("tvTicketPrice"));
	    Assert.assertTrue(가격);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_041")
	public void TC_메뉴_041(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[FLO 이용권] 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
	    
	    test.log(Status.INFO, "선택 선택디바스의 이용 가능한 이용권 안내 활성화 확인"); 
	    String 현재선택디바이스이용권안내 = util.getText(By.id("tvTicketListHeader"));
	    Assert.assertEquals(현재선택디바이스이용권안내, "현재 선택하신 디바이스(NUGU)에서 구매가능한 이용권입니다.");
	    
	    test.log(Status.INFO, "[FLO 이용권] 상세 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[FLO 이용권] 도메인 아이콘 노출 확인"); 
	    boolean 도메인아이콘 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Image"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "[FLO 이용권] 도메인명 노출 확인"); 
	    boolean 도메인명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]"));
	    Assert.assertTrue(도메인명);
	    
	    test.log(Status.INFO, "[FLO 이용권] 이벤트 아이콘 노출 확인"); 
	    boolean 이벤트아이콘 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]"));
	    Assert.assertTrue(이벤트아이콘);
	    
	    test.log(Status.INFO, "[FLO 이용권] 상품명 노출 확인"); 
	    boolean 상품명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
	    Assert.assertTrue(상품명);
	    
	    test.log(Status.INFO, "[FLO 이용권] 상품설명 노출 확인"); 
	    boolean 상품설명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[3]"));
	    Assert.assertTrue(상품설명);
	    
	    test.log(Status.INFO, "[FLO 이용권] 멤버쉽아이콘 노출 확인"); 
	    boolean 멤버쉽아이콘 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.widget.Image"));
	    Assert.assertTrue(멤버쉽아이콘);
	    
	    test.log(Status.INFO, "[FLO 이용권] 멤버쉽할인 노출 확인"); 
	    boolean 멤버쉽할인 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[4]"));
	    Assert.assertTrue(멤버쉽할인);
	    
	    test.log(Status.INFO, "[FLO 이용권] 할인전가격 노출 확인"); 
	    boolean 할인전가격 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]"));
	    Assert.assertTrue(할인전가격);
	    
	    test.log(Status.INFO, "[FLO 이용권] 가격 노출 확인"); 
	    boolean 가격 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]"));
	    Assert.assertTrue(가격);
	    
	    test.log(Status.INFO, "[FLO 이용권] 안내 노출 확인"); 
	    boolean 안내 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View[2]"));
	    Assert.assertTrue(안내);
	    
	    test.log(Status.INFO, "[FLO 이용권] 안내상세 노출 확인"); 
	    boolean 안내상세 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View[3]"));
	    Assert.assertTrue(안내상세);
	    
	    test.log(Status.INFO, "[FLO 이용권] 할인표 노출 확인"); 
	    boolean 할인표 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.GridView"));
	    Assert.assertTrue(할인표);
	    
	    test.log(Status.INFO, "[FLO 이용권] 유의사항 노출 확인"); 
	    boolean 유의사항 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[7]"));
	    Assert.assertTrue(유의사항);
	    
	    test.log(Status.INFO, "[FLO 이용권] 유의사항상세 노출 확인"); 
	    boolean 유의사항상세 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[8]"));
	    Assert.assertTrue(유의사항상세);
	    
	    test.log(Status.INFO, "[FLO 이용권] 판매자정보 노출 확인"); 
	    boolean 판매자정보 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[9]"));
	    Assert.assertTrue(판매자정보);
	    
	    test.log(Status.INFO, "[FLO 이용권] 판매자정보상세 노출 확인"); 
	    boolean 판매자정보상세 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[10]"));
	    Assert.assertTrue(판매자정보상세);
	    
	    test.log(Status.INFO, "[FLO 이용권] 구매하기버튼 노출 확인"); 
	    boolean 구매하기버튼 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
	    Assert.assertTrue(구매하기버튼);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_042")
	public void TC_메뉴_042(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "구매가능한 [FLO 이용권] 리스트의 아이콘 노출 확인"); 
		boolean 아이콘 = util.isElementPresent(By.id("ivTicketListAgent"));
	    Assert.assertTrue(아이콘);
	    
	    test.log(Status.INFO, "구매가능한 [FLO 이용권] 리스트의 도메인명 노출 확인"); 
		boolean 도메인명 = util.isElementPresent(By.id("tvTicketListAgent"));
	    Assert.assertTrue(도메인명);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_043")
	public void TC_메뉴_043(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "멜론 도메인 클릭");
	    util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
	    
	    String 멜론로그인 = "멜론 로그인    후";
	    
	    if(!멜론로그인.equals(util.getText(By.id("serviceGuide")))) {
	    		    	
	    	test.log(Status.INFO, "멜론 사용자 계정 클릭");
		    util.click((By.id("serviceGuideLayout")));
		    
		    Thread.sleep(1500);
		    test.log(Status.INFO, "멜론 [연결해제]버튼 클릭");
		    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.Button")));
		    
		    test.log(Status.INFO, "멜론 [연결해제]팝업에서 [확인]클릭");
		    util.click((By.id("positiveButton")));
	    } 
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[멜론 이용권] 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]"));
	    
	    test.log(Status.INFO, "[멜론 이용권] 상세 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
	    
	    test.log(Status.INFO, "[이용권 구매]버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
		
		test.log(Status.INFO, "로그인 안내 팝업 확인"); 
		String 멜론로그인안내 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(멜론로그인안내, "멜론 로그인을 하셔야 구매할 수 있습니다.");
		
		test.log(Status.INFO, "로그인 창 이동 [확인]클릭");
	    util.click((By.id("positiveButton")));
		
	    test.log(Status.INFO, "멜론로그인");
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]"
	    		+ "/android.view.View/android.widget.EditText"), "tjdtn10!!");
	    
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"), "ksszidan");
	    util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"));
	    util.AndroidKey_e();
	    
	    
	    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button")));
	    
	    test.log(Status.INFO, "[멜론 이용권] 구매하기버튼 노출 확인"); 
	    boolean 구매하기버튼 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
	    Assert.assertTrue(구매하기버튼);

	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_044")
	public void TC_메뉴_044(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "설정 버튼 클릭"); 
	    util.click((By.id("settingsButton")));
	    
	    test.log(Status.INFO, "앱설정 메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='앱 설정']")));
	    
	    test.log(Status.INFO, "이용약관 메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='이용약관']")));
	    
	    test.log(Status.INFO, "판매중개서비스 약관 버튼 클릭"); 
	    util.click((By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[10]")));
	    
	    test.log(Status.INFO, "동의 철회 버튼 클릭"); 
	    util.touchTab(560, 1800);
	    
	    test.log(Status.INFO, "동의 철회 [확인]클릭");
	    util.click((By.id("positiveButton")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "[멜론 이용권] 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]"));
	    
	    test.log(Status.INFO, "[멜론 이용권] 상세 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
	    
	    test.log(Status.INFO, "[이용권 구매]버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
		
		test.log(Status.INFO, "약관동의 페이지 노출 확인"); 
		String 약관명 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.view.View[1]/android.widget.ListView/android.view.View/android.view.View/android.view.View"
	    		+ "/android.view.View/android.widget.CheckBox"));
		Assert.assertEquals(약관명, "SK텔레콤 판매중개서비스 약관 (필수)");
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_045")
		public void TC_메뉴_045(Method method) throws Exception {
		
		test.log(Status.INFO, "닫기버튼 클릭");
		util.click(By.id("actionClose"));
		    
	    test.log(Status.INFO, "[이용권 구매]버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
			
		test.log(Status.INFO, "약관동의 페이지 노출 확인"); 
		String 약관명1 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.view.View[1]/android.widget.ListView/android.view.View/android.view.View/android.view.View"
	    		+ "/android.view.View/android.widget.CheckBox"));
		Assert.assertEquals(약관명1, "SK텔레콤 판매중개서비스 약관 (필수)");	
	}
		
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_046~047")
	public void TC_메뉴_046_from_047(Method method) throws Exception {
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [인증] 비활성화 확인"); 
		boolean 인증버튼비활성 = util.isEnabled(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.widget.Button"));
		Assert.assertFalse(인증버튼비활성);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_048")
	public void TC_메뉴_048(Method method) throws Exception {
		

		test.log(Status.INFO, "전체 약관 동의 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.view.View[2]/android.widget.CheckBox"));
		
		test.log(Status.INFO, "[쿠폰등록] 팝업 [인증] 비활성화 확인"); 
		boolean 인증버튼활성 = util.isEnabled(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.widget.Button"));
		Assert.assertTrue(인증버튼활성);
		
		test.log(Status.INFO, "다음 버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.widget.Button"));
		
		test.log(Status.INFO, "현재 이용중인 이용권 안내 팝업"); 
		String 이용중인이용권 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(이용중인이용권, "현재 이용 중인 이용권이 있으므로 구매하지 않아도 서비스를 이용할 수 있습니다.");
		
		test.log(Status.INFO, "팝업 [확인]클릭");
	    util.click((By.id("positiveButton")));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_049")
	public void TC_메뉴_049(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "멜론 도메인 클릭");
	    util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
	    
	    String 멜론로그인 = "멜론 로그인    후";
	    
	    if(!멜론로그인.equals(util.getText(By.id("serviceGuide")))) {
	    	
	    	test.log(Status.INFO, "멜론 사용자 계정 클릭");
		    util.click((By.id("serviceGuideLayout")));
		    
		    Thread.sleep(2000);
		    test.log(Status.INFO, "멜론 [연결해제]버튼 클릭");
		    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.Button")));
		    
		    test.log(Status.INFO, "멜론 [연결해제]팝업에서 [확인]클릭");
		    util.click((By.id("positiveButton")));
	    } 
	    
	    test.log(Status.INFO, "멜론 사용자 계정 클릭");
	    util.click((By.id("serviceGuideLayout")));
	    
	    test.log(Status.INFO, "멜론로그인");
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]"
	    		+ "/android.view.View/android.widget.EditText"), "dbswjd12");
	    
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"), "blingy");
	    util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"));
	    util.AndroidKey_j();
	    
	    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button")));
	    
	    test.log(Status.INFO, "기존 뮤직 서비스 설정 취소");
	    util.click((By.id("negativeButton")));
	    
	    test.log(Status.INFO, "멜론 이용권 구매로 이동");
	    util.click((By.id("actionTicket")));
	    
	    test.log(Status.INFO, "[멜론 이용권] 상세 버튼 클릭");
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
	    
	    test.log(Status.INFO, "[이용권 구매]버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.widget.Button"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
		
		test.log(Status.INFO, "이용권 구매 페이지 이동 확인"); 
		boolean 이용권구매페이지 = util.isElementPresent(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='NUGU 이용권 구매']"));
		Assert.assertTrue(이용권구매페이지);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_050")
	public void TC_메뉴_050(Method method) throws Exception {
		
		test.log(Status.INFO, "구매 취소 버튼 클릭"); 
		util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View"
	    		+ "/android.view.View[2]/android.view.View[1]"));
		
		test.log(Status.INFO, "이용권 상세 페이지 이동 확인"); 
		boolean 이용권상세페이지 = util.isElementPresent(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='NUGU 이용권 상세']"));
		Assert.assertTrue(이용권상세페이지);
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "멜론 도메인 클릭");
	    util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
	    
	    test.log(Status.INFO, "멜론 사용자 계정 클릭");
	    util.click((By.id("serviceGuideLayout")));
	    
	    Thread.sleep(1500);
	    test.log(Status.INFO, "멜론 [연결해제]버튼 클릭");
	    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.Button")));
	    
	    test.log(Status.INFO, "멜론 [연결해제]팝업에서 [확인]클릭");
	    util.click((By.id("positiveButton")));
	    
	    test.log(Status.INFO, "멜론 사용자 계정 클릭");
	    util.click((By.id("serviceGuideLayout")));
	    
	    test.log(Status.INFO, "멜론로그인");
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]"
	    		+ "/android.view.View/android.widget.EditText"), "tjdtn10!!");
	    
	    util.type(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"), "ksszidan");
	    util.click(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]"
	    		+ "/android.view.View/android.widget.EditText"));
	    util.AndroidKey_e();
	    
	    util.click((By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button")));
	    
	    test.log(Status.INFO, "기존 뮤직 서비스 설정 취소");
	    util.click((By.id("negativeButton")));
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "[이용권] 버튼 클릭");
	    util.click(By.id("ticketButton"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	}

}
