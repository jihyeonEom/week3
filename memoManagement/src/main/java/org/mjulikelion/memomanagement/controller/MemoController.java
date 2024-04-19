package org.mjulikelion.memomanagement.controller;

import lombok.AllArgsConstructor;
import org.mjulikelion.memomanagement.Memo;
import org.mjulikelion.memomanagement.service.MemoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMemo(@RequestBody Memo memo) {
        this.memoService.createMemo(memo);
    }

    @GetMapping("/memos/{user_id}")
    public List<Memo> getAllMemoByUserId(@PathVariable String user_id) {
        return this.memoService.getAllMemoByUserId(user_id);
    }

    @GetMapping("/memo/{memo_id}")
    public Memo getMemoByMemoId(@PathVariable String memo_id, @RequestHeader HttpHeaders headers) {
        String user_id = headers.getFirst(HttpHeaders.USER_AGENT);
        return this.memoService.getMemoByMemoId(user_id, memo_id);
    }

    @DeleteMapping("/memo/{memo_id}")
    public void deleteMemoByMemoId(@PathVariable String memo_id, @RequestHeader HttpHeaders headers) {
        String user_id = headers.getFirst(HttpHeaders.USER_AGENT);
        this.memoService.deleteMemoByMemoId(user_id, memo_id);
    }

    @PatchMapping("/memo/{memo_id}")
    public void updateMemoByMemoId(@PathVariable String memo_id, @RequestBody String content, @RequestHeader HttpHeaders headers) {
        String user_id = headers.getFirst(HttpHeaders.USER_AGENT);
        this.memoService.updateMemoByMemoId(user_id, memo_id, content);
    }
}
