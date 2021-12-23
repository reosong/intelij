package hello.hellospring.repository;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemoryMemberRepositoryTest {


    MemberRepository repository = new MemoryMemberRepository();

        @Test
        public void save(){
        Member member = new Member();
            member.setName("spring");

            repository.save(member);

           Member result= repository.findById(member.getId()).get();

        }



}
