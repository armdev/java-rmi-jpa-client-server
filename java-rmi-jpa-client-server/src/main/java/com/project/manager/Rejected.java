
package com.project.manager;

final public class Rejected extends java.rmi.RemoteException {

    public Rejected() {
        super();
    }

    public Rejected(String reason) {
        super(reason);
    }
}
