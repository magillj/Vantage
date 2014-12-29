package DAO;
import DAO.model.Member;

/**
 * Created by btaylor5 on 12/23/14.
 *
 * Reference: http://www.mkyong.com/spring/maven-spring-jdbc-example/
 */

public interface MemberDAO {
    public void insert(Member member); //USED to be static..can I remove?
    public Member lookUpMember(int memberID);
    public int lookUpMemberByEmail(String Email);
}
