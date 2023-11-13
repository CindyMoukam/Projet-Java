package model;

import java.util.Observable;


/**
 *

 *		the class Objet
 */

public  class Model extends Observable{

    /**
     * Instantiates a new model.
     */
    public Model() {

    }

    /**
     * Gets the observable.
     *
     * @return the observable
     *
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }

    public void loadHelloWorld(String gb) {
     }

   public Throwable getHelloWorld() {return null;}
}