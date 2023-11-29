package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * HashMap 은 동시성 문제가 고려되어 있지 않기 때문에
 * 실무에서는 ConcurrentHashMap, AtomicLong  사용을 생각해 봐야함.
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤 패턴
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤으로 생성
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){

        Collection<Member> values = store.values();
        return new ArrayList<>(values);

    }

    public void clearStore(){
        store.clear();
    }
}
