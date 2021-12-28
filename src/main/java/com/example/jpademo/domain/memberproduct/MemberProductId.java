package com.example.jpademo.domain.memberproduct;

import java.io.Serializable;
import java.util.Objects;

public class MemberProductId implements Serializable {


    /**
     * 복합 기본 키
     * @EmbeddedId를 사용하는 방법이 있다.
     */

    private String member;
    private String product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProductId that = (MemberProductId) o;
        return Objects.equals(member, that.member) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }
}
