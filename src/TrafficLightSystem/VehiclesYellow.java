/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class VehiclesYellow extends VehiclesEnabled {
	
	public VehiclesYellow(Context trafficLight) {
		super(trafficLight);
		super.timeToWait = 3;
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
		trafficLight.trafficLightState = new VehiclesGreen(trafficLight);
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Vehicles Yellow state");
	}

}
