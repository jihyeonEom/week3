package org.mjulikelion.memomanagement.service;

import lombok.AllArgsConstructor;
import org.mjulikelion.memomanagement.Memo;
import org.mjulikelion.memomanagement.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public void createMemo(Memo memo) {
        this.memoRepository.createMemo(memo);
    }

    public List<Memo> getAllMemoByUserId(String user_id) {
        return this.memoRepository.getAllMemoByUserId(user_id);
    }

    public Memo getMemoByMemoId(String user_id, String memo_id) {
        return this.memoRepository.getMemoByMemoId(user_id, memo_id);
    }

    public void deleteMemoByMemoId(String user_id, String memo_id) {
        this.memoRepository.deleteMemoByMemoId(user_id, memo_id);
    }

    public void updateMemoByMemoId(String user_id, String memo_id, String content) {
        this.memoRepository.updateMemoByMemoId(user_id, memo_id, content);
    }
}
