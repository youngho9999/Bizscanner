package store.bizscanner.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UpdateNicknameRequest {

    @Email
    private String email;

    @Pattern(regexp = "^[^!@#$%^&*()_+|<>?:{}ㄱ-ㅎㅏ-ㅣ가-힣]*[a-zA-Z]{2,16}[^!@#$%^&*()_+|<>?:{}ㄱ-ㅎㅏ-ㅣ가-힣]*$", message = "2 ~ 16 글자 이내, 특수문자, 자음 , 모음 제외")
    private String nickname;


}
