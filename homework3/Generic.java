// generic class

public class Generic<E>{

    E object;

    Generic(E obj){
        object = obj;
    }

    public void display(){
        System.out.println(object);
    }
    

    public void class_find(){
            System.out.println(object.getClass()); 
    }

    // generic method 
    public E get_object(){
        return object;
    }

}

class Main{
    public static void main(String[] args) {
        Generic<Integer> g = new Generic<Integer>(5);

        g.display();

        Integer h = g.get_object();

        System.out.println(h);
    }
}

