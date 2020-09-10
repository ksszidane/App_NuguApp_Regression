package NUGUAPP_003_홈;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_03_디바이스메시지 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_006")
	public void TC_홈_006(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
	    util.click(By.id("loginButton"));
	    
	    test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
	    util.click(By.className("btn-secondary-text"));
	    
	    //test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
	    //util.click(By.className("c-ick"));
	    
	    test.log(Status.INFO, "디바이스 연결없는 계정 로그인");
	    
	    test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
	    util.type(By.id("userId"), "ksszidane1@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
	    util.type(By.id("password"), "rlatjdtn10!!");
	    
	    test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 확인");
	    String 연결하기홈카드 = util.getText(By.id("tvDescription"));
	    Assert.assertEquals(연결하기홈카드, "NUGU 디바이스를 연결해주세요.");
	    
	    test.log(Status.INFO, "첫번째 홈카드 재 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 홈카드 클릭");
	    util.click(By.id("deviceMessageViewPager"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));

	    test.log(Status.INFO, "건너뛰기로 홈 화면 복귀");
	    util.click(By.id("skipButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_007~008")
	public void TC_홈_007_from_008(Method method) throws Exception {
		
		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
	    util.click(By.className("btn-secondary-text"));
	    
	    //test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
	    //util.click(By.className("c-ick"));
	    
	    test.log(Status.INFO, "디바이스 연결없는 계정 로그인");
	    
	    test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
	    util.type(By.id("userId"), "ksszidane1@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
	    util.type(By.id("password"), "rlatjdtn10!!");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    //test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    //util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice_SkipCheck();
	    	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금연결하기' 확인");
	    String 연결하기홈카드 = util.getText(By.id("tvDescription"));
	    Assert.assertEquals(연결하기홈카드, "연결을 기다리는 NUGU 디바이스가 있어요.");
	    
	    test.log(Status.INFO, "첫번째 홈카드 재 이동");
	    util.swipe(200, 650, 900, 650);
	    
	    test.log(Status.INFO, "홈카드 '지금설정하기' 홈카드 클릭");
	    util.click(By.id("deviceMessageViewPager"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.id("descriptionTextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("디바이스 전원을 켜고"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_013")
	public void TC_홈_013_01(Method method) throws Exception {

		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.xpath("//ul[@class='account-list']/li[3]"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU mini (NU200_3F2B99) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	   
	    test.log(Status.INFO, "\"멜론 top 100 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("멜론 top 100 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"멜론 top 100 틀어줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("누구 앱에서 멜론에 로그인해주세요. 지금은 1분만 들려드릴게요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_013")
	public void TC_홈_013_02(Method method) throws Exception {
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
		 
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
		    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("1분 미리듣기 중\n계속 들으시려면\n멜론 로그인해 주세요."));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_014")
	public void TC_홈_014_01(Method method) throws Exception {
		
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
		
	    test.log(Status.INFO, "\"FLO 최신 노래 들려줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("FLO 최신 노래 들려줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"FLO 최신 노래 들려줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("누구 앱에서 Flo에 로그인해주세요. 지금은 1분만 들려드릴게요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
    

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_014")
	public void TC_홈_014_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("1분 미리듣기 중\n계속 들으시려면\nFLO 로그인해 주세요."));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_015")
	public void TC_홈_015_01(Method method) throws Exception {
	   
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
		
		test.log(Status.INFO, "\"11번가초이스 상품 추천해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("11번가초이스 상품 추천해줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"11번가초이스 상품 추천해줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("누구 앱에서, 11번가 로그인 하신 후 주문해 주세요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_015")
	public void TC_홈_015_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("쇼핑을 빠르고 쉽게\n11번가 로그인 후\n주문할 수 있어요"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_016")
	public void TC_홈_016_01(Method method) throws Exception {
	   
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
		
		test.log(Status.INFO, "\"내일 일정 알려줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("내일 일정 알려줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"내일 일정 알려줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("연동된 캘린더가 없습니다. 누구앱에서 구글 캘린더와 연동해주세요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_016")
	public void TC_홈_016_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("Google 캘린더\n로그인 후 일정을\n확인해보세요"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_017")
	public void TC_홈_017_01(Method method) throws Exception {
	   
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
		
		test.log(Status.INFO, "\"에어컨 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("에어컨 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"에어컨 틀어줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("스마트홈 로그인이 필요합니다. 누구 앱에서 SKT 스마트홈에 로그인 해주세요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_017")
	public void TC_홈_017_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("스마트홈을 편리하게 기기연결 하여 음성 컨트롤하세요."));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_018")
	public void TC_홈_018_01(Method method) throws Exception {
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='B tv (Smart_BC78) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	   
	    test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, smart3_did, smart3_token);
	    
	    test.log(Status.INFO, "\"CJ 오쇼핑 주문해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("CJ 오쇼핑 주문해줘", ksszidane10, smart3_did, ServerName, Place, smart3_token);
	       
	    test.log(Status.INFO, "\"CJ 오쇼핑 주문해줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, smart3_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("상품을 주문 하시려면, 누구 앱에서, 씨제이 오쇼핑에 로그인해주세요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, smart3_did, ServerName, Place, smart3_token);
    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_018")
	public void TC_홈_018_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("로그인 후\nCJ오쇼핑 상품을\n간편하게 주문"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_019")
	public void TC_홈_019_01(Method method) throws Exception {
		
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, smart3_did, smart3_token);
		
		test.log(Status.INFO, "\"SK 스토아 주문해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("SK 스토아 주문해줘", ksszidane10, smart3_did, ServerName, Place, smart3_token);
	       
	    test.log(Status.INFO, "\"SK 스토아 주문해줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, smart3_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("상품을 주문 하시려면, 누구 앱에서, 에스케이 스토아에 로그인해주세요."));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, smart3_did, ServerName, Place, smart3_token);
	    
	  
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_019")
	public void TC_홈_019_02(Method method) throws Exception {
		
		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
		    
	    test.log(Status.INFO, "홈화면 새로고침"); 
		util.scrollUp(1);
		    
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
		util.connectingDevice();
		    
		test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
		util.fastSwipe(200, 650, 900, 650, 7);
		Thread.sleep(1000);
		솔루션메시지.add(util.getText(By.id("tvDescription")));
		Thread.sleep(2500);
		솔루션메시지.add(util.getText(By.id("tvDescription")));
		Thread.sleep(2500);
		솔루션메시지.add(util.getText(By.id("tvDescription")));
		Thread.sleep(2500);
		솔루션메시지.add(util.getText(By.id("tvDescription")));
		    
		System.out.println(솔루션메시지);
		Assert.assertTrue(솔루션메시지.contains("로그인 후\nSK스토아 상품을\n간편하게 주문"));		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_020")
	public void TC_홈_020_01(Method method) throws Exception {
		
		if(Place.equals("out")) {
			test.log(Status.SKIP, "사내OA망이 아님, Test Skip"); 
			throw new SkipException("사내OA망이 아님, Test Skip");
			
			
        } 
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='T map (Android) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	   
	    test.log(Status.INFO, "\"스타벅스에서 아메리카노 주문해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("스타벅스에서 아메리카노 주문해줘", ksszidane10, "ALDFL0RMN9H6319D2F26", ServerName, Place, "");
	    
	       
	    test.log(Status.INFO, "\"스타벅스에서 아메리카노 주문해줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, "ALDFL0RMN9H6319D2F26", ServerName, Place);
	    Assert.assertTrue(tts.contains("누구 앱에서, 스타벅스 계정을 등록하신 후, 주문할 수 있어요."));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_020")
	public void TC_홈_020_02(Method method) throws Exception {
		
		if(Place.equals("out")) {
			test.log(Status.SKIP, "사내OA망이 아님, Test Skip"); 
			throw new SkipException("사내OA망이 아님, Test Skip");
        } 
		
	    ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("누구 앱에서, 스타벅스 계정을 등록하신 후, 주문할 수 있어요."));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_022")
	public void TC_홈_022_01(Method method) throws Exception {
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU mini (NU200_3F2B99) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
	   
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("B tv에서 EBS 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("연결된 셋톱박스가 없습니다. NUGU 앱을 통해 연결 후 다시 이용해 주세요"));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_022")
	public void TC_홈_022_02(Method method) throws Exception {
		
	    ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("편리한 TV생활\nB tv 연결 후\n음성 컨트롤 하세요"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_023")
	public void TC_홈_023(Method method) throws Exception {

	    test.log(Status.INFO, "\"내폰 찾아줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("내폰 찾아줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	          
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "폰찾기 팝업 확인");
	    boolean 폰찾기팝업 = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='NUGU에서 폰찾기를 요청했습니다.'])"));
		Assert.assertTrue(폰찾기팝업);
		
		test.log(Status.INFO, "폰찾기 팝업 확인");
		util.click(By.id("positiveButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_024")
	public void TC_홈_024(Method method) throws Exception {

		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
	    
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
        
		test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

        test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane, NU100_4228C8_did, NU100_4228C8_token);
	 
	    test.log(Status.INFO, "\"11번가에서 상품 추천해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("11번가에서 상품 추천해줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "푸쉬메시지 확인");
	    boolean 십일번가초이스푸쉬 = util.pushMessage("요청하신 11번가 상품리스트가 도착했습니다.");
		Assert.assertTrue(십일번가초이스푸쉬);
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	}

	@Test(description = "누구앱 리그레이션 TC : 홈_025")
	public void TC_홈_025(Method method) throws Exception {
		
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane, NU100_4228C8_did, NU100_4228C8_token);
		
		test.log(Status.INFO, "\"11번가에서 햇반 검색해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("11번가에서 햇반 검색해줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "푸쉬메시지 확인");
	    boolean 십일번가초이스푸쉬 = util.pushMessage("요청하신 11번가 상품리스트가 도착했습니다.");
		Assert.assertTrue(십일번가초이스푸쉬);
  
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_026")
	public void TC_홈_026(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU mini (NU200_3F2B99) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
	   
	    test.log(Status.INFO, "\"오늘 일정뭐야\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("오늘 일정뭐야", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("B tv에서 EBS 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);

	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(2);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("Google 캘린더\n로그인 후 일정을\n확인해보세요"));
	    Assert.assertTrue(솔루션메시지.contains("편리한 TV생활\nB tv 연결 후\n음성 컨트롤 하세요"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_027")
	public void TC_홈_027(Method method) throws Exception {
		
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);

	    //test.log(Status.INFO, "\"오늘 일정뭐야\" [발화 커맨트] 텍스트 입력"); 
	    //util.sendPost("오늘 일정뭐야", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("B tv에서 EBS 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "\"11번가에서 상품 추천해줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("11번가에서 상품 추천해줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "\"멜론에서 길구봉구 노래 들려줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("멜론에서 길구봉구 노래 들려줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);

	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("쇼핑을 빠르고 쉽게\n11번가 로그인 후\n주문할 수 있어요"));
	    Assert.assertTrue(솔루션메시지.contains("편리한 TV생활\nB tv 연결 후\n음성 컨트롤 하세요"));
	    Assert.assertTrue(솔루션메시지.contains("1분 미리듣기 중\n계속 들으시려면\n멜론 로그인해 주세요."));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_028")
	public void TC_홈_028(Method method) throws Exception {
		
		test.log(Status.INFO, "솔루션메시지(앱카드) 조회 후 이력 삭제 ");
	    util.AppCard_Delete(ksszidane10, NU200_3F2B99_did, NU200_3F2B99_token);
		
	    test.log(Status.INFO, "\"멜론에서 인기음악 들려줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("멜론에서 인기음악 들려줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);

	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
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
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 셀렉트 창 오픈"); 
	    util.click(By.id("deviceNameTextView"));
	    
	    test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='NUGU mini (NU200_3F2B99) ']")));
   
	    test.log(Status.INFO, "메뉴 닫기 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    ArrayList<String> 솔루션메시지 = new ArrayList<String>();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("1분 미리듣기 중\n계속 들으시려면\n멜론 로그인해 주세요."));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_029")
	public void TC_홈_029(Method method) throws Exception {

		ArrayList<String> 솔루션메시지 = new ArrayList<String>();
		
		test.log(Status.INFO, "홈화면 새로고침"); 
	    util.scrollUp(1);
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동하면서 텍스트메시지 리스트에 넣기");
	    util.fastSwipe(200, 650, 900, 650, 7);
	    Thread.sleep(1000);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    Thread.sleep(2500);
	    솔루션메시지.add(util.getText(By.id("tvDescription")));
	    
	    System.out.println(솔루션메시지);
	    Assert.assertTrue(솔루션메시지.contains("1분 미리듣기 중\n계속 들으시려면\n멜론 로그인해 주세요."));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_032")
	public void TC_홈_032(Method method) throws Exception {

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
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.fastSwipe(200, 650, 900, 650, 3);
	    
	    test.log(Status.INFO, "바로실행 버튼 체크");
	    for (int i=0; i<7; i++) {
	    	boolean 바로실행  = util.isElementPresent(By.id("voiceCommandLayout"));
	    	Assert.assertFalse(바로실행);
	    	util.fastSwipe(200, 650, 900, 650);
	   
	    }

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_034")
	public void TC_홈_034(Method method) throws Exception {

		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
	    util.switchContext("WEBVIEW");
	    
	    test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
	    
	    test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.xpath("//ul[@class='account-list']/li[3]"));
        
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("B tv에서 EBS 틀어줘", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	       
	    test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [TTS] 확인"); 
	    String tts = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("연결된 셋톱박스가 없습니다. NUGU 앱을 통해 연결 후 다시 이용해 주세요"));
	    
	    test.log(Status.INFO, "\"그만\" [발화 커맨트] 텍스트 입력"); 
	    util.sendPost("그만", ksszidane10, NU200_3F2B99_did, ServerName, Place, NU200_3F2B99_token);
	    
	    test.log(Status.INFO, "첫번째 홈카드 이동");
	    util.fastSwipe(200, 650, 900, 650, 3);
	    
	    test.log(Status.INFO, "홈카드 바로실행 버튼 유무 확인 후 있으면 클릭");
	    for (int i=0; i<7; i++) {
	    	if (util.isElementPresent(By.id("voiceCommandLayout"))) {
		    	System.out.println("바로실행버튼 [있음] 바로실행버튼 클릭");
		    	test.log(Status.INFO, "바로실행버튼 [있음] 바로실행버튼 클릭");
		    	util.click(By.id("voiceCommandLayout"));
		    	test.log(Status.INFO, "\"B tv에서 EBS 틀어줘\" [TTS] 확인"); 
			    String tts1 = util.TTS_JsonParsing(ksszidane10, NU200_3F2B99_did, ServerName, Place);
			    System.out.println(tts1);
		    	test.log(Status.INFO, tts1);
			    
		    } else {
		    	System.out.println("바로실행버튼 [없음] 다음 페이지 실행 대기");
		    	//Thread.sleep(2500);
		    	util.fastSwipe(200, 650, 900, 650);
		    }
	    }

	}
	
	

}
