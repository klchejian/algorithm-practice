package main.java.ClassicAlgo;

import java.util.Random;
import java.util.Scanner;

public class LinkedListSummary {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder(String.valueOf(value));
            Node p = next;
            Node testCycle = next;
            while (p != null) {
                sb.append(" -> " + p.value);
                p = p.next;
                if(testCycle.next != null && testCycle.next.next != null){
                    testCycle = testCycle.next.next;
                }
                if( testCycle == p){
                    break;
                }
            }
            return sb.toString();
        }
    }
    public static String printList(Node head){
        StringBuilder sb = new StringBuilder("");
        if(head == null){
            return sb.toString();
        }
        Node p = head;
        sb.append(head.value);
        while(p.next != null){
            p = p.next;
            sb.append(" "+ p.value);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node head = initList();
        System.out.println(printList(head));
        System.out.println(printList(reverseIterable(head)));
    }

    public static Node ReverseList(Node head) {
        if(head == null)
            return null;
        Node p = head.next;
        head.next = null;
        Node tmp;
        while (p != null){
            tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }

    public static Node reverseIterable(Node head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        Node res = reverseIterable(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }




    public static Node initList(int n){
        final int R_FACTOR = 100;
        Random r = new Random();
        Node head = null;
        Node p = null;
        p = head = new Node(r.nextInt(R_FACTOR));
        for (int i = 0; i < n-1; i++){
            p.next = new Node(r.nextInt(R_FACTOR));
            p = p.next;
        }
        return head;
    }
    public static Node initList(){
        return initList(10);
    }

    public static Node initListCustom(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node p = null;
        p = head = new Node(sc.nextInt());

        for (int i = 0; i < n; i++){
            p.next = new Node(sc.nextInt());
            p = p.next;
        }
        return head;
    }




}
