package model;

public class CouponResponse {
    private Long id;
    private String name;
    private Long condition;
    private Long denominations;

    public CouponResponse(
            final Long id,
            final String name,
            final Long condition,
            final Long denominations
    ) {
        this.id = id;
        this.name = name;
        this.condition = condition;
        this.denominations = denominations;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getCondition() {
        return condition;
    }

    public void setCondition(final Long condition) {
        this.condition = condition;
    }

    public Long getDenominations() {
        return denominations;
    }

    public void setDenominations(final Long denominations) {
        this.denominations = denominations;
    }
}
