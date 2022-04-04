package com.example.struct.setmap;

import com.example.struct.CustomLinkedList;
import com.example.struct.Node;

import java.util.*;

public class HashSetAndMap {

    /**
     * Efficient in O(1) constant time
     */
    public boolean hasCycle(CustomLinkedList nodes) {
        HashSet<Node> hashSet = new HashSet<>();

        Node current = nodes.getHead();

        while (current != null) {
            if (hashSet.contains(current))
                return true;
            else
                hashSet.add(current);

            current = current.next;
        }

        return false;
    }

    public void displayFreqOfEachElement(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) {
            if (!freqMap.containsKey(x)) {
                freqMap.put(x, 1);
            } else {
                freqMap.put(x, freqMap.get(x) + 1);
            }
        }

        System.out.println("source: " + Arrays.toString(arr));
        freqMap.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
    }

    public List<Integer> findMissingElements(int[] first, int[] second) {
        ArrayList<Integer> missingElements = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : second) {
            hashSet.add(i);
        }

        for (int x : first) {
            if (!hashSet.contains(x)) {
                missingElements.add(x);
            }
        }

        return missingElements;
    }

    public static void hasCycle() {
        HashSetAndMap sm = new HashSetAndMap();
        CustomLinkedList nodes = new CustomLinkedList();

        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(6);

        nodes.setHead(n1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("has no cycle: " + sm.hasCycle(nodes));
        n2.next = n1;
        System.out.println("has cycle: " + sm.hasCycle(nodes));
    }

    public static void displayFreqOfEachElement() {
        HashSetAndMap sm = new HashSetAndMap();
        sm.displayFreqOfEachElement(new int[]{1, 2, 2, 3, 4, 2, 5, 8, 6});
    }

    public static void findMissingElement() {
        HashSetAndMap sm = new HashSetAndMap();

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4};

        List<Integer> results = sm.findMissingElements(arr1, arr2);
        System.out.println("missing elements: " + results);
        results.forEach(System.out::println);
    }

    public static void example() {

        Employee employee = new Employee("Robby", 3827,
                "Technology");
        Employee employee2 = new Employee("Bobby", 9612,
                "Marketing");
        Employee employee3 = new Employee("Sally", 2519,
                "Sales");

        HashMap<Integer, Employee> employeesById = new HashMap<>();
        employeesById.put(employee.id, employee);
        employeesById.put(employee2.id, employee2);
        employeesById.put(employee3.id, employee3);

        Employee retrievedEmployee = employeesById.get(9612);

        if (retrievedEmployee != null) {
            System.out.println(retrievedEmployee.name + " : " +
                    retrievedEmployee.department);
        }

        HashSet<String> productCodes = new HashSet<>();
        productCodes.add("2T26B");
        productCodes.add("9K42P");
        productCodes.add("H5J781");

        System.out.println(productCodes.contains("H5J781"));
        System.out.println(productCodes.contains("9KTYP"));

    }
}
