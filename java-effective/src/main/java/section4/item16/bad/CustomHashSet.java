package section4.item16.bad;

import java.util.Collection;
import java.util.HashSet;

/**
 * HashSet의 요소를 몇번 삽입했는지 갯수를 출력하기 위해 만든 클래스
 */
public class CustomHashSet<E> extends HashSet {

    private int addCount = 0;

    public CustomHashSet(){}

    public CustomHashSet(int initCap, float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(Object o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
