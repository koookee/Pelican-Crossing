/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The context class for calling the different
 * traffic light states
 */
public class Context {

	public boolean pedestrianIsWaiting;
	public TrafficLightState trafficLightState;
	public PedestrianLight pedestrianLight;
	public VehicleLight vehicleLight;
	
	public Context() {
		pedestrianIsWaiting = false;
		trafficLightState = new VehiclesEnabled(this);
		trafficLightState.stateEntry();
	}

	public synchronized void pedestrianWaiting() {
		trafficLightState.pedestrianWaiting();
	}
	
	/**
	 * The timeout event that causes the state to exit
	 */
	public synchronized void timeout() {
		trafficLightState.printCurrentState();
		trafficLightState.stateExit();
	}
}
