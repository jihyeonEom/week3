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

    public List<Memo> getAllMemoByUserId(String userId) {
        return this.memoRepository.getAllMemoByUserId(userId);
    }

    public Memo getMemoByMemoId(String userId, String memoId) {
        return this.memoRepository.getMemoByMemoId(userId, memoId);
    }

    public void deleteMemoByMemoId(String userId, String memoId) {
        this.memoRepository.deleteMemoByMemoId(userId, memoId);
    }

    public void updateMemoByMemoId(String userId, String memoId, String content) {
        this.memoRepository.updateMemoByMemoId(userId, memoId, content);
    }
}
