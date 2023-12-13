package hello.demo.discount;

import hello.demo.member.Grade;
import hello.demo.member.Member;

public class FixDiscountPolicy implements DiscoundPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
