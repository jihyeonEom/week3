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

    @GetMapping("/memos")
    public List<Memo> getAllMemoByUserId(@RequestHeader("userId") String userId) {
        return this.memoService.getAllMemoByUserId(userId);
    }

    @GetMapping("/memos/{memoId}")
    public Memo getMemoByMemoId(@PathVariable String memoId, @RequestHeader("userId") String userId) {
        return this.memoService.getMemoByMemoId(userId, memoId);
    }

    @DeleteMapping("/memos/{memoId}")
    public void deleteMemoByMemoId(@PathVariable String memoId, @RequestHeader("userId") String userId) {
        this.memoService.deleteMemoByMemoId(userId, memoId);
    }

    @PatchMapping("/memos/{memoId}")
    public void updateMemoByMemoId(@PathVariable String memoId, @RequestBody String content, @RequestHeader("userId") String userId) {
        this.memoService.updateMemoByMemoId(userId, memoId, content);
    }
}
