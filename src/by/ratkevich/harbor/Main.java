package by.ratkevich.harbor;
import by.ratkevich.harbor.harbor.Harbor;
import by.ratkevich.harbor.ship.Ship;


public class Main {

    private static int CONTAINERS_CAPACITY_IN_HARBOR = 200;
    private static int SHIPS_CAPACITY_IN_HARBOR = 3;
    private static int CONTAINERS_CAPACITY_IN_SHIP = 100;
    private static int NUMBER_OF_CONTAINERS_ON_SHIP = 50;
    private static int AMOUNT_OF_CONTAINERS_TO_LOAD = 50;
    private static int AMOUNT_OF_CONTAINERS_TO_UNLOAD = 50;
    private static int WRONG_AMOUNT_OF_CONTAINERS_TO_UNLOAD = 60;

    public static void main(String[] args) {

        Harbor harbor = new Harbor (CONTAINERS_CAPACITY_IN_HARBOR, SHIPS_CAPACITY_IN_HARBOR);

        Ship ship1 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 1" );
        Ship ship2 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 2" );
        Ship ship3 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 3" );
        Ship ship4 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 4" );
        Ship ship5 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 5" );
        Ship ship6 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 6" );
        Ship ship7 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, true, "ship 7" );
        Ship ship8 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, false, "ship 8" );
        Ship ship9 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, false, "ship 9" );
        Ship ship10 = new Ship (CONTAINERS_CAPACITY_IN_SHIP, NUMBER_OF_CONTAINERS_ON_SHIP, false, "ship 10" );

        Thread thread1 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship1, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread2 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship2, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread3 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship3, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread4 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship4, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread5 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship5, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread6 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship6, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread7 = new Thread () {
            @Override
            public void run () {
                harbor.loadTheShip(ship7, AMOUNT_OF_CONTAINERS_TO_LOAD);
            }
        };

        Thread thread8 = new Thread () {
            @Override
            public void run () {
                harbor.unLoadTheShip(ship8, AMOUNT_OF_CONTAINERS_TO_UNLOAD);
            }
        };

        Thread thread9 = new Thread () {
            @Override
            public void run () {
                harbor.unLoadTheShip(ship9, AMOUNT_OF_CONTAINERS_TO_UNLOAD);
            }
        };

        Thread thread10 = new Thread () {
            @Override
            public void run () {
                harbor.unLoadTheShip(ship10, WRONG_AMOUNT_OF_CONTAINERS_TO_UNLOAD);
            }
        };


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();


    }
}