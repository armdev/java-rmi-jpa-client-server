package com.project.client;

import com.project.entities.Person;
import com.project.manager.PersonManager;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoteClient {

    private static final String SERVER = "armen";
    private PersonManager personManager;

    public static void main(String[] args) {
        RemoteClient remoteClient = new RemoteClient();
        Person person = new Person();
        person.setFirstname("Firstname");
        person.setLastname("Lastname");
        try {
            remoteClient.getPersonManager().create(person);
        } catch (RemoteException ex) {
            Logger.getLogger(RemoteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("Person counts at the moment " + remoteClient.getPersonManager().getPersonCount());
        } catch (RemoteException ex) {
            Logger.getLogger(RemoteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    public RemoteClient() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            personManager = (PersonManager) registry.lookup(SERVER);
        } catch (RemoteException | NotBoundException se) {
            System.out.println("The runtime failed: " + se);
            System.exit(0);
        }
        System.out.println("Connected to server: " + SERVER);
    }

    public PersonManager getPersonManager() {
        return personManager;
    }

}
