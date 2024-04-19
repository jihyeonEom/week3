package org.mjulikelion.memomanagement.repository;

import org.mjulikelion.memomanagement.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemoRepository {
    private final List<Memo> memoList = new ArrayList<>();

    public void createMemo(Memo memo) {
        memoList.add(memo);
    }

    public List<Memo> getAllMemoByUserId(String user_id) {
        List<Memo> result = new ArrayList<>();
        for (Memo m : memoList) {
            if (m.getUser_id().equals(user_id)) {
                result.add(m);
            }
        }
        return result;
    }

    public Memo getMemoByMemoId(String user_id, String memo_id) {
        for (Memo m : memoList) {
            if (m.getId().equals(memo_id) && m.getUser_id().equals(user_id)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Memo with id " + memo_id + " not found");
    }

    public void deleteMemoByMemoId(String user_id, String memo_id) {
        for (Memo m : memoList) {
            if (m.getId().equals(memo_id) && m.getUser_id().equals(user_id)) {
                memoList.remove(m);
                return;
            }
        }
        throw new IllegalArgumentException("Memo with id " + memo_id + " not found");
    }

    public void updateMemoByMemoId(String user_id, String memo_id, String content) {
        for (Memo m : memoList) {
            if (m.getId().equals(memo_id) && m.getUser_id().equals(user_id)) {
                memoList.remove(m);
                memoList.add(new Memo(memo_id, content, m.getUser_id()));
                return;
            }
        }
        throw new IllegalArgumentException("Memo with id " + memo_id + " not found");
    }

}
