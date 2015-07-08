package java8;


import java.util.Arrays;
import java.util.concurrent.*;

public class Playground {
    public static void main(String[] args) {
        Arrays.asList("a", "b", "c");
//        Supplier<Car> aNew = Car::new;
//        final Car car = Car.create(aNew);
//        Optional<Car> option = Optional.of(car);

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo" + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("Foo" + name);
        });

        final ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        final Future<Integer> submit = executorService1.submit(() -> {
            return 123;
        });

        System.out.println("future done" + submit.isDone());
        try {
            System.out.println("future = " + submit.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


    }

//    private interface Defaulable {
//        // Interfaces now allow default methods, the implementer may or
//        // may not implement (override) them.
//        default String notRequired() {
//            return "Default implementation";
//        }
//    }
//
//    private static class DefaultableImpl implements Defaulable {
//    }
//
//    private static class OverridableImpl implements Defaulable {
//        @Override
//        public String notRequired() {
//            return "Overridden implementation";
//        }
//    }
//
//    private interface DefaulableFactory {
//        // Interfaces now allow static methods
//        static Defaulable create( Supplier<Defaulable> supplier ) {
//            return supplier.get();
//        }
//    }
//
//    public static class Car {
//        public static Car create( final Supplier< Car > supplier ) {
//            return supplier.get();
//        }
//
//        public static void collide( final Car car ) {
//            System.out.println( "Collided " + car.toString() );
//        }
//
//        public void follow( final Car another ) {
//            System.out.println( "Following the " + another.toString() );
//        }
//
//        public void repair() {
//            System.out.println( "Repaired " + this.toString() );
//        }
//    }
//



}
