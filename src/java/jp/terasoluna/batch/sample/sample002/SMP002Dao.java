package jp.terasoluna.batch.sample.sample002;

import jp.terasoluna.batch.sample.common.NyusyukkinData;

public interface SMP002Dao {

    /**
     * 入出金情報を1件挿入する。
     * @param data 入出金情報
     * @return 挿入件数
     */
    public int insertNyusyukkinData(NyusyukkinData data);

}
