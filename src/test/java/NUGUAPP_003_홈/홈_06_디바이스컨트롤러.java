package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_06_디바이스컨트롤러 extends TestCase {
	
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
	    
	    test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
	    
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
	
	@Test(description = "누구앱 리그레이션 TC : 홈_059")
	public void TC_홈_060(Method method) throws Exception {
		
		test.log(Status.INFO, "연결된 디바이스 베터리 구성 확인"); 
		String 베터리잔량 = util.getText(By.id("tvBattery"));
	    Assert.assertTrue(베터리잔량.contains("%"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_059")
	public void TC_홈_061(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 설정 버튼 클릭"); 
		util.click(By.id("ivDeviceSetting"));
		
		test.log(Status.INFO, "디바이스 설정 화면 이동 확인"); 
		boolean 디바이스설정화면 = util.isElementPresent(By.id("rvDeviceInfo"));
	    Assert.assertTrue(디바이스설정화면);
	    
	    test.log(Status.INFO, "뒤로가기 버튼 클릭");
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='뒤로가기']")));
	    
	}


}
