package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class Car extends Vehicle {
    final int MAX_PASSENGERS = 4;

    public Car(int p, String id) throws Exception {
        if (rightAmountOfPassengers(p, MAX_PASSENGERS)){
            this.regNr = id;
            this.feeForPassengers = 15;
            this.fee = 100;
            this.space = 1;
            this.passengers = p;
        }else{
            throw new Exception("To many people in the car");
        }
    }
}
