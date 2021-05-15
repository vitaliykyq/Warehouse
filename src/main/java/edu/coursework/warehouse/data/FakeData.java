package edu.coursework.warehouse.data;

/*
    @author:    Sasha
    @project:    Warehouse
    @class:    FakeData
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.warehouse.model.Manager;
import edu.coursework.warehouse.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeData {

    private List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person("1", "Igor", "Vits", 23),
                    new Person("2", "Grisha", "Vino", 18),
                    new Person("3", "Nick", "Bush", 26),
                    new Person("4", "Jhon", "Dush", 25),
                    new Person("5", "Julia", "Vits", 29),
                    new Person("6", "Natasha", "Leon", 30),
                    new Person("7", "Masha", "Mileno", 35),
                    new Person("8", "Oleg", "Lods", 40),
                    new Person("9", "Olga", "Zem", 23),
                    new Person("10", "Nina", "Lit", 40)));

    private List<Manager> managerList = new ArrayList<>(
            Arrays.asList(
                    new Manager("1", personList.get(0), 10000, 5),
                    new Manager("2", personList.get(1), 12000, 4),
                    new Manager("3", personList.get(2), 9000, 2),
                    new Manager("4", personList.get(3), 12000, 5),
                    new Manager("5", personList.get(4), 15000, 4),
                    new Manager("6", personList.get(5), 10000, 7),
                    new Manager("7", personList.get(6), 11000, 8),
                    new Manager("8", personList.get(7), 12000, 9),
                    new Manager("9", personList.get(8), 11000, 10),
                    new Manager("10", personList.get(9), 12000, 3)));

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
}
