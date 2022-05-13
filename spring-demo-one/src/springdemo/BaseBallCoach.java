package springdemo;

public class BaseBallCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins";
	}

	@Override
	public String getDailyFortune() {
		//use my fortuneService to get a fortune
		return fortuneService.getDailyFortune();
	}
}