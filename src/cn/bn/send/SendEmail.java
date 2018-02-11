package cn.bn.send;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.bn.pojo.User;

public class SendEmail extends Thread{
	
	private String from="zhaochaofei0804@163.com";//用于给用户发送邮件的邮箱 
	private String name="chaofei";//邮箱的用户名
	private String word="1992114ly";//邮箱的授权码
	private String host="smtp.163.com";//发送邮件的服务器地址
	private User user;
	
	public SendEmail() {
		super();
	}
	public SendEmail(User user) {
		super();
		this.user = user;
	}
	
	/* 重写run方法的实现，在run方法中发送邮件给指定的用户
	 * @see java.lang.Thread#run()
	 */
	
	public void run(){
		try {
			Properties prop=new Properties();
			prop.setProperty("mail.host", host);
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.auth", "true");
			
			Session session=Session.getInstance(prop);
			session.setDebug(true);
			Transport ts=session.getTransport();
			ts.connect(host, name, word);
			
			Message message=createEmail(session,user);
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * 创建要发送的邮件
	 */
	public Message createEmail(Session session,User user) throws Exception{
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		message.setSubject("用户注册邮件");
		String info="恭喜您注册成功，您的用户名：" + user.getUsername() + ",您的密码：" + user.getPassword() + "，请妥善保管，如有问题请联系网站客服!!";
		message.setContent(info,"text/html;charset=UTF-8");
		message.saveChanges();
		return message;
		
	}
}
