package ks222rt_assign2.Exercise_2;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class FerrySystem implements Ferry {
    private final int TOTAL_NUMBER_OF_PASSENGERS = 200;
    private final int TOTAL_NUMBERS_OF_CARS = 40;
    private static float carSize = 0;
    private static int amountOfMoney = 0;
    private ArrayList<Vehicle> carList;
    private ArrayList<Passenger> passengerList;

    public FerrySystem(){
        carList = new ArrayList<>();
        passengerList = new ArrayList<>();
    }

    // Number of passengers on board
    @Override
    public int countPassengers() {
        return passengerList.size();
    }

    // Used vehicle space. One car is 1.
    @Override
    public int countVehicleSpace() {
        return Math.round(carSize);
    }

    // Earned money
    @Override
    public int countMoney() {
        return amountOfMoney;
    }

    // Embark vehicle, warning if not enough space
    @Override
    public void embark(Vehicle v) {
        if (hasSpaceFor(v) && ((passengerList.size() + v.getAmountPassengers()) > TOTAL_NUMBER_OF_PASSENGERS)){
            carList.add(v);
            carSize += v.getSpace();
        }else{
            System.out.println("Warning: The ferry cant take the vehicle");
        }
    }

    // Embark passenger, warning if not enough room
    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)){
            passengerList.add(p);
        }else{
            System.out.println("Warning: No room left for the passenger");
        }
    }

    // Clear (empty) ferry. The money earned remains,
    // i.e., is not reset to zero
    @Override
    public void disembark() {

    }

    // true if we can embark vehicle v
    @Override
    public boolean hasSpaceFor(Vehicle v) {
        if ((carSize + v.getSpace()) <= TOTAL_NUMBERS_OF_CARS && carList.contains(v)){
            return true;
        }
        return false;
    }

    // true if we can embark passenger p
    @Override
    public boolean hasRoomFor(Passenger p) {
        if (passengerList.size() <= TOTAL_NUMBER_OF_PASSENGERS && passengerList.contains(p)){
            return true;
        }
        return false;
    }


    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    private class VehicleIterator implements Iterator<Vehicle>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count<carList.size();
        }

        @Override
        public Vehicle next() {
            return carList.get(count++);
        }
    }
}
