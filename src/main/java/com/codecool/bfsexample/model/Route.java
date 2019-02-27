package com.codecool.bfsexample.model;

import java.util.List;
import java.util.Stack;

public class Route {

    Stack<UserNode> routeNodes = new Stack<>();

    public Route(UserNode startingUser, UserNode nextUser) {

        routeNodes.push(startingUser);
        routeNodes.push(nextUser);

    }

    public Route(Route previousRoute, UserNode newUser) {
        this.routeNodes = previousRoute.getRouteNodes();
        this.addToRoute(newUser);
    }

    public Stack<UserNode> getRouteNodes() {
        return routeNodes;
    }

    public void addToRoute(UserNode user) {

        routeNodes.push(user);

    }

    public UserNode peekAtLastNode() {

        return routeNodes.peek();

    }
}
