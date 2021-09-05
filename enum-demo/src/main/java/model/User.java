package model;

import my_enum.MemberEnum;

public class User {
    private Long id;
    private String name;
    private Integer memberType;

    public User(Long id, String name, Integer memberType) {
        this.id = id;
        this.name = name;
        this.memberType = memberType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
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
