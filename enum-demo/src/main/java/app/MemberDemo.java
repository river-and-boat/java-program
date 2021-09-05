package app;

import model.User;
import my_enum.MemberEnum;

import java.math.BigDecimal;

public class MemberDemo {
    public static void main(String[] args) {
        User user = new User(1L, "brave", MemberEnum.GOLD_MEMBER.getType());
        BigDecimal productPrice = new BigDecimal("1000");
        BigDecimal discountedPrice =
                MemberEnum.getEnumByType(user.getMemberType())
                        .calculateFinalPrice(productPrice);
        System.out.println(discountedPrice);
    }
}
