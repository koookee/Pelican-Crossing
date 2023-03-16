/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class VehiclesGreen extends VehiclesEnabled {
	
	/**
	 * 
	 */
	public VehiclesGreen(Context trafficLight) {
		super(trafficLight);
		stateEntry();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	@Override
	public void stateEntry() {
		timeToWait = 10;
		setTimer(timeToWait);
		signalVehicles(VehicleLight.GREEN);
		trafficLight.pedestrianIsWaiting = false;
	}
	
	/**
	 * Signals that a pedestrian is waiting to cross
	 */
	@Override
	public void pedestrianWaiting() {
		trafficLight.pedestrianIsWaiting = true;
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
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
