package com.codecool.bfsexample.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserNode {

    // feel free to add new properties or methods here

    private long id;
    private static long idCounter = 0;
    private String firstName;
    private String lastName;

    private Set<UserNode> friends = new HashSet<>();

    public UserNode(String firstName, String lastName) {
        this.id = idCounter;
        idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public Set<UserNode> getFriends() {return friends;}

    public void addFriend(UserNode friend) {
        friends.add(friend);
        friend.friends.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + "_" + lastName + " (" + id + ")";
    }

    public boolean isIn(List<UserNode> list) {

        Iterator<UserNode> it = list.iterator();
        while (it.hasNext()) {

            UserNode current = it.next();

            if (current.getId() == this.getId()) {
                return true;
            }

        }
        return false;

    }
}
