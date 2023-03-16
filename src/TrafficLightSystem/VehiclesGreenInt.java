/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The class responsible for handling events 
 * in the Vehicles Green Int state. Only leaves the
 * state when it receives a pedestrian waiting event
 */
public class VehiclesGreenInt extends VehiclesEnabled {

	/**
	 * VehiclesGreenInt constructor
	 * @param trafficLight the Context object
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
		System.out.println("Pedestrian pressed the waiting button");
		stateExit();
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state");
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
