# 查找单链表中倒数第K个节点

## 1、介绍

这是一道面试题，查找一个单链表中倒数第K个节点

## 2、分析

```java
size - index 位置，就是我们倒数的第K个节点
```



## 3、代码

```java
	/**
     * 查找单链表中倒数第K个节点
     * size - index 位置，就是我们倒数的第K个节点
     * @param node 原链表
     * @param index 倒数第K个节点
     * @return
     */
    public static Node findLastIndexNode(Node node, int index){
        if (node.next == null){
            log.debug("空链表");
            return null;
        }
        int size = getSize(node);
        if (index < 0 || index > size){
            log.debug("指定的位置超出链表范围了");
            return null;
        }
        Node currentNode = node.next;
        for (int i = 0; i < size - index; i++){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
```



