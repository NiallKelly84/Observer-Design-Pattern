package observer.weather;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherTest {

	
	//Test to validate the display classes
	@Test
	public void test1() {
		WeatherData wd=new WeatherData();	//Create new weatherData object
			
		Observer obs=new ForecastDisplay(wd);	//create new observer object of type ForecastDisplay and pass the wd object as an argument
		Observer obs1=new StatisticsDisplay(wd);//create new observer object of type ForecastDisplay and pass the wd object as an argument
		Observer obs2=new CurrentConditionsDisplay(wd);//create new observer object of type ForecastDisplay and pass the wd object as an argument
		
		wd.setHumidity(40);	//set the humdity to 40
		wd.setPressure(50);	//set the pressure to 50
		wd.setTemperature(60);	//set the temperature to 60
		
		//First assertion
		float expected=50;
		float actual=obs.getPressure();
		assertEquals(expected,actual,0.0001); //check if pressure set in forcastDisplay equals the value set above
		
		//second assertion
		float expected1=60;
		float actual1=obs1.getTemperature();
		assertEquals(expected1,actual1,0.0001);	//check if temperature set in StatisticsDisplay equals the value set above
		
		//third assertion
		float expected2a=40;
		float actual2a=obs2.getHumidity();
		assertEquals(expected2a,actual2a,0.0001);//check if humidity set in CurrentConditionsDisplay equals the value set above
		
		//4th assertion
		float expected2b=50;
		float actual2b=obs2.getPressure();
		assertEquals(expected2b,actual2b,0.0001);	//check if pressure set in CurrentConditionsDisplay equals the value set above
		
		//5th assertion
		float expected2c=60;
		float actual2c=obs2.getTemperature();
		assertEquals(expected2c,actual2c,0.0001);	//check if temperature set in CurrentConditionsDisplay equals the value set above
		
		//Repeat the tests above with new data values to see if the observers are notified and updated correctly when new data is passed
		wd.setHumidity(10);
		wd.setPressure(20);
		wd.setTemperature(30);
		
		float expected3=20;
		float actual3=obs.getPressure();
		assertEquals(expected3,actual3,0.0001);//check if pressure set in forcastDisplay equals the value set above
		
		float expected4=30;
		float actual4=obs1.getTemperature();
		assertEquals(expected4,actual4,0.0001);	//check if temperature set in StatisticsDisplay equals the value set above
		
		float expected5a=10;
		float actual5a=obs2.getHumidity();
		assertEquals(expected5a,actual5a,0.0001);	//check if humidity set in CurrentConditionsDisplay equals the value set above
		
		float expected5b=20;
		float actual5b=obs2.getPressure();
		assertEquals(expected5b,actual5b,0.0001);//check if pressure set in CurrentConditionsDisplay equals the value set above
		
		float expected5c=30;
		float actual5c=obs2.getTemperature();
		assertEquals(expected5c,actual5c,0.0001);	//check if temperature set in CurrentConditionsDisplay equals the value set above	
	}
}