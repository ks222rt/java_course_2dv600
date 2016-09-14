package ks222rt_assign2.Exercise_2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class FerrySystem implements Ferry {
    private final int TOTAL_NUMBER_OF_PASSENGERS = 200;
    private final int TOTAL_NUMBERS_OF_CARS = 40;
    private static double carSize = 0;
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
        return (int)Math.ceil((double)Math.round(carSize * 10d) / 10d);
    }

    // Earned money
    @Override
    public int countMoney() {
        return amountOfMoney;
    }

    // Embark vehicle, warning if not enough space
    @Override
    public void embark(Vehicle v) {
        if (hasSpaceFor(v) && ((passengerList.size() + v.getAmountPassengers()) <= TOTAL_NUMBER_OF_PASSENGERS)){
            carList.add(v);
            for (int i = 0; i < v.getAmountPassengers(); i++){
                Passenger p = new Passenger(v.getFeeForPassengers());
                embark(p);
            }
            carSize += v.getSpace();
            amountOfMoney += v.getFee();
        }else{
            System.err.println("Warning: The ferry cant take the vehicle");
        }
    }

    // Embark passenger, warning if not enough room
    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)){
            passengerList.add(p);
            amountOfMoney += p.getAmount();
        }else{
            System.err.println("Warning: No room left for the passenger");
        }
    }

    // Clear (empty) ferry. The money earned remains,
    // i.e., is not reset to zero
    @Override
    public void disembark() {
        carList.clear();
        passengerList.clear();
        carSize = 0;
    }

    // true if we can embark vehicle v
    @Override
    public boolean hasSpaceFor(Vehicle v) {
        if (((Math.round(carSize * 10d) / 10d) + v.getSpace()) <= TOTAL_NUMBERS_OF_CARS && !carList.contains(v)){
            return true;
        }
        return false;
    }

    // true if we can embark passenger p
    @Override
    public boolean hasRoomFor(Passenger p) {
        if (passengerList.size() < TOTAL_NUMBER_OF_PASSENGERS && !passengerList.contains(p)){
            return true;
        }
        return false;
    }

    public String getInformationAboutSizePassengerMoney(){
        StringBuffer sb = new StringBuffer();
        sb.append("Amount of carsize used: " + countVehicleSpace() + "\n");
        sb.append("Amount of earned money: " + countMoney() + "\n");
        sb.append("Amount of passengers onboard: " + countPassengers() + "\n");
        return sb.toString();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        int count = 1;
        Iterator it = iterator();
        while(it.hasNext()){
            Vehicle v = ((Vehicle) it.next());
            sb.append(count + ": " + v.getType() + " - fee: " + v.fee + " - space: " +
                    v.getSpace() + " -  amount of passengers: " +
                    v.getAmountPassengers() + " - fee for passengers: " + v.getFeeForPassengers() +"\n");
            count++;
        }
        count = 1;
        return sb.toString();
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
