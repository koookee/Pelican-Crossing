/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class VehiclesGreenInt extends VehiclesEnabled {

	/**
	 * 
	 */
	public VehiclesGreenInt(Context trafficLight) {
		super(trafficLight);
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	@Override
	public void stateEntry() {
		// Nothing for the vehicles green int state
	}
	
	/**
	 * Signals that a pedestrian is waiting to cross
	 */
	@Override
	public void pedestrianWaiting() {
		stateExit();
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		trafficLight.trafficLightState = new VehiclesYellow(trafficLight);
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Vehicles GreenInt state");
	}

}
