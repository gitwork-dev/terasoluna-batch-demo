package jp.terasoluna.batch.sample.sample001;

import org.apache.ibatis.session.ResultHandler;

import jp.terasoluna.batch.sample.common.NyusyukkinData;

public interface SMP001Dao {

    /**
     * 入出金情報を取得する。
     * @param object SQLパラメータ引数オブジェクト
     * @param handler ResultHandler
     */
    public void collectNyusyukkinData(Object object, ResultHandler<NyusyukkinData> handler);
    
    public int testConnection();
}
