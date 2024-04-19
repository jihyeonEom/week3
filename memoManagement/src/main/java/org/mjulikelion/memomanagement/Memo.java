package org.mjulikelion.memomanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Memo {
    private String id; // 메모 ID
    private String content; // 메모 내용
    private String user_id; // 메모 작성자의 ID
}
