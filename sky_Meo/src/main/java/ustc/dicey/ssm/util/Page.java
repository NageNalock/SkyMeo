package ustc.dicey.ssm.util;

public class Page {
    // 数据开始位置,start,其实就是个Index表示现在所在位置
    private int start;

    // 每页显示数量,count
    private int count;

    // 数据数量,不是页码数量,total
    private int total;

    private static final int DEFAULTCOUNT = 5;  // 默认参数

    public Page()
    {
        // TestClass.test();
        this.count = DEFAULTCOUNT;
    }

    public Page(int start, int count)
    {
        this();
        this.start = start;
        this.count = count;
        // System.out.println("有参构造:" + start + "," + count);
    }

    // 根据count与total算出一共有多少页,getTotalPage
    public int getTotalPage()
    {
        // 内部逻辑还可以优化
        if (total == 0)
            return 1;
        if (total % count == 0)
        {
            // 能被整除
            return total / count;
        }else {
            return total / count + 1;
        }
    }

    // 计算出最后一页第一条的位置为多少,getLast
    public int getLast()
    {
        int lastIndex;
        // 假设总数是50,能被5整除,那么最后一页的开始为45
        int last = total % count;  // 余数
        if (last == 0)
        {
            lastIndex = total - count;
        }else {
            // 51的话,则是50
            lastIndex = total - last;
        }

        lastIndex = lastIndex<0 ? 0:last;

        return lastIndex;
    }

    // 判断是否有前一页isHasPrevious,
    public boolean isHasPreviouse()
    {
        return !(start == 0);
    }

    // 是否有后一页,isHasNext
    public boolean isHasNext()
    {
        return !(start == getLast());
    }

    // 重写toString


    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }

    // 无效参数
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
