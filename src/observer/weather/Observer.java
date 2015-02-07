package observer.weather;

public interface Observer {	//observer interface

	public void update(float temp, float humidity, float pressure);	//pass the new weather data as arguments to this method
	public float getPressure();	//getters to be implemented in the display classes
	public float getTemperature();
	public float getHumidity();
	
}
