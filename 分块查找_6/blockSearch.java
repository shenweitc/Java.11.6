package 分块查找_6;

public class blockSearch {
    public static void main(String[] args) {
        int[] arr={16,5,9,12,21,18,
                32,23,37,26,45,34,
                50,48,61,52,73,66};

        //创建块的对象
        block b1=new block(21,0,5);
        block b2=new block(45,6,11);
        block b3=new block(73,12,17);

        //索引表
        block[] blockArr={b1,b2,b3};

        //定义要查找的对象
        int number=66;

        int index= getIndex(blockArr,arr,number);
        System.out.println(index);

    }

    private static int getIndex(block[] blockArr,int[] arr,int number) {
        int indexBlock=findIndexBlock(blockArr,number);
        if(indexBlock==-1){
            return -1;
        }
        //2.获取这一块的起始索引和结束索引
        int startIndex=blockArr[indexBlock].getStartIndex();
        int endIndex=blockArr[indexBlock].getEndIndex();

        //遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if(arr[i]==number){
                return i;
            }
        }
        return -1;
    }

    //定义一个方法确定在哪一块中
    public static int findIndexBlock(block[] blockArr,int number){
        //从0索引开始遍历blockArr，如果number小于max，那么就表示number是在这一块当中的
        for (int i = 0; i < blockArr.length; i++) {
            if(number<=blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }

}

class block{
    private int max;
    private int startIndex;
    private int endIndex;

    public block() {
    }

    public block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    /**
     * 获取
     * @return max
     */
    public int getMax() {
        return max;
    }

    /**
     * 设置
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * 获取
     * @return startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * 设置
     * @param startIndex
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 获取
     * @return endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * 设置
     * @param endIndex
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String toString() {
        return "block{max = " + max + ", startIndex = " + startIndex + ", endIndex = " + endIndex + "}";
    }
}