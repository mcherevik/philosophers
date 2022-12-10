package philosophers;

public class Table {
    int food;

    Table () {
        this.food = 100;
    }

    public boolean isEmpty() {
        return this.food <= 0;
    }
}
