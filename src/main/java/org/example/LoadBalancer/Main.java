package org.example.LoadBalancer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Destination ds1 = new Destination("ip1", 5);
        Destination ds2 = new Destination("ip2", 2);
        Destination ds3 = new Destination("ip3", 3);
        Set<Destination> destinations = new LinkedHashSet<>();
        destinations.add(ds1);
        destinations.add(ds2);
        destinations.add(ds3);
        Service s1 = new Service("S1", destinations);


        Request r1 = new Request("1", RequestType.Type1);
        Request r2 = new Request("2", RequestType.Type2);
        Request r3 = new Request("3", RequestType.Type3);
        Request r4 = new Request("4", RequestType.Type1);
        Request r5 = new Request("5", RequestType.Type1);
        Request r6 = new Request("6", RequestType.Type1);
        Request r7 = new Request("7", RequestType.Type1);


        LoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.register(RequestType.Type1, s1);
        loadBalancer.register(RequestType.Type2, s1);
        loadBalancer.register(RequestType.Type3, s1);

        Destination d1 = loadBalancer.balance(r1);
        System.out.println("Request: " + r1.id + " Destination: " + d1.ip);
        Destination d2 = loadBalancer.balance(r2);
        System.out.println("Request: " + r2.id + " Destination: " + d2.ip);
        Destination d3 = loadBalancer.balance(r3);
        System.out.println("Request: " + r3.id + " Destination: " + d3.ip);
        Destination d4 = loadBalancer.balance(r4);
        System.out.println("Request: " + r4.id + " Destination: " + d4.ip);
        Destination d5 = loadBalancer.balance(r5);
        System.out.println("Request: " + r5.id + " Destination: " + d5.ip);
        Destination d6 = loadBalancer.balance(r6);
        System.out.println("Request: " + r6.id + " Destination: " + d6.ip);
        Destination d7 = loadBalancer.balance(r7);
        System.out.println("Request: " + r7.id + " Destination: " + d7.ip);

    }
}
