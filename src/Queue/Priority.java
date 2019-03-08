package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.QueueDoubleList;
import Queue.QueueDoubleList;
import java.util.ArrayList;
import java.util.List;


public class Priority<T extends Comparable<T>> {

    List<QueueDoubleList<T>> prip;

    public static enum prioridad {muy_alta, alta, media, baja, muy_baja}

    private final int[] size;
    private final int[] front;
    private final int[] back;
    private final int[] count;

    public Priority(int size) {
        prip = new ArrayList();
        this.size = new int[prioridad.values().length];
        this.front = new int[prioridad.values().length];
        this.back = new int[prioridad.values().length];
        this.count = new int[prioridad.values().length];

        for (int i = 0; i < prioridad.values().length; i++) {
            this.front[i] = -1;
            this.size[i] = size;
            this.back[i] = 0;
            this.count[i] = 0;
            prip.add(new QueueDoubleList<T>(size));
        }
    }

    public boolean enqueue(int pos, T value) {
        try{
            isFull(pos);
            count[pos]++;
            prip.get(pos).enqueue(value);
            return true;
        } catch (isFullException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T dequeue(){
        for (int i = 0; i < size[0]; i++) {
            try{
                isEmpty(i);
                count[i]--;
                return prip.get(i).dequeue();
            } catch (isEmptyException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public boolean removeAll() {
        for (int j = 0; j < prioridad.values().length; j++) {
            for (int i = 0; i < size[0]; i++) {
                prip.get(j).removeAll();
            }
            front[j] = -1;
            back[j] = 0;
            count[j] = 0;
        }
        return true;
    }

    public boolean isFull(int pos) throws isFullException {
        if (count[pos] == size[pos])
            throw new isFullException("Cola llena");
        else return false;
    }

    public boolean isEmpty(int pos) throws isEmptyException {
        if (count[pos] == 0)
            throw new isEmptyException("Cola vacía");
        else return false;
    }

    public T front() {
        for (int i = 0; i < prioridad.values().length; i++) {
            try {
                if (!isEmpty(i))
                    return prip.get(i).front();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public T last() {
        for (int i = prioridad.values().length - 1; i >= 0; i--) {
            try {
                if (!isEmpty(i))
                    return prip.get(i).last();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}