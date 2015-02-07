package observer.weather;

public class StatisticsDisplay implements Observer, DisplayElement{
 
	private float currentTemperature=30.1f;
	private float lastTemperature;
	private WeatherData weatherData;
	public float temp; 
	public float humidity; 
	public float pressure;
	
	@Override
	public float getPressure() {
		return pressure;
	}

	@Override
	public float getTemperature() {
		return currentTemperature;
	}

	@Override
	public float getHumidity() {
		return humidity;
	}
	
	
	
	public StatisticsDisplay(WeatherData weatherData) {	//pass this weather data as an argument into Statistics Display method
		this.weatherData = weatherData;	//assign a name to this object
		this.weatherData = weatherData;
		weatherData.registerObserver(this);	//call the registerobserver method for the weatherData object and pass this new data as an object
	}


public void update(float temp, float humidity, float pressure) {
	lastTemperature = currentTemperature;	//lastTemperature is assigned the value that was currentTemperature
	currentTemperature = temp;	//currentTemperature becomes the new temperature that is set above

	display();	//call the display method
}


public void display() {		//prints the appropriate statement according to the conditions satisfied
	System.out.print("Statistical Forecast: ");
	if (currentTemperature > lastTemperature) {
		System.out.println("Hotter Weather is on the way! Statistics don't lie!");
	} else if (currentTemperature == lastTemperature) {
		System.out.println("The temperature has not changed! Statistically it is unusual "
				+ "for the weather to stay the same for so long.");
	} else if (currentTemperature < lastTemperature) {
		System.out.println("It will freeze tonight. Drive carefully!");
	}
}


}