package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import model.CouponInfo;
import model.CouponResponse;

public class CouponTest {
    public static void main(String[] args) throws JsonProcessingException {
        List<CouponResponse> coupons = getCoupons();
        var result =
                coupons.stream().collect(
                        Collectors.groupingBy(CouponResponse::getId,
                                Collectors.mapping(CouponInfo::buildCouponInfo, Collectors.toList())));
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result));
    }

    private static List<CouponResponse> getCoupons() {
        return List.of(
                new CouponResponse(1L, "满5减4", 500L, 400L),
                new CouponResponse(1L, "满5减4", 500L, 400L),
                new CouponResponse(2L, "满10减9", 1000L, 900L),
                new CouponResponse(3L, "满60减50", 6000L, 5000L)
        );
    }
}
