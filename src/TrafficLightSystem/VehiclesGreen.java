/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 * The class responsible for handling events 
 * in the Vehicles Green state. Leaves the state on
 * timeout
 */
public class VehiclesGreen extends VehiclesEnabled {
	
	/**
	 * VehiclesGreen constructor
	 * @param trafficLight the Context object
	 */
	public VehiclesGreen(Context trafficLight) {
		super(trafficLight);
		timeToWait = 10;
		stateEntry();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	@Override
	public void stateEntry() {
		setTimer(timeToWait);
		signalVehicles(VehicleLight.GREEN);
		trafficLight.pedestrianIsWaiting = false;
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state (" + timeToWait + " seconds elapsed)");
		if (trafficLight.pedestrianIsWaiting) trafficLight.trafficLightState = new VehiclesYellow(trafficLight);
		else trafficLight.trafficLightState = new VehiclesGreenInt(trafficLight);
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Vehicles Green state");
	}

}
