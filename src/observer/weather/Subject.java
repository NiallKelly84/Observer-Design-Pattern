package observer.weather;

public interface Subject {	//subject interface
	
	
	public void removeObserver(Observer observer);	//removeObserver method with the observer object passed
	public void notifyObservers();	//notifyObserver method
	public void registerObserver(Observer observer);	//registerObserver method with the observer object passed
//all these methods must be implemented in the three display classes
}
