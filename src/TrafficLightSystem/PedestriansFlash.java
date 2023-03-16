/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class PedestriansFlash extends PedestriansEnabled{
	
	public PedestriansFlash(Context trafficLight) {
		super(trafficLight);
		timeToWait = 2;
		stateEntry();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	public void stateEntry() {
		setTimer(timeToWait);
		signalPedestrians(PedestrianLight.DONT_WALK);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		VehiclesEnabled vehiclesEnabledState = new VehiclesEnabled(trafficLight);
		trafficLight.trafficLightState = vehiclesEnabledState;
		vehiclesEnabledState.stateEntry();
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Pedestrians Flash state");
	}
}
