package store.bizscanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.bizscanner.dto.request.CommentRequest;
import store.bizscanner.dto.response.comment.CommentListResponse;
import store.bizscanner.entity.Member;
import store.bizscanner.service.CommentService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@Valid @RequestBody CommentRequest commentRequest) {
        Member member = new Member();

        commentService.createComment(commentRequest, member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{careaCode}/{jcategoryCode}")
    public ResponseEntity<CommentListResponse> getComment(@PathVariable String careaCode, @PathVariable String jcategoryCode) {
        return new ResponseEntity<>(commentService.getComment(careaCode, jcategoryCode), HttpStatus.OK);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@Valid @RequestBody CommentRequest commentRequest, @PathVariable Long commentId) {
        commentService.updateComment(commentRequest, commentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<CommentListResponse> getComment() {
        Member member = new Member();

        return new ResponseEntity<>(commentService.getMyComment(member), HttpStatus.OK);
    }
}
