package my_enum;

import java.math.BigDecimal;

public enum MemberEnum {
    GOLD_MEMBER(1, "Gold") {
        @Override
        public BigDecimal calculateFinalPrice(BigDecimal originPrice) {
            return originPrice.multiply(new BigDecimal("0.6"));
        }
    },
    SILVER_MEMBER(2, "Silver") {
        @Override
        public BigDecimal calculateFinalPrice(BigDecimal originPrice) {
            return originPrice.multiply(new BigDecimal("0.7"));
        }
    },
    BRONZE_MEMBER(3, "Bronze") {
        @Override
        public BigDecimal calculateFinalPrice(BigDecimal originPrice) {
            return originPrice.multiply(new BigDecimal("0.8"));
        }
    }

    ;

    private final Integer type;
    private final String desc;

    MemberEnum(final Integer type, final String desc) {
        this.type = type;
        this.desc = desc;
    }

    public abstract BigDecimal calculateFinalPrice(BigDecimal originPrice);

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static MemberEnum getEnumByType(Integer type) {
        MemberEnum[] values = MemberEnum.values();
        for (MemberEnum memberEnum : values) {
            if (memberEnum.getType().equals(type)) {
                return memberEnum;
            }
        }
        throw new IllegalArgumentException("Invalid Enum type:" + type);
    }
}
