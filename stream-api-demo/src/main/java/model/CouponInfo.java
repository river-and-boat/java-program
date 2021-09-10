package model;

public class CouponInfo {
    private Long id;
    private String name;
    private Integer num;
    private Long condition;
    private Long denominations;

    public CouponInfo(
            final Long id,
            final String name,
            final Integer num,
            final Long condition,
            final Long denominations
    ) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.condition = condition;
        this.denominations = denominations;
    }

    public static CouponInfo buildCouponInfo(CouponResponse origin) {
        return new CouponInfo(
                origin.getId(),
                origin.getName(),
                1,
                origin.getCondition(),
                origin.getDenominations()
        );
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

    public Integer getNum() {
        return num;
    }

    public void setNum(final Integer num) {
        this.num = num;
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
