package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}