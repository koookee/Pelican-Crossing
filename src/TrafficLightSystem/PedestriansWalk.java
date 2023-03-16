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
		signalPedestrians(PedestrianLight.WALK);
		setTimer(timeToWait);
	}
	
	/**
	 * The behaviour executed when the state is exited
	 */
	@Override
	public void stateExit() {
		System.out.println("Leaving state (" + timeToWait + " seconds elapsed)");
		trafficLight.trafficLightState = new PedestriansFlash(trafficLight);
	}
	
	/**
	 * Prints the state that the traffic light is in
	 */
	@Override
	public void printCurrentState() {
		System.out.println("In Pedestrians Walk state");
	}
}
