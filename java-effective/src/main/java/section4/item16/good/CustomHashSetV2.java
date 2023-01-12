package section4.item16.good;

import java.util.Collection;
import java.util.Set;

/**
 * 이러한 디자인패턴을 decorator 패턴
 * 위 bad 패키지의 CustomHashSet의 단점을 보완한다.
 * fowardigSet이라는클래스를 만들어 Set 인터페이스의 addAll을 구현한다.
 * bad 패키지에서는 addAll이 곱절로 콜이되어 세번을 add해도 총 곱절이므로 6개의 카운트가 된것!
 */
public class CustomHashSetV2<E> extends ForwardingSet {

    private int addCount = 0;

    public CustomHashSetV2(Set<E> set){
        super(set);
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
