package org.mjulikelion.memomanagement.repository;

import org.mjulikelion.memomanagement.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MemoRepository {
    private final WeakHashMap<String, Memo> memos = new WeakHashMap<>();

    public void createMemo(Memo memo) {
        memos.put(memo.getId(), memo);
    }

    public List<Memo> getAllMemoByUserId(String userId) {
        List<Memo> result = new ArrayList<>();
        for(String key : memos.keySet()){
            Memo memo = memos.get(key);
            if(userId.equals(memo.getUserId())){
                result.add(memo);
            }
        }
        return result;
    }

    public Memo getMemoByMemoId(String userId, String memoId) {
        for(String key: memos.keySet()){
            Memo memo = memos.get(key);
            if(memo.getId().equals(memoId)){
                if(userId.equals(memo.getUserId())){
                    return memo;
                }
                throw new IllegalArgumentException("User with id " + userId + " does not have access to memo with id " + memoId);
            }
        }
        throw new IllegalArgumentException("Memo with id " + memoId + " not found");
    }

    public void deleteMemoByMemoId(String userId, String memoId) {
        for(String key: memos.keySet()){
            Memo memo = memos.get(key);
            if(memo.getId().equals(memoId)){
                if(userId.equals(memo.getUserId())){
                    memos.remove(key);
                    System.gc();
                    System.out.println("Memo with id " + memoId + " removed");
                    return;
                }
                throw new IllegalArgumentException("User with id " + userId + " does not have access to memo with id " + memoId);
            }
        }
        throw new IllegalArgumentException("Memo with id " + memoId + " not found");
    }

    public void updateMemoByMemoId(String userId, String memoId, String content) {
        for(String key: memos.keySet()){
            Memo memo = memos.get(key);
            if(memo.getId().equals(memoId)){
                if(userId.equals(memo.getUserId())){
                    memos.remove(key);
                    Memo newMemo = new Memo(memoId, content, memo.getUserId());
                    memos.put(key, newMemo);
                    return;
                }
                throw new IllegalArgumentException("User with id " + userId + " does not have access to memo with id " + memoId);
            }
        }
        throw new IllegalArgumentException("Memo with id " + memoId + " not found");
    }
}
