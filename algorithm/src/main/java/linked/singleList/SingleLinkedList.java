package linked.singleList;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

class LNode{
    int data;
    LNode next;
}

@Log
public class SingleLinkedList {
    /**
     * 逆序 就地逆序
     * @param head
     */
    public static void reverse(LNode head){
        if (head==null||head.next==null)
            return;
        LNode pre=null; //前驱结点
        LNode our=null; //当前结点
        LNode next=null; //后继结点

        our=head.next;  //获取首结点
        next=our.next;
        our.next=null; //将链表首结点变为尾结点
        pre=our;
        our=next;
        while (our.next!=null){
            next=our.next;
            our.next=pre;
            pre=our;

            //our=our.next;
            our=next;
        }
        our.next=pre;
        head.next=our;
    }

    /**
     * 不带头结点  递归逆序
     * @param head
     * @return
     */
    public static LNode noLeadRecursiveReverse(LNode head){
        if (head==null ||head.next==null)
            return head;

        LNode newHead = noLeadRecursiveReverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    /**
     * 带头结点 递归逆序
     * @param head
     */
    public static void leadRecursiveReverse(LNode head){
        if (head==null)
            return;
        LNode firstNode=head.next;
        LNode newHead=noLeadRecursiveReverse(firstNode);
        head.next=newHead;
    }

    /**
     * 插入逆序
     * @param head
     */
    public static void insertReverse(LNode head){
        if (head==null || head.next==null)
            return;
        LNode cur=null;
        LNode next=null;
        cur=head.next.next;
        head.next.next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=head.next;
            head.next=cur;
            cur=next;
        }
    }

    /**
     * 顺序删除重复项
     * @param head
     */
    public static void orderRemovingDuplicates(LNode head){
        if (head==null || head.next==null)
            return;
        LNode outer=head.next;
        LNode inner=null;
        LNode pre=null;
        for (;outer!=null;outer=outer.next)
            for (inner=outer.next,pre=outer;inner!=null;inner=inner.next){ //循环查找后面的结点
                if (outer.data==inner.data){ //外部结点与内部结点数据比较
                    pre.next=inner.next;
                }else {
                    pre=inner;
                }
            }
    }


    /**
     * 递归删除重复项
     * @param head
     * @return
     */
    public static LNode recursiveRemovingDuplicates(LNode head){
        if (head.next==null)
            return head;
        LNode pointer=null;
        LNode cur=head;
        head.next=recursiveRemovingDuplicates(head.next);
        pointer=head.next;
        while (pointer!=null){
            if (head.data==pointer.data){
                cur.next=pointer.next;
                pointer=cur.next;
            }else {
                pointer=pointer.next;
                cur=cur.next;
            }
        }
        return head;
    }

    public static void spaceForTimeRemovingDuplicates(LNode head){
        if (head==null || head.next==null)
            return;
        HashSet<Integer> lNodeHashSet = new HashSet<Integer>();
        lNodeHashSet.add(Integer.valueOf(head.next.data));
        LNode cur=null;
        LNode pointer=head.next;
        for (cur=pointer.next;cur!=null;cur=cur.next){
            Iterator<Integer> it=lNodeHashSet.iterator();
            boolean flag=false;
            while (it.hasNext()){
                Integer integer=it.next();
                if (cur.data==integer.intValue()){
                   pointer.next=cur.next;
                   flag=true;
                   break;
                }else {
                    continue;
                }
            }
            if (!flag){
                pointer=cur;
                lNodeHashSet.add(cur.data);
            }
        }
    }

    public static void print(Iterator<Integer> it){
        while (it.hasNext())
            System.out.println(it.next());
    }

    @Test
    public void testReverse(){
        LNode head=new LNode();
        head.next=null;
        LNode temp=null;
        LNode cur=head;
        for (int i=0;i<8;++i){
            temp = new LNode();
            temp.data=i;
            temp.next=null;
            cur.next=temp;
            cur=temp;
        }
        System.out.println("/********逆序前********/");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
        System.out.println("/********逆序后*******/");
        reverse(head);
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
        System.out.println("/******递归后********/");
        leadRecursiveReverse(head);
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
        System.out.println("/*****插入后*****/");
        insertReverse(head);
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
    }

    @Test
    public void teatRemove(){
        LNode head=new LNode();
        head.next=null;
        LNode temp=null;
        LNode cur=head;
        for (int i=0;i<8;++i){
            temp = new LNode();
            if (i%2==0){
                temp.data=i+1;
            }else {
                temp.data=i;
            }
            temp.next=null;
            cur.next=temp;
            cur=temp;
        }
        LNode flag=head;

        System.out.println("/********删除前********/");
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
//        System.out.println("/*****顺序删除后******/");
//        orderRemovingDuplicates(flag);
//        for (cur=head.next;cur!=null;cur=cur.next){
//            System.out.println(cur.data);
//        }
        System.out.println("/*****递归删除后******/");
        recursiveRemovingDuplicates(flag);
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }

        System.out.println("/*****空间换时间删除后******/");
        spaceForTimeRemovingDuplicates(head);
        for (cur=head.next;cur!=null;cur=cur.next){
            System.out.println(cur.data);
        }
    }
}
