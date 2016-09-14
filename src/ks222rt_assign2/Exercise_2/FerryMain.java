package ks222rt_assign2.Exercise_2;

/**
 * Created by Kristoffer on 2016-09-14.
 */
public class FerryMain {
    public static void main(String[] args){
        FerrySystem ferrySystem = new FerrySystem();
        System.out.println(ferrySystem.toString());

        Bus bus = new Bus(20);
        Car car = new Car(4);
        Lorry lorry = new Lorry(1);
        Bicycle bicycle = new Bicycle(1);
        Car car1 = new Car(3);
        Bus bus1 = new Bus(20);
        Lorry lorry1 = new Lorry(2);
        Lorry lorry2 = new Lorry(2);
        Lorry lorry3 = new Lorry(2);
        Bicycle b1 = new Bicycle(1);
        Bicycle b2 = new Bicycle(1);


        ferrySystem.embark(bus);
        System.out.println("Embarked a bus with 20 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(car);
        System.out.println("Embarked a car with 4 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(lorry);
        System.out.println("Embarked a lorry with 1 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(bicycle);
        System.out.println("Embarked a bicycle with 1 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(car1);
        System.out.println("Embarked a car with 3 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(bus1);
        System.out.println("Embarked a bus with 20 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(lorry1);
        System.out.println("Embarked a lorry1 with 2 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(lorry2);
        System.out.println("Embarked a lorry2 with 2 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(lorry3);
        System.out.println("Embarked a lorry3 with 2 passengers, but couldnt take it because of carspace");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(b1);
        System.out.println("Embarked a bicycle with 1 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        ferrySystem.embark(b2);
        System.out.println("Embarked a bicycle with 1 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());

        for (int i = 0; i < 144; i++){
            Passenger p = new Passenger(20);
            ferrySystem.embark(p);
        }
        System.out.println("Embarked 144 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());

        Passenger p = new Passenger(20);
        ferrySystem.embark(p);
        System.out.println("Embarked 1 passengers");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());

        ferrySystem.embark(p);
        System.out.println("Embarked 1 passengers, but no room left");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());

        System.out.println(ferrySystem.toString());

        ferrySystem.disembark();
        System.out.println("Disembarked the ferry");
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());

        for (int i = 0; i < 200; i++){
            Bicycle b = new Bicycle(1);
            ferrySystem.embark(b);
        }
        System.out.println(ferrySystem.getInformationAboutSizePassengerMoney());
        System.out.println(ferrySystem.toString());
    }
}
