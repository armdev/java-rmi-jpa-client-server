package com.project.service;

import com.project.controllers.PersonController;
import com.project.manager.PersonManager;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteServer {

    static final String SERVER = "armen";

    public RemoteServer() {
        try {
            PersonManager personManager = new PersonController();        
            LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind(SERVER, personManager);
         
            System.out.println(personManager + " is ready.");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
        Object o = new Object();
        synchronized (o) {
            try {
                o.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
       new RemoteServer();

    }
}
