package com.codecool.bfsexample.model;

import java.util.*;

public class FriendFinder {

    private List<UserNode> users;

    public FriendFinder(List<UserNode> users) {

        this.users = users;

    }

    public int getDistanceBetween(long idFrom, long idTo) {

        UserNode activeNode = getNodeById(idFrom);
        int distance = 1;
        int sumOfFriendsInNextDistance = 0;
        List<UserNode> nodesVisited = new LinkedList<>();
        nodesVisited.add(activeNode);
        List<UserNode> nodesToVisit = new LinkedList<>();
        nodesToVisit.addAll(activeNode.getFriends());
        int friendsRemainingInDistance = nodesToVisit.size();

        while (nodesToVisit.size() > 0) {

            if (friendsRemainingInDistance == 0) {
                friendsRemainingInDistance = sumOfFriendsInNextDistance;
                distance++;
                sumOfFriendsInNextDistance = 0;
            }

            activeNode = ((LinkedList<UserNode>) nodesToVisit).getFirst();
            ((LinkedList<UserNode>) nodesToVisit).remove(activeNode);
            nodesVisited.add(activeNode);
            if (activeNode.getId() == idTo) {
                    return distance;
                }

            List<UserNode> friendsOfActiveNode = new ArrayList<>();
            friendsOfActiveNode.addAll(activeNode.getFriends());
            for (UserNode user: friendsOfActiveNode
                 ) {



                if (!user.isIn(nodesToVisit) && !user.isIn(nodesVisited)) {

                    nodesToVisit.add(user);
                    sumOfFriendsInNextDistance++;

                }

            }

            friendsRemainingInDistance--;

        }

        throw new IllegalArgumentException("The users don't have common friends or the ids don't exist");


    }

    public UserNode getNodeById(long id) {

        for (UserNode user: users
             ) {

            if (user.getId() == id) {
                return user;
            }

        }

        throw new IllegalArgumentException("No such id in users");

    }

    public List<List<UserNode>> breadthFirstSearch(long idToStartFrom) {

        UserNode activeNode = getNodeById(idToStartFrom);
        int distance = 1;
        int sumOfFriendsInNextDistance = 0;
        List<UserNode> nodesVisited = new LinkedList<>();
        nodesVisited.add(activeNode);
        List<UserNode> nodesToVisit = new LinkedList<>();
        nodesToVisit.addAll(activeNode.getFriends());
        List<List<UserNode>> formattedResultList = new ArrayList<>();
        formattedResultList.add(0, new ArrayList<>(Arrays.asList(activeNode)));
        formattedResultList.add(distance,new ArrayList<>());
        for (UserNode user: nodesToVisit
             ) {
            formattedResultList.get(distance).add(user);
        }
        formattedResultList.add(distance + 1, new ArrayList<>());
        int friendsRemainingInDistance = nodesToVisit.size();

        while (nodesToVisit.size() > 0) {

            if (friendsRemainingInDistance == 0) {
                friendsRemainingInDistance = sumOfFriendsInNextDistance;
                distance++;
                formattedResultList.add(distance + 1, new ArrayList<>());
                sumOfFriendsInNextDistance = 0;
            }

            activeNode = ((LinkedList<UserNode>) nodesToVisit).getFirst();
            ((LinkedList<UserNode>) nodesToVisit).remove(activeNode);
            nodesVisited.add(activeNode);

            List<UserNode> friendsOfActiveNode = new ArrayList<>();
            friendsOfActiveNode.addAll(activeNode.getFriends());
            for (UserNode user: friendsOfActiveNode
                 ) {



                if (!user.isIn(nodesToVisit) && !user.isIn(nodesVisited)) {

                    nodesToVisit.add(user);
                    formattedResultList.get(distance + 1).add(user);
                    sumOfFriendsInNextDistance++;

                }

            }

            friendsRemainingInDistance--;

        }

        return formattedResultList;


    }

    public int getDistanceBetweenIndexes(long idFrom, long idTo) {

        List<List<UserNode>> bFSResult = breadthFirstSearch(idFrom);

        for (int i = 0; i < bFSResult.size(); i++) {

            List<UserNode> currentList = bFSResult.get(i);

            for (UserNode user: currentList
                 ) {

                if (user.getId() == idTo) {
                    return i;
                }

            }

        }

        throw new IllegalArgumentException("The users don't have common friends or the ids don't exist");

    }

}
