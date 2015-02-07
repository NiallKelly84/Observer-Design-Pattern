package observer.weather;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float currentPressure = 29.92f;
	private float lastPressure;
	private float currentTemperature = 30.2f;
	private float lastTemperature;
	private float currentHumidity = 75.3f;
	private float lastHumidity;
	private WeatherData weatherData;
	public float temp;
	public float humidity;
	public float pressure;

	@Override
	public float getPressure() { // get current pressure
		return currentPressure;
	}

	@Override
	public float getTemperature() { // get current temperature
		return currentTemperature;
	}

	@Override
	public float getHumidity() { // get humidity
		return currentHumidity;
	}

	public CurrentConditionsDisplay(WeatherData weatherData) { // pass weather
																// data object
																// as object
																// into method
		this.weatherData = weatherData; // assign name to this object
		weatherData.registerObserver(this); // call the register observer method
											// of the weatherData object
		// and pass this new weather data into it as an argument
	}

	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure; // lastPressure assumes the value that
										// was currentpressure
		currentPressure = pressure; // currentpressure is assigned the new
									// pressure value passed in the argument
		lastTemperature = currentTemperature; // lastTemperature assumes the
												// value that was
												// currentTemperature
		currentTemperature = temp; // currenttemperature is assigned the new
									// temperature value passed in the argument
		lastHumidity = currentHumidity; // lastHumidity assumes the value that
										// was currentHumidity
		currentHumidity = humidity; // currentHumidity is assigned the new
									// humidity value passed in the argument

		display(); // call the display method
	}

	public void display() { // display method prints the statements
		System.out.println("The current conditions are as follows: ");
		System.out.println("Temperature: " + currentTemperature);
		System.out.println("Humidity: " + currentHumidity);
		System.out.println("Pressure: " + currentPressure);
	}
}// end class

