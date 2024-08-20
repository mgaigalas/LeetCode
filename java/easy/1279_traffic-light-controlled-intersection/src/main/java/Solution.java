/**
 * Solution class contains solution for LeetCode problem:
 * #1279. Traffic Light Controlled Intersection.
 *
 * @author Marius Gaigalas on 16/08/2024
 */
public class Solution {
    private int activeRoadId = 1;

    /**
     * Executes car drive-through.
     *
     * @param carId     car id
     * @param roadId    road id
     * @param direction direction car is going through road
     * @param turnGreen action that turns traffic light green (as {@link Runnable} action)
     * @param crossCar  action that drives car through road (as {@link Runnable} action)
     */
    @SuppressWarnings("unused")
    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            if (activeRoadId != roadId) {
                turnGreen.run();
                activeRoadId = roadId;
            }
            crossCar.run();
        }
    }
}