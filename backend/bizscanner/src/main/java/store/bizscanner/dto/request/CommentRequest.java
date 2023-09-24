package store.bizscanner.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CommentRequest {
    @NotNull
    private String careaCode;

    @NotNull
    private String jcategoryCode;

    @Size(min = 2, max = 300)
    private String contents;
}
