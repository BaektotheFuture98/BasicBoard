package repository;

import com.engine.springbootquickstart_v2.member.dto.Member;
import com.engine.springbootquickstart_v2.member.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberRepositoryTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();

    @Test
    public void save(){
        Member member = new Member();
        member.setId("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result); // 왼 : 기대값, 오 :  판별대상
    }
}
