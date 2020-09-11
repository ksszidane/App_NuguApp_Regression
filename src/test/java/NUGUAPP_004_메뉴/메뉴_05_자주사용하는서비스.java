package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_05_자주사용하는서비스 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_083")
	public void TC_메뉴_083_01(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "자주 사용하는 서비스 레이아웃 확인"); 
	    String 자주사용서비스 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.LinearLayout/android.widget.TextView"));
	    Assert.assertEquals(자주사용서비스, "자주 사용하는 서비스");
	    
	    if(!util.isElementPresent(By.id("layoutAdd"))) {
	    	
	    	test.log(Status.INFO, "[편집]버튼 확인 및 클릭"); 
		    util.click(By.id("layoutEdit"));
		    
		    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='4']"))) {
		    	test.log(Status.INFO, "4번 즐겨찾기 있으면 선택 해제"); 
		    	util.click(By.xpath("//android.widget.TextView[@text='4']"));
		    }
		    
		    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='3']"))) {
		    	test.log(Status.INFO, "3번 즐겨찾기 있으면 선택 해제"); 
		    	util.click(By.xpath("//android.widget.TextView[@text='3']"));
		    }
		    
		    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='2']"))) {
		    	test.log(Status.INFO, "2번 즐겨찾기 있으면 선택 해제"); 
		    	util.click(By.xpath("//android.widget.TextView[@text='2']"));
		    }
		    
		    if(util.isElementPresent(By.xpath("//android.widget.TextView[@text='1']"))) {
		    	test.log(Status.INFO, "1번 즐겨찾기 있으면 선택 해제"); 
		    	util.click(By.xpath("//android.widget.TextView[@text='1']"));
		    }
		    
		    test.log(Status.INFO, "저장버튼 클릭 메뉴패널 복귀");
			util.click(By.id("btnFavoriteSave"));
			
			test.log(Status.INFO, "페이지 연결 로딩 확인");
		    util.ProgressBar_Loading();
		    
	    }
	    
	    test.log(Status.INFO, "[+추가]버튼 확인 및 클릭"); 
	    util.click(By.id("layoutAdd"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "자주 사용하는 서비스 레이아웃 확인"); 
	    String NUGU서비스목록 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.LinearLayout/android.widget.TextView"));
	    Assert.assertEquals(NUGU서비스목록, "NUGU 서비스");
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_083")
	public void TC_메뉴_083_02(Method method) throws Exception {
		
	    
	    test.log(Status.INFO, "닫기 버튼 클릭"); 
	    util.click((By.id("actionClose")));
	    
	    test.log(Status.INFO, "자주 사용하는 서비스 레이아웃 확인"); 
	    String 자주사용서비스 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.LinearLayout/android.widget.TextView"));
	    Assert.assertEquals(자주사용서비스, "자주 사용하는 서비스");
	    
	    test.log(Status.INFO, "[+추가]버튼 확인 및 클릭"); 
	    util.click(By.id("layoutAdd"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "자주 사용하는 서비스 레이아웃 확인"); 
	    String NUGU서비스목록 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    		+ "/android.widget.LinearLayout/android.widget.TextView"));
	    Assert.assertEquals(NUGU서비스목록, "NUGU 서비스");
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_083")
	public void TC_메뉴_083_03(Method method) throws Exception {
		
		test.log(Status.INFO, "Car Life 카테고리 확인"); 
		boolean Car_Life = util.isElementPresent(By.xpath("//android.widget.TextView[@text='Car Life']"));
	    Assert.assertTrue(Car_Life);
	    
	    test.log(Status.INFO, "TV Life 카테고리 확인"); 
		boolean TV_Life = util.isElementPresent(By.xpath("//android.widget.TextView[@text='TV Life']"));
	    Assert.assertTrue(TV_Life);
	    
	    test.log(Status.INFO, "키즈  카테고리 확인"); 
		boolean 키즈 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='키즈']"));
	    Assert.assertTrue(키즈);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "음악/오디오 카테고리 확인"); 
		boolean 음악_오디오 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='음악/오디오']"));
	    Assert.assertTrue(음악_오디오);
	    
	    test.log(Status.INFO, "편리한 기능 카테고리 확인"); 
		boolean 편리한_기능 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='편리한 기능']"));
	    Assert.assertTrue(편리한_기능);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "생활/정보 카테고리 확인"); 
		boolean 생활_정보 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='생활/정보']"));
	    Assert.assertTrue(생활_정보);
	    
	    test.log(Status.INFO, "검색 카테고리 확인"); 
		boolean 검색 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='검색']"));
	    Assert.assertTrue(검색);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);   
	    
	    test.log(Status.INFO, "쇼핑 카테고리 확인"); 
		boolean 쇼핑 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='쇼핑/주문']"));
	    Assert.assertTrue(쇼핑);
	    
	    test.log(Status.INFO, "금융 카테고리 확인"); 
		boolean 금융 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='금융']"));
	    Assert.assertTrue(금융);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1); 
	    
	    test.log(Status.INFO, "NUGU play 카테고리 확인"); 
		boolean NUGU_play = util.isElementPresent(By.xpath("//android.widget.TextView[@text='NUGU play']"));
	    Assert.assertTrue(NUGU_play);  
	    
	    test.log(Status.INFO, "뮤직/엔터 카테고리 확인"); 
		boolean 뮤직_엔터 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='뮤직/엔터']"));
	    Assert.assertTrue(뮤직_엔터);
	    
	    test.log(Status.INFO, "정보/생활 카테고리 확인"); 
		boolean 정보_생활 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='정보/생활']"));
	    Assert.assertTrue(정보_생활);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "유용한기능 카테고리 확인"); 
		boolean 유용한기능 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='유용한 기능']"));
	    Assert.assertTrue(유용한기능);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "교육/유아 카테고리 확인"); 
		boolean 교육_유아 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='교육/유아']"));
	    Assert.assertTrue(교육_유아);
	    
	    test.log(Status.INFO, "비즈니스/경제 카테고리 확인"); 
		boolean 비즈니스_경제  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='비즈니스/경제']"));
	    Assert.assertTrue(비즈니스_경제);
	    	    
	    test.log(Status.INFO, "종교 카테고리 확인"); 
		boolean 종교  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='종교']"));
	    Assert.assertTrue(종교);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "게임 카테고리 확인"); 
		boolean 게임  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='게임']"));
	    Assert.assertTrue(게임);
	    
	    test.log(Status.INFO, "스마트홈기능 카테고리 확인"); 
		boolean 스마트홈기능  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='스마트홈 기능']"));
	    Assert.assertTrue(스마트홈기능);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "기타 카테고리 확인"); 
		boolean 기타  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='기타']"));
	    Assert.assertTrue(기타);
	    
	    test.log(Status.INFO, "스크롤 다운 동작"); 
	    util.scrollUp(10);
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_084")
	public void TC_메뉴_083_04(Method method) throws Exception {
		
		test.log(Status.INFO, "저장 버튼 비활성화 확인");
		boolean 저장비활성 = util.isEnabled(By.id("btnFavoriteSave"));
		Assert.assertFalse(저장비활성);
		
		test.log(Status.INFO, "B tv x NUGU 선택");
		util.click(By.xpath("//android.widget.TextView[@text='B tv x NUGU']"));
		
		test.log(Status.INFO, "1 넘버링 생성 확인");
		boolean 일번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='1']"));
		Assert.assertTrue(일번);
		
		test.log(Status.INFO, "저장 버튼 활성화 확인");
		boolean 저장활성 = util.isEnabled(By.id("btnFavoriteSave"));
		Assert.assertTrue(저장활성);
		
		test.log(Status.INFO, "T map 스타벅스 선택");
		util.click(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		
		test.log(Status.INFO, "2 넘버링 생성 확인");
		boolean 이번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='2']"));
		Assert.assertTrue(이번);
		
		test.log(Status.INFO, "로봇컨트롤 선택");
		util.click(By.xpath("//android.widget.TextView[@text='로봇컨트롤']"));
		
		test.log(Status.INFO, "3 넘버링 생성 확인");
		boolean 삼번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='3']"));
		Assert.assertTrue(삼번);
		
		test.log(Status.INFO, "놀이학습 선택");
		util.click(By.xpath("//android.widget.TextView[@text='놀이학습']"));
		
		test.log(Status.INFO, "4 넘버링 생성 확인");
		boolean 사번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='4']"));
		Assert.assertTrue(사번);
    
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_084")
	public void TC_메뉴_083_05(Method method) throws Exception {
		
		test.log(Status.INFO, "저장버튼 클릭 메뉴패널 복귀");
		util.click(By.id("btnFavoriteSave"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "B tv x NUGU 확인 생성 확인");
		boolean Btv_NUGU  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='B tv x NUGU']"));
		Assert.assertTrue(Btv_NUGU);
	    
	    test.log(Status.INFO, "로봇컨트롤 확인 생성 확인");
		boolean 로봇컨트롤  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='로봇컨트롤']"));
		Assert.assertTrue(로봇컨트롤);
	    
	    test.log(Status.INFO, "스타벅스 확인 생성 확인");
		boolean 스타벅스  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		Assert.assertTrue(스타벅스);
		
		test.log(Status.INFO, "놀이학습 확인 생성 확인");
		boolean 놀이학습  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='놀이학습']"));
		Assert.assertTrue(놀이학습);
    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_084")
	public void TC_메뉴_084_01(Method method) throws Exception {
		
		test.log(Status.INFO, "[편집]버튼 확인 및 클릭"); 
	    util.click(By.id("layoutEdit"));
	    
	    test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "놀이학습 선택");
		util.click(By.xpath("//android.widget.TextView[@text='놀이학습']"));
		
		test.log(Status.INFO, "4 넘버링 제거 확인");
		boolean 사번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='4']"));
		Assert.assertFalse(사번);
		
		test.log(Status.INFO, "저장버튼 클릭 메뉴패널 복귀");
		util.click(By.id("btnFavoriteSave"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	    test.log(Status.INFO, "서비스추가버튼 확인");
		boolean 서비스추가버튼  = util.isElementPresent(By.xpath("//android.widget.ImageView[@content-desc='서비스 추가 버튼']"));
		Assert.assertTrue(서비스추가버튼);
		
		test.log(Status.INFO, "서비스추가버튼 클릭");
		util.click(By.xpath("//android.widget.ImageView[@content-desc='서비스 추가 버튼']"));
		
		test.log(Status.INFO, "페이지 연결 로딩 확인");
	    util.ProgressBar_Loading();
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_084")
	public void TC_메뉴_084_02(Method method) throws Exception {
		
		test.log(Status.INFO, "변경사항 없는 경우 저정버튼 비활성화 확인");
		boolean 저장비활성 = util.isEnabled(By.id("btnFavoriteSave"));
		Assert.assertFalse(저장비활성);
		
		test.log(Status.INFO, "B tv x NUGU 선택");
		util.click(By.xpath("//android.widget.TextView[@text='B tv x NUGU']"));
		
		test.log(Status.INFO, "3 넘버링 제거 확인");
		boolean 삼번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='3']"));
		Assert.assertFalse(삼번);
		
		test.log(Status.INFO, "T map 스타벅스 선택");
		util.click(By.xpath("//android.widget.TextView[@text='T map 스타벅스']"));
		
		test.log(Status.INFO, "2 넘버링 제거 확인");
		boolean 이번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='2']"));
		Assert.assertFalse(이번);
		
		test.log(Status.INFO, "로봇컨트롤 선택");
		util.click(By.xpath("//android.widget.TextView[@text='로봇컨트롤']"));
		
		test.log(Status.INFO, "1 넘버링 제거 확인");
		boolean 일번  = util.isElementPresent(By.xpath("//android.widget.TextView[@text='1']"));
		Assert.assertFalse(일번);
		
		test.log(Status.INFO, "저장버튼 클릭 메뉴패널 복귀");
		util.click(By.id("btnFavoriteSave"));
		
		test.log(Status.INFO, "서비스추가버튼 비노출 확인");
		boolean 서비스추가버튼  = util.isElementPresent(By.xpath("//android.widget.ImageView[@content-desc='서비스 추가 버튼']"));
		Assert.assertFalse(서비스추가버튼);
		
		test.log(Status.INFO, "[+추가]버튼 확인 및 클릭");
		boolean 추가버튼  = util.isElementPresent(By.id("layoutAdd"));
		Assert.assertTrue(추가버튼);
		

	}

}
