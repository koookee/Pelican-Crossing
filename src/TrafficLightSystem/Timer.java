/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 * 
 * The timer class that waits (sleeps) before invoking
 * the timeout event. Each state will have a different duration
 */
public class Timer implements Runnable{
	
	private Context trafficLight;
	private int timeToWait;
	
	/**
	 * The constructor for the Time class 
	 * @param trafficLight the Context that contains the timeout method
	 * @param timeToWait the int of the time to wait in seconds
	 */
	public Timer(Context trafficLight, int timeToWait) {
		this.trafficLight = trafficLight;
		this.timeToWait = timeToWait;
	}

	/**
	 * The method run when the thread is started
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(timeToWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		trafficLight.timeout();
	}

}
