package store.bizscanner.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.request.CommentRequest;
import store.bizscanner.entity.Comment;
import store.bizscanner.entity.Member;
import store.bizscanner.repository.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@Transactional
class CommentServiceTest {
    @InjectMocks
    private CommentService commentService;

    @Mock
    private MemberRepository memberRepository;

    String careaCode = "2110008";
    String jcategoryCode = "CS300002";
    String contents = "test contents";

    @DisplayName("댓글_생성_성공")
    @Test
    void createCommentTest() {
        // given
        CommentRequest commentRequest = new CommentRequest(careaCode, jcategoryCode, contents);

        Member member = new Member();
        memberRepository.save(member);

        // when
        Comment comment = commentService.createComment(commentRequest, member);

        // then
        assertThat(comment.getContents()).isEqualTo(contents);
        assertThat(comment.getCareaCode()).isEqualTo(careaCode);
        assertThat(comment.getJcategoryCode()).isEqualTo(jcategoryCode);
    }
}
