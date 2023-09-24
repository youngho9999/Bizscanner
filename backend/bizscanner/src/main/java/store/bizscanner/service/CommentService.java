package store.bizscanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.bizscanner.dto.request.CommentRequest;
import store.bizscanner.dto.response.comment.CommentListResponse;
import store.bizscanner.dto.response.comment.CommentResponse;
import store.bizscanner.entity.Comment;
import store.bizscanner.entity.Member;
import store.bizscanner.global.exception.CustomException;
import store.bizscanner.global.exception.ErrorCode;
import store.bizscanner.repository.CommentRepository;

import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(CommentRequest commentRequest, Member member) {
        return commentRepository.save(Comment.builder()
                        .careaCode(commentRequest.getCareaCode())
                        .jcategoryCode(commentRequest.getJcategoryCode())
                        .contents(commentRequest.getContents())
                        .member(member)
                .build());
    }

    public CommentListResponse getComment(String careaCode, String jcategoryCode) {
        return new CommentListResponse(
                commentRepository.findByCareaCodeAndJcategoryCode(careaCode, jcategoryCode).stream()
                        .map(comment -> new CommentResponse(
                                comment.getMember().getNickname(),
                                comment.getContents(),
                                comment.getModifiedDate()))
                        .collect(Collectors.toList()));
    }

    @Transactional
    public Comment updateComment(CommentRequest commentRequest, Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND))
                .update(commentRequest.getContents());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public CommentListResponse getMyComment(Member member) {
        return new CommentListResponse(
                commentRepository.findByMember(member).stream()
                        .map(comment -> new CommentResponse(
                                comment.getMember().getNickname(),
                                comment.getContents(),
                                comment.getModifiedDate()))
                        .collect(Collectors.toList())
        );
    }
}
