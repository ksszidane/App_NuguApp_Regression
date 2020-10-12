package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_09_미디어컨트롤러상세 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_106")
	public void TC_홈_106(Method method) throws Exception {
		
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
	    util.sendPost("멜론에서 봄여름가을겨울의 거리의 악사 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='봄여름가을겨울']"));
	    Assert.assertTrue(가수.contains("봄여름가을겨울"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("거리의 악사"));

	}
	

	@Test(description = "누구앱 리그레이션 TC : 홈_107")
	public void TC_홈_107(Method method) throws Exception {
		
		test.log(Status.INFO, "FLO에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("FLO에서 봄여름가을겨울의 거리의 악사 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='봄여름가을겨울']"));
	    Assert.assertTrue(가수.contains("봄여름가을겨울"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("거리의 악사"));
		
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_108")
	public void TC_홈_108(Method method) throws Exception {
		
		test.log(Status.INFO, "벅스에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("벅스에서 봄여름가을겨울의 거리의 악사 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='봄여름가을겨울']"));
	    Assert.assertTrue(가수.contains("봄여름가을겨울"));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains("거리의 악사"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_110")
	public void TC_홈_109(Method method) throws Exception {
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "멜론 어린이 메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='멜론 어린이']")));
	    
	    test.log(Status.INFO, "가수명 체크 확인"); 
	    String get_가수 = util.getText(By.id("artistNameTextView"));
		
		test.log(Status.INFO, "노래제목 체크 확인"); 
		String get_노래제목 = util.getText(By.id("songNameTextView"));
		
		test.log(Status.INFO, "첫번째 동요 클릭"); 
		util.click(By.id("songNameTextView"));
		
		test.log(Status.INFO, "선택 재생 클릭"); 
		util.click(By.id("selectPlayTextView"));
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴닫기 버튼 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
		
		test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수 = util.getText(By.xpath("//android.widget.TextView[@text='"+get_가수+"']"));
	    Assert.assertTrue(가수.contains(get_가수));
	    
	    test.log(Status.INFO, "노래제목 [있음] 확인"); 
	    String 노래제목 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(노래제목.contains(get_노래제목));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_110")
	public void TC_홈_110(Method method) throws Exception {
		
		test.log(Status.INFO, "힐링사운드 재생해줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("힐링사운드 재생해줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "제공처 [있음] 확인"); 
		String 제공처 = util.getText(By.xpath("//android.widget.TextView[@text='탕카']"));
	    Assert.assertTrue(제공처.contains("탕카"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_111")
	public void TC_홈_111(Method method) throws Exception {
		
		test.log(Status.INFO, "팟빵 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("팟빵에서 씨네타운나인틴 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "프로그램명 [있음] 확인"); 
		String 프로그램명 = util.getText(By.xpath("//android.widget.TextView[@text='씨네타운 나인틴 - 풍문으로 듣는 방송']"));
	    Assert.assertTrue(프로그램명.contains("씨네타운 나인틴 - 풍문으로 듣는 방송"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_112")
	public void TC_홈_112(Method method) throws Exception {
		
		test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "라디오 세션명 [있음] 확인"); 
	    String 세션명 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명.contains("SBS 파워FM"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_113")
	public void TC_홈_113(Method method) throws Exception {
		
		test.log(Status.INFO, "자체소싱(부스트파크송) 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("부스트파크송 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "제공처 [있음] 확인"); 
		String 제공처 = util.getText(By.xpath("//android.widget.TextView[@text='SK텔레콤']"));
	    Assert.assertTrue(제공처.contains("SK텔레콤"));
	    
	    test.log(Status.INFO, "제목 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_114")
	public void TC_홈_114(Method method) throws Exception {
		
		test.log(Status.INFO, "오디오북 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("오디오북에서 잠자고 싶은 토끼 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "프로그램명 [있음] 확인"); 
		String 프로그램명 = util.getText(By.xpath("//android.widget.TextView[@text='잠자고 싶은 토끼']"));
	    Assert.assertTrue(프로그램명.contains("잠자고 싶은 토끼"));
	    
	    test.log(Status.INFO, "에피소드명 [있음] 확인"); 
	    //String 노래제목 = util.getText(By.xpath("//android.widget.TextView[contains(text(),'Get Lucky')]"));
	    boolean 세션명 = util.isElementPresent(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_115")
	public void TC_홈_115(Method method) throws Exception {
		
		test.log(Status.INFO, "키워드뉴스 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("스포츠 뉴스 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어);
	    
	    String 뉴스동작확인 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 6);
	    Assert.assertTrue(뉴스동작확인.contains("playServiceId\":\"nugu.builtin.news"));


	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_117")
	public void TC_홈_117(Method method) throws Exception {

	    test.log(Status.INFO, "FLO에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("FLO에서 daft punk 노래 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "미디어플레이어 클릭 후 전체 펼침");
	    util.click(By.id("mediaLayout"));
	    
	    test.log(Status.INFO, "현재 재생중인 미디어 아이콘"); 
	    boolean 현재재생 = util.isElementPresent(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.ImageView"));
	    Assert.assertTrue(현재재생);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_118")
	public void TC_홈_118(Method method) throws Exception {
		
		test.log(Status.INFO, "FLO 플레이리스트 제목 읽어오기"); 
	    String FLO_제목1 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));
	    
	    String FLO_제목2 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[2]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));
	    
	    String FLO_제목3 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[3]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));

	    test.log(Status.INFO, "멜론 TOP 100 발화 "); 
	    util.sendPost("멜론 TOP 100 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);

	    test.log(Status.INFO, "멜론 플레이리스트 제목 읽어오기"); 
	    String 멜론_제목1 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));
	    
	    String 멜론_제목2 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[2]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));
	    
	    String 멜론_제목3 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[3]/android.widget.LinearLayout/"
	    		+ "android.widget.LinearLayout/android.widget.TextView"));
	    
	    test.log(Status.INFO, "플레이리스트 변경확인 "); 
	    Assert.assertFalse(FLO_제목1.contains(멜론_제목1));
	    Assert.assertFalse(FLO_제목2.contains(멜론_제목2));
	    Assert.assertFalse(FLO_제목3.contains(멜론_제목3));
	    
	    test.log(Status.INFO, "플레이리스트 닫기 "); 
	    util.click(By.id("actionClose"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_119")
	public void TC_홈_119(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "멜론 메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
		
		test.log(Status.INFO, "첫번째 노래 클릭"); 
		util.click(By.id("songNameTextView"));
		
		test.log(Status.INFO, "선택 재생 클릭"); 
		util.click(By.id("selectPlayTextView"));
		
		test.log(Status.INFO, "뒤로가기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "메뉴닫기 버튼 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "미디어 플레이어 [다음] 클릭"); 
	    util.click(By.id("nextButton"));
	    
	    test.log(Status.INFO, "\"한곡 재생시에는 지원하지 않는 기능입니다.\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 7);
	    Assert.assertTrue(tts.contains("한 곡만 재생할 때는 지원하지 않는 기능이에요."));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_122")
	public void TC_홈_122(Method method) throws Exception {

		test.log(Status.INFO, "멜론에서 노래 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("멜론에서 아이유 노래 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "가수명 [있음] 확인"); 
		String 가수1 = util.getText(By.xpath("//android.widget.TextView[@text='아이유']"));
	    Assert.assertTrue(가수1.contains("아이유"));
	    
	    test.log(Status.INFO, "첫번째 노래 제목 확인"); 
	    String 노래제목1 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    
	    test.log(Status.INFO, "미디어 플레이어 [다음] 클릭"); 
	    util.click(By.id("nextButton"));
	    
	    test.log(Status.INFO, "가수명 체크"); 
		String 가수2 = util.getText(By.xpath("//android.widget.TextView[@text='아이유']"));
	    Assert.assertTrue(가수1.contains("아이유"));
	    
	    test.log(Status.INFO, "아티스트 음악재생으로 다음곡 후 가수명 같음 확인"); 
	    Assert.assertEquals(가수1, 가수2);
	    
	    test.log(Status.INFO, "두번째 노래 제목 확인"); 
	    String 노래제목2 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    
	    test.log(Status.INFO, "다음곡 재생시 제목 다름 확인"); 
	    Assert.assertFalse(노래제목1.contains(노래제목2));
	    
	    test.log(Status.INFO, "미디어 플레이어 [이전] 클릭"); 
	    util.click(By.id("prevButton"));
	    
	    Thread.sleep(1500);
	    test.log(Status.INFO, "가수명 체크"); 
		String 가수3 = util.getText(By.xpath("//android.widget.TextView[@text='아이유']"));
	    Assert.assertTrue(가수3.contains("아이유"));
	    
	    test.log(Status.INFO, "아티스트 음악재생으로 이전곡 후 가수명 같음 확인"); 
	    Assert.assertEquals(가수1, 가수3);
	    
	    test.log(Status.INFO, "두번째 노래 제목 확인"); 
	    String 노래제목3 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    
	    test.log(Status.INFO, "이전곡 재생시 제목 같음 확인"); 
	    Assert.assertEquals(노래제목1, 노래제목3);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_123")
	public void TC_홈_123(Method method) throws Exception {

		test.log(Status.INFO, "일시정지버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
		
	    test.log(Status.INFO, "일시정지 확인");
	    String PAUSED = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4);
	    Assert.assertTrue(PAUSED.contains("PAUSED"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_124")
	public void TC_홈_124(Method method) throws Exception {

		test.log(Status.INFO, "재생버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
	    
	    test.log(Status.INFO, "재생 확인");
	    String PLAYING = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4);
	    Assert.assertTrue(PLAYING.contains("PLAYING"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_125")
	public void TC_홈_125(Method method) throws Exception {
		
		test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);

		test.log(Status.INFO, "일시정지버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
		
	    test.log(Status.INFO, "일시정지 확인");
	    String PAUSED = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 3);
	    Assert.assertTrue(PAUSED.contains("PAUSED"));
	    
	    test.log(Status.INFO, "재생버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
	    
	    test.log(Status.INFO, "재생 확인");
	    String PLAYING = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 3);
	    Assert.assertTrue(PLAYING.contains("PLAYING"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_126")
	public void TC_홈_126(Method method) throws Exception {
		
		test.log(Status.INFO, "FLO에서 최신곡 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("FLO에서 최신곡 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);

		test.log(Status.INFO, "일시정지버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
		
	    test.log(Status.INFO, "일시정지 확인");
	    String PAUSED = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 2);
	    Assert.assertTrue(PAUSED.contains("PAUSED"));
	    
	    test.log(Status.INFO, "재생버튼 클릭");
	    util.click(By.id("pauseButton"));
	    Thread.sleep(1000);
	    
	    test.log(Status.INFO, "재생 확인");
	    String PLAYING = util.audio_activity_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 2);
	    Assert.assertTrue(PLAYING.contains("PLAYING"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_127")
	public void TC_홈_127(Method method) throws Exception {
		
		test.log(Status.INFO, "오디오북 재생 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("오디오북 재생 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "오디오북 꺼 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("오디오북 꺼", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어1 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어1);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_128")
	public void TC_홈_128(Method method) throws Exception {
		
		test.log(Status.INFO, "ASMR 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("ASMR 재생 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "제공처 [있음] 확인"); 
		String 제공처 = util.getText(By.xpath("//android.widget.TextView[@text='탕카']"));
	    Assert.assertTrue(제공처.contains("탕카"));
	    
	    test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "라디오 세션명 [있음] 확인"); 
	    String 세션명 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명.contains("SBS 파워FM"));
	    
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_129")
	public void TC_홈_129(Method method) throws Exception {
		
		test.log(Status.INFO, "멜론 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("멜론 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU200 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어1 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어1);
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_130")
	public void TC_홈_130(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU100 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "멜론 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("멜론 들려줘 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 2);
	    
	    test.log(Status.INFO, "AI2 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='B tv (AI 2_23A4) '])"));
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어1 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어1);
	    
	    test.log(Status.INFO, "테스트를 위한 볼륨 1설정"); 
	    util.sendPost("누구 볼륨 1", ksszidane, AI2_did, ServerName, Place, AI2_token);
	    
	    test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘", ksszidane, AI2_did, ServerName, Place, AI2_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "미디어 플레이어 노출 확인"); 
		boolean 미디어플레이어 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertTrue(미디어플레이어);
	    
	    test.log(Status.INFO, "라디오 세션명 [있음] 확인"); 
	    String 세션명 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명.contains("SBS 파워FM"));
	    
	    test.log(Status.INFO, "AI2 라디오 종료"); 
	    util.sendPost("라디오 꺼", ksszidane, AI2_did, ServerName, Place, AI2_token);
	    test.log(Status.INFO, "NU100 노래 종료"); 
	    util.sendPost("노래 종료 ", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_131")
	public void TC_홈_131(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU200 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "테스트를 위한 볼륨 1설정"); 
	    util.sendPost("볼륨 1", ksszidane, NU200_95C146_did, ServerName, Place, NU200_95C146_token);
	    
	    test.log(Status.INFO, "SBS 라디오 들려줘 발화 후 미디어컨트롤러 확인"); 
	    util.sendPost("SBS 라디오 들려줘", ksszidane, NU200_95C146_did, ServerName, Place, NU200_95C146_token);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 1);
	    
	    test.log(Status.INFO, "Tmap 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='T map (Android) '])"));
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어1 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어1);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU200 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "라디오 세션명 [있음] 확인"); 
	    String 세션명 = util.getText(By.xpath("//android.view.ViewGroup/"
	    		+ "android.widget.RelativeLayout/android.widget.FrameLayout/"
	    		+ "android.widget.RelativeLayout/android.widget.TextView[1]"));
	    Assert.assertTrue(세션명.contains("SBS 파워FM"));
	    
	    test.log(Status.INFO, "라디오 종료"); 
	    util.sendPost("라디오 꺼", ksszidane, NU200_95C146_did, ServerName, Place, NU200_95C146_token);
	    
	    test.log(Status.INFO, "미디어 플레이어 미노출 확인"); 
		boolean 미디어플레이어3 = util.isElementPresent(By.id("mediaLayout"));
	    Assert.assertFalse(미디어플레이어3);


	}
		

}
