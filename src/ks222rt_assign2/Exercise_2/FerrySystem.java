package ks222rt_assign2.Exercise_2;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class FerrySystem implements Ferry {
    final int TOTAL_NUMBER_OF_PASSENGERS = 200;
    final int TOTAL_NUMBERS_OF_CARS = 40;
    private int passengers = 0;
    private int cars = 0;
    private Node head;

    public FerrySystem(){

    }

    // Number of passengers on board
    @Override
    public int countPassengers() {
        return 0;
    }

    // Used vehicle space. One car is 1.
    @Override
    public int countVehicleSpace() {
        return 0;
    }

    // Earned money
    @Override
    public int countMoney() {
        return 0;
    }

    // Embark vehicle, warning if not enough space
    @Override
    public void embark(Vehicle v) {

    }

    // Embark passenger, warning if not enough room
    @Override
    public void embark(Passenger p) {

    }

    // Clear (empty) ferry. The money earned remains,
    // i.e., is not reset to zero
    @Override
    public void disembark() {

    }

    // true if we can embark vehicle v
    @Override
    public boolean hasSpaceFor(Vehicle v) {
        if ((v.getSpace() + cars) == TOTAL_NUMBERS_OF_CARS){
            return true;
        }
        return false;
    }

    // true if we can embark passenger p
    @Override
    public boolean hasRoomFor(Passenger p) {
        if ((p.getAmount() + passengers) == TOTAL_NUMBER_OF_PASSENGERS){
            return true;
        }
        return false;
    }


    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    private class VehicleIterator implements Iterator<Vehicle>{
        private Node node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Vehicle next() {
            Vehicle val = node.value;
            node = node.next;
            return val;
        }
    }

    private class Node{
        Vehicle value;
        Node next = null;

        public Node(Vehicle V){
            this.value = V;
        }
    }
}
