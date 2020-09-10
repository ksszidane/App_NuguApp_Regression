package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 연결_06_NUGU_albertAI extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_281")
	public void TC_연결_281(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "+ 디바이스 추가 연결버튼 확인 및 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "albert PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='albert AI']"));
		
		test.log(Status.INFO, "albert PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "디바이스 전원을 켜고\n+/- 버튼을 동시에 3초간 눌러주세요.");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_282")
	public void TC_연결_282(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를\n선택해주세요."));
	    
	    test.log(Status.INFO, "albert PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='albert AI']"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_283")
	public void TC_연결_283(Method method) throws Exception {
		
		test.log(Status.INFO, "albert 연결화면 헬프버튼 문구 확인");
		String help = util.getText(By.id("helpButton"));
		Assert.assertEquals(help, "연결 도움말");
		
		test.log(Status.INFO, "albert 연결화면 헬프버튼 클릭");
		util.click(By.id("helpButton"));
		
		test.log(Status.INFO, "albert 연결화면 헬프 연결 문구 확인");
		String 안내문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(안내문구, "전원을 켠 후 디바이스와 함께 동봉된\n" + 
									"[NUGU 연동하기] 카드를\n" + 
									"인식 센서 위치에 밀어 넣어줍니다");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
		
		test.log(Status.INFO, "닫기 버튼 클릭");
		util.click(By.id("actionClose"));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_284")
	public void TC_연결_284(Method method) throws Exception {
		
		test.log(Status.INFO, "albert 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "albert 위치접근권한 페이지 유지 확인");
		String 위치권한안내문구 = util.getText(By.className("android.widget.TextView"));
		Assert.assertEquals(위치권한안내문구, "디바이스 검색을 위해\n" + "위치접근권한을 요청합니다.");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_285")
	public void TC_연결_285(Method method) throws Exception {
		
		test.log(Status.INFO, "albert 상태확인 화면 이동 위한 이전키 클릭 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "albert PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "디바이스 전원을 켜고\n+/- 버튼을 동시에 3초간 눌러주세요.");
    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_286 ~ 연결 288")
	public void TC_연결_286_form_288(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 GPS Off");
		adb.ADB_GPS_Off(udid);
		
		test.log(Status.INFO, "앱 위치 권한 Off");
		adb.NUGUAPP_permission_LOCATION_Off(udid);
		
		test.log(Status.INFO, "albert 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 거부 ");
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 거부 ");
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 허용");
	    util.switchTo().alert().accept();
	    
		test.log(Status.INFO, "위치 정보 설정 팝업 문구 확인");
	    String 위치정보설정팝업문구 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(위치정보설정팝업문구, "디바이스를 검색할 수 있도록 위치 서비스를 \"사용\"으로 설정하고\n" + 
	    		"NUGU 앱으로 돌아오면 다음 단계 진행이 가능합니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_289")
	public void TC_연결_289(Method method) throws Exception {
		
		test.log(Status.INFO, "위치 정보 설정 팝업 [취소]버튼 클릭");
		util.click(By.id("negativeButton"));
	    
		test.log(Status.INFO, "위치 정보 설정 팝업 닫힘 확인");
		boolean 위치정보설정팝업  = util.isElementPresent(By.id("dialogLayout"));
		Assert.assertFalse(위치정보설정팝업);
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_291")
	public void TC_연결_291(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 GPS Off");
		adb.ADB_GPS_Off(udid);
		
		test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
		
		test.log(Status.INFO, "albert 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "albert 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "위치 정보 설정 팝업 문구 확인");
	    String 위치정보설정팝업문구 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(위치정보설정팝업문구, "디바이스를 검색할 수 있도록 위치 서비스를 \"사용\"으로 설정하고\n" + 
	    		"NUGU 앱으로 돌아오면 다음 단계 진행이 가능합니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_292")
	public void TC_연결_292(Method method) throws Exception {
	    
	    test.log(Status.INFO, "위치 정보 설정 팝업 [취소]버튼 클릭");
		util.click(By.id("negativeButton"));
	    
		test.log(Status.INFO, "위치 정보 설정 팝업 닫힘 확인");
		boolean 위치정보설정팝업  = util.isElementPresent(By.id("dialogLayout"));
		Assert.assertFalse(위치정보설정팝업);
		
		test.log(Status.INFO, "albert 위치접근권한 페이지 유지 확인");
		String 위치권한안내문구 = util.getText(By.className("android.widget.TextView"));
		Assert.assertEquals(위치권한안내문구, "디바이스 검색을 위해\n" + "위치접근권한을 요청합니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_293")
	public void TC_연결_293(Method method) throws Exception {

		test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
		
	    test.log(Status.INFO, "위치 정보 설정 팝업 [설정하러 가기]버튼 클릭");
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO, "디바이스 정보 > 위치정보 사용 확인 페이지 이동 확인");
		Thread.sleep(500);
		String Activity = util.currentActivity();
		Assert.assertTrue(Activity.contains("LocationSettingsActivity"));
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
			
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_294")
	public void TC_연결_294(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 GPS On");
		adb.ADB_GPS_On(udid);
		
		test.log(Status.INFO, "앱 위치 권한 Off");
		adb.NUGUAPP_permission_LOCATION_Off(udid);
	
		boolean NUGU_PoC버튼 = util.isElementPresent(By.xpath("//android.widget.TextView[@text='albert AI']"));
		if(NUGU_PoC버튼 == true) {
			test.log(Status.INFO, "NUGU PoC 버튼 클릭 있으면 클릭");
			util.click(By.xpath("//android.widget.TextView[@text='albert AI']"));
		} else {
			test.log(Status.INFO, "NUGU PoC 버튼 없으면 다음 항목 수행");
		}
		
		test.log(Status.INFO, "albert 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 거부 ");
	    util.switchTo().alert().dismiss();
		
	    test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 노출 확인");
  		boolean 위치정보접근허용버튼 = util.isElementPresent(By.id("locationButton"));
  		Assert.assertTrue(위치정보접근허용버튼);
	} 	
	
	@Test(description = "누구앱 리그레이션 TC : 연결_295")
	public void TC_연결_295(Method method) throws Exception {
	    
		test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 시스텝 팝업 확인 ");
		String 얼럿문구 = util.switchTo().alert().getText();
		Assert.assertTrue(얼럿문구.contains("NUGU에서 내 기기 위치에 액세스하도록 허용하시겠습니까?"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 거부 ");
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "albert 위치접근권한 페이지 유지 확인");
		String 위치권한안내문구 = util.getText(By.className("android.widget.TextView"));
		Assert.assertEquals(위치권한안내문구, "디바이스 검색을 위해\n" + "위치접근권한을 요청합니다.");
			
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_296")
	public void TC_연결_296(Method method) throws Exception {
	
		test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
	
		test.log(Status.INFO, "퍼미션 위치 권한 허용 ");
		util.switchTo().alert().accept();
    
		test.log(Status.INFO, "albert 디바이스 선택 페이지 진입 확인");
		String 디바이스선택페이지문구 = util.getText(By.className("android.widget.TextView"));
		System.out.println(디바이스선택페이지문구);
		Assert.assertTrue(디바이스선택페이지문구.contains("연결할 디바이스를\n선택해주세요."));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_297")
	public void TC_연결_297(Method method) throws Exception {
	    
		test.log(Status.INFO, "디바이스 GPS On");
		adb.ADB_GPS_On(udid);
		
		test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
	    
		test.log(Status.INFO, "NUGU 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "(위치권한 페이지 없이)NUGU 디바이스 선택 페이지 진입 확인");
	    String 디바이스선택페이지문구 = util.getText(By.className("android.widget.TextView"));
	    System.out.println(디바이스선택페이지문구);
	    Assert.assertTrue(디바이스선택페이지문구.contains("연결할 디바이스를\n선택해주세요."));
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_307")
	public void TC_연결_307(Method method) throws Exception {
	    
		test.log(Status.INFO, "albert 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "albert PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "디바이스 전원을 켜고\n" + "녹색 불빛을 확인해주세요.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_308")
	public void TC_연결_308(Method method) throws Exception {
	    
		test.log(Status.INFO, "albert 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "검색중 프로그래스바 확인 ");
		boolean progressBar = util.isElementPresent(By.id("progressBar"));
		Assert.assertTrue(progressBar);
		
		test.log(Status.INFO, "검색중 안내 텍스트 확인 ");
		String 디바이스검색중 = util.getText(By.id("connectibleTextView"));
		Assert.assertEquals(디바이스검색중, "연결 가능한 디바이스");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_309")
	public void TC_연결_309(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 검색 10초 대기");
		Thread.sleep(15000);
		
		test.log(Status.INFO, "검색필드 연결디바이스 안내 상세 텍스트 확인");
		String noDeviceText = util.getText(By.id("emptyDescriptionTextView"));
		Assert.assertEquals(noDeviceText, "디바이스 전원이 켜져 있는지 확인해주세요.\n" + 
				"연결 준비상태에서는 녹색 불빛이 들어옵니다.");
		
		test.log(Status.INFO, "디바이스 재검색 버튼 클릭");
		util.click(By.id("retryButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_310 ~ 311")
	public void TC_연결_310_form_311(Method method) throws Exception {
		
		
		test.log(Status.INFO, "검색중 프로그래스바 확인 ");
		boolean progressBar = util.isElementPresent(By.id("progressBar"));
		Assert.assertTrue(progressBar);
		
		test.log(Status.INFO, "검색중 안내 텍스트 확인 ");
		String 디바이스검색중 = util.getText(By.id("connectibleTextView"));
		Assert.assertEquals(디바이스검색중, "연결 가능한 디바이스");
		
		test.log(Status.INFO, "디바이스 재검색 버튼 없음 확인");
		boolean retryButton = util.isElementPresent(By.id("retryButton"));
		Assert.assertFalse(retryButton);
		
		test.log(Status.INFO, "디바이스 재검색 10초 대기");
		Thread.sleep(10000);

	}
}
