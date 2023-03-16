/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The context class for storing the current traffic light state
 * and sending events to the state
 */
public class Context {

	public boolean pedestrianIsWaiting;
	public TrafficLightState trafficLightState;
	public PedestrianLight pedestrianLight;
	public VehicleLight vehicleLight;
	
	/**
	 * The Context constructor
	 */
	public Context() {
		pedestrianIsWaiting = false;
		trafficLightState = new VehiclesEnabled(this);
		trafficLightState.stateEntry();
	}

	/**
	 * The event that occurs when the pedestrian presses the waiting button
	 */
	public synchronized void pedestrianWaiting() {
		trafficLightState.pedestrianWaiting();
	}
	
	/**
	 * The timeout event that causes the state to exit
	 */
	public synchronized void timeout() {
		trafficLightState.stateExit();
	}
}
