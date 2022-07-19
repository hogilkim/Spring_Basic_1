package springbasic1.core.order.singleton;

public class SingletonService {

    // in the static field, create only ONE object
    private static final SingletonService instance = new SingletonService();

    // use public so that it can be used from outside
    public static SingletonService getInstance(){
        return instance;
    }

    // declare it private so that new object cannot be created from outside
    private SingletonService(){
    }

    public void logic(){
        System.out.println("Call Singleton object logic");
    }
}
