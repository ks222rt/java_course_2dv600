package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Bicycle extends Vehicle {
    final int MAX_PASSENGERS = 1;

    public Bicycle(int p) throws Exception {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.passengers = new Passenger(p);
            this.fee = 40;
            this.space = 0.2;
        }else{
            throw new Exception("To many people in the car");
        }
    }
}
