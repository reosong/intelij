package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;



public class MemberService {
    private final MemberRepository memberRepository ;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    public Long join(Member member) {
        validate(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validate(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미존재하는 회원입니다");
           /*  이렇게도 가능
           ifPresent(m -> {
          throw new IllegalStateException("이미존재하는 회원입니다");
            */
                });
    }

    public List<Member> findMembers(){

        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
