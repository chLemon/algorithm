package offer;

public class No64 {
    /*
    求 1+2+...+n ，
    要求不能使用
    乘除法、
    for、
    while、
    if、
    else、
    switch、
    case
    等关键字及
    条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        //还有一个俄罗斯农民法

        //利用递归实现循环，利用短路逻辑运算完成递归基
        boolean b = (n>0 && (n+=sumNums(n-1))==0);
        return n;//注意这里
    }
}
