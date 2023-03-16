/**
 * 
 */
package TrafficLightSystem;

/**
 * @author Hussein Elmokdad
 *
 */
public class PedestriansWalk extends PedestriansEnabled{
	
	public PedestriansWalk(Context trafficLight) {
		super(trafficLight);
		timeToWait = 15;
		stateEntry();
	}
	
	/**
	 * The behaviour executed when the state is entered
	 */
	public void stateEntry() {
		setTimer(timeToWait);
		signalPedestrians(PedestrianLight.WALK);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state (" + timeToWait + " seconds elapsed)");
		PedestriansFlash pedestriansFlash = new PedestriansFlash(trafficLight, 2);
		trafficLight.trafficLightState = pedestriansFlash;
		pedestriansFlash.stateEntry();
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Pedestrians Walk state");
	}
}
