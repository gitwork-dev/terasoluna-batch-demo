package jp.terasoluna.batch.sample.sample005;

import org.apache.ibatis.session.ResultHandler;

public interface SMP005Dao {

    /**
     * 入出金情報を取得する。
     * @param object SQLパラメータ引数オブジェクト
     * @param handler ResultHandler
     */
    public void collectNyusyukkinData(Object object, ResultHandler handler);
}
