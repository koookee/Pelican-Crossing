/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class Timer implements Runnable{
	
	private Context trafficLight;
	private int timeToWait;
	
	/**
	 * 
	 */
	public Timer(Context trafficLight, int timeToWait) {
		this.trafficLight = trafficLight;
		this.timeToWait = timeToWait;
	}

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
