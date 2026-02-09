package JavaRush;

public class EnumsMonth {
    public static final EnumsMonth JANUARY = new EnumsMonth(0);
    public static final EnumsMonth FEBRUARY = new EnumsMonth(1);
    public static final EnumsMonth MARCH = new EnumsMonth(2);
    public static final EnumsMonth APRIL = new EnumsMonth(3);
    public static final EnumsMonth MAY = new EnumsMonth(4);
    public static final EnumsMonth JUNE = new EnumsMonth(5);
    public static final EnumsMonth JULY = new EnumsMonth(6);
    public static final EnumsMonth AUGUST = new EnumsMonth(7);
    public static final EnumsMonth SEPTEMBER = new EnumsMonth(8);
    public static final EnumsMonth OCTOBER = new EnumsMonth(9);
    public static final EnumsMonth NOVEMBER = new EnumsMonth(10);
    public static final EnumsMonth DECEMBER = new EnumsMonth(11);

    private static final EnumsMonth[] VALUES = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};

    private final int value;

    private static final String[] NAMES = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    private EnumsMonth(int value) {
        this.value = value;
    }

    public static EnumsMonth[] values() {
        return VALUES;
    }

    public int ordinal() {
        return value;
    }

    public String getName() {
        return NAMES[value]; // Возвращаем название месяца по порядковому номеру
    }
}
