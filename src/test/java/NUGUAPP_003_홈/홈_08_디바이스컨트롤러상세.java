package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_08_디바이스컨트롤러상세 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_080")
	public void TC_홈_080(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 1);
	    
	    test.log(Status.INFO, " 디바이스 리스트에 Android Tmap 표시 확인 "); 
	    boolean Android_Tmap = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='T map (Android) '])"));
	    Assert.assertTrue(Android_Tmap);
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 550, 2);
	    
	    test.log(Status.INFO, " 디바이스 리스트에 iOS Tmap 표시 확인 "); 
	    boolean iOS_Tmap = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='T map (iOS) '])"));
	    Assert.assertTrue(iOS_Tmap);
  
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_080")
	public void TC_홈_081(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 리스트에 별명이 [우리집]인 PoC 확인 "); 
	    boolean 우리집 = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='우리집 (AI700_70AC) '])"));
	    Assert.assertTrue(우리집);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_083")
	public void TC_홈_083(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 닫기");
	    util.click(By.id("layerDeviceName"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU200 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "디바이스 추가 [+] 버튼 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "디바이스 추가 화면으로 이동 확인"); 
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));
	    
	    test.log(Status.INFO, "NUGU 컨트롤러  화면 이동 위한 Back 키");
		util.Android_BackKey();
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_085")
	public void TC_홈_085(Method method) throws Exception {
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
		test.log(Status.INFO, "연결된 디바이스 베터리 구성 확인"); 
		boolean 베터리정보 = util.isElementPresent(By.id("tvBattery"));
	    Assert.assertTrue(베터리정보);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_087")
	public void TC_홈_087(Method method) throws Exception {
	    
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 2);
	    
	    test.log(Status.INFO, "NU110 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU candle (NU110_0127D6) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
		test.log(Status.INFO, "연결된 디바이스 베터리 구성 확인"); 
		boolean 베터리정보 = util.isElementPresent(By.id("tvBattery"));
		Assert.assertFalse(베터리정보);

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_088")
	public void TC_홈_088(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 설정 버튼 클릭"); 
		util.click(By.id("ivDeviceSetting"));
		
		test.log(Status.INFO, "디바이스 설정 화면 이동 확인"); 
		boolean 디바이스설정화면 = util.isElementPresent(By.id("rvDeviceInfo"));
	    Assert.assertTrue(디바이스설정화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭");
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_090")
	public void TC_홈_090(Method method) throws Exception {
		

	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();

		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU110 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	
		test.log(Status.INFO, "디바이스 컨트롤 [블루투스]버튼 클릭 (On)");
		util.click(By.id("btnBluetooth"));
		
		Thread.sleep(5000);
		test.log(Status.INFO, "블루투스 on TTS 확인");
		String tts = util.TTS_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 7);
	    Assert.assertTrue(tts.contains("블루투스 연결이 준비되었습니다. 연결하려는 디바이스에서"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_091")
	public void TC_홈_091(Method method) throws Exception {
	    
	    test.log(Status.INFO, "디바이스 컨트롤 [블루투스]버튼 클릭 (Off)");
		util.click(By.id("btnBluetooth"));
		
		test.log(Status.INFO, "마이크 Off context 확인");
		String Bluetooth_off = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(Bluetooth_off.contains("Bluetooth\":{\"version\":\"1.1\",\"device\":{\"name\":\"NUGU_4228C8\",\"status\":\"OFF"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_092")
	public void TC_홈_092(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 컨트롤 [마이크]버튼 클릭 (Off)");
		util.click(By.id("btnMic"));
		
		test.log(Status.INFO, "마이크 Off context 확인");
		String mic_off = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(mic_off.contains("micStatus\":\"OFF"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_093")
	public void TC_홈_093(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 컨트롤 [마이크]버튼 클릭 (On)");
		util.click(By.id("btnMic"));
		
		test.log(Status.INFO, "마이크 on context 확인");
		String mic_on = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(mic_on.contains("micStatus\":\"ON"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_096")
	public void TC_홈_096(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 컨트롤 [무드등]버튼 클릭 (On)");
		util.click(By.id("btnLight"));
		
		test.log(Status.INFO, "무드등 on context 확인");
		String moodlight_on = util.event_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 8);
	    Assert.assertTrue(moodlight_on.contains("TurnOnLightSucceeded"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_097")
	public void TC_홈_097(Method method) throws Exception {
	    
		Thread.sleep(1500);
		test.log(Status.INFO, "디바이스 컨트롤 [무드등]버튼 클릭 (Off)");
		util.click(By.id("btnLight"));
		
		test.log(Status.INFO, "무드등 off context 확인");
		String moodlight_off = util.event_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 8);
	    Assert.assertTrue(moodlight_off.contains("TurnOffLightSucceeded"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_098")
	public void TC_홈_098(Method method) throws Exception {
	    
		test.log(Status.INFO, "오른쪽으로 플리킹 동작"); 
	    util.fastSwipe(900, 700, 200, 700, 3);
	    
	    test.log(Status.INFO, "더보기 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageView[@content-desc='더보기']")));
	    
	    test.log(Status.INFO, "텍스트 명령 화면으로 이동 확인"); 
	    boolean 텍스트명령화면 = util.isElementPresent(By.id("commandEditText"));
	    Assert.assertTrue(텍스트명령화면);
	    
	    test.log(Status.INFO, "NUGU 컨트롤러 닫기 화면 클릭"); 
	    util.click(By.id("actionClose"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_099")
	public void TC_홈_099(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
		    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 1);
		    
	    test.log(Status.INFO, "Tmap디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='T map (Android) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "텍스트 명령 화면으로 이동 확인"); 
	    boolean 볼룸바 = util.isElementPresent(By.id("sbVolume"));
	    Assert.assertFalse(볼룸바);
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_100")
	public void TC_홈_100(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU100 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
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
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [-]로 -1 값 변경");
		util.click(By.id("ivMinVolume"));
		Thread.sleep(1500);
		
		test.log(Status.INFO, "볼륨 컨트롤 [3] 선택 확인");
		String volume_1 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_1.contains("volume\":3"));
	    
		test.log(Status.INFO, "볼륨 컨트롤 [-]로 +1 값 변경");
		util.click(By.id("ivMaxVolume"));
		Thread.sleep(1500);

		test.log(Status.INFO, "볼륨 컨트롤 [4] 선택 확인");
		String volume_7 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_7.contains("volume\":4,\"muted"));
	   
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_101")
	public void TC_홈_101(Method method) throws Exception {
		
		test.log(Status.INFO, "[볼륨 2로 변경해줘] 발화 후 볼륨 컨트롤러 확인"); 
	    util.sendPost("볼륨 2로 변경해줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [2] 선택 확인");
		String volume_7 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_7.contains("volume\":2,\"muted"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_102")
	public void TC_홈_102(Method method) throws Exception {
		
		test.log(Status.INFO, "NU100 PoC SPK 최소볼륨값1, 최대볼륨값 확인20"); 
		String nu100_volume_Setting = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(nu100_volume_Setting.contains("minVolume\":0,\"maxVolume\":20"));
		
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU200 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU mini (NU200_95C146) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈1 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈1);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[몇시야] 발화"); 
	    util.sendPost("몇시야", ksszidane, NU200_95C146_did, ServerName, Place, NU200_95C146_token);
	    
	    test.log(Status.INFO, "NU100 PoC SPK 최소볼륨값1, 최대볼륨값 확인16"); 
		String nu200_volume_Setting = util.context_JsonParsing(ksszidane, NU200_95C146_did, ServerName, Place);
		Assert.assertTrue(nu200_volume_Setting.contains("minVolume\":0,\"maxVolume\":16"));
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "연결된 NUGU 디바이스 목록 아래로 스크롤");
	    util.fastSwipe(520, 900, 520, 620, 2);
	    
	    test.log(Status.INFO, "NU110 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='B tv (AI 2_23A4) '])"));
	    
	    Thread.sleep(1500);
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈2 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈2);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
	    test.log(Status.INFO, "[몇시야] 발화"); 
	    util.sendPost("몇시야", ksszidane, AI2_did, ServerName, Place, AI2_token);
	    
	    test.log(Status.INFO, "AI2 Btv PoC SPK 최소볼륨값1, 최대볼륨값 확인32"); 
		String ai2_volume_Setting = util.context_JsonParsing(ksszidane, AI2_did, ServerName, Place);
		Assert.assertTrue(ai2_volume_Setting.contains("minVolume\":0,\"maxVolume\":32"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_103")
	public void TC_홈_103(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 NUGU 디바이스 목록 펼침");
	    util.click(By.id("btnDeviceSelect"));
	    
	    test.log(Status.INFO, "NU110 디바이스 선택 디바이스 변경 시, Home 화면 전체 Refresh되며 홈 화면으로 이동"); 
	    util.click(By.xpath("(//android.widget.TextView[@text='NUGU (NUGU_4228C8) '])"));
	    
	    test.log(Status.INFO, "메인 홈으로 이동 확인"); 
	    boolean 메인홈 = util.isElementPresent(By.id("layerHomeMain"));
	    Assert.assertTrue(메인홈);
	    
	    test.log(Status.INFO, "디바이스컨트롤러 전체화면 펼침"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [4]으로 선택");
		util.touchTab(310, 1450);
		
		test.log(Status.INFO, "[소리 크기 줄여줘] 발화 후 볼륨 컨트롤러 확인"); 
	    util.sendPost("소리 크기 줄여줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "볼륨 컨트롤 [3] 선택 확인");
		String volume_7 = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place);
	    Assert.assertTrue(volume_7.contains("volume\":3,\"muted"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_103")
	public void TC_홈_104(Method method) throws Exception {
		
		test.log(Status.INFO, "[마이크 꺼줘] 발화 "); 
	    util.sendPost("마이크 꺼줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "마이크 on context 확인");
		String mic_off = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(mic_off.contains("micStatus\":\"OFF"));
	    
	    test.log(Status.INFO, "[마이크 켜줘] 발화 "); 
	    util.sendPost("마이크 켜줘", ksszidane, NU100_4228C8_did, ServerName, Place, NU100_4228C8_token);
	    
	    test.log(Status.INFO, "마이크 on context 확인");
		String mic_on = util.context_JsonParsing(ksszidane, NU100_4228C8_did, ServerName, Place, 5);
	    Assert.assertTrue(mic_on.contains("micStatus\":\"ON"));
		
	}
	


}
