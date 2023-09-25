package store.bizscanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.bizscanner.dto.request.MemberSignupRequest;
import store.bizscanner.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public String signUp(@RequestBody MemberSignupRequest memberSignupRequest) throws Exception {
        memberService.signUp(memberSignupRequest);
        return "회원가입 성공";
    }

    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }
}
