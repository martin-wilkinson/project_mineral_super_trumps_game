package au.com.wilkinson.martin;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by jimji on 2/05/2016.
 */
public class DoubleLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E>next;
        private Node<E>previous;
        public Node(E e, Node<E> n, Node<E> p){
            element = e;
            next = n;
            previous = p;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public Node<E> getPrevious() {return previous;}
        public void setPrevious(Node<E> p) {previous = p;}
        public void setNext(Node<E> n){
            next = n;
        }
    }
    private Node<E> current_node = new Node<>(null, null, null);
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    public DoubleLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, null, head);
        head.setNext(tail);
    }
    public int size() {return size;}
    public boolean isEmpty(){return size==0;}
    public E first(){
        if(isEmpty()) return null;
        return head.getNext().getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getPrevious().getElement();
    }
    public void addFirst(E e){
        addBetween(e, head, head.getNext());
    }
    public void addLast(E e){
       addBetween(e, tail.getPrevious(), tail);

    }
    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer;
    }


    public void removeLast() {
        current_node = tail.getPrevious();
        removeBetween(current_node.getPrevious(), current_node, tail);
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, successor, predecessor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        size++;
    }
    public void  removeBetween(Node<E> predecessor,Node<E> current, Node<E> successor) {
        if (current == tail)
            return;
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        size--;

    }
    public void search (String[] searchData) {
        for(int i = 0; i < searchData.length; i++)
            for (current_node = head.getNext(); current_node != tail.getPrevious(); current_node = current_node.getNext())
                if (Objects.equals(current_node.getElement(), searchData[i]))
                    break;


    }

    class SortComparator implements Comparator<E>{
        @Override
        public int compare(E n1, E n2){
            return n1.hashCode() - n2.hashCode();
        }
    }
    public Comparator getComp() {
        Comparator comp = new SortComparator();
        return comp;
    }


    public static <E> void quickSort(DoubleLinkedList<E> A, Comparator<E> comp) {
        A.current_node = A.tail;
        int n = A.size();
        if (n < 2) return;
        E pivot = A.last();
        DoubleLinkedList<E> L = new DoubleLinkedList<>();
        DoubleLinkedList<E> E = new DoubleLinkedList<>();
        DoubleLinkedList<E> G = new DoubleLinkedList<>();
         while (A.head.getNext() != A.tail){
            A.current_node = A.current_node.getPrevious();
            int c = comp.compare(A.current_node.getElement(), pivot);
            if (c < 0)
                if (L.isEmpty())
                    L.addFirst(A.current_node.getElement());
                else
                    L.addLast (A.current_node.getElement());
            else if (c == 0)
                if ((E.isEmpty()))
                    E.addFirst(A.current_node.getElement());
                else
                    E.addLast(A.current_node.getElement());
            else
                if (G.isEmpty())
                    G.addFirst(A.current_node.getElement());
                else
                    G.addLast(A.current_node.getElement());
             A.removeBetween(A.current_node.getPrevious(), A.current_node, A.current_node.getNext());
        }
        quickSort(L, comp);
        quickSort(G, comp);
        while (!L.isEmpty())
            if (A.isEmpty()) {
                A.addFirst(L.last());
                L.removeLast();
            }
            else {
                A.addLast(L.last());
                L.removeLast();
            }
        while (!E.isEmpty())
            if (A.isEmpty()) {
                A.addFirst(E.last());
                E.removeLast();
            }
            else {
                A.addLast(E.last());
                E.removeLast();
            }
        while (!G.isEmpty())
            if (A.isEmpty()) {
                A.addFirst(G.last());
                G.removeLast();
            }
            else {
                A.addLast(G.last());
                G.removeLast();
            }

        
    }
}
