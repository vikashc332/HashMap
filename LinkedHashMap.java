import java.util.ArrayList;
import com.blz.linkedlist.LinkList;


public class MyLinkedHashMap<K,V> {

    private final int numBuckets;
    ArrayList<LinkList> myBucketArray;

    public MyLinkedHashMap() {
        this.numBuckets = 10;
        this.myBucketArray = new ArrayList<LinkList>(numBuckets);

        for(int index=0 ; index <numBuckets ; index++) {
            this.myBucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

    public V get(K key) {

        int index = this.getBucketIndex(key);
        LinkList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null)
            return null;
        Node<K,V> myMapNode = (Node<K,V>) myLinkedList.search(key);
        return(myMapNode == null)?null:myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        LinkList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) {
            myLinkedList = new LinkList<K>();
            this.myBucketArray.set(index, myLinkedList);
        }

        Node<K, V>myMapNode = (Node<K,V>) myLinkedList.search(key);
        if(myMapNode == null) {
            myMapNode = new Node<K, V>(key, value);
            myLinkedList.append(myMapNode);
        }
        else {
            myMapNode.setValue(value);
        }
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList != null) {
            Node<K, V> myMapNode = (Node<K, V>) myLinkedList.search(key);
            myLinkedList.remove(myMapNode);
        }
        this.myBucketArray.set(index, null);
    }


    @Override
    public String toString() {
        return "MyLinkedHashMap List{" + myBucketArray + '}';
    }

}
