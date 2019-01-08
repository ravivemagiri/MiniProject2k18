package automation;
/*
 * PROJECT :: AN EFFICIENT API FOR SOCIAL NETWORKS USING SELENIUM
 * Team_Size : 4 
 * Team_Details : 1. V. RAVI 2. M.KALYAN KUMAR BABU 3. K.SAI TEJA  4. D.Bujji
 * Project_Start_Date : October 26, 2018
 * Project_End_Date : November 23,2018
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.Wait;

public class Project_Code {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("\t\t****//////************************\\\\\\\\**************");
		System.out.println("\t\t:: WELCOME TO SOCIAL NETWORKS NOTIFICATION STORE :: ");
		System.out.println("\t\t****//////************************\\\\\\\\**************\n\n");
	    System.out.println("SELECT THE SOCIAL SITE YOU WANT \n 1. Gmail\t 2. Facebook \t 3. Twitter \t 4. LinkedIn  \t 5.Telegram \t\n\n");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		ChromeOptions options = new ChromeOptions();//to-disable-notifications
		options.addArguments("--disable-notifications"); 
        String exePath = "**path of your chrome driver here**";//Example: C:\\Users\\Hero\\Downloads\\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		if(i==1) {
			driver.get("http://www.gmail.com");
			if(driver.getCurrentUrl().contains("https://accounts.google.com/signin/v2/identifier?")){
				driver.findElement(By.id("identifierId")).sendKeys("your_mail_here_@gmail.com");
				driver.findElement(By.id("identifierNext")).click();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
				driver.findElement(By.name("password")).sendKeys("your_mail_password_here");
				Thread.sleep(1000);				
				driver.findElement(By.xpath("//div[@id='passwordNext']")).click();	
				Thread.sleep(1000);				
				System.out.println("Successfully logged in to your Google Acccount");
				List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
				List<WebElement> mhead = driver.findElements(By.className("bog"));
	           // System.out.println(a.size());header
	           // System.out.println(mhead.size());subject	           
	            for (int i1 = 0; i1< a.size(); i1++) {	            	
	            	System.out.println("-----------------------");
	                System.out.println("("+(i1+1)+")"+"\t"+"Mail From:"+"."+a.get(i1).getText());
	                System.out.println("\tSUBJECT"+ ":" + mhead.get(i1).getText());
	                System.out.println("----------------------");
	                      
	                /*
	                	if (a.get(i1).getText().equals("some_mail_here")) //to click on a specific mail.
	                	{                                           
	                		a.get(i1).click();
	                	}*/
	            }
	           Thread.sleep(2000);
	           File sshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			  // Save the screenshot in the given path 
		      FileUtils.copyFile(sshot, new File("your_location_here"));//example: C:\\Users\\Hero\\Downloads\\selenium\\screenshot\\Mail_unread.png
		      Thread.sleep(5000);
			  String total=driver.findElement(By.xpath("//div[@class='bsU']")).getText();
			  int unread = Integer.parseInt(total);
			  if(unread == 0) {
					System.out.println("No new Notifications yet!");
				}
				else
				{
					System.out.println("You should visit your account now");
					System.out.println("You have \t"+ total + "\tNumber of unread mails");
				}
				
		        // Take Screenshot for Evidence
		        FileUtils.copyFile(sshot, new File("C:\\Users\\Hero\\Downloads\\selenium\\screenshot\\Mail_Interface.png"));
		        Thread.sleep(2000);	 
		        System.out.println("Do you want to view mails now?\t 1. yes. 2. No\n");
		        int mail_choice = sc.nextInt();
		        if(mail_choice==1) {
		        	System.out.println("It's your time now. you can view mails.");
		        }
		        else
		        {
		        	 //sign out
			        driver.findElement(By.xpath("//span[@class='gb_ab gbii']")).click();     
		            driver.findElement(By.linkText("Sign out")).click();
		            
		            System.out.println("Successfully logged out !!");
		        }
		 		
			}
			else{
				System.out.println("Error Occured.! Please try again.");
			}//end-of-else statement
		 		
		}//end-of-option 1;
		else if(i==2) {
			driver.get("http://www.facebook.com");
			driver.findElement(By.id("email")).sendKeys("your facebook username or email");
			driver.findElement(By.id("pass")).sendKeys("Your facebook password");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			WebElement TextArea = driver.findElement(By.name("xhpc_message"));
	        Thread.sleep(2000);
	        TextArea.click();
	        TextArea.sendKeys("some_message_here");
	        //Wait0
	        Thread.sleep(2000);
	        //Click On Post Button
	       WebElement PostBtn = driver.findElement(By.cssSelector("button[data-testid='react-composer-post-button']"));
	        PostBtn.click();
	        //Wait
	        Thread.sleep(4000);
	        // Take Screenshot for Evidence
	        File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        // Save the screenshot in the given path by the name FbStatus.png
	        FileUtils.copyFile(srce, new File("C:\\Users\\Hero\\Downloads\\selenium\\screenshot\\MyStatus_today.png"));
	        Thread.sleep(3000);	        
	        driver.findElement(By.xpath("//a[@title='Profile']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();	        
	        Thread.sleep(2000);
	        String fcount=driver.findElement(By.xpath("//span[@class='_gs6']")).getText();
	        int fcount1= Integer.parseInt(fcount);
	        System.out.println("::Congratulations::! You have "+fcount1+"\tFriends");
	        Thread.sleep(2000);
	        String count = driver.findElement(By.xpath("//span[@class='_3d0']")).getText();
	        int count1= Integer.parseInt(count);
	        Thread.sleep(2000);
	        System.out.println("You are following\t"+ count + "\tpeople");
	        Thread.sleep(2000);
	        List<WebElement> following =driver.findElements(By.xpath("//div[@data-testid='friend_list_item']"));
	       // System.out.println(following.size());
           
            for (int i1 = 0; i1 < following.size(); i1++) {
            	System.out.println("************************");
                System.out.println((i1+1)+"."+following.get(i1).getText());
                System.out.println("*************************");
                
                }
            Thread.sleep(3000);
            
           
            /*
           String online = driver.findElement(By.xpath("//span[@class='count']")).getText();
           System.out.println("Number of friends online:\t"+online);
           */
            
            System.out.println();
            Thread.sleep(2000);
	      
           // driver.findElement(By.xpath("//span[@class='count']")).click();
           List<WebElement> b =driver.findElements(By.xpath("//div[@data-testid='chat_sidebar']//div[4]//ul[1]//li[1]"));
	       String[] ousers = new String[b.size()];
	       // System.out.println(b.size());
           
            for (int i1 = 0; i1 < b.size(); i1++) {
            	System.out.println("************************");
                System.out.println((i1+1)+"."+b.get(i1).getText());
                ousers[i1]=b.get(i1).getText();
                System.out.println("*************************");
                
                }
            // click on online users
            int onlineusers=0;
            for (int i1 = 0; i1 < b.size(); i1++) {
            	if (b.get(i1).getText().equals(ousers[i1])) 
                {   onlineusers++;                                  
            		b.get(i1).click();              
            		//driver.findElement(By.xpath("//div[@class='_552h']")).click();
            		//driver.findElement(By.xpath("//div[@class='_552h']")).sendKeys("hello world");
                }
            	else
            	{
            		System.out.println("Error occured");
            	}
                
                }
                
         System.out.println(onlineusers);
            
         
	        WebElement AccSettings = driver.findElement(By.id("userNavigationLabel"));
	        AccSettings.click();	        
	       
	        //Click on Log out button
	        WebDriverWait wait = new WebDriverWait(driver, 8);
	        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
	        logout.click();
	        
	        //Wait
	        Thread.sleep(2000);
			
		}
		else if(i==3) {// Working on twitter
			
			driver.get("https://twitter.com/login");
			
			driver.findElement(By.xpath("//input[@placeholder='Phone, email or username']")).sendKeys("your mail or username");
			driver.findElement(By.xpath("//div[@class='clearfix field']//input[@placeholder='Password']")).sendKeys("your password here");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='tweet-box-home-timeline']")).sendKeys("Project Submission...");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='home-tweet-box tweet-box component tweet-user']//div[@class='TweetBoxToolbar-tweetButton tweet-button']//button[@type='button']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='ProfileCardStats-statLabel u-block'][contains(text(),'Following')]")).click() ;
			Thread.sleep(2000);
			 List<WebElement> b =driver.findElements(By.className("ProfileNav-value"));
		       String[] information = new String[b.size()];
		        //System.out.prkintln(b.size());
	           
	            for (int i1 = 0; i1 < b.size()-1; i1++) {
	            	System.out.println("---------------------------------");
	                //System.out.println((i1+1)+"."+b.get(i1).getText());
	                information[i1]=b.get(i1).getText();
	                if(i1==0) {
	                	System.out.println("You have\t" + information[i1] + "\ttweets");
	                }
	                else if(i1==1) {
	                	
	                	System.out.println("You follow : \t" + information[i1] + "\tmembers");
	                }
	                else if(i1==2) {
	                	System.out.println("You have\t" + information[i1] + "\tLists");
	                	
	                }
	                else if(i1==3) {
	
	                	System.out.println("You have\t" + information[i1] + "\tMoments");
	                }
	                System.out.println("-----------------------------------");
	                }
	           System.out.println(":: LIST OF PEOPLE YOU FOLLOW ::");
	           for(int scroll=0; scroll<=7; scroll++) {
	        	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        	   Thread.sleep(1000);
	           }
	           js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	           Thread.sleep(4);
	            List<WebElement> pc =driver.findElements(By.className(" ProfileCard-content"));
			      System.out.println("profile card content"+pc.size());
		            for (int i1 = 0; i1 < pc.size(); i1++) {
		            	System.out.println("************************");
		                System.out.println((i1+1)+"."+pc.get(i1).getText());
		             
		                System.out.println("-----------------------------------");
		                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		                }
	           
	            
	             Thread.sleep(2000);
	             String tuname = driver.findElement(By.xpath("//b[contains(@class,'fullname')]")).getText();
	           
	            driver.findElement(By.xpath(" //li[@id='user-dropdown']")).click();
	            driver.findElement(By.id("signout-button")).click();
	            System.out.println("Successfully logged out !!");
	         
	          		
			
			
		}
		else if(i==4) {
			driver.get("https://in.linkedin.com/");
			
			driver.findElement(By.id("login-email")).sendKeys("Your username");
			Thread.sleep(1000);
			driver.findElement(By.id("login-password")).sendKeys("Your password");
			driver.findElement(By.id("login-submit")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("nav-settings__dropdown-trigger")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.linkText("Sign out")).click();
		    
			System.out.println("Successfully logged out ");
		}
		else if(i==5) { //telegram
			
			driver.get("https://web.telegram.org/#/login");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			Thread.sleep(8000);
			driver.findElement(By.name("phone_number")).sendKeys("9985883426");
			
			driver.findElement(By.className("login_head_submit_btn")).click();
			driver.findElement(By.className("btn-md-primary")).click();
			
	        Thread.sleep(8000);
	        driver.findElement(By.className("login_head_submit_btn")).click();
	        
			List<WebElement> clist =driver.findElements(By.className("im_dialog_user"));
		    System.out.println("Friends count"+clist.size());
	            for (int i1 = 0; i1 < clist.size(); i1++) {
	            	System.out.println("************************");
	                System.out.println((i1+1)+"."+clist.get(i1).getText());
	             
	                System.out.println("-----------------------------------");
	                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	                }
          
			
		}
		else {
			System.out.println("Ouch! you gave a wrong input");
			
		} 	
		
		
		
		
		
		
		
		
		System.out.println("Job done! Thank You!");
		//driver.close();
	       
	    } //end-of-main
   	}//end-of-class



