package observer.weather;

import java.awt.List;
import java.util.ArrayList;

public class WeatherData implements Subject {

	public float temp; 
	public float humidity; 
	public float pressure;
	
	public float getTemperature(){
		return temp;
	}
	
	public float getHumidity(){
		return humidity;
	}
	
	public float getPressure(){
		return pressure;
	}
	
	public void setTemperature(float temp){	//sets the temperature and then calls the notifyObservers method
		this.temp=temp;
		notifyObservers();
	}
	
	public void setHumidity(float humidity){//sets the humidity and then calls the notifyObservers method
		this.humidity=humidity;
		notifyObservers();
	}
	
	public void setPressure(float pressure){//sets the pressure and then calls the notifyObservers method
		this.pressure=pressure;
		notifyObservers();
	}
	
	
	
	ArrayList<Observer> myList=new ArrayList<Observer>();	//creates an arraylist of observer objects

	public void registerObserver(Observer observer) {	
		myList.add(observer);	//new observer is added to the arraylist
		
	}
	
	
	@Override
	public void removeObserver(Observer observer) {
		myList.remove(observer);	//an observer is removed from the arraylist
	}

	@Override
	public void notifyObservers() {	//notifyObservers methos
		for(Observer obs:myList){	//loops through all the observers on the list (ie the three display classes)
			obs.update(temp, humidity, pressure);	//updates each observer with the new data
		}
		
	}

}//end class
