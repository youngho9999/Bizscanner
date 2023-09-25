package store.bizscanner.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    @NotNull
    private String careaCode;

    @NotNull
    private String jcategoryCode;

    @Size(min = 2, max = 300)
    private String contents;
}
