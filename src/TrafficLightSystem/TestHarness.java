/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 * 
 * The class that invokes the pedestrian waiting events 
 * in the context object
 *
 */
public class TestHarness {
	
	/**
	 * Sends a pedestrian waiting event after a certain number of seconds
	 * @param trafficLight the Context object that will have the pedestrianWaiting method
	 * @param time the int of the time to wait in seconds before invoking the pedestrianWaiting method
	 */
	public void sendWaitingEvent(Context trafficLight, int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		trafficLight.pedestrianWaiting();
	}
	
	/**
	 * Initializes the simulated pedestrian and the trafficLight system.
	 * Makes multiple waiting calls to test each state in the system
	 * 
	 * @param args
	 */
	public static void main(String[] args) { 
		TestHarness pedestrian = new TestHarness();
		Context trafficLight = new Context();
		
		pedestrian.sendWaitingEvent(trafficLight, 3);
		pedestrian.sendWaitingEvent(trafficLight, 30);
	}
}
