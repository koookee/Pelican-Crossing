/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class PedestriansFlash extends PedestriansEnabled{
	
	private int flashCounter;
	
	public PedestriansFlash(Context trafficLight, int flashCounter) {
		super(trafficLight);
		timeToWait = 1;
		this.flashCounter = flashCounter;
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	public void stateEntry() {
		setTimer(timeToWait);
		if (flashCounter % 2 == 0) signalPedestrians(PedestrianLight.DONT_WALK); // Could also use (flashCounter & 1) == 0 if efficiency is a concern 
		else signalPedestrians(PedestrianLight.OFF);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state (" + timeToWait + " seconds elapsed)");
		flashCounter--;
		if (flashCounter > 0) {
			PedestriansFlash pedestriansFlash = new PedestriansFlash(trafficLight, flashCounter);
			trafficLight.trafficLightState = pedestriansFlash;
			pedestriansFlash.stateEntry();
		}
		else {
			VehiclesEnabled vehiclesEnabledState = new VehiclesEnabled(trafficLight);
			trafficLight.trafficLightState = vehiclesEnabledState;
			vehiclesEnabledState.stateEntry();
		}
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Pedestrians Flash state");
	}
}
