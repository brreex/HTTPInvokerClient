package cs544.exercise25_2.client;

import cs544.exercise25_2.service.IGreeting;
import cs544.exercise25_2.service.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		IGreeting remoteService = context.getBean("greetingHttpInvokerProxy", IGreeting.class);

		Person person = new Person("John", "Doe");
		String result = remoteService.getMessage(person);
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		int sum = remoteService.calculator('+', 5);
		int mult = remoteService.calculator('*', 2);
		
		stopWatch.stop();
		
		long timetaken = stopWatch.getLastTaskTimeMillis();
		
		System.out.println("Sum  : "+sum);
		System.out.println("Multiplied by two : "+mult);
		System.out.println("Receiving result: " + result);
		System.out.println("Time taken : "+ timetaken +" milli seconds");
		
	}
}
