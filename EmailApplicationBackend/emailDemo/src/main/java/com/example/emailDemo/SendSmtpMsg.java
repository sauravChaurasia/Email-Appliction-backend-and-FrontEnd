package com.example.emailDemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendSmtpMsg {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String to,String cc,String subject,String body) 
			throws MessagingException{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		ArrayList<String> toAddressArray = null;
		ArrayList<String> ccAddressArray = null;
		
//		Splitting To Address
	
//		}
//		
//		Spliting CC Address
//		if(cc.contains(";")) {
//		String[] multiCcAddress=cc.split(";");
//		List<String> listOfCcAddress=Arrays.asList(multiCcAddress);
//		ccAddressArray=new ArrayList<String>(listOfCcAddress);
//
//		}
//		
		if(to.contains(";")) {
			String[] multiToAddress=to.split(";");
			List<String> listOfToAddress=Arrays.asList(multiToAddress);
			toAddressArray=new ArrayList<String>(listOfToAddress);	
//			Multiple ToAddress and Multiple CCaddress
			if(cc.contains(";")) {
				String[] multiCcAddress=cc.split(";");
				List<String> listOfCcAddress=Arrays.asList(multiCcAddress);
				ccAddressArray=new ArrayList<String>(listOfCcAddress);
				
						for(String toAdr:toAddressArray)
						{
						helper=new MimeMessageHelper(message,true);
			
							for(String ccAdr:ccAddressArray)
							{
								helper.setCc(ccAdr);
								helper.setSubject(subject);
								helper.setTo(toAdr);
								
								helper.setText(body,true);
								
								javaMailSender.send(message);
							}

//						helper.setCc(cc);
						
						}
			
						
				}

//			Multiple To Address and single CCAddress
			else {
				String[] multiCcAddress=cc.split(";");
				List<String> listOfCcAddress=Arrays.asList(multiCcAddress);
				ccAddressArray=new ArrayList<String>(listOfCcAddress);
				
						for(String toAdr:toAddressArray)
						{
						helper=new MimeMessageHelper(message,true);
			
						helper.setCc(cc);
						helper.setSubject(subject);
						helper.setTo(toAdr);
						
						helper.setText(body,true);
						
						javaMailSender.send(message);
						}
			}
			}
//		Single ToAddress and Multiple CCAddress
		else if(to.contains(";")==false && cc.contains(";")==true) 
		{
			String[] multiCcAddress=cc.split(";");
			List<String> listOfCcAddress=Arrays.asList(multiCcAddress);
			ccAddressArray=new ArrayList<String>(listOfCcAddress);
			
					
					
		
						for(String ccAdr:ccAddressArray)
						{ helper=new MimeMessageHelper(message,true);
							helper.setCc(ccAdr);
							helper.setSubject(subject);
							helper.setTo(to);
							
							helper.setText(body,true);
							
							javaMailSender.send(message);
						}

					
					}
		
		
//		Single ToAddress and CCAddress

	else{
			helper=new MimeMessageHelper(message,true);		
	
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);
			
			javaMailSender.send(message);
			
		}
		
	}
}
