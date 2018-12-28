import dsa.Utils;
import dsa.adt.*;
import org.junit.Test;
import practices.waterball.adt.SingleLinkedList;
import practices.waterball.adt.WbAdtFactory;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class AdtTest {
    AdtFactory adtFactory = new WbAdtFactory();  // replace the factory with yours

    @Test
    public void testStack(){
        assertStack(adtFactory.createLinkedListStack(), 1000, false);
        assertStack(adtFactory.createArrayStack(1000), 1000, true);
    }


    private void assertStack(SingleStack stack, int runSize, boolean hasSizeLimit){
        assertTrue(stack.isEmpty());

        for (int i = 1; i <= runSize; i ++)
            stack.push(i);

        assertTrue(!hasSizeLimit ^ stack.isFull());

        for (int i = runSize; i >= 1; i --)
            assertEquals(i, stack.pop());
    }

    @Test
    public void testMultipleStacks(){
        assertMultipleStack(adtFactory.createDoubleStack(1000), 500, 2);
        assertMultipleStack(adtFactory.createMultipleStack(10, 1000), 100, 10);
    }


    private void assertMultipleStack(MultipleStack stack, int runEachStackSize, int stackCount){
        for (int n = 0; n < stackCount; n ++)
        {
            assertTrue(stack.isEmpty(n));

            for (int i = 1; i <= runEachStackSize; i ++)
                stack.push(n, i);
        }

        for (int n = 0; n < stackCount; n ++)
            assertTrue(stack.isFull(n));

        for (int n = 0; n < stackCount; n ++)
        {
            for (int i = runEachStackSize; i >= 1; i --)
                assertEquals(i, stack.pop(n));
        }
    }

    @Test
    public void testQueues(){
        assertQueue(adtFactory.createCircularArrayQueue(1000), 1000, true);
        assertQueue(adtFactory.createSingleLinkedListQueue(), -1, false);
        assertQueue(adtFactory.createCircularLinkedListQueue(), -1, false);
    }

    private void assertQueue(Queue queue, int runSize, boolean hasSizeLimit){
        assertTrue(queue.isEmpty());

        for (int i = 1; i <= runSize; i ++)
            queue.add(i);

        assertTrue(!hasSizeLimit ^ queue.isFull());

        for (int i = 1; i <= runSize; i ++)
            assertEquals(i, queue.delete());
    }

    @Test
    public void testLinkedList(){
        assertAddingBothLinkedListEnds(adtFactory.createDoubleLinkedList());
        assertInsertingLinkedList(adtFactory.createDoubleLinkedList());

        assertAddingBothLinkedListEnds(adtFactory.createSingleLinkedList());
        assertInsertingLinkedList(adtFactory.createSingleLinkedList());
        assertSingleLinkedListInversion(adtFactory.createSingleLinkedList());
    }

    private void assertAddingBothLinkedListEnds(LinkedList linkedList){
        final int NUM = 10;

        linkedList.addHead(0);  //root
        for (int i = 1; i <= NUM; i ++)  // ... -3 -2 -1 0 1 2 3 ...
        {
            linkedList.addTail(i);
            linkedList.addHead((-1)*i);
        }

        for (int i = NUM; i > 0; i --)
        {
            assertEquals((-1)*i, linkedList.deleteHead());
            assertEquals(i, linkedList.deleteTail());
        }
        assertEquals(0, linkedList.deleteHead());
    }

    private void assertInsertingLinkedList(LinkedList linkedList){
        final int NUM = 10;
        for (int i = 1; i <= NUM; i += 2)  // 1, 3, 5, 7, 9 ... odds
            linkedList.addTail(i);

        //insert even nums 2, 4, 6, 8, 10...
        for(int i = 2; i <= NUM; i+= 2)
            linkedList.insert(i-2, i);

        assertEquals(10, linkedList.length());

        try {
            linkedList.insert(10, -999);  //index out of bound
            fail();
        }catch (IndexOutOfBoundsException err){}


        for (int i = 0; i < NUM; i ++)  //assert 1, 2, 3, 4, 5, ..., NUM after inserted
            assertEquals(i+1, linkedList.deleteHead());

    }

    private void assertSingleLinkedListInversion(SingleLinkedList linkedList) {
        final int NUM = 10;
        for (int i = 1; i <= NUM; i ++)  // 1, 2, 3, 4, ..., NUM
            linkedList.addTail(i);
        linkedList.invert();
        for (int i = NUM; i >= 1; i --)  // NUM, NUM-1, ..., 3, 2, 1
            assertEquals(i, linkedList.deleteHead());
    }

    @Test
    public void testBStrees(){
        assertBstree(adtFactory.createBStree());
    }

    private void assertBstree(BSTree bStree) {
        final int[] expectedInorder = {1, 2, 3, 4, 5, 7, 8, 13, 14, 15, 20, 21, 22, 23};
        final int[] expectedPostorder = {1, 4, 3, 2, 7, 13, 14, 21, 23, 22, 20, 15, 8, 5};
        final int[] expectedPreorder = {5, 2, 1, 3, 4, 8, 7, 15, 14, 13, 20, 22, 21, 23};

        final Data[] insertedDatas = {
                new Data(5, 'a')
                , new Data(2, 'b')
                , new Data(1, 'c')
                , new Data(3, 'd')
                , new Data(4, 'e')
                , new Data(8, 'f')
                , new Data(7, 'g')
                , new Data(15, 'h')
                , new Data(14, 'i')
                , new Data(13, 'j')
                , new Data(20, 'k')
                , new Data(22, 'l')
                , new Data(21, 'm')
                , new Data(23, 'n')};

        //inserting
        for (Data d : insertedDatas)
            bStree.insert(d);

        List<Data> actualInorder = bStree.inorderTraversal();
        List<Data> actualPostorder = bStree.postorderTraversal();
        List<Data> actualPreorder = bStree.preorderTraversal();

        System.out.println("Inorder traversal: " + Utils.listToString(actualInorder));
        System.out.println("Postorder traversal: " + Utils.listToString(actualPostorder));
        System.out.println("Preorder traversal: " + Utils.listToString(actualPreorder));

        //traversal
        for (int i = 0; i < insertedDatas.length; i ++)
        {
            assertEquals(expectedInorder[i], actualInorder.get(i).key);
            assertEquals(expectedPostorder[i], actualPostorder.get(i).key);
            assertEquals(expectedPreorder[i], actualPreorder.get(i).key);
        }

        //searching
        for (Data d : insertedDatas)
            assertEquals(d.content, bStree.search(d.key).content);

        Data minData = bStree.findMin();
        assertEquals('c', minData.content);

        /* Delete method temporarily not testable because it's too intricate on a thread b tree */
        /*
        bStree.delete(23);  //leaf
        bStree.delete(20);  //one child node
        bStree.delete(5);  //two children node

        final int[] expectedInorderAfterDelete = {1, 2, 3, 4, 7, 8, 13, 14, 15, 21, 22};
        final int[] expectedPreorderfterDelete = {7, 2, 1, 3, 4, 8, 15, 14, 13, 22, 21};
        final int[] expectedPostorderfterDelete = {1, 4, 3, 2, 13, 14, 21, 22, 15, 8, 7};


        //traversal after deleted
        for (int i = 0; i < insertedDatas.length; i ++)
        {
            assertEquals(expectedInorder[i], actualInorder.get(i));
            assertEquals(expectedPostorder[i], actualPostorder.get(i));
            assertEquals(expectedPreorder[i], actualPreorder.get(i));
        }*/
    }

    @Test
    public void testDisjointSet(){
        DisjointSet disjointSet = adtFactory.createDisjointSet();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < nums.length; i++) {
            for (int num : nums[i]) {
                disjointSet.put(num, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int num : nums[i]) {
                assertEquals(i, disjointSet.find(num));
            }
        }

        disjointSet.union(1, 0);
        disjointSet.union(2, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int num : nums[i]) {
                assertEquals(0, disjointSet.find(num));
            }
        }
    }

    @Test
    public void testPriorityQueues(){
        assertPriorityQueue(adtFactory.createMinBinaryHeap());
    }

    private void assertPriorityQueue(PriorityQueue priorityQueue) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            priorityQueue.insert(random.nextInt(100));
        }

        int previous = priorityQueue.delete();
        System.out.print("Sorted: " + previous + " ");

        while (!priorityQueue.isEmpty())
        {
            int next = priorityQueue.delete();
            System.out.print(next + " ");
            assertTrue(previous <= next);
            previous = next;
        }
        System.out.println();
    }

    @Test
    public void testDoubleEndedPriorityQueue(){
        //assertDoubleEndedPriorityQueue(adtFactory.createMinMaxHeap());
    }

    private void assertDoubleEndedPriorityQueue(DoubleEndedPriorityQueue doubleEndedPriorityQueue){
        //test ascending
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            doubleEndedPriorityQueue.insert(random.nextInt(100));
        }

        int previous = doubleEndedPriorityQueue.deleteMin();
        System.out.print("Sorted (ascending): " + previous + " ");

        while (!doubleEndedPriorityQueue.isEmpty())
        {
            int next = doubleEndedPriorityQueue.deleteMin();
            System.out.print(next + " ");
            assertTrue(previous <= next);
            previous = next;
        }
        System.out.println();

        //test descending
        for (int i = 0; i < 50; i++) {
            doubleEndedPriorityQueue.insert(random.nextInt(100));
        }

        previous = doubleEndedPriorityQueue.deleteMax();
        System.out.print("Sorted (descending): " + previous + " ");

        while (!doubleEndedPriorityQueue.isEmpty())
        {
            int next = doubleEndedPriorityQueue.deleteMax();
            System.out.print(next + " ");
            assertTrue(previous >= next);
            previous = next;
        }
        System.out.println();
    }

    @Test
    public void testHashingMap() {
        HashMap hashMap = adtFactory.createHashMap();
        java.util.HashMap<Data, Integer> answerHashMap = new java.util.HashMap<>();

        Random random = new Random();
        for (int i = 0; i <20; i ++)
        {
            Data data = new Data(random.nextInt(), (char) (random.nextInt()%26+65));
            hashMap.put(data, i);
            answerHashMap.put(data, i);
        }

        for (Data data : answerHashMap.keySet())
            assertEquals(new Integer(hashMap.get(data)), answerHashMap.get(data));
    }
}
