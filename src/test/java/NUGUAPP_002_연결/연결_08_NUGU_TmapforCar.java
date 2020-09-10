package NUGUAPP_002_연결;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.nativekey.AndroidKey;
import junit.framework.Assert;
import unit.TestCase;

public class 연결_08_NUGU_TmapforCar extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 연결_338")
	public void TC_연결_338(Method method) throws Exception {
		
		test.log(Status.INFO, "인트로 화면에서 로그인 이동");
        util.click(By.id("loginButton"));
        
        test.log(Status.INFO, "WEBVIEW로 화면 전환");
        util.switchContext("WEBVIEW");
        
        test.log(Status.INFO, "저장된 간편로그인 유효성 체크 및 클릭");
        util.click(By.className("account-item"));

		test.log(Status.INFO, "정상로그인 확인"); 
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "퍼미션 위치 권한 취소 "); 
	    util.switchTo().alert().accept();
	    
	    test.log(Status.INFO, "공지 안내 팝업 유무 확인");
	    util.notice_popup_check();
	    
	    test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "+ 디바이스 추가 연결버튼 확인 및 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "스크롤 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "TMap for Car PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='T map for Car']"));
		
		test.log(Status.INFO, "TMap for Car PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("tvDescription"));
		Assert.assertEquals(연결문구, "NUGU 서비스 연결을 위해\nT map for Car 인증을 해주세요.");
		

	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_339")
	public void TC_연결_339(Method method) throws Exception {
		
		test.log(Status.INFO, "TMap for Car PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("tvDescriptionSub"));
		Assert.assertEquals(연결문구, "운전 중 음성명령으로 NUGU의 기능을 이용할 수 있도록 NUGU 서비스 이용 기간 동안 해당 서비스 식별 정보를 수집/이용합니다.");
		
		test.log(Status.INFO, "T map for Car 지원 차량 타이틀");
		String 지원타이틀 = util.getText(By.id("tvListTitle"));
		Assert.assertEquals(지원타이틀, "T map for Car 지원 차량");
		
		test.log(Status.INFO, "지원 차량 목록 재규어");
		String 재규어 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
											+"android.widget.LinearLayout[1]/android.widget.TextView[1]"));;
		Assert.assertEquals(재규어, "재규어 랜드로버");
		
		test.log(Status.INFO, "지원 차량 목록 재규어 네비박스");
		String 르노 = util.getText(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
											+"android.widget.LinearLayout[2]/android.widget.TextView[1]"));;
		Assert.assertEquals(르노, "르노삼성자동차");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_340")
	public void TC_연결_340(Method method) throws Exception {
		
		test.log(Status.INFO, "NUGU 연결하기  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "NUGU inside 연결하기 페이지 진입 확인");
	    String 연결하기페이지문구 = util.getText(By.xpath("//android.widget.TextView[@text='NUGU inside']"));
	    Assert.assertTrue(연결하기페이지문구.contains("NUGU inside"));
	    
	    test.log(Status.INFO, "스크롤 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "TMap for Car PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='T map for Car']"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_341")
	public void TC_연결_341(Method method) throws Exception {
		
		test.log(Status.INFO, "지원 차량 목록 재규어 버튼 > 클릭");
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
											+"android.widget.LinearLayout[1]/android.widget.TextView[2]"));;
		
		test.log(Status.INFO, "TMap for Car 재규어 PoC 연결 문구 확인");
		String 재규어연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(재규어연결문구, "NUGU 서비스 연결을 위해\nJLR T map 인증을 해주세요.");
		
		test.log(Status.INFO, "지원 차량 목록  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
		test.log(Status.INFO, "지원 차량 목록 르노 버튼 > 클릭");
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
				+"android.widget.LinearLayout[2]/android.widget.TextView[2]"));;
				
		test.log(Status.INFO, "TMap for Car 르노 PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "Smart Navi. T map 에서\n[인공지능 NUGU 설정 > 일회용 인증 번호]를 선택하세요.");
		
		test.log(Status.INFO, "지원 차량 목록  화면 이동 위한 Back 키");
		util.Android_BackKey();
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_342")
	public void TC_연결_342(Method method) throws Exception {
		
		test.log(Status.INFO, "지원 차량 목록 재규어 버튼 > 클릭");
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
											+"android.widget.LinearLayout[1]/android.widget.TextView[2]"));;
		
		test.log(Status.INFO, "TMap for Car 재규어 PoC 연결 문구 확인");
		String 재규어연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(재규어연결문구, "NUGU 서비스 연결을 위해\nJLR T map 인증을 해주세요.");
		
		test.log(Status.INFO, "TMap for Car 재규어 PoC 가이드 연결 문구 확인");
		String 재규어연결가이드문구 = util.getText(By.id("guideTextView"));
		Assert.assertEquals(재규어연결가이드문구, "운전 중 음성명령으로 NUGU의 기능을 이용할 수 있도록 NUGU 서비스 이용 기간 동안 JLR T map 서비스 식별 정보를 수집/이용합니다.");
		
		test.log(Status.INFO, "TMap for Car 재규어 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);

		test.log(Status.INFO, "TMap for Car 재규어 PoC 연결 버튼 확인");
		String 재규어연결버튼 = util.getText(By.id("nextButton"));
		Assert.assertEquals(재규어연결버튼, "JLR T map 앱에서 인증하기");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_343")
	public void TC_연결_343_and_362_form_371(Method method) throws Exception {

		test.log(Status.INFO, "TMap for Car 재규어 PoC 연결 버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "TMap for Car 재규어실행 후 연결 로딩 확인");
		util.ProgressBar_Loading();
		
		test.log(Status.INFO, "TMap for Car 재규어 PoC 연결 완료 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "연결이 완료되었습니다.\n이제 JLR T map 에서 NUGU와 대화해보세요.");
			
		test.log(Status.INFO, "TMap PoC 가이드 문구 확인");
		String 가이드문구 = util.getText(By.id("guideTextView"));
		Assert.assertEquals(가이드문구, "“아리아, 길안내해줘”");
		
		test.log(Status.INFO, "NUGU 서비스 시작하기 버튼 클릭");
		util.click(By.id("startButton"));
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		
		test.log(Status.INFO, "메뉴 > 설정 > 사용자설정 > 뮤직기본서비스 이동");
		test.log(Status.INFO, "메뉴 버튼클릭");
		util.click((By.xpath("//android.widget.ImageButton[@content-desc='메뉴']")));
		
		test.log(Status.INFO, "설정 버튼클릭");
		util.click(By.id("settingsButton"));
		
		test.log(Status.INFO, "사용자설정 버튼클릭");
		util.click((By.xpath("//android.widget.TextView[@text='사용자 설정']")));
	    
	    test.log(Status.INFO, "사용자 설정 연결 로딩 확인");
	    util.ProgressBar_Loading();
		
		test.log(Status.INFO, "뮤직기본서비스 버튼클릭");
		util.click((By.xpath("//android.widget.TextView[@text='뮤직 기본 서비스']")));
		
		test.log(Status.INFO, "TMap for Car 재규어 PoC 버튼클릭");
		util.click((By.xpath("//android.widget.TextView[@text='JLR T map (Android)']")));
		
		test.log(Status.INFO, "뮤직기본서비스 멜론클릭");
		util.click((By.xpath("//android.widget.TextView[@text='멜론']")));
		
		test.log(Status.INFO, "홈 화면 이동 위한 뒤로가기 키");
		util.Android_BackKey();
		test.log(Status.INFO, "사용자 설정 연결 로딩 확인");
		util.ProgressBar_Loading();
		util.Android_BackKey();
		util.Android_BackKey();
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();
		
		util.click(By.id("ivHeaderClose"));
		
		test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "연결된 PoC TMap 확인");
		String 연결된PoC = util.getText(By.id("btnDeviceSelect"));
		Assert.assertEquals(연결된PoC, "JLR T map");
		
		test.log(Status.INFO, "(이전설정으로 복귀)디바이스 설정 버튼 클릭"); 
	    util.click(By.id("ivDeviceSetting"));
	    
	    test.log(Status.INFO, "(이전설정으로 복귀) 별명수정하기 버튼 클릭"); 
	    util.click(By.id("btnNameChangeComplete"));
	    
	    test.log(Status.INFO, "(이전설정으로 복귀) 수정할 별명 입력 후 완료 버튼 클릭"); 
	    util.type(By.id("etNameDeviceName"), "재규어티맵");
	    util.click(By.id("btnNameChangeComplete"));
	  
	    test.log(Status.INFO, "(이전설정으로 복귀)연결해제 버튼 클릭"); 
	    util.click(By.id("btnDisconnect"));
	    
	    test.log(Status.INFO, "(이전설정으로 복귀)연결해제 완료 클릭"); 
	    util.click(By.id("positiveButton"));
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_344")
	public void TC_연결_344(Method method) throws Exception {
		
		test.log(Status.INFO, "연결을 기다리는 디바이스 유무 확인"); 
	    util.connectingDevice();

		test.log(Status.INFO, "디바이스 연결 플로팅메뉴 확인 및 클릭"); 
	    util.click(By.id("ibDeviceFab"));
	    
	    test.log(Status.INFO, "+ 디바이스 추가 연결버튼 확인 및 클릭"); 
	    util.click(By.id("ivHeaderAddDevice"));
	    
	    test.log(Status.INFO, "스크롤 이동");
	    util.scrollDown(1);
	    
	    test.log(Status.INFO, "TMap for Car PoC 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[@text='T map for Car']"));
		
		test.log(Status.INFO, "지원 차량 목록 르노 버튼 > 클릭");
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
				+"android.widget.LinearLayout[2]/android.widget.TextView[2]"));;
				
		test.log(Status.INFO, "TMap for Car 르노 PoC 연결 문구 확인");
		String 연결문구 = util.getText(By.id("descriptionTextView"));
		Assert.assertEquals(연결문구, "Smart Navi. T map 에서\n[인공지능 NUGU 설정 > 일회용 인증 번호]를 선택하세요.");
		
		test.log(Status.INFO, "TMap for Car 르노 ImageView 확인");
		boolean ImageView = util.isElementPresent(By.id("deviceImageView"));
		Assert.assertTrue(ImageView);

		test.log(Status.INFO, "TMap for Car 르노 PoC 연결 버튼 확인");
		String 재규어연결버튼 = util.getText(By.id("nextButton"));
		Assert.assertEquals(재규어연결버튼, "다음");
		
	}
	
	@Test(description = "누구앱 리그레이션 TC : 연결_346 ~ 연결_349")
	public void TC_연결_346_form_349(Method method) throws Exception {

		test.log(Status.INFO, "TMap for Car 르노 PoC 연결 버튼 클릭");
		util.click(By.id("nextButton"));
		
		test.log(Status.INFO, "인증번호 입력 필드 클릭");
		util.click(By.id("etTmapForCarOtp"));
		
		test.log(Status.INFO, "인증번호 6자리 입력");
		util.AndroidKey_Num1();util.AndroidKey_Num2();util.AndroidKey_Num3();
		util.AndroidKey_Num4();util.AndroidKey_Num5();util.AndroidKey_Num6();
		
		test.log(Status.INFO, "인증번호 7번째 자리수 입력");
		util.AndroidKey_Num7();
		
		test.log(Status.INFO, "처음 6자리만 입력되고 7번째 자리수 입력안됨 확인");
		String 인증번호입력 = util.getText(By.id("etTmapForCarOtp"));
		Assert.assertEquals(인증번호입력, "123456");
		
		test.log(Status.INFO, "기타 영역 클릭하여 입력 키패드 숨김");
		util.touchTab(400, 520);
		
		test.log(Status.INFO, "하단 연결버튼비활성화 확인");
		boolean 버튼활성화 = util.isEnabled(By.id("btnTmapForCarConnect"));
		Assert.assertTrue(버튼활성화);
		
		test.log(Status.INFO, "인증번호 입력 필드 클릭");
		util.click(By.id("btnTmapForCarConnect"));
		
		test.log(Status.INFO, "인증번호 실패 팝업 메시지");
		String 팝업메세지 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(팝업메세지, "인증번호 확인 후 다시 시도해 주세요.");
		
		test.log(Status.INFO, "인증번호 실패 팝업 확인");
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO, "입력된 숫자 제거 확인");
		String 인증번호입력제거 = util.getText(By.id("etTmapForCarOtp"));
		Assert.assertEquals(인증번호입력제거, "******");
		
	}
	
	
	
}
