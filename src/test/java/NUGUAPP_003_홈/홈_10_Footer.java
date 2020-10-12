package NUGUAPP_003_홈;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import unit.TestCase;

public class 홈_10_Footer extends TestCase {
	
	@Test(description = "누구앱 리그레이션 TC : 홈_132")
	public void TC_홈_132(Method method) throws Exception {
		
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
	    
	    test.log(Status.INFO, "홈카드 스크롤 다운"); 
	    util.scrollDown(5);
	    
	    test.log(Status.INFO, "하단 고객센터 정보 확인"); 
	    String 고객센터바로가기 = util.getText(By.id("customerCenterTextView"));
	    Assert.assertEquals(고객센터바로가기, "고객센터 바로가기");
	    
	    test.log(Status.INFO, "하단 고객센터 전화번호 운영시간 정보 확인"); 
	    String 고객센터운영시간 = util.getText(By.id("customerCenterTimeTextView"));
	    Assert.assertEquals(고객센터운영시간, "1670-0110 09:00~18:00(주말 및 공휴일 제외)");
	    
	    test.log(Status.INFO, "고객센터 바로가기 클릭"); 
	    util.click(By.id("customerCenterTextView"));
	    
	    test.log(Status.INFO, "고객센터 화면 이동 확인"); 
		boolean 고객센터화면 = util.isElementPresent(By.id("rvMain"));
	    Assert.assertTrue(고객센터화면);
	    
 
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_133")
	public void TC_홈_133(Method method) throws Exception {
		
		Thread.sleep(1500);
	    test.log(Status.INFO, "고객센터 전화번호 확인"); 
	    String 센터전화번호 = util.getText(By.id("btnCenterNumber"));
	    Assert.assertEquals(센터전화번호, "1670-0110");
	    
	    test.log(Status.INFO, "누구 고객센터 텍스트"); 
	    String 고객센터텍스트 = util.getText(By.id("tvCenterName"));
	    Assert.assertEquals(고객센터텍스트, "NUGU 고객센터");
	    
	    test.log(Status.INFO, "누구 고객센터 텍스트"); 
	    String 운영시간 = util.getText(By.id("tvCenterTime"));
	    Assert.assertEquals(운영시간, "09:00 ~ 18:00, 주말 및 공휴일 제외");
	    
	    test.log(Status.INFO, "화면 뒤로가기");
	    util.Android_BackKey();
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_134")
	public void TC_홈_134(Method method) throws Exception {
		
		test.log(Status.INFO, "홈카드 스크롤 다운"); 
	    util.scrollDown(3);
		
		test.log(Status.INFO, "사업자 확인"); 
	    String 사업자 = util.getText(By.id("expandButton"));
	    Assert.assertEquals(사업자, "SK telecom");
	    
	}
	
	@Test(description = "누구앱 리그레이션 TC : 홈_135")
	public void TC_홈_135(Method method) throws Exception {
		
		test.log(Status.INFO, "사업자 확인 펼침"); 
		util.click(By.id("expandButton"));
		
		test.log(Status.INFO, "홈카드 스크롤 다운"); 
	    util.scrollDown(1);
		
		test.log(Status.INFO, "사업자 확인 펼침 내용 확인"); 
	    String 사업자상세 = util.getText(By.id("contentTextView"));
	    Assert.assertEquals(사업자상세, "SK텔레콤(주)은 통신판매중개자로서 거래 당사자가 아니며, "
	    		+ "입점 판매자가 등록한 상품 정보 및 거래에 대해 SK텔레콤(주)은 일체 책임을 지지 않습니다.\n" + 
	    		"\n" + 
	    		"대표이사/사장 박정호 사업자등록번호 104-81-37225 판매허가번호 중구 02923호 주소 서울특별시 중구 을지로");
	    
	}
	

}
