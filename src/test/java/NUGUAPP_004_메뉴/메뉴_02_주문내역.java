package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_02_주문내역 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_010")
	public void TC_메뉴_010(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "[주문내역] 버튼 클릭");
	    util.click(By.id("purchaseListButton"));
	    
	    test.log(Status.INFO, "주문내역 페이지 이동 확인"); 
		boolean 주문내역화면 = util.isElementPresent(By.id("rvPurchase"));
	    Assert.assertTrue(주문내역화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_011")
	public void TC_메뉴_011(Method method) throws Exception {

	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[주문내역] 버튼 클릭");
	    util.click(By.id("purchaseListButton"));
	    
	    test.log(Status.INFO, "서비스 타이틀 확인"); 
		boolean 서비스타이틀 = util.isElementPresent((By.xpath("//android.widget.TextView[@text='주문 내역']")));
	    Assert.assertTrue(서비스타이틀);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 확인"); 
	    boolean 뒤로가기버튼 = util.isElementPresent((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    Assert.assertTrue(뒤로가기버튼);
	
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_012")
	public void TC_메뉴_012(Method method) throws Exception {

	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
	    test.log(Status.INFO, "[전체] 디폴트 리스트 확인"); 
	    boolean 전체디폴트셀렉트 = util.isElementPresent((By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.RelativeLayout[1]")));
	    Assert.assertTrue(전체디폴트셀렉트);
	    
	    test.log(Status.INFO, "셀렉트리스트 순서 확인"); 
 
	    for(int i=1; i < 7; i++) {

	    	String 주문내역리스트 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.RelativeLayout["+i+"]/android.widget.TextView"));
		    System.out.println(i + "번 : " + 주문내역리스트);
		    	
		    Assert.assertTrue(주문내역리스트.contains(NUGU_data.data.주문필터리스트[i-1]));
	    }
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_013")
	public void TC_메뉴_013(Method method) throws Exception {
		
		test.log(Status.INFO, "[도미노피자] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='도미노피자']")));
		
		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
	    test.log(Status.INFO, "[도미노피자] 디폴트 리스트 확인"); 
	    boolean 도미노피자디폴트셀렉트 = util.isElementPresent((By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.RelativeLayout[2]")));
	    Assert.assertTrue(도미노피자디폴트셀렉트);
	    
	    test.log(Status.INFO, "필터 리스트 닫기"); 
	    util.click((By.xpath("//android.widget.TextView[@text='도미노피자']")));
	    
	    test.log(Status.INFO, "선택된 리스트 도메인 확인"); 
	    String 도미노피자리스트 = util.getText(By.id("tvPurchaseServiceName"));
	    Assert.assertEquals(도미노피자리스트, "도미노피자");
	  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_014")
	public void TC_메뉴_014(Method method) throws Exception {

		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
		test.log(Status.INFO, "[BBQ] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='BBQ']")));
		
		String BBQ리스트 = util.getText(By.id("tvPurchaseServiceName"));
	    Assert.assertEquals(BBQ리스트, "BBQ");
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
		test.log(Status.INFO, "[SK스토아] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='SK스토아']")));
		
		String SK스토아리스트 = util.getText(By.id("tvPurchaseServiceName"));
	    Assert.assertEquals(SK스토아리스트, "SK스토아");
	  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_015")
	public void TC_메뉴_015(Method method) throws Exception {

		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
		test.log(Status.INFO, "[11번가] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='11번가']")));
		
		test.log(Status.INFO, "주문 내역 없음 확인"); 
		String 주문내역없음 = util.getText(By.id("tvNotFoundInfo"));
		Assert.assertEquals(주문내역없음, "주문내역이 없습니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_016")
	public void TC_메뉴_016(Method method) throws Exception {

		test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
	    test.log(Status.INFO, "[도미노피자] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='도미노피자']")));
		
		test.log(Status.INFO, "[도미노피자] 도메인 확인"); 
		String 도미노피자리스트 = util.getText(By.id("tvPurchaseServiceName"));
		Assert.assertEquals(도미노피자리스트, "도미노피자");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_017")
	public void TC_메뉴_017(Method method) throws Exception {

		test.log(Status.INFO, "[도미노피자] 주문 상태 노출 확인"); 
		boolean 주문상태 = util.isElementPresent(By.id("tvPurchaseOrderState"));
	    Assert.assertTrue(주문상태);
	    
	    test.log(Status.INFO, "[도미노피자] 주문 이미지 노출 확인"); 
		boolean 주문이미지확인 = util.isElementPresent(By.id("ivPurchase"));
	    Assert.assertTrue(주문이미지확인);
	    
	    test.log(Status.INFO, "[도미노피자] 도메인 노출 확인"); 
		String 도미노피자도메인 = util.getText(By.id("tvPurchaseServiceName"));
		Assert.assertEquals(도미노피자도메인, "도미노피자");
		
		test.log(Status.INFO, "[도미노피자] 주문 날짜 노출 확인"); 
		boolean 도미노피자주문날짜 = util.isElementPresent(By.id("tvPurchaseOrderDate"));
	    Assert.assertTrue(도미노피자주문날짜);
	    
	    test.log(Status.INFO, "[도미노피자] 상품명 노출 확인"); 
		boolean 도미노피자상품명 = util.isElementPresent(By.id("tvPurchaseProductName"));
	    Assert.assertTrue(도미노피자상품명);
	    
	    test.log(Status.INFO, "[도미노피자] 결제수단  노출 확인"); 
		boolean 도미노피자결제수단 = util.isElementPresent(By.id("tvPurchasePaymentType"));
	    Assert.assertTrue(도미노피자결제수단);
	    
	    test.log(Status.INFO, "[도미노피자] 가격 노출 확인"); 
		boolean 도미노피자가격 = util.isElementPresent(By.id("tvPurchasePrice"));
	    Assert.assertTrue(도미노피자가격);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_018")
	public void TC_메뉴_018(Method method) throws Exception {

		test.log(Status.INFO, "[도미노피자] 주문 상세 이동"); 
		util.click((By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout")));
		
		test.log(Status.INFO, "[도미노피자] 주문 상태 노출 확인"); 
		String 주문상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				+ "/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertEquals(주문상태, "배달완료");
	    
	    test.log(Status.INFO, "[도미노피자] 주문 이미지 노출 확인"); 
	    boolean 주문이미지 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertTrue(주문이미지);
	    
	    test.log(Status.INFO, "[도미노피자] 도메인 노출 확인"); 
	    boolean 도메인 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[2]"));
	    Assert.assertTrue(도메인);
	    
	    test.log(Status.INFO, "[도미노피자] 주문날짜 노출 확인"); 
	    boolean 주문날짜 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[3]"));
	    Assert.assertTrue(주문날짜);
	    
	    test.log(Status.INFO, "[도미노피자] 상품명 노출 확인"); 
	    boolean 상품명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[4]"));
	    Assert.assertTrue(상품명);
	    
	    test.log(Status.INFO, "[도미노피자] 주문번호 노출 확인"); 
	    String 주문번호 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문번호, "주문번호");
	    
	    test.log(Status.INFO, "[도미노피자] 주문번호 내용 확인"); 
	    String 주문번호내용 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문번호내용.contains("CP"));
	    
	    test.log(Status.INFO, "[도미노피자] 주문상품 노출 확인"); 
	    String 주문상품 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문상품, "주문상품");
	    
	    test.log(Status.INFO, "[도미노피자] 주문번호 상세내용 확인"); 
	    String 주문상품상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문상품상세.contains("우리 고구마 피자 세트 1개"));
	    
	    test.log(Status.INFO, "[도미노피자] 결제수단 노출 확인"); 
	    String 결제수단 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제수단, "결제수단");
	    
	    test.log(Status.INFO, "[도미노피자] 결제수단  상세 내용 확인"); 
	    String 결제수단상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(결제수단상세.contains("카드"));
	    
	    test.log(Status.INFO, "[도미노피자] 결제정보 노출 확인"); 
	    String 결제정보  = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제정보 , "결제정보");
	    
	    test.log(Status.INFO, "[도미노피자] 결제정보  상세 내용 확인"); 
	    String 결제정보상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[1]"));
	    Assert.assertEquals(결제정보상세 , "결제금액");
	    
	    test.log(Status.INFO, "[도미노피자] 결제금액 상세 내용 확인"); 
	    String 결제금액상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[2]"));
	    Assert.assertEquals(결제금액상세 , "25,360원");
		
	    test.log(Status.INFO, "[도미노피자] 주문인 노출 확인"); 
	    String 주문인 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문인, "주문인");
		
	    test.log(Status.INFO, "[도미노피자] 주문인  상세 내용 확인"); 
	    String 주문인상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문인상세.contains("김성수"));
	    
	    test.log(Status.INFO, "[도미노피자] 연락처 노출 확인"); 
	    String 연락처 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(연락처, "연락처");
		
	    test.log(Status.INFO, "[도미노피자] 주문인  상세 내용 확인"); 
	    String 연락처상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(연락처상세.contains("010-3245"));
	    
	    test.log(Status.INFO, "[도미노피자] 배송지 노출 확인"); 
	    String 배송지 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(배송지, "배송지");
		
	    test.log(Status.INFO, "[도미노피자] 배송지  상세 내용 확인"); 
	    String 배송지상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(배송지상세.contains("경상북도 울릉군 서면 남서길 75-73 주문테스트"));
	    
	    test.log(Status.INFO, "[도미노피자] 배달매장 노출 확인"); 
	    String 배달매장 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(배달매장, "배달매장");
		
	    test.log(Status.INFO, "[도미노피자] 배달매장  상세 내용 확인"); 
	    String 배달매장상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(배달매장상세.contains("온라인점"));
	  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_019")
	public void TC_메뉴_019(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
	    test.log(Status.INFO, "[SK스토아] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='BBQ']")));

		test.log(Status.INFO, "[BBQ] 주문 상태 노출 확인"); 
		boolean 주문상태 = util.isElementPresent(By.id("tvPurchaseOrderState"));
	    Assert.assertTrue(주문상태);
	    
	    test.log(Status.INFO, "[BBQ] 주문 이미지 노출 확인"); 
		boolean 주문이미지확인 = util.isElementPresent(By.id("ivPurchase"));
	    Assert.assertTrue(주문이미지확인);
	    
	    test.log(Status.INFO, "[BBQ] 도메인 노출 확인"); 
		String BBQ도메인 = util.getText(By.id("tvPurchaseServiceName"));
		Assert.assertEquals(BBQ도메인, "BBQ");
		
		test.log(Status.INFO, "[BBQ] 주문 날짜 노출 확인"); 
		boolean BBQ주문날짜 = util.isElementPresent(By.id("tvPurchaseOrderDate"));
	    Assert.assertTrue(BBQ주문날짜);
	    
	    test.log(Status.INFO, "[BBQ] 상품명 노출 확인"); 
		boolean BBQ상품명 = util.isElementPresent(By.id("tvPurchaseProductName"));
	    Assert.assertTrue(BBQ상품명);
	    
	    test.log(Status.INFO, "[BBQ] 결제수단  노출 확인"); 
		boolean BBQ결제수단 = util.isElementPresent(By.id("tvPurchasePaymentType"));
	    Assert.assertTrue(BBQ결제수단);
	    
	    test.log(Status.INFO, "[BBQ] 가격 노출 확인"); 
		boolean BBQ가격 = util.isElementPresent(By.id("tvPurchasePrice"));
	    Assert.assertTrue(BBQ가격);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_020")
	public void TC_메뉴_020(Method method) throws Exception {

		test.log(Status.INFO, "[BBQ] 주문 상세 이동"); 
		util.click((By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout")));
		
		test.log(Status.INFO, "[BBQ] 주문 상태 노출 확인"); 
		String 주문상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				+ "/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertEquals(주문상태, "주문실패");
	    
	    test.log(Status.INFO, "[BBQ] 주문 이미지 노출 확인"); 
	    boolean 주문이미지 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertTrue(주문이미지);
	    
	    test.log(Status.INFO, "[BBQ] 도메인 노출 확인"); 
	    boolean 도메인 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[2]"));
	    Assert.assertTrue(도메인);
	    
	    test.log(Status.INFO, "[BBQ] 주문날짜 노출 확인"); 
	    boolean 주문날짜 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[3]"));
	    Assert.assertTrue(주문날짜);
	    
	    test.log(Status.INFO, "[BBQ] 상품명 노출 확인"); 
	    boolean 상품명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[4]"));
	    Assert.assertTrue(상품명);
	    
	    test.log(Status.INFO, "[BBQ] 주문번호 노출 확인"); 
	    String 주문번호 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문번호, "주문번호");
	    
	    test.log(Status.INFO, "[BBQ] 주문번호 내용 확인"); 
	    String 주문번호내용 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문번호내용.contains("CP"));
	    
	    test.log(Status.INFO, "[BBQ] 주문상품 노출 확인"); 
	    String 주문상품 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문상품, "주문상품");
	    
	    test.log(Status.INFO, "[BBQ] 주문상품 상세내용 확인"); 
	    String 주문상품상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문상품상세.contains("황금올리브치킨 1개"));
	    
	    test.log(Status.INFO, "[BBQ] 결제수단 노출 확인"); 
	    String 결제수단 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제수단, "결제수단");
	    
	    test.log(Status.INFO, "[BBQ] 결제수단  상세 내용 확인"); 
	    String 결제수단상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(결제수단상세.contains("카드"));
	    
	    test.log(Status.INFO, "[BBQ] 결제정보 노출 확인"); 
	    String 결제정보  = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제정보 , "결제정보");
	    
	    test.log(Status.INFO, "[BBQ] 결제정보  상세 내용 확인"); 
	    String 결제정보상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[1]"));
	    Assert.assertEquals(결제정보상세 , "결제금액");
	    
	    test.log(Status.INFO, "[BBQ] 결제금액 상세 내용 확인"); 
	    String 결제금액상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[2]"));
	    Assert.assertEquals(결제금액상세 , "18,000원");
		
	    test.log(Status.INFO, "[BBQ] 주문인 노출 확인"); 
	    String 주문인 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문인, "주문인");
		
	    test.log(Status.INFO, "[BBQ] 주문인  상세 내용 확인"); 
	    String 주문인상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문인상세.contains("김성수"));
	    
	    test.log(Status.INFO, "[BBQ] 연락처 노출 확인"); 
	    String 연락처 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(연락처, "연락처");
		
	    test.log(Status.INFO, "[BBQ] 주문인  상세 내용 확인"); 
	    String 연락처상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(연락처상세.contains("010-3245"));
	    
	    test.log(Status.INFO, "[BBQ] 배송지 노출 확인"); 
	    String 배송지 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(배송지, "배송지");
		
	    test.log(Status.INFO, "[BBQ] 배송지  상세 내용 확인"); 
	    String 배송지상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(배송지상세.contains("서울특별시 강남구 언주로 315 도미노피자 3층 주문테스트"));
	    
	    test.log(Status.INFO, "[BBQ] 배달매장 노출 확인"); 
	    String 배달매장 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(배달매장, "배달매장");
		
	    test.log(Status.INFO, "[BBQ] 배달매장  상세 내용 확인"); 
	    String 배달매장상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(배달매장상세.contains("역삼스타점"));
	  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_021")
	public void TC_메뉴_024(Method method) throws Exception {
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "필터 리스트 클릭"); 
	    util.click(By.id("layerPurchaseCategory"));
	    
	    test.log(Status.INFO, "[SK스토아] 리스트 클릭"); 
		util.click((By.xpath("//android.widget.TextView[@text='SK스토아']")));

		test.log(Status.INFO, "[SK스토아] 주문 상태 노출 확인"); 
		boolean 주문상태 = util.isElementPresent(By.id("tvPurchaseOrderState"));
	    Assert.assertTrue(주문상태);
	    
	    test.log(Status.INFO, "[SK스토아] 주문 이미지 노출 확인"); 
		boolean 주문이미지확인 = util.isElementPresent(By.id("ivPurchase"));
	    Assert.assertTrue(주문이미지확인);
	    
	    test.log(Status.INFO, "[SK스토아] 도메인 노출 확인"); 
		String BBQ도메인 = util.getText(By.id("tvPurchaseServiceName"));
		Assert.assertEquals(BBQ도메인, "SK스토아");
		
		test.log(Status.INFO, "[SK스토아] 주문 날짜 노출 확인"); 
		boolean BBQ주문날짜 = util.isElementPresent(By.id("tvPurchaseOrderDate"));
	    Assert.assertTrue(BBQ주문날짜);
	    
	    test.log(Status.INFO, "[SK스토아] 상품명 노출 확인"); 
		boolean BBQ상품명 = util.isElementPresent(By.id("tvPurchaseProductName"));
	    Assert.assertTrue(BBQ상품명);
	    
	    test.log(Status.INFO, "[SK스토아] 결제수단  노출 확인"); 
		boolean BBQ결제수단 = util.isElementPresent(By.id("tvPurchasePaymentType"));
	    Assert.assertTrue(BBQ결제수단);
	    
	    test.log(Status.INFO, "[SK스토아] 가격 노출 확인"); 
		boolean BBQ가격 = util.isElementPresent(By.id("tvPurchasePrice"));
	    Assert.assertTrue(BBQ가격);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_020")
	public void TC_메뉴_025(Method method) throws Exception {

		test.log(Status.INFO, "[SK스토아] 주문 상세 이동"); 
		util.click((By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout")));
		
		test.log(Status.INFO, "[SK스토아] 주문 상태 노출 확인"); 
		String 주문상태 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
				+ "/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertEquals(주문상태, "상담완료");
	    
	    test.log(Status.INFO, "[SK스토아] 주문 이미지 노출 확인"); 
	    boolean 주문이미지 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
	    Assert.assertTrue(주문이미지);
	    
	    test.log(Status.INFO, "[SK스토아] 도메인 노출 확인"); 
	    boolean 도메인 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[2]"));
	    Assert.assertTrue(도메인);
	    
	    test.log(Status.INFO, "[SK스토아] 주문날짜 노출 확인"); 
	    boolean 주문날짜 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[3]"));
	    Assert.assertTrue(주문날짜);
	    
	    test.log(Status.INFO, "[SK스토아] 상품명 노출 확인"); 
	    boolean 상품명 = util.isElementPresent(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.view.View[4]"));
	    Assert.assertTrue(상품명);
	    
	    test.log(Status.INFO, "[SK스토아] 주문번호 노출 확인"); 
	    String 주문번호 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문번호, "주문번호");
	    
	    test.log(Status.INFO, "[SK스토아] 주문번호 내용 확인"); 
	    String 주문번호내용 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문번호내용.contains("20190326"));
	    
	    test.log(Status.INFO, "[SK스토아] 주문상품 노출 확인"); 
	    String 주문상품 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문상품, "주문상품");
	    
	    test.log(Status.INFO, "[SK스토아] 주문상품 상세내용 확인"); 
	    String 주문상품상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문상품상세.contains("[AIA생명](무)원스톱 슈퍼암보험 (갱신형)_스마트티포트 2종"));
	    
	    test.log(Status.INFO, "[SK스토아] 결제수단 노출 확인"); 
	    String 결제수단 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제수단, "결제수단");
	    
	    test.log(Status.INFO, "[SK스토아] 결제수단  상세 내용 확인"); 
	    String 결제수단상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(결제수단상세.contains("상담신청상품"));
	    
	    test.log(Status.INFO, "[SK스토아] 결제정보 노출 확인"); 
	    String 결제정보  = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(결제정보 , "결제정보");
	    
	    test.log(Status.INFO, "[SK스토아] 결제정보  상세 내용 확인"); 
	    String 결제정보상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[1]"));
	    Assert.assertEquals(결제정보상세 , "결제금액");
	    
	    test.log(Status.INFO, "[SK스토아] 결제금액 상세 내용 확인"); 
	    String 결제금액상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]"
	    		+ "/android.view.View[2]/android.widget.ListView/android.view.View[3]/android.view.View[2]"));
	    Assert.assertEquals(결제금액상세 , "0원");
		
	    test.log(Status.INFO, "[SK스토아] 주문인 노출 확인"); 
	    String 주문인 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(주문인, "주문인");
		
	    test.log(Status.INFO, "[SK스토아] 주문인  상세 내용 확인"); 
	    String 주문인상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(주문인상세.contains("김성수"));
	    
	    test.log(Status.INFO, "[SK스토아] 연락처 노출 확인"); 
	    String 연락처 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(연락처, "연락처");
		
	    test.log(Status.INFO, "[SK스토아] 주문인  상세 내용 확인"); 
	    String 연락처상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(연락처상세.contains("010-32**-06**"));
	    
	    test.log(Status.INFO, "[SK스토아] 배송지 노출 확인"); 
	    String 배송지 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[1]"));
	    Assert.assertEquals(배송지, "배송지");
		
	    test.log(Status.INFO, "[SK스토아] 배송지  상세 내용 확인"); 
	    String 배송지상세 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView"
	    		+ "/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]"
	    		+ "/android.view.View[2]/android.view.View"));
	    Assert.assertTrue(배송지상세.contains("당산로"));

	  
	}

}
