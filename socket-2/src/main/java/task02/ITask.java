package task02;

public interface ITask {
    /** クライアントで最初に計算させる数字を入力しておく関数 */
    public void setExecNumber(int x);

    public int getExecNumber();

    /** サーバで計算を実行をさせる関数...計算アルゴリズムが記載される */
    public void exec();

    /** クライアントで結果を取り出す関数 */
    public int getResult();
}
