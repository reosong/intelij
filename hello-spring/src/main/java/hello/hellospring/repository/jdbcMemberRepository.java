package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class jdbcMemberRepository implements MemberRepository{

    private final DataSource dataSource;

    public jdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        dataSource.getConnection();

    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = getConnection();
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, member.getName());
            pstmt.executeUpdate();
            rs=pstmt.getGeneratedKeys();
            if(rs.next()){
                member.setId(rs.getLong(1));

            }else{
                throw new SQLException("id false");
            }
            return  member;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(con, pstmt, rs);
        }

        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
