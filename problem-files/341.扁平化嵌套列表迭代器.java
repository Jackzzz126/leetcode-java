/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }

    @Override
    public Integer next() {
        NestedInteger cur = this.list.get(0);
        Integer x = cur.getInteger();
        this.list.remove(0);
        return x;
    }

    @Override
    public boolean hasNext() {
        while (this.list.size() > 0) {
            NestedInteger cur = this.list.get(0);
            if(cur.isInteger()) {
                return true;
            } else {
                List<NestedInteger> newList = cur.getList();
                this.list.remove(0);
                newList.addAll(this.list);
                this.list = newList;
                continue;
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

