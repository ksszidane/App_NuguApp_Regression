package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_07_미디어컨트롤러 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_01(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "테스트를 위한 볼륨1 설정"); 
	    util.sendPost("볼륨 1", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "멜론에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("멜론에서 daft punk의 Get Lucky 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='Daft Punk']"));
	    Assert.assertTrue(가수.contains("Daft Punk"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("Get Lucky"));

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "앨범커버 [있음] 확인"); 
		boolean 앨범커버 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(앨범커버);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_02(Method method) throws Exception {
		
	    test.log(Status.INFO, "FLO에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("FLO에서 daft punk의 Get Lucky 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='Daft Punk']"));
	    Assert.assertTrue(가수.contains("Daft Punk"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("Get Lucky"));

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "앨범커버 [있음] 확인"); 
		boolean 앨범커버 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(앨범커버);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_03(Method method) throws Exception {
		
	    test.log(Status.INFO, "벅스에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("벅스에서 daft punk의 Get Lucky 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='Daft Punk']"));
	    Assert.assertTrue(가수.contains("Daft Punk"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("Get Lucky"));

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "앨범커버 [있음] 확인"); 
		boolean 앨범커버 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(앨범커버);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_04(Method method) throws Exception {
		
	    test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "라디오 세션명 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 세션명 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명.contains("SBS 파워FM"));

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_05(Method method) throws Exception {
		
	    test.log(Status.INFO, "팟빵 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("팟빵에서 씨네타운나인틴 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "프로그램명 [있음] 확인"); 
		String 프로그램명 = util.getText(By.xpath("//android.widget.TextView[@text='씨네타운 나인틴 - 풍문으로 듣는 방송']"));
	    Assert.assertTrue(프로그램명.contains("씨네타운 나인틴 - 풍문으로 듣는 방송"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "프로그램이미지 [있음] 확인"); 
		boolean 프로그램이미지 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(프로그램이미지);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_06(Method method) throws Exception {
		
	    test.log(Status.INFO, "오디오북 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("오디오북에서 잠자고 싶은 토끼 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "프로그램명 [있음] 확인"); 
		String 프로그램명 = util.getText(By.xpath("//android.widget.TextView[@text='잠자고 싶은 토끼']"));
	    Assert.assertTrue(프로그램명.contains("잠자고 싶은 토끼"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "프로그램이미지 [있음] 확인"); 
		boolean 프로그램이미지 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(프로그램이미지);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_07(Method method) throws Exception {
		
	    test.log(Status.INFO, "ASMR 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("ASMR ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "제공처 [있음] 확인"); 
		String 제공처 = util.getText(By.xpath("//android.widget.TextView[@text='탕카']"));
	    Assert.assertTrue(제공처.contains("탕카"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "프로그램이미지 [있음] 확인"); 
		boolean 프로그램이미지 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(프로그램이미지);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_073")
	public void TC_홈_073_08(Method method) throws Exception {
		
	    test.log(Status.INFO, "자체소싱(부스트파크송) 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("부스트파크송 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "도메인아이콘 [있음] 확인"); 
		boolean 도메인아이콘 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(도메인아이콘);
	    
	    test.log(Status.INFO, "제공처 [있음] 확인"); 
		String 제공처 = util.getText(By.xpath("//android.widget.TextView[@text='SK텔레콤']"));
	    Assert.assertTrue(제공처.contains("SK텔레콤"));
	    
	    test.log(Status.INFO, "제목 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	    test.log(Status.INFO, "일시정지버튼[있음] 확인"); 
		boolean 일시정지버튼 = util.isElementPresent(By.id("pauseButton"));
	    Assert.assertTrue(일시정지버튼);
	    
	    test.log(Status.INFO, "이전버튼[있음] 확인"); 
		boolean 이전버튼 = util.isElementPresent(By.id("prevButton"));
	    Assert.assertTrue(이전버튼);
	    
	    test.log(Status.INFO, "다음버튼[있음] 확인"); 
		boolean 다음버튼 = util.isElementPresent(By.id("nextButton"));
	    Assert.assertTrue(다음버튼);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "재생목록 [있음] 확인"); 
	    String 재생목록 = util.getText(By.xpath("//android.widget.TextView[@text='재생목록']"));
	    Assert.assertTrue(재생목록.contains("재생목록"));
	    
	    test.log(Status.INFO, "프로그램이미지 [있음] 확인"); 
		boolean 프로그램이미지 = util.isElementPresent(By.id("serviceIconImageView"));
	    Assert.assertTrue(프로그램이미지);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_074")
	public void TC_홈_074_01(Method method) throws Exception {
		
	    test.log(Status.INFO, "FLO에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("FLO에서 daft punk 노래 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	        
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='Daft Punk']"));
	    Assert.assertTrue(가수.contains("Daft Punk"));
	    
	    test.log(Status.INFO, "현재 노래 제목 확인"); 
	    String 현재노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    System.out.println(현재노래제목);

	    test.log(Status.INFO, "일시정지버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
		
	    test.log(Status.INFO, "일시정지 확인");
	    String PAUSED = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 7);
	    Assert.assertTrue(PAUSED.contains("PAUSED"));
	    
	    test.log(Status.INFO, "재생버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
	    
	    test.log(Status.INFO, "재생 확인");
	    String PLAYING = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(PLAYING.contains("PLAYING"));
	    
	    test.log(Status.INFO, "다음버튼 클릭"); 
	    util.click(By.id("nextButton"));
	    Thread.sleep(1500);
	    
	    test.log(Status.INFO, "다음 노래 제목 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 다음노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    System.out.println(다음노래제목);
	    Assert.assertFalse(다음노래제목.contains(현재노래제목));	    
	    
	    test.log(Status.INFO, "이전버튼 클릭"); 
	    util.click(By.id("prevButton"));
	    Thread.sleep(1500);
	    
	    test.log(Status.INFO, "이전 노래 제목 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    String 이전노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    System.out.println(이전노래제목);
	    Assert.assertEquals(현재노래제목, 이전노래제목);
	    
	}
	

	@Test(description = "누구앱 리그레이션 TC : 홈_074")
	public void TC_홈_074_02(Method method) throws Exception {
		
		test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "현재 재생중인 미디어 아이콘"); 
	    boolean 현재재생 = util.isElementPresent(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.ImageView"));
	    Assert.assertTrue(현재재생);
	    
	    test.log(Status.INFO, "세버째 재생목록 클릭"); 
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[3]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView[1]"));
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "현재 재생중인 미디어 아이콘 세번째 리스트 확인"); 
	    boolean 현재재생2 = util.isElementPresent(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[3]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.ImageView"));
	    Assert.assertTrue(현재재생2);
	    
	    test.log(Status.INFO, "미디어플레이어 재생목록 닫기");
	    util.click(By.id("actionClose"));
		
	}
	
	

}
