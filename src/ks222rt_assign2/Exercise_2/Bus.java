package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Bus extends Vehicle {
    final int MAX_PASSENGERS = 20;

    public Bus(int p, String id) throws Exception {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.regNr = id;
            this.feeForPassengers = 10;
            this.fee = 200;
            this.space = 4;
            this.passengers = p;
        }else{
            throw new Exception("To many people in the car");
        }
    }
}
