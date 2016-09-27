package com.project.manager;

import com.project.entities.Person;
import java.rmi.Remote;
import java.util.List;

public interface PersonManager extends Remote {

    public void create(Person person) throws java.rmi.RemoteException, Rejected;

    public void edit(Person person) throws java.rmi.RemoteException, Rejected;

    public void destroy(Integer id) throws java.rmi.RemoteException, Rejected;

    public List<Person> findPersonEntities() throws java.rmi.RemoteException, Rejected;

    public List<Person> findPersonEntities(int maxResults, int firstResult) throws java.rmi.RemoteException, Rejected;

    public Person findPerson(Integer id) throws java.rmi.RemoteException, Rejected;

    public int getPersonCount() throws java.rmi.RemoteException, Rejected;

}
