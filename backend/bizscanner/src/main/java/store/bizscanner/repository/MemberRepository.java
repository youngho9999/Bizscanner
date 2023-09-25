package store.bizscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.bizscanner.entity.Member;
import store.bizscanner.entity.SocialType;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByNickname(String nickName);

    Optional<Member> findByRefreshToken(String refreshToken);

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
