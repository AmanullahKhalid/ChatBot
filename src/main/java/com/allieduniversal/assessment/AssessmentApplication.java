package com.allieduniversal.assessment;

import com.allieduniversal.assessment.entity.Message;
import com.allieduniversal.assessment.service.ChatBotService;
import com.allieduniversal.assessment.service.impl.ChatBotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.Set;

import static com.allieduniversal.assessment.service.impl.ChatBotServiceImpl.INVALID_MSG;

@SpringBootApplication
public class AssessmentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@Autowired
	ChatBotService chatBotService;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int odr = 0;
		boolean cnt = true;
		Message prev = chatBotService.getMsg(odr, null);
		System.out.println(prev.getBody() + " - ");
		while (cnt) {
			String choice = sc.nextLine();
			Message msg = chatBotService.getMsg(++odr, choice);
			System.out.println(msg.getBody());
			if (msg.getBody().equals(INVALID_MSG)) {
				--odr;
				System.out.println(prev);
				continue;
			}
			if (msg.getResponses().size() == 0) {
				cnt = false;
			}
			prev = msg;
		}
		System.exit(0);
	}
}
