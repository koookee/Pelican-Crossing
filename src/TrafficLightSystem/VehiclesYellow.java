/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The class responsible for handling events 
 * in the Vehicles Yellow state. Leaves the state
 * on timeout
 */
public class VehiclesYellow extends VehiclesEnabled {
	
	public VehiclesYellow(Context trafficLight) {
		super(trafficLight);
		timeToWait = 3;
		stateEntry();
	}

	/**
	 * The behaviour executed when the state is entered
	 */
	@Override
	public void stateEntry() {
		setTimer(timeToWait);
		signalVehicles(VehicleLight.YELLOW);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state (" + timeToWait + " seconds elapsed)");
		PedestriansEnabled pedestriansEnabledState = new PedestriansEnabled(trafficLight);
		trafficLight.trafficLightState = pedestriansEnabledState;
		pedestriansEnabledState.stateEntry();
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Vehicles Yellow state");
	}

}
