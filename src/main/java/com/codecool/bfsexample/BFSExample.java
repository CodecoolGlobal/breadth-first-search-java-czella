package com.codecool.bfsexample;

import com.codecool.bfsexample.model.FriendFinder;
import com.codecool.bfsexample.model.UserNode;
import java.util.List;

public class BFSExample {

    private static List<UserNode> populateDB() {

        RandomDataGenerator generator = new RandomDataGenerator();
        List<UserNode> users = generator.generate();

        GraphPlotter graphPlotter = new GraphPlotter(users);
        
        System.out.println("Done!");
        return users;
    }

    public static void main(String[] args) {
        List<UserNode> users = populateDB();
        System.out.println(users);
        FriendFinder friendFinder = new FriendFinder(users);
        System.out.println("The distance between the nodes is: " + friendFinder.getDistanceBetween(1,114));
        System.out.println("The other method: " + friendFinder.getDistanceBetweenIndexes(1,114));

    }
}
