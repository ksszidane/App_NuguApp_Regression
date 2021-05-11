package NUGUAPP_003_홈;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.NUGU_TestCase;

public class 홈_06_디바이스컨트롤러 extends NUGU_TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_054")
	public void TC_홈_054(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "[+]플로팅 버튼 노출 확인 "); 
	    boolean 플로팅버튼 = util.isElementPresent(By.id("ibDeviceFab"));
	    Assert.assertTrue(플로팅버튼);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_055")
	public void TC_홈_055(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 전체 화면 노출 확인 "); 
	    boolean NUGU컨트롤러화면 = util.isElementPresent((By.xpath("//android.view.ViewGroup[@content-desc='NUGU 컨트롤러 화면']")));
	    Assert.assertTrue(NUGU컨트롤러화면);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 전체화면 닫기"); 
	    util.click(By.id("ivHeaderClose"));
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_056")
	public void TC_홈_056(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "디바이스추가버튼 구성 확인"); 
	    boolean 디바이스추가버튼 = util.isElementPresent(By.id("ivHeaderAddDevice"));
	    Assert.assertTrue(디바이스추가버튼);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 전체화면 닫기 버튼 구성 확인");  
	    boolean NUGU컨트롤러화면닫기버튼 = util.isElementPresent(By.id("ivHeaderClose"));
	    Assert.assertTrue(NUGU컨트롤러화면닫기버튼);
	    
	    test.log(Status.INFO, "연결된 디바이스 정보 구성 확인");  
	    boolean 연결된디바이스정보 = util.isElementPresent(By.id("layerDeviceName"));
	    Assert.assertTrue(연결된디바이스정보);
	    
	    if (util.isElementPresent(By.id("tvBattery"))) {
			System.out.println("베터리 정보 [있음]");
			test.log(Status.INFO, "연결된 디바이스 베터리 구성 확인"); 
			boolean 베터리정보 = util.isElementPresent(By.id("tvBattery"));
		    Assert.assertTrue(베터리정보);
		} 
	    
	    test.log(Status.INFO, "설정버튼 정보 구성 확인");  
	    boolean 설정버튼 = util.isElementPresent(By.id("ivDeviceSetting"));
	    Assert.assertTrue(설정버튼);
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 구성 확인");  
	    boolean 텍스트명령어 = util.isElementPresent(By.id("etTextCommand"));
	    Assert.assertTrue(텍스트명령어);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼란 구성 확인");  
	    boolean 디바이스기능버튼 = util.isElementPresent(By.id("layerDeviceStateButton"));
	    Assert.assertTrue(디바이스기능버튼);
	    
	    test.log(Status.INFO, "스피커 볼륨 영역 구성 확인");  
	    boolean 스피커볼륨 = util.isElementPresent(By.id("sbVolume"));
	    Assert.assertTrue(스피커볼륨);
 
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_057")
	public void TC_홈_057(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스추가버튼 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "디바이스 추가 화면으로 이동 확인"); 
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));
	    
	    test.log(Status.INFO, "NUGU 컨트롤러  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_058")
	public void TC_홈_058(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		
		test.log(Status.INFO, "NUGU 컨트롤러 닫기 화면 클릭"); 
	    util.click(By.id("ivHeaderClose"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_059")
	public void TC_홈_059(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 이미지 확인"); 
		boolean 연결된디바이스이미지 = util.isElementPresent(By.id("ivDeviceImage"));
	    Assert.assertTrue(연결된디바이스이미지);
	    
	    test.log(Status.INFO, "연결된 NUGU 별명 확인"); 
		String 디바이스별명 = util.getText(By.id("btnDeviceSelect"));
	    Assert.assertTrue(디바이스별명.contains("NUGU"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "Device 리스트 노출 확인"); 
	    boolean 연결리스트 = util.isElementPresent(By.id("listSelect"));
	    Assert.assertTrue(연결리스트);
	    
	    test.log(Status.INFO, "연결된 디바이스의 디바이스명(시리얼 넘버) 노출"); 
	    String 디바이스명_시리얼넘버 = util.getText(By.id("deviceNameTextView"));
	    Assert.assertEquals(디바이스명_시리얼넘버, "NUGU (NUGU_4228C8) ");
	    
	    test.log(Status.INFO, "선택된 디바이스에 V 표시"); 
	    boolean 선택됨 = util.isSelected(By.id("deviceNameTextView"));
	    Assert.assertTrue(선택됨);
	    
	    test.log(Status.INFO, " 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_060")
	public void TC_홈_060(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 디바이스 베터리 구성 확인"); 
		String 베터리잔량 = util.getText(By.id("tvBattery"));
	    Assert.assertTrue(베터리잔량.contains("%"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_061")
	public void TC_홈_061(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 설정 버튼 클릭"); 
		util.click(By.id("ivDeviceSetting"));
		
		test.log(Status.INFO, "디바이스 설정 화면 이동 확인"); 
		boolean 디바이스설정화면 = util.isElementPresent(By.id("rvDeviceInfo"));
	    Assert.assertTrue(디바이스설정화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭");
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_062")
	public void TC_홈_062(Method method) throws Exception {
		
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, " NUGU_4228C8로 디바이스 변경 뒤 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "가이드 문구 확인"); 
	    String 가이드문구 = util.getText(By.id("etTextCommand"));
	    Assert.assertEquals(가이드문구, "NUGU에게 말해보세요");
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 텍스트입력"); 
	    util.click(By.id("etTextCommand"));
	    util.type(By.id("etTextCommand"), "몇시야");
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 텍스트 전송 후 토스트팝업 확인"); 
	    util.click(By.id("ivTextCommand"));
	    //System.out.println(util.toastMessage("텍스트"));
	    
	    
	    test.log(Status.INFO, "텍스트명령어 공백 입력 후 전송 후 토스트팝업 확인"); 
	    util.click(By.id("ivTextCommand"));
	    //System.out.println(util.toastMessage("텍스트"));
	    
	    test.log(Status.INFO, "텍스트명령어 40자 이상 입력 후 전송 후 토스트팝업 확인"); 
	    util.click(By.id("etTextCommand"));
	    util.type(By.id("etTextCommand"), "가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
	    //System.out.println(util.toastMessage("40자"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_063 ~ 064")
	public void TC_홈_063_form_064(Method method) throws Exception {
		
		ArrayList<String> 최근전송명령어 = new ArrayList<String>();
		
		test.log(Status.INFO, "최근 전송 텍스트 명령어 확인"); 
		for(int i=1; i < 7; i++) {
			int y = 1;
			if (i < 4) {
	    		최근전송명령어.add(util.fast_getText(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout"
	    				+ "/android.widget.LinearLayout[1]/android.widget.Button["+i+"]")));
		    	System.out.println(i + "번 : " + 최근전송명령어);
	    	} else if (i > 3){ 
	    		최근전송명령어.add(util.fast_getText(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout"
	    				+ "/android.widget.LinearLayout[2]/android.widget.Button["+y+"]")));
		    	System.out.println(i + "번 : " + 최근전송명령어);
		    	
	    	}
	    }
		test.log(Status.INFO, "최근 전송 텍스트 명령어 최대 6개 확인"); 
	    Assert.assertEquals(최근전송명령어.size(), 6);
	    
	    test.log(Status.INFO, "오른쪽으로 플리킹 동작"); 
	    util.fastSwipe(900, 700, 200, 700, 3);
	    
	    test.log(Status.INFO, "더보기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageView[@content-desc='더보기']")));
	    
	    test.log(Status.INFO, "텍스트 명령 화면으로 이동 확인"); 
	    boolean 텍스트명령화면 = util.isElementPresent(By.id("commandEditText"));
	    Assert.assertTrue(텍스트명령화면);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 닫기 화면 클릭"); 
	    util.click(By.id("actionClose"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 텍스트입력 후 전송"); 
	    util.click(By.id("etTextCommand"));
	    util.type(By.id("etTextCommand"), "몇시야");
	    util.click(By.id("ivTextCommand"));
	    
	    test.log(Status.INFO, "첫번째 말풍선에 방금 전송한 '몇시야'명렁어가 있는지 확인"); 
	    util.fastSwipe(200, 700, 900, 700, 3);
	    String 첫번째말풍선 = util.fast_getText(By.xpath("//android.widget.HorizontalScrollView/android.widget.LinearLayout"
				+ "/android.widget.LinearLayout[1]/android.widget.Button[1]"));
	    Assert.assertEquals(첫번째말풍선, "몇시야");

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_065")
	public void TC_홈_065_01(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 컨트롤 [블루투스]버튼 클릭 (On)");
		util.click(By.id("btnBluetooth"));
		
		test.log(Status.INFO, "블루투스 on TTS 확인");
		String tts = util.TTS_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(tts.contains("블루투스 연결이 준비되었습니다. 연결하려는 디바이스에서"));
	    
	    test.log(Status.INFO, "디바이스 컨트롤 [블루투스]버튼 클릭 (Off)");
		util.click(By.id("btnBluetooth"));
	
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_065")
	public void TC_홈_065_02(Method method) throws Exception {
		

		test.log(Status.INFO, "디바이스 컨트롤 [마이크]버튼 클릭 (Off)");
		util.click(By.id("btnMic"));
		
		test.log(Status.INFO, "마이크 Off context 확인");
		String mic_off = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4 );
		Assert.assertTrue(mic_off.contains("micStatus\":\"OFF"));
		
		test.log(Status.INFO, "디바이스 컨트롤 [마이크]버튼 클릭 (On)");
		util.click(By.id("btnMic"));
		
		test.log(Status.INFO, "마이크 on context 확인");
		String mic_on = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4);
	    Assert.assertTrue(mic_on.contains("micStatus\":\"ON"));

	}

	@Test(description = "누구앱 리그레이션 TC : 홈_065")
	public void TC_홈_065_03(Method method) throws Exception {
	
		test.log(Status.INFO, "디바이스 컨트롤 [무드등]버튼 클릭 (On)");
		util.click(By.id("btnLight"));
		
		test.log(Status.INFO, "무드등 on context 확인");
		String moodlight_on = util.event_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4);
	    Assert.assertTrue(moodlight_on.contains("TurnOnLightSucceeded"));
		
	    Thread.sleep(1500);
		test.log(Status.INFO, "디바이스 컨트롤 [무드등]버튼 클릭 (Off)");
		util.click(By.id("btnLight"));
		
		test.log(Status.INFO, "무드등 off context 확인");
		String moodlight_off = util.event_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 4);
	    Assert.assertTrue(moodlight_off.contains("TurnOffLightSucceeded"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_065")
	public void TC_홈_065_04(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 컨트롤 [알람]버튼 클릭");
		util.click(By.id("btnAlarm"));
		
		test.log(Status.INFO, "알람 설정 화면 이동 확인");
		boolean 알람설정화면 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='알람']"));
	    Assert.assertTrue(알람설정화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭");
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_065")
	public void TC_홈_065_05(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		
		test.log(Status.INFO, "볼륨 컨트롤 [10]으로 선택");
		util.touchTab(558, 1450);
		
		test.log(Status.INFO, "볼륨 컨트롤 [10] 선택 확인");
		String volume_10 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_10.contains("volume\":10,\"muted"));
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [4]으로 선택");
		util.touchTab(310, 1450);
		
		test.log(Status.INFO, "볼륨 컨트롤 [4] 선택 확인");
		String volume_4 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_4.contains("volume\":4,\"muted"));
		

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_066")
	public void TC_홈_066(Method method) throws Exception {
		
	    test.log(Status.INFO, "PoC SPK 최소볼륨값1, 최대볼륨값 확인20"); 
		String volume_Setting = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_Setting.contains("{\"minVolume\":0,\"maxVolume\":20,\"defaultVolumeStep\":1,\"volume\":10,\"muted\":false,\"name\":\"NUGU\"}"));
		
		test.log(Status.INFO, "볼륨 컨트롤 [-]로 -3 값 변경");
		util.click(By.id("ivMinVolume"));
		Thread.sleep(1500);
		util.click(By.id("ivMinVolume"));
		Thread.sleep(1500);
		util.click(By.id("ivMinVolume"));
		
		test.log(Status.INFO, "볼륨 컨트롤 [1] 선택 확인");
		String volume_1 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_1.contains("volume\":1"));
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [4]으로 선택");
		util.touchTab(310, 1450);
		
		test.log(Status.INFO, "볼륨 컨트롤 [-]로 +3 값 변경");
		util.click(By.id("ivMaxVolume"));
		Thread.sleep(1500);
		util.click(By.id("ivMaxVolume"));
		Thread.sleep(1500);
		util.click(By.id("ivMaxVolume"));
		Thread.sleep(3000);
		
		test.log(Status.INFO, "볼륨 컨트롤 [7] 선택 확인");
		String volume_7 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_7.contains("volume\":7,\"muted"));
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [4]으로 선택");
		util.touchTab(310, 1450);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_067")
	public void TC_홈_067(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 이동");
	    util.fastSwipe(520, 900, 520, 550, 2);
	    
	    test.log(Status.INFO, " B tv (AI 2_23A4)로 디바이스 변경 뒤 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='B tv (AI 2_23A4) '])"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스추가버튼 구성 확인"); 
	    boolean 디바이스추가버튼 = util.isElementPresent(By.id("ivHeaderAddDevice"));
	    Assert.assertTrue(디바이스추가버튼);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 전체화면 닫기 버튼 구성 확인");  
	    boolean NUGU컨트롤러화면닫기버튼 = util.isElementPresent(By.id("ivHeaderClose"));
	    Assert.assertTrue(NUGU컨트롤러화면닫기버튼);
	    
	    test.log(Status.INFO, "연결된 디바이스 정보 구성 확인");  
	    boolean 연결된디바이스정보 = util.isElementPresent(By.id("layerDeviceName"));
	    Assert.assertTrue(연결된디바이스정보);

	    test.log(Status.INFO, "설정버튼 정보 구성 확인");  
	    boolean 설정버튼 = util.isElementPresent(By.id("ivDeviceSetting"));
	    Assert.assertTrue(설정버튼);
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 구성 확인");  
	    boolean 텍스트명령어 = util.isElementPresent(By.id("etTextCommand"));
	    Assert.assertTrue(텍스트명령어);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼란 구성 확인");  
	    boolean 디바이스기능버튼 = util.isElementPresent(By.id("layerDeviceStateButton"));
	    Assert.assertTrue(디바이스기능버튼);
	    
	    test.log(Status.INFO, "스피커 볼륨 영역 구성 확인");  
	    boolean 스피커볼륨 = util.isElementPresent(By.id("sbVolume"));
	    Assert.assertTrue(스피커볼륨);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_068")
	public void TC_홈_068_And_070(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 디바이스 [베터리 구성 없음] 확인"); 
		boolean 베터리정보 = util.isElementPresent(By.id("tvBattery"));
	    Assert.assertFalse(베터리정보);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [블루투스 있음] 확인");
		boolean 블루투스 = util.isElementPresent(By.id("btnBluetooth"));
		Assert.assertTrue(블루투스);
	    
		test.log(Status.INFO, "디바이스 기능 버튼 [마이크 없음] 확인");
		boolean 마이크 = util.isElementPresent(By.id("btnMic"));
		Assert.assertTrue(마이크);
		
	    test.log(Status.INFO, "디바이스 기능 버튼 [무드등 없음] 확인"); 
		boolean 무드등 = util.isElementPresent(By.id("btnLight"));
	    Assert.assertFalse(무드등);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [알람 있음] 확인"); 
		boolean 알람 = util.isElementPresent(By.id("btnAlarm"));
	    Assert.assertTrue(알람);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_069")
	public void TC_홈_069_01(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 이동");
	    util.fastSwipe(520, 900, 520, 550, 2);
	    
	    test.log(Status.INFO, "T map (iOS) 로 디바이스 변경 뒤 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='T map (iOS) '])"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스추가버튼 구성 확인"); 
	    boolean 디바이스추가버튼 = util.isElementPresent(By.id("ivHeaderAddDevice"));
	    Assert.assertTrue(디바이스추가버튼);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 전체화면 닫기 버튼 구성 확인");  
	    boolean NUGU컨트롤러화면닫기버튼 = util.isElementPresent(By.id("ivHeaderClose"));
	    Assert.assertTrue(NUGU컨트롤러화면닫기버튼);
	    
	    test.log(Status.INFO, "연결된 디바이스 정보 구성 확인");  
	    boolean 연결된디바이스정보 = util.isElementPresent(By.id("layerDeviceName"));
	    Assert.assertTrue(연결된디바이스정보);

	    test.log(Status.INFO, "설정버튼 정보 구성 확인");  
	    boolean 설정버튼 = util.isElementPresent(By.id("ivDeviceSetting"));
	    Assert.assertTrue(설정버튼);
	    
	    test.log(Status.INFO, "POC의 대표 발화문 노출 확인");  
	    boolean 대표발화문 = util.isElementPresent(By.id("layerUtterance"));
	    Assert.assertTrue(대표발화문);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_069")
	public void TC_홈_069_02_And_070(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 기능 버튼 [블루투스 없음] 확인");
		boolean 블루투스 = util.isElementPresent(By.id("btnBluetooth"));
		Assert.assertFalse(블루투스);
		
		test.log(Status.INFO, "디바이스 기능 버튼 [마이크 없음] 확인");
		boolean 마이크 = util.isElementPresent(By.id("btnMic"));
		Assert.assertFalse(마이크);
		
		test.log(Status.INFO, "디바이스 기능 버튼 [무드등 없음] 확인"); 
		boolean 무드등 = util.isElementPresent(By.id("btnLight"));
	    Assert.assertFalse(무드등);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [알람 없음] 확인"); 
		boolean 알람 = util.isElementPresent(By.id("btnAlarm"));
	    Assert.assertFalse(알람);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [볼륨 없음] 확인");  
	    boolean 스피커볼륨 = util.isElementPresent(By.id("sbVolume"));
	    Assert.assertFalse(스피커볼륨);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_070")
	public void TC_홈_070(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));

	    test.log(Status.INFO, " B tv (AI 2_23A4)로 디바이스 변경 뒤 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		
		test.log(Status.INFO, "디바이스 기능 버튼 [블루투스 있음] 확인");
		boolean 블루투스 = util.isElementPresent(By.id("btnBluetooth"));
		Assert.assertTrue(블루투스);
		
		test.log(Status.INFO, "디바이스 기능 버튼 [마이크 있음] 확인");
		boolean 마이크 = util.isElementPresent(By.id("btnMic"));
		Assert.assertTrue(마이크);
		
		test.log(Status.INFO, "디바이스 기능 버튼 [무드등 있음] 확인"); 
		boolean 무드등 = util.isElementPresent(By.id("btnLight"));
	    Assert.assertTrue(무드등);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [알람 있음] 확인"); 
		boolean 알람 = util.isElementPresent(By.id("btnAlarm"));
	    Assert.assertTrue(알람);
	    
	    test.log(Status.INFO, "디바이스 기능 버튼 [볼륨 있음] 확인");  
	    boolean 스피커볼륨 = util.isElementPresent(By.id("sbVolume"));
	    Assert.assertTrue(스피커볼륨);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_071")
	public void TC_홈_071_01(Method method) throws Exception {
		
		test.log(Status.INFO, "오른쪽으로 플리킹 동작"); 
	    util.fastSwipe(900, 700, 200, 700, 3);
	    
	    test.log(Status.INFO, "더보기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageView[@content-desc='더보기']")));
	    
	    test.log(Status.INFO, "입력필드에 포커스 확인"); 
	    boolean 포커스 = util.isFucused(By.id("commandEditText"));
	    Assert.assertTrue(포커스);
	    
	    test.log(Status.INFO, "텍스트명령어 입력란 텍스트입력"); 
	    util.type(By.id("commandEditText"), "몇시야");
	    
	    test.log(Status.INFO, "텍스트 명령어 입력란 [X]버튼 노출 확인 및 클릭"); 
		boolean X버튼 = util.isElementPresent(By.id("commandClearImageView"));
	    Assert.assertTrue(X버튼);
	    util.click(By.id("commandClearImageView"));
	    
	    test.log(Status.INFO, "입력된 텍스트명령어 삭제 후 가이드 문구 확인");
	    String 가이드문구 = util.getText(By.id("commandEditText"));
	    Assert.assertEquals(가이드문구, "NUGU에게\n말해보세요.");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_071")
	public void TC_홈_071_02(Method method) throws Exception {
		
		test.log(Status.INFO, "즐겨찾기 영역 확인"); 
		String 즐겨찾기 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.TextView"));
	    Assert.assertEquals(즐겨찾기, "즐겨찾기");
	    
	    test.log(Status.INFO, "즐겨찾기 목록 확인"); 
	    boolean 즐겨찾기토글 = util.isChecked(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/"
				+ "android.widget.ToggleButton"));
	    Assert.assertTrue(즐겨찾기토글);
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_071")
	public void TC_홈_071_03(Method method) throws Exception {
		
		test.log(Status.INFO, "즐겨찾기 영역 확인"); 
		String 즐겨찾기 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.TextView"));
	    Assert.assertEquals(즐겨찾기, "즐겨찾기");
	    
	    test.log(Status.INFO, "즐겨찾기 목록 확인"); 
	    boolean 즐겨찾기토글 = util.isChecked(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[1]/"
				+ "android.widget.ToggleButton"));
	    Assert.assertTrue(즐겨찾기토글);
	    
	    test.log(Status.INFO, "임의의 영역 클릭 후 키패드 사라지게 하기"); 
	    util.click(By.id("titleTextView"));
	    
	    test.log(Status.INFO, "즐겨찾기 목록 클릭"); 
	    util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[3]"));
	    
	    test.log(Status.INFO, "최근대화 첫번째 목록에 추가 확인");
	    String 최근대화  = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[5]/android.widget.TextView[2]"));
	    Assert.assertTrue(최근대화.contains("지투"));
	    
	    test.log(Status.INFO, "최근대화 첫번째 목록에 추가 확인");
	    String 최근대화_오늘  = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
	    		+ "android.widget.LinearLayout[5]/android.widget.TextView[3]"));
	    Assert.assertTrue(최근대화_오늘.contains("오늘"));
	}
	

}
