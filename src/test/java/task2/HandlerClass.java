package task2;

import ru.inno.edu.task2_cache.annotation.Cache;
import ru.inno.edu.task2_cache.annotation.Mutator;

public class HandlerClass  implements Handlerable{
        private int counter = 0;

        private String name;

    public HandlerClass(String name) {
        this.name = name;
    }


    public int getCounter() {
        return counter;
    }

    @Cache
    public String getName() {
        counter++;
        return name;
    }

    @Mutator
    public void setName(String name) {
        this.name = name;
    }
}
