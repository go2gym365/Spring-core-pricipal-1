package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

public class AppConfig {
    
    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService()");
        return new MemberServiceImpl(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository()");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService()");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
