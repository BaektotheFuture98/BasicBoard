package repository;

import com.engine.springbootquickstart_v2.board.domain.Member;
import com.engine.springbootquickstart_v2.board.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();

    @Test
    public void save(){
        Member member = new Member();
        member.setId("spring");
        repository.save(member);

        Member result = repository.findById(member.getSequecne()).get();

        Assertions.assertEquals(member, result);
    }
}
