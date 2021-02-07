package com.example.emailDemo;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class RootController {	
	
		@Autowired
		private SendSmtpMsg smtpMsg;	
		
		
//		@RequestMapping(value="/send-mail",method=RequestMethod.POST)
		@RequestMapping(value="/send-mail",method=RequestMethod.POST)
		public String sendMail(@RequestBody Details det) throws MessagingException {
			Details details=new Details();	
			try
			{
				if(det!=null)
				{
					if(det.getCc()!=null && det.getSubject()!=null) 
					{
					details.setEmailId(det.getEmailId());
					details.setCc(det.getCc());
					details.setSubject(det.getSubject());
					details.setText(det.getText());
					smtpMsg.send(details.getEmailId(),details.getCc(),
							details.getSubject(),details.getText());
					}
//					smtpMsg.send("sauraval790@gmail.com","sauraval801@gmailgmail.com",
//					"fdasdsd","sahduih");
				}
				
			}
			catch(MessagingException e) {				
				return "Error while sending Mail";				
			}
//			System.out.println(this.details);		
			return "Mail Sent Successfully";
			
		}
}
