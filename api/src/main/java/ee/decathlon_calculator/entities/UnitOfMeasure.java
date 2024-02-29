package ee.decathlon_calculator.entities;

public enum UnitOfMeasure {
    METER("meters"),
    SECOND("second"),
    MINUTE("minutes");
    private String unit;
    UnitOfMeasure(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return unit;
    }
}
