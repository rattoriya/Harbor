package by.ratkevich.harbor.harbor;

import by.ratkevich.harbor.ship.Ship;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Harbor{


    private int containersCapacity;
    private int shipsCapacity;
    private volatile int containersInHarbor;
    private volatile int shipsInHarbor;


    public Harbor (int containersCapacity, int shipsCapacity) {

        this.containersCapacity = containersCapacity;
        this.shipsCapacity = shipsCapacity;
        this.containersInHarbor = 200;
        this.shipsInHarbor=0;
    }

    public void setContainersCapacity (int containersCapacity) {
        this.containersCapacity = containersCapacity;
    }

    public void setShipsCapacity ( int shipsCapacity) {
        this.shipsCapacity = shipsCapacity;
    }

    public void setContainersInHarbor (int containersInHarbor) {
        this.containersInHarbor = containersInHarbor;
    }

    public void setShipsInHarbor (int shipsInHarbor) {
        this.shipsInHarbor = shipsInHarbor;
    }

    public int getContainersCapacity () {
        return containersCapacity;
    }

    public int getShipsCapacity () {
        return shipsCapacity;
    }

    public int getContainersInHarbor () {
        return containersInHarbor;
    }

    public int getShipsInHarbor () {
        return shipsInHarbor;
    }

    public void loadTheShip (Ship ship, int numOfContainers) {

            while (numOfContainers > containersInHarbor || shipsInHarbor+1>shipsCapacity) {
                try {
                    SECONDS.sleep(1);
                }
                catch (InterruptedException e) {
                    currentThread().interrupt();
                }

            }

            getPlaceToLoad(numOfContainers);
            ship.loadContainers(numOfContainers);
            freePlaceFromLoad();

    }

    public void unLoadTheShip (Ship ship, int numOfContainers) {

        while (shipsInHarbor+1>shipsCapacity || containersInHarbor+numOfContainers>containersCapacity) {
            try {
                SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                currentThread().interrupt();
            }

        }

        getPlaceToUnLoad();
        ship.unloadContainers(numOfContainers);
        freePlaceFromUnLoad(numOfContainers);

    }

    private synchronized void getPlaceToLoad (int numOfContainers) {
        shipsInHarbor++;
        this.containersInHarbor-=numOfContainers;
    }

    private synchronized void freePlaceFromLoad () {
        shipsInHarbor--;
    }

    private synchronized void getPlaceToUnLoad () {
        shipsInHarbor++;
    }

    private synchronized void freePlaceFromUnLoad (int numOfContainers) {
        shipsInHarbor--;
        this.containersInHarbor+=numOfContainers;
    }

}

