package com.neopane.mocking.dummy;

public class FakeEmailService implements EmailService {

	@Override
	public void sendEmail(String msg) {
		 System.out.println("Sending Email");

	}

}
