package observer.weather;



public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	public float temp; 
	public float humidity; 
	
	private WeatherData weatherData;	//declare weather data object
	
	
	public ForecastDisplay(WeatherData weatherData) {	//pass this weather data as an argument into forecastDisplay method
		this.weatherData = weatherData;	//assign a name to this object
		weatherData.registerObserver(this);//call the register observer method of the weatherData object 
		//and pass this new weather data into it as an argument
	}

	public void update(float temp, float humidity, float pressure) {	//pass new weather data to the update method
        lastPressure = currentPressure;	//lastPressure takes the value of curremt pressure
		currentPressure = pressure;	//current pressure takes the new value set for pressure
		display();	//call the display method for this class
	}
	
	
	public void display() {		//display method prints statement according to the condition staisfied
	    System.out.print("Forecast Display: ");
	    if (currentPressure > lastPressure) {
	    	System.out.println("Improving weather on the way!");
	    } else if (currentPressure == lastPressure) {
	    	System.out.println("More of the same");
	    } else if (currentPressure < lastPressure) {
	    	System.out.println("Watch out for cooler, rainy weather");
	    }
	
	 }

	@Override
	public float getPressure() {	//getter for pressure
		return currentPressure;
	}

	@Override
	public float getTemperature() {	//getter for temperature
		return temp;
	}

	@Override
	public float getHumidity() {	//getter for humidity
		return humidity;
	}
		
	}//end class
