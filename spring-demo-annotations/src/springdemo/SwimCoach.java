package springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${fortunes}")
	private String[] fortunes;
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	private Random myRandom = new Random();
	
	public String getRandomFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(fortunes.length);
				
		String theFortune = fortunes[index];
				
		return theFortune;
	}
}
