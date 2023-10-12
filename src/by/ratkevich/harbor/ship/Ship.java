package by.ratkevich.harbor.ship;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Ship {

    private int capacity;
    private int numOfContainers;
    private boolean isLoading;
    private String name;

    public Ship (int capacity, int numOfContainers, boolean isLoading, String name) {

        this.capacity = capacity;
        this.numOfContainers = numOfContainers;
        this.isLoading = isLoading;
        this.name = name;
    }

    public void setCapacity (int capacity) {
        this.capacity = capacity;
    }

    public void setNumOfContainers (int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }

    public void setIsLoading (boolean isLoading) {
        this.isLoading = isLoading;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getCapacity () {
        return capacity;
    }

    public int getNumOfContainers () {
        return numOfContainers;
    }

    public boolean getIsLoading () {
        return isLoading;
    }

    public String getName () {
        return name;
    }

    public void loadContainers (int numOfContainers) {

        if (!(this.numOfContainers + numOfContainers > capacity)) {

            System.out.println (name + " is loading");

            try {
                SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                currentThread().interrupt();
            }

            this.numOfContainers += numOfContainers;

        }
        else {
            System.out.println ("The number of containers to load on " + name + " is too big");
        }
    }

    public void unloadContainers (int numOfContainers) {

        if (this.numOfContainers-numOfContainers >=0) {

            System.out.println (name + " is unloading");

            try {
                SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                currentThread().interrupt();
            }

            this.numOfContainers-=numOfContainers;
        }
        else {
            System.out.println ("The number of containers to unload on " + name + " is too big");
        }
    }


}
