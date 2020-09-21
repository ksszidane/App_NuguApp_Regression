package NUGUAPP_004_메뉴;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 메뉴_07_자주묻는질문 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_098")
	public void TC_메뉴_098(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "자주 묻는 질문 메뉴 버튼 클릭");
	    util.click(By.id("faqButton"));
	    
	    test.log(Status.INFO, "자주 묻는 질문 페이지 이동 확인"); 
		String 자주묻는질문 = util.getText(By.id("tvTitle"));
	    Assert.assertEquals(자주묻는질문, "TOP 20 질문");
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "메뉴 패널 펼침 확인"); 
	    boolean 메뉴패널펼침 = util.isElementPresent(By.id("rvMenuPanel"));
	    Assert.assertTrue(메뉴패널펼침);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_099")
	public void TC_메뉴_099(Method method) throws Exception {
	    
	    test.log(Status.INFO, "자주 묻는 질문 메뉴 버튼 클릭");
	    util.click(By.id("faqButton"));
	    
	    test.log(Status.INFO, "[1:1 문의]버튼 클릭"); 
		util.click(By.id("menuOneOnOne"));
	    
	    test.log(Status.INFO, "1:1 문의하기 페이지 이동 확인"); 
		boolean 일대일 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='1:1 문의하기']"));
	    Assert.assertTrue(일대일);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 페이지 이동 확인"); 
		String 자주묻는질문 = util.getText(By.id("tvTitle"));
	    Assert.assertEquals(자주묻는질문, "TOP 20 질문");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_100")
	public void TC_메뉴_100(Method method) throws Exception {
	    
		test.log(Status.INFO, "자주 묻는 질문 카테고리 클릭"); 
		util.click(By.id("tvTitle"));
		
		test.log(Status.INFO, "페이지 스크롤 다운"); 
		util.scrollDown(1);
		
		test.log(Status.INFO, "스크롤 이동 후 가장 하단 NUGU opal 확인"); 
		String NUGUopal = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout[13]/android.widget.TextView"));
	    Assert.assertEquals(NUGUopal, "NUGU opal");
	    
	    test.log(Status.INFO, "[가입/서비스 이용] 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='가입/서비스 이용']"));
	    
	    test.log(Status.INFO, "자주 묻는 질문 카테고리 선택 확인"); 
		String 자주묻는질문 = util.getText(By.id("tvTitle"));
	    Assert.assertEquals(자주묻는질문, "가입/서비스 이용");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_101")
	public void TC_메뉴_101(Method method) throws Exception {
	    
		test.log(Status.INFO, "자주 묻는 질문 카테고리 클릭"); 
		util.click(By.id("tvTitle"));
		
	    test.log(Status.INFO, "[뮤직/미디어] 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='뮤직/미디어']"));
	    
	    test.log(Status.INFO, "자주 묻는 질문 카테고리 선택 확인"); 
		String 자주묻는질문 = util.getText(By.id("tvTitle"));
	    Assert.assertEquals(자주묻는질문, "뮤직/미디어");
	    
	    test.log(Status.INFO, "뮤직/미디어 3번째 질문 목록 확인 및 클릭 "); 
		String 세번째질문 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView"));
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView"));
	    
	    test.log(Status.INFO, "선택했던 3번째 질문 제목 확인");
	    String 제목 = util.getText(By.xpath("//android.webkit.WebView/android.webkit.WebView/android.view.View"
	    		+ "/android.view.View/android.view.View[1]"));
	    Assert.assertEquals(세번째질문, 제목);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_102")
	public void TC_메뉴_102(Method method) throws Exception {
	    
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 카테고리 클릭"); 
		util.click(By.id("tvTitle"));
		
		test.log(Status.INFO, "페이지 스크롤 업");
		util.scrollUp(1);
		
	    test.log(Status.INFO, "[NUGU 연결] 클릭"); 
	    util.click(By.xpath("//android.widget.TextView[@text='NUGU 연결']"));
	    
	    test.log(Status.INFO, "자주 묻는 질문 카테고리 선택 확인"); 
		String 자주묻는질문 = util.getText(By.id("tvTitle"));
	    Assert.assertEquals(자주묻는질문, "NUGU 연결");
	    
	    test.log(Status.INFO, "NUGU 연결 1번째 질문 목록 확인 및 클릭 "); 
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView"
				+ "/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView"));
		
		test.log(Status.INFO, "자주 묻는 질문 상세 확인");
		boolean 상세 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='자주 묻는 질문 상세']"));
	    Assert.assertTrue(상세);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 리스트 확인");
		boolean 리스트 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='자주 묻는 질문']"));
	    Assert.assertTrue(리스트);
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_103")
	public void TC_메뉴_103(Method method) throws Exception {
	    
		test.log(Status.INFO, "자주 묻는 질문 [검색] 클릭"); 
	    util.click((By.id("menuSearch")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 키워드 안내 확인");
		boolean 키워드 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='자주 묻는 질문 키워드']"));
	    Assert.assertTrue(키워드);
	    
	    test.log(Status.INFO, "키패드 가림");
	    util.click(By.xpath("//android.widget.TextView[@text='자주 묻는 질문 키워드']"));
	    
	    test.log(Status.INFO, "자주 묻는 질문 [키워드] 영역 노출 확인"); 
		for(int i=1; i < 10; i++) {
			int j = i+1;
	    	String 키워드리스트 = util.fast_getText(By.xpath("//androidx.recyclerview.widget.RecyclerView"
	    	+"/android.widget.RelativeLayout["+j+"]/android.widget.TextView"));
		    System.out.println(i + "번 : " + 키워드리스트);
		    	
		    Assert.assertTrue(키워드리스트.contains(NUGU_data.data.자주묻는질문키워드[i-1]));
	    }

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_104")
	public void TC_메뉴_104(Method method) throws Exception {
	    
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 리스트 확인");
		boolean 리스트 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='자주 묻는 질문']"));
	    Assert.assertTrue(리스트);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_106")
	public void TC_메뉴_106(Method method) throws Exception {
	    
		test.log(Status.INFO, "자주 묻는 질문 [검색] 클릭"); 
	    util.click((By.id("menuSearch")));
	    
	    test.log(Status.INFO, "자주 묻는 질문 키워드 안내 확인");
		boolean 키워드 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='자주 묻는 질문 키워드']"));
	    Assert.assertTrue(키워드);
	    
	    test.log(Status.INFO, "키워드 입력필드에 '연' 입력 ");
	    util.type(By.id("etSearchWord"), "연");
	    
	    test.log(Status.INFO, "'연' 자동완성 검색결과 확인");
	    String 검색결과 = util.getText(By.id("tvSearchSubContent"));
	    Assert.assertTrue(검색결과.contains("연결"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_107")
	public void TC_메뉴_107(Method method) throws Exception {
	    
	    test.log(Status.INFO, "키워드 입력필드에 [X] 클릭");
	    util.click(By.id("menuClear"));
	    
	    test.log(Status.INFO, "현재 입력 필드값 확인");
	    String 입력키워드없음 = util.getText(By.id("etSearchWord"));
	    Assert.assertEquals(입력키워드없음, "검색어를 입력하세요");
	    
	    test.log(Status.INFO, "검색결과 제목 없음 확인");
		boolean 제목 = util.isElementPresent(By.id("tvSearchTitle"));
	    Assert.assertFalse(제목);
	    
	    test.log(Status.INFO, "검색결과 내용 없음 확인");
		boolean 내용 = util.isElementPresent(By.id("tvSearchSubContent"));
	    Assert.assertFalse(내용);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_108")
	public void TC_메뉴_108(Method method) throws Exception {
	    
	    test.log(Status.INFO, "키워드 입력필드에 '와우' 입력 ");
	    util.type(By.id("etSearchWord"), "와우");

	    test.log(Status.INFO, "'와우' 검색결과 없음 확인");
	    boolean 검색결과없음 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='검색결과가 없습니다.']"));
	    Assert.assertTrue(검색결과없음);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 메뉴_109")
	public void TC_메뉴_109(Method method) throws Exception {
	    
	    test.log(Status.INFO, "키워드 입력필드에 [X] 클릭");
	    util.click(By.id("menuClear"));
	    
	    test.log(Status.INFO, "키워드 입력필드에 '회원' 입력 ");
	    util.type(By.id("etSearchWord"), "회원");

	    test.log(Status.INFO, "'회원' 자동완성 검색결과 확인");
	    String 검색결과 = util.getText(By.id("tvSearchSubContent"));
	    Assert.assertTrue(검색결과.contains("회원"));
	    
	}
	
	

}
