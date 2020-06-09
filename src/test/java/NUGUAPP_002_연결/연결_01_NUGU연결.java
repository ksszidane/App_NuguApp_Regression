package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 연결_01_NUGU연결 extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_001~002")
	public void TC_001_from_002_연결(Method method) throws Exception {

		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "다른아이디 로그인 버튼 유효성 체크 및 클릭");
        util.click(By.className("btn-secondary-text"));
        
        test.log(Status.INFO, "자동로그인체크박스 유효성 체크 및 체크박스 해제");
        util.click(By.className("c-ick"));
        
        test.log(Status.INFO, "디바이스 연결없는 계정 로그인");
        
        test.log(Status.INFO, "아이디입력필드 유효성 체크 및  '유효' 이메일 아이디입력");
        util.type(By.id("userId"), "ksszidane10@naver.com");

	    test.log(Status.INFO, "패스워드입력필드 유효성 체크 및  '정상' 암호입력");
        util.type(By.id("password"), "tjdtn10!!");
        
        test.log(Status.INFO, "로그인버튼 유효성체크 및 버튼 클릭");
		util.click(By.id("authLogin"));
		
		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
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
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를"));
	
	    test.log(Status.INFO, "건너뛰기로 홈 화면 복귀");
	    util.click(By.id("skipButton"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_003")
	public void TC_003_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "앱 재 실행");
		util.resetApp();
		
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
	    
	    test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "+ 디바이스 추가 연결버튼 확인 및 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를"));
	    
	    test.log(Status.INFO, "건너뛰기로 홈 화면 복귀");
	    util.click(By.id("skipButton"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_004")
	public void TC_004_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
	    
	    test.log(Status.INFO, "설정 버튼 클릭"); 
	    util.click(By.id("settingsButton"));
	    
	    test.log(Status.INFO, "디바이스 설정 메뉴 버튼 클릭"); 
	    util.click((By.xpath("//android.widget.TextView[@text='디바이스 설정']")));
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "디바이스 설정 메뉴 버튼 클릭"); 
	    util.click(By.id("layerSettingDeviceListAddNew"));
	    
	    test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를"));
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_009")
	public void TC_009_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU PoC 버튼 유무 확인");
		boolean NU100버튼 = util.isElementPresent(By.xpath("(//android.widget.TextView[@text='NUGU'])"));
		Assert.assertTrue(NU100버튼);
		
		test.log(Status.INFO, "NUGU PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "디바이스 전원을 켜고\n" + "녹색 불빛을 확인해주세요.");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_010")
	public void TC_010_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.className("android.widget.TextView"));
	    System.out.println(연결하기페이지문구);
	    Assert.assertTrue(연결하기페이지문구.contains("연결할 NUGU 디바이스를"));
	
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_011")
	public void TC_011_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='NUGU']"));
		
		test.log(Status.INFO, "NUGU 연결화면 헬프버튼 문구 확인");
		String help = util.getText(By.id("helpButton"));
		Assert.assertEquals(help, "불빛이 들어오지 않나요?");
		
		test.log(Status.INFO, "NUGU 연결화면 헬프버튼 클릭");
		util.click(By.id("helpButton"));
		
		test.log(Status.INFO, "NUGU 연결화면 헬프 연결 문구 확인");
		String 안내문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(안내문구, "음소거버튼￼을 길게 눌러\n" + "연결 준비 상태로 변경해주세요.");
		
		test.log(Status.INFO, "디바이스 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);
		
		test.log(Status.INFO, "닫기 버튼 클릭");
		util.click(By.id("actionClose"));

	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_012")
	public void TC_012_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().dismiss();
	    
	    test.log(Status.INFO, "NUGU 위치접근권한 페이지 유지 확인");
		String 위치권한안내문구 = util.getText(By.className("android.widget.TextView"));
		Assert.assertEquals(위치권한안내문구, "디바이스 검색을 위해\n" + "위치접근권한을 요청합니다.");
		
		test.log(Status.INFO, "[위치 정보 접근 허용 >] 버튼 클릭");
		util.click(By.id("locationButton"));
		
		test.log(Status.INFO, "퍼미션 위치 권한 확인 ");
		String 얼럿문구 = util.switchTo().alert().getText();
		Assert.assertTrue(얼럿문구.contains("NUGU에서 내 기기 위치에 액세스하도록 허용하시겠습니까?"));
	    util.switchTo().alert().accept();
		
	    test.log(Status.INFO, "디바이스 선택 화면 확인");
	    String AP연결화면 = util.getText(By.id("descriptionTextView"));
	    Assert.assertEquals(AP연결화면, "연결할 디바이스를\n" + "선택해주세요.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_013")
	public void TC_013_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 상태확인 화면 이동 위한 이전키 클릭 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "디바이스 전원을 켜고\n" + "녹색 불빛을 확인해주세요.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_014 ~ 연결_016")
	public void TC_014_form_016_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 GPS Off");
		adb.ADB_GPS_Off(udid);
		
		test.log(Status.INFO, "앱 위치 권한 Off");
		adb.NUGUAPP_permission_LOCATION_Off(udid);
		
		test.log(Status.INFO, "NUGU 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
	    
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
	
	@Test(description = "누구앱 리그레이션 TC : 연결_017")
	public void TC_017_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "위치 정보 설정 팝업 [취소]버튼 클릭");
		util.click(By.id("negativeButton"));
	    
		test.log(Status.INFO, "위치 정보 설정 팝업 닫힘 확인");
		boolean 위치정보설정팝업  = util.isElementPresent(By.id("dialogLayout"));
		Assert.assertFalse(위치정보설정팝업);
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_019")
	public void TC_019_연결(Method method) throws Exception {
		
		test.log(Status.INFO, "디바이스 GPS Off");
		adb.ADB_GPS_Off(udid);
		
		test.log(Status.INFO, "앱 위치 권한 On");
		adb.NUGUAPP_permission_LOCATION_On(udid);
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU 연결 [다음]버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "위치 정보 설정 팝업 문구 확인");
	    String 위치정보설정팝업문구 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(위치정보설정팝업문구, "디바이스를 검색할 수 있도록 위치 서비스를 \"사용\"으로 설정하고\n" + 
	    		"NUGU 앱으로 돌아오면 다음 단계 진행이 가능합니다.");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_020")
	public void TC_020_연결(Method method) throws Exception {
	    
	    test.log(Status.INFO, "위치 정보 설정 팝업 [취소]버튼 클릭");
		util.click(By.id("negativeButton"));
	    
		test.log(Status.INFO, "위치 정보 설정 팝업 닫힘 확인");
		boolean 위치정보설정팝업  = util.isElementPresent(By.id("dialogLayout"));
		Assert.assertFalse(위치정보설정팝업);
		
		 test.log(Status.INFO, "NUGU 위치접근권한 페이지 유지 확인");
			String 위치권한안내문구 = util.getText(By.className("android.widget.TextView"));
			Assert.assertEquals(위치권한안내문구, "디바이스 검색을 위해\n" + "위치접근권한을 요청합니다.");
			
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_021")
	public void TC_021_연결(Method method) throws Exception {
	    
	    test.log(Status.INFO, "위치 정보 설정 팝업 [설정하러 가기]버튼 클릭");
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO, "디바이스 정보 > 위치정보 사용 확인 페이지 이동 확인");
		String Activity = util.currentActivity();
		System.out.println(Activity);

	}

}
