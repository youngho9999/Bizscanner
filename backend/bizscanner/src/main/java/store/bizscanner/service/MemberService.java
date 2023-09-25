package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.request.MemberSignupRequest;
import store.bizscanner.entity.Member;
import store.bizscanner.entity.enums.Role;
import store.bizscanner.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(MemberSignupRequest memberSignUpRequest) throws Exception {

        if (memberRepository.findByEmail(memberSignUpRequest.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if (memberRepository.findByNickname(memberSignUpRequest.getNickname()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        Member member = Member.builder()
                .email(memberSignUpRequest.getEmail())
                .password(memberSignUpRequest.getPassword())
                .nickname(memberSignUpRequest.getNickname())
                .role(Role.USER)
                .build();

        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }
}
