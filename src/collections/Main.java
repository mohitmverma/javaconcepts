package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        OurGenericList<Integer> list = new OurGenericList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);

//        Iterator<Integer> iterator =  list.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for( int x :list) {                                     // calling iterator internally
//            System.out.println(x);
//        }

        //-----------------------------     List Interface
        //  ---arrayList

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 100);
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        list.addAll(list2);
        System.out.println(list);
        System.out.println(list.subList(2,5));     // 2 is inclusive and 5 is exclusive*/

        // ----------- vector
/*        System.out.println("Vectors");
        List<Integer> vector = new Vector<>();
        vector.add(2);
        vector.add(4);
        System.out.println(vector);*/

        //  --LinkedList

//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        ListIterator<Integer>  iterator = list.listIterator();
//        System.out.println(iterator.next() + " : " + iterator.next() + " : " + iterator.previous() + ":" + iterator.next());
//
//        Integer arr[] = list.toArray(new  Integer[0]);
//        for(int x:arr)
//            System.out.println(x);

        // ---------- Queue
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.poll();
//        System.out.println(q.peek());
//
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        System.out.println(st.peek());
//        st.pop();
//
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.addFirst(1);
//        dq.addLast(2);
//        System.out.println(dq + ": " + dq.getFirst());

//        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a );    // comparator
//        pq.add(1);
//        pq.add(3);
//        pq.add(2);
//        while(!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }

        //Set<Integer> set = new HashSet<>();

        NavigableSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(14);
        set.add(10);

        for(int x:set) {
            System.out.print(x+",");
        }
        System.out.println();
        System.out.println(set.ceiling(10));



    }
}
